package com.SmellyModder.TheLostSea.common.blocks.plants;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.common.item.specialtools.neptunum.ItemNeptunumSword;
import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.player.events.PlayerBreakEvents;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.NonNullList;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCoconut extends BlockHorizontal implements IGrowable {
	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 2);
	
	protected static final AxisAlignedBB[] COCONUT_EAST_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.6875D, 0.5D, 0.375D, 0.9375D, 0.75D, 0.625D), new AxisAlignedBB(0.5625D, 0.38D, 0.3125D, 0.9375D, 0.75D, 0.6875D), new AxisAlignedBB(0.4375D, 0.25D, 0.25D, 0.9375D, 0.75D, 0.75D)};
    protected static final AxisAlignedBB[] COCONUT_WEST_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0625D, 0.5D, 0.375D, 0.3125D, 0.75D, 0.625D), new AxisAlignedBB(0.0625D, 0.38D, 0.3125D, 0.4375D, 0.75D, 0.6875D), new AxisAlignedBB(0.0625D, 0.25D, 0.25D, 0.5625D, 0.75D, 0.75D)};
    protected static final AxisAlignedBB[] COCONUT_NORTH_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.375D, 0.5D, 0.0625D, 0.625D, 0.75D, 0.3125D), new AxisAlignedBB(0.3125D, 0.38D, 0.0625D, 0.6875D, 0.75D, 0.4375D), new AxisAlignedBB(0.25D, 0.25D, 0.0625D, 0.75D, 0.75D, 0.5625D)};
    protected static final AxisAlignedBB[] COCONUT_SOUTH_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.375D, 0.5D, 0.6875D, 0.625D, 0.75D, 0.9375D), new AxisAlignedBB(0.3125D, 0.38D, 0.5625D, 0.6875D, 0.75D, 0.9375D), new AxisAlignedBB(0.25D, 0.25D, 0.4375D, 0.75D, 0.75D, 0.9375D)};
    
    public BlockCoconut(String name) {
		super(Material.GOURD);
		setRegistryName(name);
		setTranslationKey(name);
		
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(AGE, Integer.valueOf(0)));
		this.setTickRandomly(true);
		TLSBlocks.BLOCKS.add(this);
		TLSItems.ITEMS.add(new ItemBlock(this).setRegistryName(name));
	}
	
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!this.canBlockStay(worldIn, pos, state)) {
            this.dropBlock(worldIn, pos, state);
        } else {
            int i = ((Integer)state.getValue(AGE)).intValue();

            if (i < 2 && ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(5) == 0)) {
                worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(i + 1)), 2);
                ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
            }
        }
    }
	
	@Override
	public void harvestBlock(World world, EntityPlayer player, BlockPos blockPos, IBlockState state, TileEntity te, ItemStack stack) {
		if(((Integer)state.getValue(BlockCoconut.AGE)).intValue() != 2) return;
		
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
	
    public boolean isFullCube(IBlockState state) {
        return false;
    }
    
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
    
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        int i = ((Integer)state.getValue(AGE)).intValue();

        switch ((EnumFacing)state.getValue(FACING)) {
            case SOUTH:
                return COCONUT_SOUTH_AABB[i];
            case NORTH:
            default:
                return COCONUT_NORTH_AABB[i];
            case WEST:
                return COCONUT_WEST_AABB[i];
            case EAST:
                return COCONUT_EAST_AABB[i];
        }
    }
    
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }
    
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        EnumFacing enumfacing = EnumFacing.fromAngle((double)placer.rotationYaw);
        worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
    }

    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
    	if (!facing.getAxis().isHorizontal()) {
            facing = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty(FACING, facing.getOpposite()).withProperty(AGE, Integer.valueOf(0));
    }
    
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
    	if (!this.canBlockStay(worldIn, pos, state)) {
            this.dropBlock(worldIn, pos, state);
        }
    }

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return ((Integer)state.getValue(AGE)).intValue() < 2;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(((Integer)state.getValue(AGE)).intValue() + 1)), 2);
	}
	
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
		pos = pos.offset((EnumFacing)state.getValue(FACING));
	   	IBlockState iblockstate = worldIn.getBlockState(pos);
	   	return iblockstate.getBlock() == TLSBlocks.PALM_LOG;
	}
	 
	private void dropBlock(World worldIn, BlockPos pos, IBlockState state) {
	    worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
	    this.dropBlockAsItem(worldIn, pos, state, 0);
	}
	
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getRenderLayer() {
	    return BlockRenderLayer.CUTOUT;
	}

	public IBlockState getStateFromMeta(int meta) {
	    return this.getDefaultState().withProperty(FACING, EnumFacing.byHorizontalIndex(meta)).withProperty(AGE, Integer.valueOf((meta & 15) >> 2));
	}
	
	public int getMetaFromState(IBlockState state) {
		int i = 0;
	    i = i | ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();
	    i = i | ((Integer)state.getValue(AGE)).intValue() << 2;
	    return i;
	}
	
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING, AGE});
	}
	
	public static boolean canFallThrough(IBlockState state) {
        Block block = state.getBlock();
        Material material = state.getMaterial();
        return block == Blocks.FIRE || material == Material.AIR || material == Material.WATER || material == Material.LAVA;
    }
	
}
