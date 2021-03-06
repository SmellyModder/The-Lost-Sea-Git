package com.SmellyModder.TheLostSea.common.blocks;

import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.TheLostSea;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBase extends Block {
	
	public BlockBase(String name, Material material) {
		super(material);
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(TheLostSea.TLS_BLOCKS);
		TLSBlocks.BLOCKS.add(this);
		TLSItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
}
