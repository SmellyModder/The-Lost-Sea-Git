package com.SmellyModder.TheLostSea.common.blocks;

import net.minecraft.block.material.Material;

public class BlockMetalBase extends BlockBase{

	public BlockMetalBase(String name, Material material, float hardness, float resistance) {
		super(name, material);
		setHardness(hardness);
		setResistance(resistance);
	}
	
	
}
