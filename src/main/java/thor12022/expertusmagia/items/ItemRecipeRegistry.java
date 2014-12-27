package thor12022.expertusmagia.items;

/*
 * General place to do all your item related recipe things'n'stuff.
 */

import thor12022.expertusmagia.blocks.BlockRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ItemRecipeRegistry
{

   // Self explanatory. Continue these how you wish. EG: registerSmeltingRecipes
   private static void registerShapedRecipes()
   {
      GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.blaze_rod), new Object[] { "X  ", " X ", "  X", 'X', "powderBlaze" }));
      GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.blaze_rod), new Object[] { "  X", " X ", "X  ", 'X', "powderBlaze" }));
   }

   private static void registerShaplessRecipes()
   {
      //GameRegistry.addShapelessRecipe(new ItemStack(BlockRegistry.exampleBlock), new ItemStack( ItemRegistry.example, 9));
   }

   public static void registerItemRecipes()
   {
      registerShapedRecipes();
      registerShaplessRecipes();
   }
}
