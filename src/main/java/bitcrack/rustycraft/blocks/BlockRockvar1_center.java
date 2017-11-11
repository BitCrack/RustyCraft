package bitcrack.rustycraft.blocks;

import bitcrack.rustycraft.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockRockvar1_center extends Block {

	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0, 0, 0, 0.0625 * 16, 0.0625 * 32, 0.0625 * 16);

	public BlockRockvar1_center() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.RustycraftBlocks.ROCKVAR1_CENTER.getUnlocalizedName());
		setRegistryName(Reference.RustycraftBlocks.ROCKVAR1_CENTER.getRegistryName());
		setHardness(5F);
		setSoundType(SoundType.STONE);
		setHarvestLevel("pickaxe", 0);
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BOUNDING_BOX;
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entityIn) {
		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
    	return Items.COAL;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		Random generator = new Random();
		drops.add(new ItemStack(Blocks.COBBLESTONE, generator.nextInt(8) + 10));
		drops.add(new ItemStack(Blocks.IRON_ORE, generator.nextInt(5) + 5));
		return drops;
	}
}
