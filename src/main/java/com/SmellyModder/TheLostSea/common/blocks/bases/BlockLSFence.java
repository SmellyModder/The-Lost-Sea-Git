package com.SmellyModder.TheLostSea.common.blocks.bases;

import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLSFence extends BlockFence implements IHasModel {

	IBlockState parent;
	public BlockLSFence(String name, IBlockState blockParent) {
		super(Material.WOOD, MapColor.WOOD);
		this.setCreativeTab(TheLostSea.TLS_BLOCKS);
		parent = blockParent;
		setRegistryName(name);
		setTranslationKey(name);
		
		TLSBlocks.BLOCKS.add(this);
		TLSItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
		return parent.getBlockHardness(worldIn, pos);
	}
	
	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
	    return parent.getBlock().getFireSpreadSpeed(world, pos, face);
	}

	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
	    return parent.getBlock().getFlammability(world, pos, face);
	}
	
	@Override	
	public void registerModels() {
		TheLostSea.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
