package com.SmellyModder.TheLostSea.common.item.devutils;

import com.SmellyModder.TheLostSea.common.item.ItemBase;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemScreen extends ItemBase{

	public ItemScreen(String name) {
		super(name);
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
    	TheLostSea.proxy.openScreen();
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}
