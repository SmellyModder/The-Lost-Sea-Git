package com.SmellyModder.TheLostSea.common.item.shield;

import java.util.List;

import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;

import com.SmellyModder.TheLostSea.client.model.items.ModelCobaltShield;
import com.SmellyModder.TheLostSea.client.model.items.ModelLSShield;
import com.SmellyModder.TheLostSea.client.model.items.ModelVanadiumShield;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSEnchants;
import com.SmellyModder.TheLostSea.common.item.ItemBase;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.interfaces.ILSShield;

import net.minecraft.block.BlockDispenser;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
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

public class ItemNeptunumShield extends ItemBase implements ILSShield
{
    public ItemNeptunumShield(String name)
    {
    	super(name);
        this.maxStackSize = 1;
        this.setMaxDamage(876);
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
        return I18n.translateToLocal("item.cobalt_shield.name");
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
        return repair.getItem() == Item.getItemFromBlock(TLSBlocks.COBALT_BLOCK) ? true : super.getIsRepairable(toRepair, repair);
    }

	@Override
	public ModelLSShield shieldModel() {
		return new ModelCobaltShield();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
        {
			tooltip.add(TextFormatting.BLUE + "Water-Bound:" + TextFormatting.GRAY + " This item is more powerful when your elements are bound to water");
        }
		else {
			tooltip.add(TextFormatting.BLUE + "Water-Bound" + TextFormatting.GRAY + " [SHIFT]");
		}
	}
}
