package com.SmellyModder.TheLostSea.core.api.shop;

import net.minecraft.item.Item;

public interface IShopButton {

	public Item getItem();
	
	public int setPrice();
	
	public String getDescription();
}
