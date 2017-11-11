package bitcrack.rustycraft;

import bitcrack.rustycraft.init.ModBlocks;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGen implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.getDimension())
		{
		case -1:
			break;
		case 0:
			generateOverworld(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 1:
			break;
		}
	}
	
	private int fetchTopBlock(World world, int x, int z, boolean ignoreFluids, boolean onlyGroundBlocks, boolean ignoreFoliage)
	{
		BlockPos pos = new BlockPos(x, 0, z);
		int currentTop = world.getTopSolidOrLiquidBlock(pos).getY();
		boolean pass;
		IBlockState blockBelow;
		for(int i = currentTop; i > 0; i--)
		{
			BlockPos pos2 = new BlockPos(x, i - 1, z);
			blockBelow = world.getBlockState(pos2);
			pass = true;

			if(ignoreFluids && (blockBelow.getBlock() != Blocks.WATER || blockBelow.getBlock() != Blocks.LAVA))
			{
				pass = false;
			}

			if(onlyGroundBlocks && (blockBelow.getBlock() != Blocks.GRASS || blockBelow.getBlock() != Blocks.STONE))
			{
				pass = false;
			}

			if(pass)
			{
				return i;
			}

		}
		
		return currentTop;
	}
	
	private void generateOverworld(World world, Random random, int x, int z)
	{
		int randomX = x + random.nextInt(16);
		int randomZ = z + random.nextInt(16);
		int randomY = fetchTopBlock(world, randomX, randomZ, true, true, true);

		BlockPos pos = new BlockPos(randomX, randomY, randomZ);

		for(int i=0; i<3; i++) {
			for (int j=0; j < 3; j++) {
				for (int k=0; k < 3; k++) {
					if (world.getBlockState(pos.add(j - 1, i, k - 1)).getBlock() != Blocks.AIR) { return; }
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (world.getBlockState(pos.add(i - 1, -1, j - 1)).getBlock() != Blocks.GRASS) { return; }
			}
		}

		world.setBlockState(pos, ModBlocks.rockvar1_center.getDefaultState());

		world.setBlockState(pos.add(1,0,0), ModBlocks.rockvar1_side.getDefaultState().withProperty(BlockHorizontal.FACING, EnumFacing.EAST));
		world.setBlockState(pos.add(-1,0,0), ModBlocks.rockvar1_side.getDefaultState().withProperty(BlockHorizontal.FACING, EnumFacing.WEST));
		world.setBlockState(pos.add(0,0,-1), ModBlocks.rockvar1_side.getDefaultState().withProperty(BlockHorizontal.FACING, EnumFacing.NORTH));
		world.setBlockState(pos.add(0,0,1), ModBlocks.rockvar1_side.getDefaultState().withProperty(BlockHorizontal.FACING, EnumFacing.SOUTH));

		world.setBlockState(pos.add(-1,0,-1), ModBlocks.rockvar1_corner.getDefaultState().withProperty(BlockHorizontal.FACING, EnumFacing.WEST));
		world.setBlockState(pos.add(1,0,1), ModBlocks.rockvar1_corner.getDefaultState().withProperty(BlockHorizontal.FACING, EnumFacing.EAST));
		world.setBlockState(pos.add(-1,0,1), ModBlocks.rockvar1_corner.getDefaultState().withProperty(BlockHorizontal.FACING, EnumFacing.SOUTH));
		world.setBlockState(pos.add(1,0,-1), ModBlocks.rockvar1_corner.getDefaultState().withProperty(BlockHorizontal.FACING, EnumFacing.NORTH));
	}

}
