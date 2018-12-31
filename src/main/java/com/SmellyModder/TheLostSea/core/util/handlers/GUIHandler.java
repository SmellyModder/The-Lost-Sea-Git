package com.SmellyModder.TheLostSea.core.util.handlers;

import javax.annotation.Nullable;

import com.SmellyModder.TheLostSea.client.gui.GUILoreBook;
import com.SmellyModder.TheLostSea.client.gui.GUISubUpgrades;
import com.SmellyModder.TheLostSea.client.gui.GuiStarterChest;
import com.SmellyModder.TheLostSea.common.container.ContainerStarterChest;
import com.SmellyModder.TheLostSea.common.container.ContainerSubUpgrades;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler
{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		ItemStack stack = player.getHeldItemMainhand();
		 if(ID == Reference.ID_LORE) return new GUILoreBook(stack);
		 if(ID == Reference.ID_GUI_CHEST) return new ContainerStarterChest(player.inventory, (IInventory)world.getTileEntity(new BlockPos(x,y,z)), player);
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		ItemStack stack = player.getHeldItemMainhand();
		 if(ID == Reference.ID_LORE)return new GUILoreBook(stack);
		 
		 if(ID == Reference.ID_GUI_CHEST) return new GuiStarterChest(player.inventory, (IInventory)world.getTileEntity(new BlockPos(x,y,z)));

		return null;
	}
   

}
