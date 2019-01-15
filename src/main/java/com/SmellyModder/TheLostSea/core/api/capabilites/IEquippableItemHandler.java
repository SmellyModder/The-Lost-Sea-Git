package com.SmellyModder.TheLostSea.core.api.capabilites;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandlerModifiable;

public interface IEquippableItemHandler extends IItemHandlerModifiable {

	public boolean isItemValidForSlot(int slot, ItemStack stack, EntityLivingBase player);

	
	public boolean isEquipBlocked();
	public void setEquipBlocked(boolean blockEvents);
	
	
	boolean hasChanged(int slot);
	void setChanged(int slot, boolean changed);

	public void setPlayer(EntityLivingBase player);

}
