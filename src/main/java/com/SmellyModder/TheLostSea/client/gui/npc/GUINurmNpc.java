package com.SmellyModder.TheLostSea.client.gui.npc;

import org.lwjgl.opengl.GL11;

import com.SmellyModder.TheLostSea.core.util.Reference;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.interfaces.IDialogueNurm;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.controller.DialogueControllerN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.provider.DialogueProviderN;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GUINurmNpc extends GuiScreen{

	private final int HEIGHT = 210;
	private final int WIDTH = 256;
	private int currentNPCGui = 0;
	private int dialogueID = 0;
	protected FontRenderer customFontRenderer = new FontRenderer(Minecraft.getMinecraft().gameSettings, new ResourceLocation(Reference.MOD_ID + ":textures/font/npc_font.png"), Minecraft.getMinecraft().renderEngine, false);
	private static final ResourceLocation BG = new ResourceLocation(Reference.MOD_ID + ":textures/gui/overlay/gray_bg.png");
	private String log;
	
	EntityPlayer player;
	public GUINurmNpc(EntityPlayer player) {
		this.player = player;
		IDialogueNurm dialouge = this.player.getCapability(DialogueProviderN.DIALOGUE_CAP, null);
		dialogueID = dialouge.getVerse();
		log = String.valueOf(dialogueID);
	}
	
	@Override
	public void initGui() {
		
		super.initGui();
		
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	public void updateScreen() 
	{
		
	}
	
	public void drawBackGround() {
		this.drawDefaultBackground();
	}
	
	@Override
	public void drawScreen(int parWidth, int parHeight, float p_73863_3_)
	{
		int offsetFromScreenLeft = (width - WIDTH) / 2;
		this.drawBackGround();
		fontRenderer.drawString(log, height, 155, 0, false);
	}
	
	public void addOpeningText() {
		fontRenderer.drawString("Hello!", height, 155, 0, false);
	}
}
