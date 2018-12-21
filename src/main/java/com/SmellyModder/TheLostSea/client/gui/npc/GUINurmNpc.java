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
	ScaledResolution scaledresolution = new ScaledResolution(mine);
    double screenHeight = scaledresolution.getScaledHeight_double();
    int y = (height + 555) / 4;
	private final int WIDTH = 256;
	private int currGui = 0;
	private int dialogueID = 0;
	protected FontRenderer customFontRenderer = new FontRenderer(Minecraft.getMinecraft().gameSettings, new ResourceLocation(Reference.MOD_ID + ":textures/font/npc_font.png"), Minecraft.getMinecraft().renderEngine, false);
	private static final ResourceLocation BG = new ResourceLocation(Reference.MOD_ID + ":textures/gui/overlay/gray_bg.png");
	int offsetFromScreenLeft = (width - WIDTH) / 2;
	
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
        
        buttonList.add(testButton = new GuiButton(785, this.offsetFromScreenLeft + 167, 65, 98, 28, ""));
   
        testButton.visible = true;
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
		if(player instanceof EntityPlayerMP) {
			TheLostSea.NETWORK.sendTo(new MessageVerseN(dialouge.getVerse()), (EntityPlayerMP) player);
		 }
	}
	
	public void drawBackGround() {
		this.drawDefaultBackground();
	}
	
	@Override
	public void drawScreen(int parWidth, int parHeight, float p_73863_3_)
	{
		this.drawGradientRect(0, 0, this.width, this.height, -1072689136, -804253680);
		if(dialogueID == 0) {
			fontRenderer.drawStringWithShadow("Welcome to Nurm's Adventure Emporium!", offsetFromScreenLeft + 145, y, 16777215);
		} else if (dialogueID == 1) {
			fontRenderer.drawStringWithShadow("Welcome back! Have you managed to get that eye?", offsetFromScreenLeft + 145, y, 16777215);
		}
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
