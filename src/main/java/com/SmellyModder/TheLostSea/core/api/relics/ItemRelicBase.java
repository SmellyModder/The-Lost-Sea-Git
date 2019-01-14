package com.SmellyModder.TheLostSea.core.api.relics;

import com.SmellyModder.TheLostSea.common.item.ItemBase;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;

public class ItemRelicBase extends ItemBase implements IEquppible{

	public ItemRelicBase(String name) {
		super(name);
	}

	@Override
	public EquippableType getEquippableType(ItemStack stack) {
		return EquippableType.RELIC;
	}
	
	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
	}

}
