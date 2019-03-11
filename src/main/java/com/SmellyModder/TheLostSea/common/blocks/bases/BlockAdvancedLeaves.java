package com.SmellyModder.TheLostSea.common.blocks.bases;

import java.util.Random;

import com.SmellyModder.TheLostSea.common.blocks.BlockBase;
import com.SmellyModder.TheLostSea.common.blocks.util.ISpecialLeaf;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAdvancedLeaves extends BlockBase implements ISpecialLeaf {

	private final Block sapling;
	private int type;
	public BlockAdvancedLeaves(String name, Block saplingToDrop, int type) {
		super(name, Material.LEAVES);
		this.sapling = saplingToDrop;
		this.setTickRandomly(true);
		this.setCreativeTab(null);
		this.type = type;
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isRemote) {
        	
            if (type == 0) {
            	if(!this.checkLeaves(worldIn, pos, 0)) {
            		this.destroy(worldIn, pos);
            	}
            } else if(type == 1) {
            	if(!this.checkLeaves(worldIn, pos, 1)) {
            		this.destroy(worldIn, pos);
            	}
            } else if(type == 2) {
            	if(!this.checkLeaves(worldIn, pos, -1)) {
            		this.destroy(worldIn, pos);
            	}
            }
		}
	}
	
	@Override
	public int quantityDropped(Random random) {
	    return random.nextInt(22) == 1 ? 1 : 0;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(sapling);
	}
	
	@Override
    public BlockRenderLayer getRenderLayer() {
        return Blocks.LEAVES.getRenderLayer();
    }
    
    @Override
    public boolean shouldSideBeRendered(IBlockState state, IBlockAccess access, BlockPos pos, EnumFacing side) {
        BlockPos neighborPos = pos.offset(side);
        if (this.isOpaqueCube(state) && access.getBlockState(neighborPos).getBlock() == this) {
            return false;
        }
        return !access.getBlockState(neighborPos).doesSideBlockRendering(access, neighborPos, side.getOpposite());
    }
	
	@Override
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return 30;
    }

    @Override
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return 70;
    }
    
    protected void destroy(World worldIn, BlockPos pos) {
        this.dropBlockAsItem(worldIn, pos, worldIn.getBlockState(pos), 0);
        worldIn.setBlockToAir(pos);
    }
    
    protected boolean checkLeaves(World world, BlockPos pos, int lvl) {
        return
        		world.getBlockState(pos.add(1, lvl, 0)).getBlock() instanceof ISpecialLeaf
                ||
                world.getBlockState(pos.add(-1, lvl, 0)).getBlock() instanceof ISpecialLeaf
                ||
                world.getBlockState(pos.add(0, lvl, 1)).getBlock() instanceof ISpecialLeaf
                ||
                world.getBlockState(pos.add(0, lvl, -1)).getBlock() instanceof ISpecialLeaf
                ||
                world.getBlockState(pos.add(1, lvl, 1)).getBlock() instanceof ISpecialLeaf
                ||
                world.getBlockState(pos.add(-1, lvl, -1)).getBlock() instanceof ISpecialLeaf
                ||
                world.getBlockState(pos.add(1, lvl, -1)).getBlock() instanceof ISpecialLeaf
                ||
                world.getBlockState(pos.add(-1, lvl, 1)).getBlock() instanceof ISpecialLeaf
                ? true : false;
    }

}
