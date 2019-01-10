package com.SmellyModder.TheLostSea.core.proxy;

import com.SmellyModder.TheLostSea.client.gui.GUILoreBook;
import com.SmellyModder.TheLostSea.client.gui.npc.GuiNurmNpc;
import com.SmellyModder.TheLostSea.client.gui.npc.NPCFont;
import com.SmellyModder.TheLostSea.client.gui.npc.shop.GuiNurmShop;
import com.SmellyModder.TheLostSea.client.util.GuiGreenScreen;
import com.SmellyModder.TheLostSea.core.util.Reference;
import com.SmellyModder.TheLostSea.core.util.handlers.RenderHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;


public class ClientProxy extends CommonProxy{

	public void registerItemRenderer(Item item, int meta, String id) {
			
			ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
			
		}

	@Override
	public void preInit() {
		RenderHandler.registerEntityRenders();
	}
	
	@Override
	public void openScreen() {
		Minecraft.getMinecraft().displayGuiScreen(new GuiGreenScreen());
	}

	@Override
	public void openMyGui(ItemStack stack)
	{
	     Minecraft.getMinecraft().displayGuiScreen(new GUILoreBook(stack));
	}
	
	public void OpenNurmGUI(EntityPlayer player) {
		 Minecraft.getMinecraft().displayGuiScreen(new GuiNurmNpc(player));
	}
	
	@Override
	public void OpenNurmShop(EntityPlayer player) {
		 Minecraft.getMinecraft().displayGuiScreen(new GuiNurmShop(player));
	}
}
