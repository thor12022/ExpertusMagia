package thor12022.expertusmagia.enchantments;

import net.minecraft.enchantment.Enchantment;
import thor12022.expertusmagia.ConfigHandler;
import thor12022.expertusmagia.enchantments.*;

public class EnchantmentRegistry
{
   public static Enchantment excavate;
   public static Enchantment attack; 
   public static void registerEnchantments()
   {
      excavate = new EnchantmentExcavate();
      Enchantment.addToBookList(excavate);
      
      attack = new EnchantmentAttack();
      Enchantment.addToBookList(attack);
   }
}
