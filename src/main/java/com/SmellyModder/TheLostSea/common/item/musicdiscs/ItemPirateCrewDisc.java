package com.SmellyModder.TheLostSea.common.item.musicdiscs;

import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.util.IHasModel;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;

import net.minecraft.item.ItemRecord;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPirateCrewDisc extends ItemRecord implements IHasModel{

	public ItemPirateCrewDisc(String name, SoundEvent soundIn) {
		super(name, soundIn);
		this.setTranslationKey(name);
		this.setRegistryName(name);
		setCreativeTab(TheLostSea.TLS_MUSIC);
		
		TLSItems.ITEMS.add(this);
	}
	@Override
	public void registerModels() {
		TheLostSea.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
