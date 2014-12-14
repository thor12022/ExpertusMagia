package thor12022.expertusmagia.util;

//General place to register all oreDict recipes.

import thor12022.expertusmagia.blocks.BlockRegistry;
import thor12022.expertusmagia.items.ItemRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictHandler {

	//Oredict entries
	//items
	public static String powderBlaze = "powderBlaze";
	public static String quisqueLapis = "dustQuisqueLapis";

	//blocks
	public static String quisqueLapis_ore = "oreLapisQuisque";

	public static void registerOreDict() {
		OreDictionary.registerOre(powderBlaze, new ItemStack(Items.blaze_powder, 1, 0));
		OreDictionary.registerOre(quisqueLapis, new ItemStack(ItemRegistry.quisqueLapis));

		OreDictionary.registerOre(quisqueLapis_ore, new ItemStack(BlockRegistry.quisqueLapisOre));
	}
}