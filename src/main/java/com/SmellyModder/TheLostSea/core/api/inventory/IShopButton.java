package com.SmellyModder.TheLostSea.core.api.inventory;

import net.minecraft.item.Item;

public interface IShopButton {

	/*
	 * Sets the Button Item's Price
	 */
	public int getPrice();
	
	/*
	 * Sets the Item for sale
	 */
	public Item getItem();
	
}
