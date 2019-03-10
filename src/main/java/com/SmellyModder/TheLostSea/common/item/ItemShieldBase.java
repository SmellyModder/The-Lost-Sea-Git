package com.SmellyModder.TheLostSea.common.item;

import java.util.List;

import javax.annotation.Nullable;

import com.SmellyModder.TheLostSea.core.TheLostSea;

import net.minecraft.block.BlockDispenser;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBanner;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemShieldBase extends ItemBase {
	
	TLS_Rarities rarity;
	
		public ItemShieldBase(String name, TLS_Rarities rarityAmt) {
			super(name);
			this.maxStackSize = 1;
			this.setCreativeTab(TheLostSea.TLS_GEAR);
			this.setMaxDamage(387);
			
			this.rarity = rarityAmt;
			
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

	/**
	 * returns the action that specifies what animation to play when the items is being used
	 */
	public EnumAction getItemUseAction(ItemStack stack)
	{
	    return EnumAction.BLOCK;
	}
	
	@Override
	public TLS_Rarities getTLSRarity(ItemStack stack) {
	return this.rarity;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	public int getMaxItemUseDuration(ItemStack stack)
	{
	    return 25000;
	}

	/**
	 * Called when the equipped item is right clicked.
	 */
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{
	    ItemStack itemstack = playerIn.getHeldItem(handIn);
	    playerIn.setActiveHand(handIn);
	    return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack) {
	return EnumRarity.RARE;
	}
	
}
