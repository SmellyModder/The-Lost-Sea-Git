package com.SmellyModder.TheLostSea.common.item.specialtools;

import java.util.List;

import com.SmellyModder.TheLostSea.common.item.ItemBase;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLorePage extends ItemBase{

	public ItemLorePage(String name) {
		super(name);
		this.maxStackSize = 1;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("A lost page of the Aquapedia");
	}

}
