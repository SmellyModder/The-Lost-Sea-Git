package com.SmellyModder.TheLostSea.common.item;

import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.util.IHasModel;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBase extends Item implements IHasModel{

	public ItemBase(String name)
	{
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
