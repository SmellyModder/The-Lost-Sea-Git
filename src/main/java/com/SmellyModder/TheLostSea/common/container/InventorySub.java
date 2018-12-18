package com.SmellyModder.TheLostSea.common.container;

import java.util.Iterator;

import com.SmellyModder.TheLostSea.common.container.enums.EnumSubUpgrades;
import com.SmellyModder.TheLostSea.common.item.submarine.ItemSubUpgrades;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;

public class InventorySub  implements IInventory
{
    public static final EnumSubUpgrades[] SLOTS;
    public final ItemStack stack;
    private final NonNullList<ItemStack> inventory;

    public InventorySub(ItemStack stack) {
        this.stack = stack;
        this.inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        this.readFromNBT(stack.getTagCompound());
    }

    public int getSizeInventory() {
        return this.inventory.size();
    }

    public boolean isEmpty() {
        Iterator var1 = this.inventory.iterator();

        ItemStack itemstack;
        do {
            if (!var1.hasNext()) {
                return true;
            }

            itemstack = (ItemStack)var1.next();
        } while(itemstack.isEmpty());

        return false;
    }

    public ItemStack getStackInSlot(int index) {
        return index >= 0 && index < this.inventory.size() ? (ItemStack)this.inventory.get(index) : ItemStack.EMPTY;
    }

    public ItemStack decrStackSize(int index, int count) {
        ItemStack itemstack = ItemStackHelper.getAndSplit(this.inventory, index, count);
        if (!itemstack.isEmpty()) {
            this.markDirty();
        }

        return itemstack;
    }

    public ItemStack removeStackFromSlot(int index) {
        ItemStack itemstack = (ItemStack)this.inventory.get(index);
        if (itemstack.isEmpty()) {
            return ItemStack.EMPTY;
        } else {
            this.inventory.set(index, ItemStack.EMPTY);
            return itemstack;
        }
    }

    public void setInventorySlotContents(int index, ItemStack stack) {
        this.inventory.set(index, stack);
        if (!stack.isEmpty() && stack.getCount() > this.getInventoryStackLimit()) {
            stack.setCount(this.getInventoryStackLimit());
        }

        this.markDirty();
    }

    public int getInventoryStackLimit() {
        return 1;
    }

    public void markDirty() {
        this.writeToNBT(this.stack.getTagCompound());
    }

    public boolean isUsableByPlayer(EntityPlayer player) {
        return true;
    }

    public void openInventory(EntityPlayer player) {
    }

    public void closeInventory(EntityPlayer player) {
    }

    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if (!(stack.getItem() instanceof ItemSubUpgrades)) {
            return false;
        } else {
            ItemSubUpgrades item = (ItemSubUpgrades)stack.getItem();
            return item.isContainer() ? false : SLOTS[index] == item.getType();
        }
    }

    public int getField(int id) {
        return 0;
    }

    public void setField(int id, int value) {
    }

    public int getFieldCount() {
        return 0;
    }

    public void clear() {
        this.inventory.clear();
        this.markDirty();
    }

    public String getName() {
        return this.stack.getDisplayName();
    }

    public boolean hasCustomName() {
        return true;
    }

    public ITextComponent getDisplayName() {
        return this.stack.getTextComponent();
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        NBTTagList items = new NBTTagList();

        for(int i = 0; i < this.getSizeInventory(); ++i) {
            if (!this.getStackInSlot(i).isEmpty()) {
                NBTTagCompound item = new NBTTagCompound();
                item.setByte("Slot", (byte)i);
                this.getStackInSlot(i).writeToNBT(item);
                items.appendTag(item);
            }
        }

        compound.setTag("Items", items);
        return compound;
    }

    public void readFromNBT(NBTTagCompound compound) {
        NBTTagList items = compound.getTagList("Items", compound.getId());

        for(int i = 0; i < items.tagCount(); ++i) {
            NBTTagCompound item = items.getCompoundTagAt(i);
            byte slot = item.getByte("Slot");
            if (slot >= 0 && slot < this.getSizeInventory()) {
                this.inventory.set(slot, new ItemStack(item));
            }
        }

    }

    static {
        SLOTS = new EnumSubUpgrades[]{EnumSubUpgrades.HEALTH, EnumSubUpgrades.SIGHT, EnumSubUpgrades.TORPEDO, EnumSubUpgrades.SPEED};
    }

}
