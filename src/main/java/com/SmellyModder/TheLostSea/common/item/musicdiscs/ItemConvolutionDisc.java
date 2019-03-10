package com.SmellyModder.TheLostSea.common.item.musicdiscs;

import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.TheLostSea;

import net.minecraft.item.ItemRecord;
import net.minecraft.util.SoundEvent;

public class ItemConvolutionDisc extends ItemRecord {

	public ItemConvolutionDisc(String name, SoundEvent soundIn) {
		super(name, soundIn);
		this.setTranslationKey(name);
		this.setRegistryName(name);
		setCreativeTab(TheLostSea.TLS_SPECIAL);
		
		TLSItems.ITEMS.add(this);
	}
	
}
