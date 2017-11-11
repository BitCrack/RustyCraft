package bitcrack.rustycraft.init;

import bitcrack.rustycraft.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block lantern;
	
	public static Block barrelvar1;
	public static Block barrelvar2;
	
	public static Block rockvar1_center;
	public static Block rockvar1_side;
	public static Block rockvar1_corner;

	public static Block rockvar2_center;
	public static Block rockvar2_side;
	public static Block rockvar2_corner;

	public static Block rockvar3_center;
	public static Block rockvar3_side;
	public static Block rockvar3_corner;
	
	public static void init()
	{
		lantern = new BlockLantern();
		
		barrelvar1 = new BlockBarrelvar1();
		barrelvar2 = new BlockBarrelvar2();
		
		rockvar1_center = new BlockRockvar1_center();
		rockvar1_side = new BlockRockvar1_side();
		rockvar1_corner = new BlockRockvar1_corner();

		rockvar2_center = new BlockRockvar2_center();
		rockvar2_side = new BlockRockvar2_side();
		rockvar2_corner = new BlockRockvar2_corner();

		rockvar3_center = new BlockRockvar3_center();
		rockvar3_side = new BlockRockvar3_side();
		rockvar3_corner = new BlockRockvar3_corner();
	}
	
	public static void register()
	{
		registerBlock(lantern);
		
		registerBlock(barrelvar1);
		registerBlock(barrelvar2);
		
		registerBlock(rockvar1_center);
		registerBlock(rockvar1_side);
		registerBlock(rockvar1_corner);

		registerBlock(rockvar2_center);
		registerBlock(rockvar2_side);
		registerBlock(rockvar2_corner);

		registerBlock(rockvar3_center);
		registerBlock(rockvar3_side);
		registerBlock(rockvar3_corner);
	}
	
	private static void registerBlock(Block block)
	{
		GameRegistry.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}
	
	public static void registerRenders()
	{
		registerRender(lantern);
		
		registerRender(barrelvar1);
		registerRender(barrelvar2);
		
		registerRender(rockvar1_center);
		registerRender(rockvar1_side);
		registerRender(rockvar1_corner);

		registerRender(rockvar2_center);
		registerRender(rockvar2_side);
		registerRender(rockvar2_corner);

		registerRender(rockvar3_center);
		registerRender(rockvar3_side);
		registerRender(rockvar3_corner);
	}
	
	private static void registerRender(Block block)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}
