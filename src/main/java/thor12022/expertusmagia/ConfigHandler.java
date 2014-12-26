package thor12022.expertusmagia;

/*
 * Creation and usage of the config file.
 */

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler
{

   public static Configuration config;

   // Sections to add to the config
   public static String exampleSection = "Enchantments";

   // Options in the config
   public static int excavateEnchantmentId   = 232;
   public static int attackEnchantmentId     = 233;
   public static int empowerEnchantmentId    = 0;

   public static void init(File file)
   {
      config = new Configuration(file);
      syncConfig();
   }

   public static void syncConfig()
   {
      config.addCustomCategoryComment(exampleSection, "");

      excavateEnchantmentId = config.get(exampleSection, "excavate", excavateEnchantmentId, "WIP").getInt(excavateEnchantmentId);
      attackEnchantmentId = config.get(exampleSection, "attack", attackEnchantmentId, "WIP").getInt(attackEnchantmentId);
      empowerEnchantmentId = config.get(exampleSection, "empower", empowerEnchantmentId, "Unimplemented").getInt(empowerEnchantmentId);

      config.save();
   }
}
