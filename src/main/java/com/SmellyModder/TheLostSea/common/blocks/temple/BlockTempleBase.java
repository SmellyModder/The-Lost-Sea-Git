package com.SmellyModder.TheLostSea.common.blocks.temple;

import com.SmellyModder.TheLostSea.common.blocks.BlockBase;

import net.minecraft.block.material.Material;

public class BlockTempleBase extends BlockBase{

	public BlockTempleBase(String name, Material material) {
		super(name, material);
		setLightLevel(0.7F);
		setResistance(1.0F);
		setHardness(2.0F);
	}
}
