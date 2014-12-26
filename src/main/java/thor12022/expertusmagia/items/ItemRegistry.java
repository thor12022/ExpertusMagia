package thor12022.expertusmagia.items;

/*
 * Class to register your blocks in.
 * The order that you list them here is the order they are registered.
 * Keep that in mind if you like nicely organized creative tabs.
 */

import thor12022.expertusmagia.ConfigHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.init.Items;

public class ItemRegistry
{

   // items
   public static Item quisqueLapis;
   public static Item baseBook;
   public static Item wand;

   public static void registerItems()
   {
      quisqueLapis = new ItemLapisQuisque();
      GameRegistry.registerItem(quisqueLapis, "ItemLapisQuisque");

      baseBook = new ItemBaseBook();
      GameRegistry.registerItem(baseBook, "ItemBaseBook");

      wand = new ItemWand();
      GameRegistry.registerItem(wand, "ItemWand");
   }
}
