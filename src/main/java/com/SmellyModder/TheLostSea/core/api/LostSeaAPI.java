package com.SmellyModder.TheLostSea.core.api;

import com.SmellyModder.TheLostSea.core.api.capabilites.EquippableCapabilties;
import com.SmellyModder.TheLostSea.core.api.capabilites.IEquippableItemHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

public class LostSeaAPI {
	
	public static IEquippableItemHandler getEquippableHandler(EntityPlayer player)
	{
		IEquippableItemHandler handler = player.getCapability(EquippableCapabilties.CAPABILITY_EQUIPPABLES, null);
		handler.setPlayer(player);
		return handler;
	}
	
	public static int isEquippableEquipped(EntityPlayer player, Item equippable) {
		IEquippableItemHandler handler = getEquippableHandler(player);
		for (int i = 0; i < handler.getSlots(); i++) {
			
			if (!handler.getStackInSlot(i).isEmpty() && handler.getStackInSlot(i).getItem()==equippable) 
				
				return i;
		}
		return -1;
	}
	
}
