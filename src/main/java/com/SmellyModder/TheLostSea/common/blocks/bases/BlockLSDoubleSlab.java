package com.SmellyModder.TheLostSea.common.blocks.bases;

import com.SmellyModder.TheLostSea.common.init.TLSBlocks;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;

public class BlockLSDoubleSlab extends BlockLSSlab {

	public BlockLSDoubleSlab(String name, Material materialIn, BlockSlab half) {
		super(name, materialIn, half);
	}

	@Override
	public boolean isDouble() {return true;}
}
