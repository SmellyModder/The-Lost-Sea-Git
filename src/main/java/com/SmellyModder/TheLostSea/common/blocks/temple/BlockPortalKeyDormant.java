package com.SmellyModder.TheLostSea.common.blocks.temple;

import java.util.Random;

import com.SmellyModder.TheLostSea.client.particle.LostSeaParticles;
import com.SmellyModder.TheLostSea.common.blocks.BlockBase;
import com.SmellyModder.TheLostSea.common.blocks.util.WorldBoolHandler;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.common.init.TLSSounds;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPortalKeyDormant extends BlockBase {
	public static final AxisAlignedBB PORTAL_BOX_N = new AxisAlignedBB(0.0000D, 0, 0.1875D, 1.0125D, 0.975D, 0.8125D);
	public static final AxisAlignedBB Z_AXIS_AABB = new AxisAlignedBB(0.187500D, 0, 0.0000D, 0.8125D, 0.975D, 1.0125D);
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	boolean isOn = false;
	Random rand = new Random();
	
	public BlockPortalKeyDormant(String name, Material material) {
		super(name, material);
		setBlockUnbreakable();
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}
	
	boolean once = true;
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
		
		if (playerIn.inventory.getCurrentItem() != null && playerIn.inventory.getCurrentItem().getItem() == TLSItems.GOLDEN_ELDER_EYE) {
				((EntityPlayer) playerIn).inventory.clearMatchingItems(TLSItems.GOLDEN_ELDER_EYE, -1, 1, null);
				worldIn.playSound(playerIn, i, j, k, TLSSounds.PORTAL_OPENING, SoundCategory.WEATHER, 5.5F, 0F);
				WorldBoolHandler.portalIsToFill = true;
				if (mcserv != null && once == true) {
					once = false;
					mcserv.getPlayerList().sendMessage(new TextComponentString(TextFormatting.AQUA + "A sea once lost is no longer lost..."));
					worldIn.weatherEffects.add(new EntityLightningBolt(worldIn, pos.getX(), pos.getY(), pos.getZ(), false));
					worldIn.weatherEffects.add(new EntityLightningBolt(worldIn, pos.getX() + rand.nextInt(10), pos.getY(), pos.getZ(), false));
					worldIn.weatherEffects.add(new EntityLightningBolt(worldIn, pos.getX() + rand.nextInt(10), pos.getY(), pos.getZ(), false));
				}
	            
				switch(state.getValue(FACING)) {
					case NORTH:
					default:
						return worldIn.setBlockState(new BlockPos(i, j, k), TLSBlocks.PORTAL_KEY.getDefaultState(), 3);
					case SOUTH:
						return worldIn.setBlockState(new BlockPos(i, j, k), TLSBlocks.PORTAL_KEY.getDefaultState().withProperty(FACING, EnumFacing.SOUTH), 3);
					case EAST:
						return worldIn.setBlockState(new BlockPos(i, j, k), TLSBlocks.PORTAL_KEY.getDefaultState().withProperty(FACING, EnumFacing.EAST), 3);
					case WEST:
						return worldIn.setBlockState(new BlockPos(i, j, k), TLSBlocks.PORTAL_KEY.getDefaultState().withProperty(FACING, EnumFacing.WEST), 3);
					case UP:
						return worldIn.setBlockState(new BlockPos(i, j, k), TLSBlocks.PORTAL_KEY.getDefaultState().withProperty(FACING, EnumFacing.NORTH), 3);
					case DOWN:
						return worldIn.setBlockState(new BlockPos(i, j, k), TLSBlocks.PORTAL_KEY.getDefaultState().withProperty(FACING, EnumFacing.SOUTH), 3);
				}
		}
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
		if(isOn) {
			EntityPlayer entity = Minecraft.getMinecraft().player;
			int i = pos.getX();
			int j = pos.getY();
			int k = pos.getZ();
			World par1World = world;
			int par2 = i;
			int par3 = j;
			int par4 = k;
			Random par5Random = random;
			if (true)
				for (int l = 0; l < 20; ++l) {
					double d0 = (double) ((float) par2 + par5Random.nextFloat());
					double d1 = (double) ((float) par3 + par5Random.nextFloat());
					double d2 = (double) ((float) par4 + par5Random.nextFloat());
					double d3 = 0.0D;
					double d4 = 0.0D;
					double d5 = 0.0D;
					int i1 = par5Random.nextInt(2) * 2 - 1;
					d3 = ((double) par5Random.nextFloat() - 0.5D) * 1.9D;
					d4 = ((double) par5Random.nextFloat() - 0.5D) * 1.9D;
					d5 = ((double) par5Random.nextFloat() - 0.5D) * 1.9D;
					LostSeaParticles.AQUA_PORTAL.spawn(par1World, d0, d1, d2, d3, d4, d5);
			}
			this.isOn = false;
		}
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
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.byHorizontalIndex(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getHorizontalIndex();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }
	
	@SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos) {
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
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
	   IBlockState state = super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer);
	   return state.withProperty(FACING, placer.getHorizontalFacing());
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) {
		return false;
	}
	
	public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
}
