package com.SmellyModder.TheLostSea.common.blocks.bases;

import com.SmellyModder.TheLostSea.common.blocks.BlockBase;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.TheLostSea;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockLSPlank extends Block {

	public BlockLSPlank(String name) {
		super(Material.WOOD);
		setHardness(2.0F);
		setResistance(5.0F);
		setHarvestLevel("axe", 0);
		setCreativeTab(TheLostSea.TLS_BLOCKS);
		setTranslationKey(name);
		setRegistryName(name);
		
		TLSBlocks.BLOCKS.add(this);
		TLSItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return 5;
    }

    @Override
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return 20;
    }
	
}
