package thor12022.expertusmagia.enchantments;

import thor12022.expertusmagia.ConfigHandler;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class EnchantmentAttack extends BaseEnchantment
{
   public static int id;
   
   public EnchantmentAttack()
   {
      super(ConfigHandler.attackEnchantmentId, 8, EnchantmentType.Primary);
      setName("expertusmagia.attack");
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
}
