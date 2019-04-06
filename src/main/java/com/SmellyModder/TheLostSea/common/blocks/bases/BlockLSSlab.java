package com.SmellyModder.TheLostSea.common.blocks.bases;

import java.util.Random;

import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.TheLostSea;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPurpurSlab.Variant;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockLSSlab extends BlockSlab {
	Block half;
	public static final PropertyEnum<PalmVariant> VARIANT = PropertyEnum.<PalmVariant>create("variant", PalmVariant.class);
	
	public BlockLSSlab(String name, Material materialIn, BlockSlab half) {
		super(materialIn);
		
		setTranslationKey(name);
		setRegistryName(name);
		this.setCreativeTab(TheLostSea.TLS_BLOCKS);
		this.setHardness(2F);
		this.setResistance(15F);
		this.useNeighborBrightness = !this.isDouble();
		
		IBlockState state = this.blockState.getBaseState().withProperty(VARIANT, PalmVariant.DEFAULT);
		if(!this.isDouble()) state = state.withProperty(HALF, EnumBlockHalf.BOTTOM);
		setDefaultState(state);
		
		this.half = half;
		
		TLSBlocks.BLOCKS.add(this);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(half);
	}
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(half);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState state = this.blockState.getBaseState().withProperty(VARIANT, PalmVariant.DEFAULT);
		if(!this.isDouble()) state = state.withProperty(HALF, ((meta & 8) != 0) ? EnumBlockHalf.TOP : EnumBlockHalf.BOTTOM);
		return state;
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		int meta = 0;
		if(!this.isDouble() && state.getValue(HALF) == EnumBlockHalf.TOP) meta |= 8;
		return meta;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		if(!this.isDouble()) return new BlockStateContainer(this, new IProperty[] {VARIANT, HALF});
		else return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}

	@Override
	public String getTranslationKey(int meta) {
		return super.getTranslationKey();
	}

	@Override
	public boolean isDouble() {
		return false;
	}

	@Override
	public IProperty<?> getVariantProperty() {
		return VARIANT;
	}

	@Override
	public Comparable<?> getTypeForItem(ItemStack stack) {
		return Variant.DEFAULT;
	}
	
	public static enum PalmVariant implements IStringSerializable {
		DEFAULT;
		
		@Override
		public String getName() {
			return "default";
		}
	}
}
