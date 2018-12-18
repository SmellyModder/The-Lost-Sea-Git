package com.SmellyModder.TheLostSea.common.item.submarine;

import com.SmellyModder.TheLostSea.common.container.enums.EnumSubUpgrades;
import com.SmellyModder.TheLostSea.common.item.ItemBase;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class ItemSubUpgrades extends Item
{
    public abstract EnumSubUpgrades getType();

    public abstract boolean isContainer();

    public int getItemStackLimit(ItemStack stack)
    {
        return 1;
    }

	
}
