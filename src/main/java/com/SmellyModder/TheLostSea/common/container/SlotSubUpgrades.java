package com.SmellyModder.TheLostSea.common.container;

import com.SmellyModder.TheLostSea.common.container.enums.EnumSubUpgrades;
import com.SmellyModder.TheLostSea.common.item.submarine.ItemSubUpgrades;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotSubUpgrades extends Slot
{
    public EnumSubUpgrades type;

    public SlotSubUpgrades(IInventory inventoryIn, EnumSubUpgrades type, int index, int xPosition, int yPosition)
    {
        super(inventoryIn, index, xPosition, yPosition);
        this.type = type;
    }

    public boolean isItemValid(ItemStack stack)
    {
        return stack.getItem() instanceof ItemSubUpgrades && !((ItemSubUpgrades)stack.getItem()).isContainer() && ((ItemSubUpgrades)stack.getItem()).getType() == this.type;
    }
}