package com.SmellyModder.TheLostSea.common.blocks.plants;

import java.util.Random;

import com.SmellyModder.TheLostSea.common.blocks.BlockBase;
import com.SmellyModder.TheLostSea.common.blocks.itemblocks.ItemBlockCoconut;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.TheLostSea;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDecoCoconut extends BlockFalling {

	public BlockDecoCoconut(String name) {
		super(Material.GOURD);
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(TheLostSea.TLS);
		TLSBlocks.BLOCKS.add(this);
		TLSItems.ITEMS.add(new ItemBlockCoconut(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {}
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

}
