package thor12022.expertusmagia.blocks;

/*
 * General place to do all your block related recipe things'n'stuff.
 */

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class BlockRecipeRegistry
{

   // Self explanatory. Continue these how you wish. EG:
   // registerPulverizerRecipes
   private static void registerShapedRecipes()
   {
      //GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.exampleBlock), new Object[] { "XXX", "XXX", "XXX", 'X', "dustExample" }));
   }

   private static void registerShaplessRecipes()
   {

   }

   public static void registerBlockRecipes()
   {
      registerShapedRecipes();
      registerShaplessRecipes();
   }
}
