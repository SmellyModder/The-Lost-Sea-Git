package com.SmellyModder.TheLostSea.common.blocks.bases;

import com.SmellyModder.TheLostSea.common.blocks.BlockBase;
import com.SmellyModder.TheLostSea.core.TheLostSea;

import net.minecraft.block.material.Material;

public class BlockLSBark extends BlockBase {

	public BlockLSBark(String name) {
		super(name, Material.WOOD);
		setHardness(2.0F);
		setResistance(5.0F);
		setHarvestLevel("axe", 0);
		setCreativeTab(TheLostSea.TLS_BLOCKS);
	}
}
