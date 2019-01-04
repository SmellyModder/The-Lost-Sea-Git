package com.SmellyModder.TheLostSea.client.gui.npc.shop;

import com.SmellyModder.TheLostSea.core.packets.npc.MessageRequestVerseN;
import com.SmellyModder.TheLostSea.core.util.Reference;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.interfaces.IDialogueNurm;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.provider.DialogueProviderN;
import com.SmellyModder.TheLostSea.core.util.player.CoinProvider;
import com.SmellyModder.TheLostSea.core.util.player.shoputil.ICurrency;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiNurmShop extends GuiScreen{

	EntityPlayer player;
	Minecraft mine = Minecraft.getMinecraft();
	ScaledResolution resolution = new ScaledResolution(mine);
    double screenHeight = resolution.getScaledHeight_double();
    
    private final int WIDTH = 256;
	private final int HEIGHT = 256;
    public GuiNurmShop(EntityPlayer player) {
    	this.player = player;
	}
    
    @Override
	public void initGui() {
		int offsetFromScreenLeft = (width - WIDTH) / 2;
		IDialogueNurm dialouge = this.player.getCapability(DialogueProviderN.DIALOGUE_CAP, null); 
    }
    
    @Override
    public boolean doesGuiPauseGame() {
    	return false;
    }
    
    @Override
	public void updateScreen() 
	{
    	
	}
    
    @Override
	public void onGuiClosed() {
		super.onGuiClosed();
	}
    
    @Override
	public void drawScreen(int parWidth, int parHeight, float p_73863_3_)
	{
		int offsetFromScreenLeft = (width - WIDTH) / 2;	
		int y = (this.height - HEIGHT) / 2;
		ICurrency coins = this.player.getCapability(CoinProvider.COIN_CAP, null); 
		this.drawBackGround();
		
		
		mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/npc/nurm/shop.png"));
		this.drawModalRectWithCustomSizedTexture(offsetFromScreenLeft + (int)90.5F, y + 11, 0, 0, 80, 32, 80, 32);
	
		mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/npc/nurm/shop_coinamount.png"));
		this.drawModalRectWithCustomSizedTexture(offsetFromScreenLeft - 45, y + 11, 0, 0, 96, 32, 96, 32);
		this.fontRenderer.drawString(String.valueOf(coins.getCoins()), offsetFromScreenLeft - 8, y + 20.5F, 16777215, true);
	
		mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/npc/nurm/shop_page_1.png"));
		this.drawModalRectWithCustomSizedTexture(offsetFromScreenLeft - 35, y + 45, 0, 0, 162, 195, 162, 195);
		
		mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/npc/nurm/shop_page_2.png"));
		this.drawModalRectWithCustomSizedTexture(offsetFromScreenLeft + 135, y + 45, 0, 0, 162, 195, 162, 195);
		
	}
    
    public void drawBackGround() {
		this.drawDefaultBackground();
	}
}
