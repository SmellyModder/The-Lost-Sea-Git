package com.SmellyModder.TheLostSea.common.blocks.temple;

import java.util.Random;

import com.SmellyModder.TheLostSea.client.particle.LostSeaParticles;
import com.SmellyModder.TheLostSea.common.blocks.BlockBase;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPortalKey extends BlockBase {

	public static final AxisAlignedBB PORTAL_BOX_N = new AxisAlignedBB(0.0000D, 0, 0.1875D, 1.0125D, 0.975D, 0.8125D);
	public static final AxisAlignedBB Z_AXIS_AABB = new AxisAlignedBB(0.187500D, 0, 0.0000D, 0.8125D, 0.975D, 1.0125D);
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	public BlockPortalKey(String name, Material material) {
		super(name, material);
		setBlockUnbreakable();
		setLightLevel(0.7F);
		this.setCreativeTab(null);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		EntityPlayer entity = Minecraft.getMinecraft().player;

		world.scheduleUpdate(new BlockPos(i, j, k), this, this.tickRate(world));
	}
	
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		switch(state.getValue(FACING)) {
			case NORTH:
			default:
			return PORTAL_BOX_N;
			case SOUTH:
			return PORTAL_BOX_N;
			case EAST:
			return Z_AXIS_AABB;
			case WEST:
			return Z_AXIS_AABB;
			case UP:
			return PORTAL_BOX_N;
			case DOWN:
			return PORTAL_BOX_N;
		}
	}
	
	@Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.byHorizontalIndex(meta));
    }
	
    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(FACING).getHorizontalIndex();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, FACING);
    }
    
	@SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos)
    {
		switch(state.getValue(FACING)) {
		case NORTH:
		default:
		return PORTAL_BOX_N.offset(pos);
		case SOUTH:
		return PORTAL_BOX_N.offset(pos);
		case EAST:
		return Z_AXIS_AABB.offset(pos);
		case WEST:
		return Z_AXIS_AABB.offset(pos);
		case UP:
		return PORTAL_BOX_N.offset(pos);
		case DOWN:
		return PORTAL_BOX_N.offset(pos);
	}
    }
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
	   IBlockState state = super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer);
	   return state.withProperty(FACING, placer.getHorizontalFacing());
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) {
		return false;
	}
	
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

}
