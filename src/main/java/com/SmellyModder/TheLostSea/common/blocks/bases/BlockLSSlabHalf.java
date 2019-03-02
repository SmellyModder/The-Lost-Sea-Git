package com.SmellyModder.TheLostSea.common.blocks.bases;

import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.util.IHasModel;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;

public class BlockLSSlabHalf extends BlockLSSlab implements IHasModel {

	public BlockLSSlabHalf(String name, Material materialIn, BlockSlab half, BlockSlab doubleSlab) {
		super(name, materialIn, half);
		TLSItems.ITEMS.add(new ItemLSSlab(this, doubleSlab).setRegistryName(name));
	}
	
	@Override
	public boolean isDouble() {return false;}

	@Override
	public void registerModels() {
		TheLostSea.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
}
