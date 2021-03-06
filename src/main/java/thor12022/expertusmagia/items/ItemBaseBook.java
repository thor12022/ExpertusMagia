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

public class ItemBaseBook extends ItemBase
{

   public IIcon[] icon = new IIcon[1];

   public ItemBaseBook()
   {
      super("book");
      this.setHasSubtypes(true);
      this.setMaxStackSize(1);
   }

   @Override
   public String getUnlocalizedName(ItemStack itemstack)
   {
      String name = "";
      switch(itemstack.getItemDamage())
      {
         case 0:
         {
            name = "base";
            break;
         }
         default:
            name = "nothing";
            break;
      }
      return getUnlocalizedName() + "." + name;
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister ri)
   {
      this.icon[0] = ri.registerIcon(ModInformation.ID + ":baseBook_closed");
   }

   @SideOnly(Side.CLIENT)
   public IIcon getIconFromDamage(int meta)
   {
      return this.icon[meta];
   }

   @SuppressWarnings({ "rawtypes", "unchecked" })
   @SideOnly(Side.CLIENT)
   public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List list)
   {
      for(int i = 0; i <= 0; i++)
      {
         list.add(new ItemStack(this, 1, i));
      }
   }

   @Override
   public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
   {
      switch(itemStack.getItemDamage())
      {
         case 0:
         {
            player.openGui(ExpertusMagia.instance, 0, world, (int) player.posX, (int) player.posY, (int) player.posZ);
            return itemStack;
         }
      }
      return itemStack;
   }

   @SuppressWarnings("unchecked")
   @Override
   public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
   {
   }
}
