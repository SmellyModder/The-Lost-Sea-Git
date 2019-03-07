package com.SmellyModder.TheLostSea.common.item.shield;

import java.util.List;

import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;

import com.SmellyModder.TheLostSea.common.item.ItemBase;
import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.interfaces.ILSShield;
import com.SmellyModder.TheLostSea.client.model.items.ModelLSShield;
import com.SmellyModder.TheLostSea.client.model.items.ModelVanadiumShield;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSEnchants;

import net.minecraft.block.BlockDispenser;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBanner;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemVanadiumShield extends ItemBase implements ILSShield
{
    public ItemVanadiumShield(String name)
    {
    	super(name);
        this.maxStackSize = 1;
        this.setMaxDamage(655);
        this.setCreativeTab(TheLostSea.TLS_GEAR);
        this.addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, ItemArmor.DISPENSER_BEHAVIOR);
    }

    public String getItemStackDisplayName(ItemStack stack)
    {
        return I18n.translateToLocal("item.v_shield.name");
    }
    
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BLOCK;
    }

    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }

    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        return repair.getItem() == Item.getItemFromBlock(TLSBlocks.VANADIUM_BLOCK) ? true : super.getIsRepairable(toRepair, repair);
    }

	@Override
	public ModelLSShield shieldModel() {
		return new ModelVanadiumShield();
	}

}
