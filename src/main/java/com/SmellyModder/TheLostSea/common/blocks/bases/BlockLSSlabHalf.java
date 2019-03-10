package com.SmellyModder.TheLostSea.common.blocks.bases;

import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.TheLostSea;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;

public class BlockLSSlabHalf extends BlockLSSlab {

	public BlockLSSlabHalf(String name, Material materialIn, BlockSlab half, BlockSlab doubleSlab) {
		super(name, materialIn, half);
		TLSItems.ITEMS.add(new ItemLSSlab(this, doubleSlab).setRegistryName(name));
	}
	
	@Override
	public boolean isDouble() {return false;}
}
