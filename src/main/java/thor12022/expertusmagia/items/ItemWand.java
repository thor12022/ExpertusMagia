package thor12022.expertusmagia.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

import com.google.common.collect.Multimap;

import thor12022.expertusmagia.ExpertusMagia;
import thor12022.expertusmagia.ModInformation;
import thor12022.expertusmagia.enchantments.BaseEnchantment;
import thor12022.expertusmagia.util.KeyboardHelper;
import thor12022.expertusmagia.util.TextHelper;

public class ItemWand extends ItemBase
{

   public ItemWand()
   {
      super("wand");
      this.setTextureName(ModInformation.ID + ":wand");
      this.setMaxStackSize(1);
   }
   
   @Override
   public boolean canHarvestBlock(Block block, ItemStack stack)
   {
      //! @todo proper metadata for harvest level
      return getHarvestLevel(stack, block.getHarvestTool(0)) >= block.getHarvestLevel(0);
   }
   
   @Override
   public int getItemEnchantability()
   {
       return 8;
   }
   
   @Override
   public boolean isItemTool(ItemStack itemStack)
   {
      return itemStack.getItem() instanceof ItemWand;
   }

   @Override
   public float getDigSpeed(ItemStack stack, Block block, int meta)
   {
      if( EnchantmentHelper.getEnchantmentLevel(BaseEnchantment.excavate.effectId, stack) > 0 )
      {
         return (EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, stack) + 1 ) * 1.5f;
      }
      else
      {
         return 0.0f;
      }
   }

   @Override
   public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player)
   {
      if(player.experienceTotal > 0)
      {
         return super.onBlockStartBreak(itemstack, x, y, z, player);
      }
      else
      {
         player.addChatMessage(new ChatComponentTranslation("info." + ModInformation.ID + ".chat.lowXp"));
         return true;
      }
   }
   
   @Override
   public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
   {
      if(player.experienceTotal > 0)
      {
         return super.onItemUse(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
      } 
      else
      {
         player.addChatMessage(new ChatComponentTranslation("info." + ModInformation.ID + ".chat.lowXp"));
         return false;
      }
   }

   @SuppressWarnings("unchecked")
   @Override
   public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
   {
      
   }

   @Override
   public int getHarvestLevel(ItemStack stack, String toolClass)
   {
      return ( toolClass == "pickaxe" || toolClass == "shovel" || toolClass == "axe" ) ? 
               EnchantmentHelper.getEnchantmentLevel(BaseEnchantment.excavate.effectId, stack) :
               0;
   }

   @Override
   public boolean isDamageable()
   {
      return true;
   }
   
   /**
    * ItemStack sensitive version of getItemAttributeModifiers
    */
   @Override
   public Multimap getAttributeModifiers(ItemStack stack)
   {
       Multimap multimap = super.getItemAttributeModifiers();
       double modifier = EnchantmentHelper.getEnchantmentLevel(BaseEnchantment.attack.effectId, stack) * 1.0;
       multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", modifier, 0));
       return multimap;
   }

   public void addMoreInformation(ItemStack itemStack, List<String> toolTip)
   {
      int harvestLevel = getHarvestLevel( itemStack, "pickaxe" );
      if( harvestLevel > 0 )
      {
         toolTip.add(new String(TextHelper.localize("info." + ModInformation.ID + ".tooltip.harvestLevel") + ": " + harvestLevel));
      }
      Block digBlock;
      digBlock = (BlockStone)Block.blockRegistry.getObject("stone");
      toolTip.add(new String(TextHelper.localize("info." + ModInformation.ID + ".tooltip.digSpeed") +": " + 
                          String.format("%.2f", itemStack.getItem().getDigSpeed(itemStack, digBlock,0))));
      toolTip.add(new String(TextHelper.localize("info." + ModInformation.ID + ".tooltip.enchantability") + ": " + 
                          itemStack.getItem().getItemEnchantability()));
   }
}
