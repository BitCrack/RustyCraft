package bitcrack.rustycraft.init;

import bitcrack.rustycraft.Reference;
import bitcrack.rustycraft.items.ItemLantern;
import bitcrack.rustycraft.items.ItemScrap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static Item lantern;
	public static Item scrap;

	public static void init()
	{
		lantern = new ItemLantern();
		scrap = new ItemScrap();
	}
	
	public static void register()
	{
		GameRegistry.register(lantern);
		GameRegistry.register(scrap);
	}
	
	public static void registerRenders()
	{
		registerRender(lantern);
		registerRender(scrap);
	}
	
	private static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
