package bitcrack.rustycraft.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import bitcrack.rustycraft.Reference;
import bitcrack.rustycraft.init.ModBlocks;
import bitcrack.rustycraft.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

public class BlockBarrelvar1 extends Block {
	
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0, 0, 0, 0.0625 * 16, 0.0625 * 23, 0.0625 * 16);

	public BlockBarrelvar1() {
		super(Material.ANVIL);
		setUnlocalizedName(Reference.RustycraftBlocks.BARRELVAR1.getUnlocalizedName());
		setRegistryName(Reference.RustycraftBlocks.BARRELVAR1.getRegistryName());
		setHardness(5F);
		setSoundType(SoundType.METAL);
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
		drops.add(new ItemStack(Items.COAL, generator.nextInt(5) + 10));
		drops.add(new ItemStack(ModItems.scrap, generator.nextInt(1) + 3));
		return drops;
	}
}
