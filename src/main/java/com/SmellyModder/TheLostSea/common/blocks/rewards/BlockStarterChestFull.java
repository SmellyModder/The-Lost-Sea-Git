package com.SmellyModder.TheLostSea.common.blocks.rewards;

import java.util.Random;

import javax.annotation.Nullable;

import com.SmellyModder.TheLostSea.client.particle.LostSeaParticles;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.common.tileentity.rewards.TileEntityStarterChestFull;
import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.packets.MessageCoins;
import com.SmellyModder.TheLostSea.core.util.IHasModel;
import com.SmellyModder.TheLostSea.core.util.Reference;
import com.SmellyModder.TheLostSea.core.util.player.CoinProvider;
import com.SmellyModder.TheLostSea.core.util.player.shoputil.ICurrency;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockStarterChestFull extends BlockContainer implements IHasModel
{
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	protected static final AxisAlignedBB NORTH_CHEST_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0D, 0.9375D, 0.975D, 0.9375D);
	 protected static final AxisAlignedBB SOUTH_CHEST_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.975D, 1.0D);
	 protected static final AxisAlignedBB WEST_CHEST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0625D, 0.9375D, 0.975D, 0.9375D);
	 protected static final AxisAlignedBB EAST_CHEST_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 1.0D, 0.975D, 0.9375D);
	 protected static final AxisAlignedBB NOT_CONNECTED_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.975D, 0.9375D);
	
	public BlockStarterChestFull(String name) 
	{
		super(Material.WOOD);
		this.setHardness(2.5F);
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(null);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		
		TLSBlocks.BLOCKS.add(this);
		TLSItems.ITEMS.add(new ItemBlock(this).setRegistryName(name));
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(TLSBlocks.STARTER_CHEST);
	}
	
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return 1;
	}
	
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
		TileEntity tileentityC = worldIn.getTileEntity(pos);
		if(tileentityC instanceof TileEntityStarterChestFull) {
			if(((TileEntityStarterChestFull)tileentityC).isOpen()) {
				for (int i = 0; i < 4; ++i)
                {
            		double d0 = (double)((float)pos.getX() + rand.nextFloat());
                    double d1 = (double)((float)pos.getY() + rand.nextFloat());
                    double d2 = (double)((float)pos.getZ() + rand.nextFloat());
                    double d3 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
                    double d4 = ((double)rand.nextFloat() - 0.5D) * (Math.random() * 0.5D);
                    double d5 = ((double)rand.nextFloat() - 0.5D) * (Math.random() * 0.5D);
            		LostSeaParticles.GOLD_DUST.spawn(worldIn, d0, d1, d2, d3, d4, d5);
                }
			}
		}
    }
	
	@Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }
	
	public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.byIndex(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        if (source.getBlockState(pos.north()).getBlock() == this)
        {
            return NORTH_CHEST_AABB;
        }
        else if (source.getBlockState(pos.south()).getBlock() == this)
        {
            return SOUTH_CHEST_AABB;
        }
        else if (source.getBlockState(pos.west()).getBlock() == this)
        {
            return WEST_CHEST_AABB;
        }
        else
        {
            return source.getBlockState(pos.east()).getBlock() == this ? EAST_CHEST_AABB : NOT_CONNECTED_AABB;
        }
    }
	
    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }
    
    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }
	
	@Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		int i = 0;
		BlockPos blockpos = pos.west();
        BlockPos blockpos1 = pos.east();
        BlockPos blockpos2 = pos.north();
        BlockPos blockpos3 = pos.south();
        
        if (worldIn.getBlockState(blockpos).getBlock() == this)
        {
        	 if (this.isAnotherChest(worldIn, blockpos))
             {
                 return false;
             }
        	 i++;
        }
        
        if (worldIn.getBlockState(blockpos1).getBlock() == this)
        {
        	 if (this.isAnotherChest(worldIn, blockpos1))
             {
                 return false;
             }
        	 i++;
        }
        
        if (worldIn.getBlockState(blockpos2).getBlock() == this)
        {
        	 if (this.isAnotherChest(worldIn, blockpos2))
             {
                 return false;
             }
        	 i++;
        }
        
        if (worldIn.getBlockState(blockpos3).getBlock() == this)
        {
        	 if (this.isAnotherChest(worldIn, blockpos3))
             {
                 return false;
             }
        	 i++;
        }
		return i <= 1;
	}
	
	private boolean isAnotherChest(World worldIn, BlockPos pos)
    {
        if (worldIn.getBlockState(pos).getBlock() != this)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
	
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }
    
	
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		 TileEntity tileentity = worldIn.getTileEntity(pos);
		 ICurrency coins = playerIn.getCapability(CoinProvider.COIN_CAP, null);

		if (tileentity instanceof TileEntityStarterChestFull)
        {	
			 if(!((TileEntityStarterChestFull)tileentity).hasOpened()) {
				 coins.fill(100);
				 
				 if(playerIn instanceof EntityPlayerMP) {
	        		TheLostSea.NETWORK.sendTo(new MessageCoins(coins.getCoins()), (EntityPlayerMP) playerIn);
	        	 }
				 ((TileEntityStarterChestFull)tileentity).hasOpened = true;
			 } else {
				 
			 }
			 ((TileEntityStarterChestFull)tileentity).open = 1;
        }
		
		 
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            ILockableContainer ilockablecontainer = this.getLockableContainer(worldIn, pos);

            if (ilockablecontainer != null)
            {
                playerIn.displayGUIChest(ilockablecontainer);

                playerIn.addStat(StatList.CHEST_OPENED);
                }
            }

            return true;
    }
	
	@Nullable
    public ILockableContainer getLockableContainer(World worldIn, BlockPos pos)
    {
        return this.getContainer(worldIn, pos, false);
    }
	
	 @Nullable
	    public ILockableContainer getContainer(World worldIn, BlockPos pos, boolean allowBlocking)
	    {
	        TileEntity tileentity = worldIn.getTileEntity(pos);

	        if (!(tileentity instanceof TileEntityChest))
	        {
	            return null;
	        }
	        else
	        {
	            ILockableContainer ilockablecontainer = (TileEntityChest)tileentity;

	            if (!allowBlocking && this.isBlocked(worldIn, pos))
	            {
	                return null;
	            }
	            else
	            {
	                for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
	                {
	                    BlockPos blockpos = pos.offset(enumfacing);
	                    Block block = worldIn.getBlockState(blockpos).getBlock();

	                    if (block == this)
	                    {
	                        if (!allowBlocking && this.isBlocked(worldIn, blockpos)) // Forge: fix MC-99321
	                        {
	                            return null;
	                        }

	                        TileEntity tileentity1 = worldIn.getTileEntity(blockpos);

	                        if (tileentity1 instanceof TileEntityChest)
	                        {
	                            if (enumfacing != EnumFacing.WEST && enumfacing != EnumFacing.NORTH)
	                            {
	                                ilockablecontainer = new InventoryLargeChest("container.chestDouble", ilockablecontainer, (TileEntityChest)tileentity1);
	                            }
	                            else
	                            {
	                                ilockablecontainer = new InventoryLargeChest("container.chestDouble", (TileEntityChest)tileentity1, ilockablecontainer);
	                            }
	                        }
	                    }
	                }

	                return ilockablecontainer;
	            }
	        }
	    }
	
	 private boolean isBlocked(World worldIn, BlockPos pos)
	 {
	    return this.isBelowSolidBlock(worldIn, pos);
	 }
	 
	 private boolean isBelowSolidBlock(World worldIn, BlockPos pos)
	 {
	        return worldIn.getBlockState(pos.up()).doesSideBlockChestOpening(worldIn, pos.up(), EnumFacing.DOWN);
	 }
	 
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) 
	{
		TileEntityStarterChestFull tileentity = (TileEntityStarterChestFull)worldIn.getTileEntity(pos);
		InventoryHelper.dropInventoryItems(worldIn, pos, tileentity);
		super.breakBlock(worldIn, pos, state);
	}
	
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
	   IBlockState state = super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer);
	   return state.withProperty(FACING, placer.getHorizontalFacing());
	}
	
	@Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        EnumFacing enumfacing = EnumFacing.byHorizontalIndex(MathHelper.floor((double)(placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3).getOpposite();
        state = state.withProperty(FACING, enumfacing);
        BlockPos blockpos = pos.north();
        BlockPos blockpos1 = pos.south();
        BlockPos blockpos2 = pos.west();
        BlockPos blockpos3 = pos.east();
        boolean flag = this == worldIn.getBlockState(blockpos).getBlock();
        boolean flag1 = this == worldIn.getBlockState(blockpos1).getBlock();
        boolean flag2 = this == worldIn.getBlockState(blockpos2).getBlock();
        boolean flag3 = this == worldIn.getBlockState(blockpos3).getBlock();

        if (!flag && !flag1 && !flag2 && !flag3)
        {
            worldIn.setBlockState(pos, state, 3);
        }
        else if (enumfacing.getAxis() != EnumFacing.Axis.X || !flag && !flag1)
        {
            if (enumfacing.getAxis() == EnumFacing.Axis.Z && (flag2 || flag3))
            {
                if (flag2)
                {
                    worldIn.setBlockState(blockpos2, state, 3);
                }
                else
                {
                    worldIn.setBlockState(blockpos3, state, 3);
                }

                worldIn.setBlockState(pos, state, 3);
            }
        }
        else
        {
            if (flag)
            {
                worldIn.setBlockState(blockpos, state, 3);
            }
            else
            {
                worldIn.setBlockState(blockpos1, state, 3);
            }

            worldIn.setBlockState(pos, state, 3);
        }

        if (stack.hasDisplayName())
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityStarterChestFull)
            {
                ((TileEntityStarterChestFull)tileentity).setCustomName(stack.getDisplayName());
                
                
            }
        }
        
        TileEntity tileentity = worldIn.getTileEntity(pos);
        
        for (int slot = 0; slot < 1; slot++) {

           ((TileEntityStarterChestFull) tileentity).setInventorySlotContents(slot + RANDOM.nextInt(2), new ItemStack(TLSItems.GOLDEN_ELDER_EYE, 1));

           ((TileEntityStarterChestFull) tileentity).setInventorySlotContents(slot + RANDOM.nextInt(8) + 5, new ItemStack(TLSItems.LORE_BOOK, 1));
        }
    }
	
	public IBlockState correctFacing(World worldIn, BlockPos pos, IBlockState state)
    {
        EnumFacing enumfacing = null;

        for (EnumFacing enumfacing1 : EnumFacing.Plane.HORIZONTAL)
        {
            IBlockState iblockstate = worldIn.getBlockState(pos.offset(enumfacing1));

            if (iblockstate.getBlock() == this)
            {
                return state;
            }

            if (iblockstate.isFullBlock())
            {
                if (enumfacing != null)
                {
                    enumfacing = null;
                    break;
                }

                enumfacing = enumfacing1;
            }
        }

        if (enumfacing != null)
        {
            return state.withProperty(FACING, enumfacing.getOpposite());
        }
        else
        {
            EnumFacing enumfacing2 = (EnumFacing)state.getValue(FACING);

            if (worldIn.getBlockState(pos.offset(enumfacing2)).isFullBlock())
            {
                enumfacing2 = enumfacing2.getOpposite();
            }

            if (worldIn.getBlockState(pos.offset(enumfacing2)).isFullBlock())
            {
                enumfacing2 = enumfacing2.rotateY();
            }

            if (worldIn.getBlockState(pos.offset(enumfacing2)).isFullBlock())
            {
                enumfacing2 = enumfacing2.getOpposite();
            }

            return state.withProperty(FACING, enumfacing2);
        }
    }

	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityStarterChestFull();
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) 
	{
		return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
	}
	
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasCustomBreakingProgress(IBlockState state)
    {
        return true;
    }

	@Override
	public void registerModels() {TheLostSea.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inverntory");}
}
