package com.SmellyModder.TheLostSea.common.item;

import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.TheLostSea;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBase extends Item {

	public ItemBase(String name) {
		setRegistryName(name);
		setTranslationKey(name);
		setCreativeTab(TheLostSea.TLS);
		
		TLSItems.ITEMS.add(this);
	}
	
	public TLS_Rarities getTLSRarity(ItemStack stack) {
		return stack.isItemEnchanted() ? TLS_Rarities.RARE : TLS_Rarities.ENCHANTED;
	}
	
}
