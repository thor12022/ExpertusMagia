package thor12022.expertusmagia.util;

/*
 * Class for most of your events to be registered in.
 * Remember that there are two different registries for Events. This one will not work for everything.
 */

import thor12022.expertusmagia.ConfigHandler;
import thor12022.expertusmagia.items.ItemWand;
import thor12022.expertusmagia.ExpertusMagia;
import thor12022.expertusmagia.ModInformation;
import thor12022.expertusmagia.util.KeyboardHelper;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class EventHandler
{

   @SubscribeEvent
   public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs)
   {
      if(eventArgs.modID.equals(ModInformation.ID))
      {
         ConfigHandler.syncConfig();
         ExpertusMagia.logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.config.refresh"));
      }
   }
   
   @SubscribeEvent
   public void onItemTooltip(ItemTooltipEvent eventArg)
   {
      if( eventArg.itemStack.getItem() instanceof ItemWand )
      {
         ItemWand wand = (ItemWand) eventArg.itemStack.getItem();
         if (KeyboardHelper.isShiftDown())
         {
            wand.addMoreInformation(eventArg.itemStack, eventArg.toolTip );
         }
         else
         {
            eventArg.toolTip.add(TextHelper.localize("info." + ModInformation.ID + ".tooltip.shiftMessage"));
         }
      }
   }
}
