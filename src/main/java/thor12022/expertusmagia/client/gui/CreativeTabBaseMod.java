package thor12022.expertusmagia.client.gui;

//Creates your creative tab.

import thor12022.expertusmagia.ModInformation;
import thor12022.expertusmagia.items.ItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabBaseMod extends CreativeTabs
{

   public CreativeTabBaseMod(String tabLabel)
   {
      super(tabLabel);
      setBackgroundImageName(ModInformation.ID + ".png"); 
   }

   public boolean hasSearchBar()
   {
      return true;
   }

   // The tab icon is what you return here.
   @Override
   public ItemStack getIconItemStack()
   {
      return new ItemStack(ItemRegistry.wand);
   }

   @Override
   public Item getTabIconItem()
   {
      return new Item();
   }
   
}