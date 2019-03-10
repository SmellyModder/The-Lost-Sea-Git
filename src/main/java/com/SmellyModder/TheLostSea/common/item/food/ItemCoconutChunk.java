package com.SmellyModder.TheLostSea.common.item.food;

import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.TheLostSea;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemCoconutChunk extends ItemFood {

	public ItemCoconutChunk() {
		super(4, false);
		
		this.setRegistryName("coconut_chunk");
		this.setTranslationKey("coconut_chunk");
		
		this.setCreativeTab(TheLostSea.TLS);
		TLSItems.ITEMS.add(this);
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
    {
        return 28;
    }
	
	@Override
	public float getSaturationModifier(ItemStack stack) {
		return 0.8F;
	}

}
