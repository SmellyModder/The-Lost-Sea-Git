package com.SmellyModder.TheLostSea.core.proxy;

import com.SmellyModder.TheLostSea.client.gui.GUILoreBook;
import com.SmellyModder.TheLostSea.core.util.handlers.RenderHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy{

	public void registerItemRenderer(Item item, int meta, String id) {
			
			ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
			
		}

	@Override
	public void preInit() {
		RenderHandler.registerEntityRenders();
	}

	@Override
	public void openMyGui(ItemStack stack)
	{
	     Minecraft.getMinecraft().displayGuiScreen(new GUILoreBook(stack));
	}
	
	@Override
	public void coinOverlay()
	{
		
	}
}
