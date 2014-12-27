package thor12022.expertusmagia.enchantments;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;
import thor12022.expertusmagia.ConfigHandler;
import thor12022.expertusmagia.enchantments.*;
import thor12022.expertusmagia.items.ItemWand;

public abstract class BaseEnchantment extends Enchantment
{
   public static Enchantment excavate;
   public static Enchantment attack; 
   
   private EnchantmentType type;
   
   public static void registerEnchantments()
   {
      excavate = new EnchantmentExcavate();
      Enchantment.addToBookList(excavate);
      
      attack = new EnchantmentAttack();
      Enchantment.addToBookList(attack);
   }
    
   protected BaseEnchantment(int id, int weight, EnchantmentType enchantType)
   {
      super(id, weight, EnumEnchantmentType.all);
      type = enchantType;
   }
   
   @Override
   public boolean canApply(ItemStack stack)
   {
      if( stack.getItem() instanceof ItemWand )
      {
         return true;
      }
      else
      {
         return false;
      }
   }

   @Override
   public boolean canApplyTogether(Enchantment enchant)
   {
      if( enchant instanceof BaseEnchantment )
      {
         if( ((BaseEnchantment)enchant).type == EnchantmentType.Primary )
         {
            return false;
         }
      }
      return super.canApplyTogether(enchant);
   }
}
