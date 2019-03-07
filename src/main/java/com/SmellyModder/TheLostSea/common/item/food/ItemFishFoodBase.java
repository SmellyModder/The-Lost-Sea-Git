package com.SmellyModder.TheLostSea.common.item.food;

import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.IHasModel;

import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemFood;

public class ItemFishFoodBase extends ItemFood implements IHasModel{

	public ItemFishFoodBase(String name, int amount) {
		super(amount, false);
		setRegistryName(name);
		setTranslationKey(name);
		setCreativeTab(TheLostSea.TLS);
		TLSItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		TheLostSea.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
