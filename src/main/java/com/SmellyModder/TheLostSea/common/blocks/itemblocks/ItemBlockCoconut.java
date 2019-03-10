package com.SmellyModder.TheLostSea.common.blocks.itemblocks;

import com.SmellyModder.TheLostSea.common.item.ItemBase;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemBlockCoconut extends ItemBase {

	public ItemBlockCoconut(String name) {
		super(name);
	}

	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack itemstack = player.getHeldItem(hand);

        if (!player.canPlayerEdit(pos.offset(facing), facing, itemstack))
        {
            return EnumActionResult.FAIL;
        }
        IBlockState iblockstate = worldIn.getBlockState(pos);
        Block block = iblockstate.getBlock();
        
        pos = pos.offset(facing);
        BlockPos airPos = pos.down();
        if (worldIn.isAirBlock(pos) && !worldIn.isAirBlock(airPos))
        {
            IBlockState iblockstate1 = Blocks.DIAMOND_BLOCK.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, 0, player, hand);
            worldIn.setBlockState(pos, iblockstate1, 10);

            if (!player.capabilities.isCreativeMode)
            {
                itemstack.shrink(1);
            }

            return EnumActionResult.SUCCESS;
        }
		return EnumActionResult.PASS;
    }
}
