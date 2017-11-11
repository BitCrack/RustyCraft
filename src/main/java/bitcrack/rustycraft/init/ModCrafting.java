package bitcrack.rustycraft.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ModCrafting {

	public static void register()
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.lantern), "III", "GCG", "III", 'I', "ingotIron", 'G', "blockGlass", 'C', Items.COAL));
	}
}
