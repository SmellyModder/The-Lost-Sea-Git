package com.SmellyModder.TheLostSea.common.blocks;

import java.util.Random;

import com.SmellyModder.TheLostSea.common.init.TLSBlocks;

import net.minecraft.block.BlockStone;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockRock extends BlockBase{
	private float h;
	public BlockRock(String name, Material material, float hardness, boolean isCobble) {
		super(name, material);
		setHardness(hardness);
		setResistance(22.0F);
		h = hardness;
	}

	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return MapColor.ADOBE;
	}
	
}
