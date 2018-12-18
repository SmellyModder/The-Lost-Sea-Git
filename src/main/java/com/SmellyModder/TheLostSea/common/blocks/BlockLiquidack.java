package com.SmellyModder.TheLostSea.common.blocks;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockLiquidack extends BlockBase{

	public BlockLiquidack(String name, Material material) {
		super(name, material);
		setHardness(1.0F);
		setHarvestLevel("pickaxe", 1);
		setResistance(0.9F);
	}

	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return MapColor.LAPIS;
    }
}
