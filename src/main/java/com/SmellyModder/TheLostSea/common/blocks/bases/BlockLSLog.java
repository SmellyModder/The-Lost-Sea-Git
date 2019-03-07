package com.SmellyModder.TheLostSea.common.blocks.bases;

import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.IHasModel;

import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockLSLog extends BlockLog implements IHasModel{
	
	public BlockLSLog(String name) {
		setHarvestLevel("axe", 0);
		setCreativeTab(TheLostSea.TLS_BLOCKS);
	    setSoundType(SoundType.WOOD);
	    setDefaultState(blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
	    setRegistryName(name);
	    setTranslationKey(name);
	    
	    TLSBlocks.BLOCKS.add(this);
	    TLSItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState();

        switch (meta & 12)
        {
            case 0:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
                break;
            case 4:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
                break;
            case 8:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
                break;
            default:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
        }

        return iblockstate;
    }

    @SuppressWarnings("incomplete-switch")
    public int getMetaFromState(IBlockState state)
    {
        int meta = 0;
        
        switch ((BlockLog.EnumAxis)state.getValue(LOG_AXIS))
        {
            case X:
            	meta |= 4;
                break;
            case Z:
            	meta |= 8;
                break;
            case NONE:
            	meta |= 12;
        }

        return meta;
    }
    
    @Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {LOG_AXIS});
	}
    
    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
    		float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
    	if(meta != 12) {
        	return this.getStateFromMeta(meta).withProperty(LOG_AXIS, BlockLog.EnumAxis.fromFacingAxis(facing.getAxis()));
        }
        return this.getDefaultState().withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
    }

	@Override
	public void registerModels() {
		TheLostSea.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
}
