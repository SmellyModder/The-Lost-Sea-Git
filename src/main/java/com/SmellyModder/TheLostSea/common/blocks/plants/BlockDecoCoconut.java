package com.SmellyModder.TheLostSea.common.blocks.plants;

import java.util.Random;

import javax.annotation.Nullable;

import com.SmellyModder.TheLostSea.common.blocks.BlockBase;
import com.SmellyModder.TheLostSea.common.blocks.itemblocks.ItemBlockCoconut;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.player.events.PlayerBreakEvents;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDecoCoconut extends BlockFalling {

	protected static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.50D, 0.75D);
	
	public BlockDecoCoconut(String name) {
		super(Material.GOURD);
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(TheLostSea.TLS);
		TLSBlocks.BLOCKS.add(this);
		TLSItems.ITEMS.add(new ItemBlockCoconut(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void harvestBlock(World world, EntityPlayer player, BlockPos blockPos, IBlockState state, TileEntity te, ItemStack stack) {
		ItemStack stackP = player.getHeldItemMainhand();
		final ItemStack[] COCONUT = {new ItemStack(TLSBlocks.COCONUT_ITEMBLOCK), new ItemStack(TLSItems.COCONUT_CHUNK)};
		
		int[] pos = {blockPos.getX(), blockPos.getY(), blockPos.getZ()};
		
		if(stackP != null && PlayerBreakEvents.isSword(stackP.getItem())) {
			int numToDrop = world.rand.nextInt(4) + 1;
			
			for (int i = 0; i < numToDrop; i++) {
				PlayerBreakEvents.doBlockDrop(world, pos[0], pos[1], pos[2], COCONUT[1]);
			}
		} else if(stackP != null && !PlayerBreakEvents.isSword(stackP.getItem())) {
			PlayerBreakEvents.doBlockDrop(world, pos[0], pos[1], pos[2], COCONUT[0]);
		}
		super.harvestBlock(world, player, blockPos, state, te, stack);
	}
	
	@Nullable
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {return null;}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {return BOUNDING_BOX;}
	
	public boolean isFullCube(IBlockState state) {return false;}
    
    public boolean isOpaqueCube(IBlockState state) {return false;}
	
	@Override
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {}
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {return BlockFaceShape.UNDEFINED;}

}
