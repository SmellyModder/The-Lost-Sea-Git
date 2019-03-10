package com.SmellyModder.TheLostSea.common.item.musicdiscs;

import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.TheLostSea;

import net.minecraft.item.ItemRecord;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPirateCrewDisc extends ItemRecord {

	public ItemPirateCrewDisc(String name, SoundEvent soundIn) {
		super(name, soundIn);
		this.setTranslationKey(name);
		this.setRegistryName(name);
		setCreativeTab(TheLostSea.TLS_SPECIAL);
		
		TLSItems.ITEMS.add(this);
	}
	
}
