package com.SmellyModder.TheLostSea.client.util;

import com.SmellyModder.TheLostSea.client.model.items.ModelVanadiumShield;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.util.Reference;
import com.SmellyModder.TheLostSea.core.util.interfaces.ILSShield;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiGreenScreen extends GuiScreen {
	
	public GuiGreenScreen()
	{
	}
	
	@Override
	public void drawScreen(int parWidth, int parHeight, float p_73863_3_)
	{
		this.drawGradientRect(width, height, width, height, 255, 255);
		this.itemRender.renderItem(new ItemStack(TLSItems.VANADIUM_SHIELD), ItemCameraTransforms.TransformType.GUI );
		super.drawScreen(parWidth, parHeight, p_73863_3_);
	}
}
