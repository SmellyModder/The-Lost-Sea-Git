package com.SmellyModder.TheLostSea.core.api.relics;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public interface IEquppible {
	
	public default void onWearingTick(ItemStack itemstack, EntityLivingBase player) {}
	
	public default void onEquipped(ItemStack itemstack, EntityLivingBase player) {}
	
	public default void onUnequipped(ItemStack itemstack, EntityLivingBase player) {}
	
	public default boolean isCursed(ItemStack itemstack) {return false;}
	
	public default ElementType getElementType(ItemStack stack) {return ElementType.NORMAL;}
	
	public EquippableType getEquippableType(ItemStack stack);
}
