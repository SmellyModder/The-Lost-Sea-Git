package com.SmellyModder.TheLostSea.common.blocks.temple;

import com.SmellyModder.TheLostSea.common.blocks.BlockBase;

import net.minecraft.block.material.Material;

public class BlockTempleBaseStone extends BlockBase{

	public BlockTempleBaseStone(String name, Material material) {
		super(name, material);
		setResistance(1.0F);
		setHardness(2.0F);
	}

}
