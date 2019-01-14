package com.SmellyModder.TheLostSea.core.api.relics;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public interface IEquppible {
	
	/*
	 * Checks for if it's worn and can perform some action inside the method
	 */
	public default void onWearingTick(ItemStack itemstack, EntityLivingBase player) {}
	
	/*
	 * Triggers whenever the item is equiped and can perform some action inside the method
	 */
	public default void onEquipped(ItemStack itemstack, EntityLivingBase player) {}
	
	/*
	 * Triggers whenever the item is unequiped and can perform some action inside the method
	 */
	public default void onUnequipped(ItemStack itemstack, EntityLivingBase player) {}
	
	/*
	 * Set's the item to be cursed or not
	 */
	public default boolean isCursed(ItemStack itemstack) {return false;}
	
	/*
	 * Set's/Gets the item's element type
	 */
	public default ElementType getElementType(ItemStack stack) {return ElementType.NORMAL;}
	
	/*
	 * Set's/Gets the item's type of equippable that it is; ex. EquippableType.RELIC
	 */
	public EquippableType getEquippableType(ItemStack stack);
}
