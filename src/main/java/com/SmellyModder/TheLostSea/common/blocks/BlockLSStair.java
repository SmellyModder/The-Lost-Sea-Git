package com.SmellyModder.TheLostSea.common.blocks;

import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.IHasModel;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockLSStair extends BlockStairs implements IHasModel{

	public BlockLSStair(String name, IBlockState modelState) {
		super(modelState);
		this.useNeighborBrightness = true;
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(TheLostSea.TLS_BLOCKS);
		TLSBlocks.BLOCKS.add(this);
		TLSItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {
		TheLostSea.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}
