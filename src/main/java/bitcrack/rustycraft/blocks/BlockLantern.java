package bitcrack.rustycraft.blocks;

import java.util.List;
import java.util.Random;

import bitcrack.rustycraft.Reference;
import bitcrack.rustycraft.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.network.play.server.SPacketSpawnPlayer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class BlockLantern extends Block {
	
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 3, 0.0625 * 13, 0.0625 * 14, 0.0625 * 13);

	public BlockLantern() {
		super(Material.GLASS);
		setUnlocalizedName(Reference.RustycraftBlocks.LANTERN.getUnlocalizedName());
		setRegistryName(Reference.RustycraftBlocks.LANTERN.getRegistryName());
		setHardness(0.05F);
		setLightLevel(500F);
		setSoundType(SoundType.GLASS);
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
	
	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(IBlockState StateIn, World world, BlockPos pos, Random random) {
		float f1 = (float)pos.getX() + 0.7F;
		float f2 = (float)pos.getY() + 0.45F;
		float f3 = (float)pos.getZ() + 0.3F;
		float f4 = random.nextFloat() * 0.2F -0.3F;
		float f5 = random.nextFloat() * -0.2F - -0.3F;
		
		world.spawnParticle(EnumParticleTypes.FLAME, (double)(f1+f4), (double)(f2), (double)(f3+f5), 0.0D, 0.0D, 0.0D, new int[0]);
	}
	
	public Item getItemDropped(int metadata, Random random, int fortune) {
	    return Item.getItemFromBlock(ModBlocks.lantern);
	}

}
