package thor12022.expertusmagia.enchantments;

import thor12022.expertusmagia.ConfigHandler;
import thor12022.expertusmagia.items.ItemWand;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class EnchantmentExcavate extends Enchantment
{
   public EnchantmentExcavate()
   {
      super(ConfigHandler.excavateEnchantmentId, 8, EnumEnchantmentType.all);
      setName("expertusmagia.excavate");
   }
   
   @Override
   public int getMaxLevel()
   {
      return 5;
   }
   
   @Override
   public int getMinEnchantability(int level)
   {
      return getMaxEnchantability(level) - 10;
   }
   
   @Override
   public int getMaxEnchantability(int level) 
   {
      return level * 10;
   }
   
   @Override
   public boolean canApply(ItemStack itemStack)
   {
       return itemStack.getItem() instanceof ItemWand;
   }
}
