package com.SmellyModder.TheLostSea.common.container;

import com.SmellyModder.TheLostSea.common.container.enums.EnumSubUpgrades;
import com.SmellyModder.TheLostSea.common.item.submarine.ItemSubUpgrades;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSubUpgrades extends Container
{
    public ContainerSubUpgrades(final EntityPlayer player, ItemStack stack)
    {
        InventorySub inv = new InventorySub(stack);
        addSlotToContainer(new SlotSubUpgrades(inv, EnumSubUpgrades.SPEED, 0, 80, 18));

        int k;
        for(k = 0; k < 3; ++k) {
            for(int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(player.inventory, j + k * 9 + 9, 8 + j * 18, 129 + k * 18));
            }
        }

        for(k = 0; k < 9; ++k) {
            this.addSlotToContainer(new Slot(player.inventory, k, 8 + k * 18, 187) {
                public boolean canTakeStack(EntityPlayer playerIn) {
                    return this.getStack() != player.getHeldItemMainhand();
                }
            });
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return true;
    }

    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot)this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index >= 0 && index <= 5) {
                if (!this.mergeItemStack(itemstack1, 6, 42,true)) {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (itemstack1.getItem() instanceof ItemSubUpgrades && !((ItemSubUpgrades)itemstack1.getItem()).isContainer() && ((ItemSubUpgrades)itemstack1.getItem()).getType() == EnumSubUpgrades.SPEED) {
                if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (itemstack1.getItem() instanceof ItemSubUpgrades && !((ItemSubUpgrades)itemstack1.getItem()).isContainer() && ((ItemSubUpgrades)itemstack1.getItem()).getType() == EnumSubUpgrades.HEALTH) {
                if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (itemstack1.getItem() instanceof ItemSubUpgrades && !((ItemSubUpgrades)itemstack1.getItem()).isContainer() && ((ItemSubUpgrades)itemstack1.getItem()).getType() == EnumSubUpgrades.TORPEDO) {
                if (!this.mergeItemStack(itemstack1, 2, 3, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (itemstack1.getItem() instanceof ItemSubUpgrades && !((ItemSubUpgrades)itemstack1.getItem()).isContainer() && ((ItemSubUpgrades)itemstack1.getItem()).getType() == EnumSubUpgrades.SIGHT) {
                if (!this.mergeItemStack(itemstack1, 3, 4, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 33 && index < 42) {
                if (!this.mergeItemStack(itemstack1, 6, 33, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 33, 42, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }
}
