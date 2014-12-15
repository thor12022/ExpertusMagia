package thor12022.expertusmagia.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

import thor12022.expertusmagia.ExpertusMagia;
import thor12022.expertusmagia.ModInformation;
import thor12022.expertusmagia.util.TextHelper;

public class ItemWand extends ItemBase
{

   public ItemWand()
   {
      super("wand");
      this.setMaxStackSize(1);
   }

   @Override
   public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
   {
      if(player.experienceTotal > 0)
      {
         // list.add(TextHelper.RED + TextHelper.localize("info." +
         // ModInformation.ID + ".tooltip.fire"));
      } else
      {
         player.addChatMessage(new ChatComponentTranslation("info." + ModInformation.ID + ".chat.lowXp"));
      }
      return itemStack;
   }

   @SuppressWarnings("unchecked")
   @Override
   public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
   {

   }
}
