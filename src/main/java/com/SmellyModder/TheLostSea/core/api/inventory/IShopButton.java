package com.SmellyModder.TheLostSea.core.api.inventory;

import net.minecraft.item.Item;

public interface IShopButton {

	public Item getItem();
	
	public int setPrice();
	
	public String getDescription();
}
