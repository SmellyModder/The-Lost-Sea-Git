package com.SmellyModder.TheLostSea.client.gui.npc;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.SmellyModder.TheLostSea.core.packets.npc.MessageVerseN;
import com.SmellyModder.TheLostSea.core.util.Reference;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.interfaces.IDialogueNurm;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.controller.DialogueControllerN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.provider.DialogueProviderN;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GUINurmNpc extends GuiScreen{
	
	EntityPlayer player;
	Minecraft mine = Minecraft.getMinecraft();
	ScaledResolution resolution = new ScaledResolution(mine);
    double screenHeight = resolution.getScaledHeight_double();
   
	private final int WIDTH = 256;
	private final int HEIGHT = 256;
	private int currGui = 0;
	private int dialogueID = 0;
	protected FontRenderer customFontRenderer = new FontRenderer(mine.gameSettings, new ResourceLocation("textures/font/ascii.png"), mine.renderEngine, true);
	private static final ResourceLocation BG = new ResourceLocation(Reference.MOD_ID + ":textures/gui/overlay/gray_bg.png");
	int offsetFromScreenLeft = (resolution.getScaledWidth() - WIDTH) / 2;
	int y = (this.height - HEIGHT) / 2;
	
	private int getYForSize() {
		switch(mc.gameSettings.guiScale) {
			case 0:
				default:
				return 175;
			case 1: 
				return 335;
			case 2:
				return 400;
			case 3:
				return 450;
		}
	}
	 
	private GuiButton testButton;
	
	
	public GUINurmNpc(EntityPlayer player) {
		this.player = player;
		IDialogueNurm dialouge = this.player.getCapability(DialogueProviderN.DIALOGUE_CAP, null);
		dialogueID = dialouge.getVerse();
	}
	
	@Override
	public void initGui() {
		
		
		buttonList.clear();
        Keyboard.enableRepeatEvents(true);
		super.initGui();
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	public void updateScreen() 
	{	
		IDialogueNurm dialouge = this.player.getCapability(DialogueProviderN.DIALOGUE_CAP, null);
		System.out.println(y);
		System.out.println(offsetFromScreenLeft);
	}
	
	public void drawBackGround() {
		this.drawDefaultBackground();
	}
	
	@Override
	public void drawScreen(int parWidth, int parHeight, float p_73863_3_)
	{
		this.drawGradientRect(0, 0, this.width, this.height, -1072689136, -804253680);
		this.fontRenderer.drawString("Welcome to Nurm's Adventure Emporium! How may I help you?", this.offsetFromScreenLeft + 55, y + 155, 16777215, true);
    	//this.drawGradientRect(0, this.height / 2 + 0 * 12 + 30, this.width / 2 + 0 / 2 + 1000, this.height / 2 + 0 * 10 + 140, 0x66000000, 0x66000000);
		super.drawScreen(parWidth, parHeight, p_73863_3_);
	}
	
	 protected void actionPerformed(GuiButton parButton) 
	 {	
		IDialogueNurm dialouge = this.player.getCapability(DialogueProviderN.DIALOGUE_CAP, null); 
		 if(parButton == testButton) {
			 dialouge.setVerse(1);
		 }
	 }
	static class TestButton extends GuiButton{
        public TestButton(int parButtonId, int parPosX, int parPosY)
        {
            super(parButtonId, parPosX, parPosY, 23, 13, "");
        }
	}
	
}
