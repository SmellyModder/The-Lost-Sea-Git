package com.SmellyModder.TheLostSea.common.blocks.plants.tree.crop;

import javax.annotation.Nullable;

import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.common.tileentity.rewards.TileEntityStarterChest;
import com.SmellyModder.TheLostSea.core.util.IHasModel;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFCoconut extends BlockHorizontal implements IHasModel {

	protected static final AxisAlignedBB[] COCONUT_EAST_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.4375D, 0.25D, 0.25D, 0.9375D, 0.75D, 0.75D)};
    protected static final AxisAlignedBB[] COCONUT_WEST_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0625D, 0.25D, 0.25D, 0.5625D, 0.75D, 0.75D)};
    protected static final AxisAlignedBB[] COCONUT_NORTH_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.25D, 0.25D, 0.0625D, 0.75D, 0.75D, 0.5625D)};
    protected static final AxisAlignedBB[] COCONUT_SOUTH_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.25D, 0.25D, 0.4375D, 0.75D, 0.75D, 0.9375D)};
    
	protected BlockFCoconut(String name) {
		super(Material.GOURD);
		setRegistryName(name);
		setTranslationKey(name);
		
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.setTickRandomly(true);
		TLSBlocks.BLOCKS.add(this);
		TLSItems.ITEMS.add(new ItemBlock(this).setRegistryName(name));
	}
	
	@Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityCoconut();
    }
	
	public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        switch ((EnumFacing)state.getValue(FACING))
        {
            case SOUTH:
                return COCONUT_SOUTH_AABB[0];
            case NORTH:
            default:
                return COCONUT_NORTH_AABB[0];
            case WEST:
                return COCONUT_WEST_AABB[0];
            case EAST:
                return COCONUT_EAST_AABB[0];
        }
    }
    
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (!this.canBlockStay(worldIn, pos, state))
        {
        	 worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
     	     this.dropBlockAsItem(worldIn, pos, state, 0);
        }
    }
    
    @SideOnly(Side.CLIENT)
	public BlockRenderLayer getRenderLayer()
	{
	    return BlockRenderLayer.CUTOUT;
	}

	public IBlockState getStateFromMeta(int meta)
	{
	    return this.getDefaultState().withProperty(FACING, EnumFacing.byHorizontalIndex(meta));
	}
	
	public int getMetaFromState(IBlockState state)
	{
		int i = 0;
	    i = i | ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();
	    return i;
	}
    
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) 
	{
		pos = pos.offset((EnumFacing)state.getValue(FACING));
	   	IBlockState iblockstate = worldIn.getBlockState(pos);
	    
	   	return iblockstate.getBlock() == TLSBlocks.PALM_LOG;
	}
    
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        if (!facing.getAxis().isHorizontal())
        {
            facing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, facing.getOpposite());
    }
    
    
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }
    
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        EnumFacing enumfacing = EnumFacing.fromAngle((double)placer.rotationYaw);
        worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
    }
    
    protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {FACING});
	}

	@Override
	public void registerModels() 
	{
		TheLostSea.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}
