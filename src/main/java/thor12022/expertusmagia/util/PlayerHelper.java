package thor12022.expertusmagia.util;

import net.minecraft.entity.player.EntityPlayer;

public class PlayerHelper
{
   public static boolean hasAnyExperience(EntityPlayer player)
   {
      return player.experienceLevel > 0 || player.experienceTotal > 0;
   }
   
   public static void subtractExperience( EntityPlayer player, int xp )
   {
      if( player.experience < (float)xp )
      {
         player.addExperienceLevel(-1); 
         player.addExperience( player.xpBarCap() -  (int)Math.ceil(xp - player.experience) );
      }
      else
      {
         player.addExperience(-1 * xp);
      }
   }
}
