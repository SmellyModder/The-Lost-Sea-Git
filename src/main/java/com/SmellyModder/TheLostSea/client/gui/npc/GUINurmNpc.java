package com.SmellyModder.TheLostSea.client.gui.npc;

import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.SmellyModder.TheLostSea.core.packets.npc.MessageVerseN;
import com.SmellyModder.TheLostSea.core.util.Reference;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.interfaces.IDialogueNurm;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.controller.DialogueControllerN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.provider.DialogueProviderN;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
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
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GUINurmNpc extends GuiScreen{
	
	EntityPlayer player;
	Minecraft mine = Minecraft.getMinecraft();
	ScaledResolution resolution = new ScaledResolution(mine);
    double screenHeight = resolution.getScaledHeight_double();
   
	private static double nextAnimation;
	private static double timeBefore;

	private final int WIDTH = 256;
	private final int HEIGHT = 256;
	private int currGui = 0;
	private int currDialogue = 0;
	private int dialogueID = 0;
	protected FontRenderer customFontRenderer = new FontRenderer(mine.gameSettings, new ResourceLocation("textures/font/ascii.png"), mine.renderEngine, true);
	private static final ResourceLocation BG = new ResourceLocation(Reference.MOD_ID + ":textures/gui/npc/nurm/npc_nurm_starter_gui.png");
	int offsetFromScreenLeft = (width - WIDTH) / 2;
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
	 
	/*
	 * Buttons
	 */
	private NextDialougeButton NextDialougeButton;
	
	private TalkButton TalkButton;
	private ShopButton ShopButton;
	private ExitButton ExitButton;
	
	public GUINurmNpc(EntityPlayer player) {
		this.player = player;
		IDialogueNurm dialouge = this.player.getCapability(DialogueProviderN.DIALOGUE_CAP, null);
		dialogueID = dialouge.getVerse();
	}
	
	@Override
	public void initGui() {
		
		
		buttonList.clear();
		
		buttonList.add(NextDialougeButton = new NextDialougeButton(1, offsetFromScreenLeft + 535, y + 273));
		
		//buttonList.add(TalkButton = new NurmGuiSelector(2, offsetFromScreenLeft + 640, y + 315, "Talk"));
		//buttonList.add(ShopButton = new NurmGuiSelector(3, offsetFromScreenLeft + 640, y + 315, "Shop"));
		//buttonList.add(ExitButton = new NurmGuiSelector(4, offsetFromScreenLeft + 640, y + 315, "Exit"));

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
		//this.NextDialougeButton.visible = currDialogue == 1;
	}
	
	@Override
	public void onGuiClosed() {
		IDialogueNurm dialouge = this.player.getCapability(DialogueProviderN.DIALOGUE_CAP, null);
		if(player instanceof EntityPlayerMP) {
			TheLostSea.NETWORK.sendTo(new MessageVerseN(dialouge.getVerse()), (EntityPlayerMP) player);
		}
		super.onGuiClosed();
	}
	
	public void drawBackGround() {
		this.drawDefaultBackground();
	}
	
	@Override
	public void drawScreen(int parWidth, int parHeight, float p_73863_3_)
	{	IDialogueNurm dialouge = this.player.getCapability(DialogueProviderN.DIALOGUE_CAP, null); 
		
		this.drawGradientRect(0, 0, this.width, this.height, -1072689136, -804253680);
		
    	this.drawGradientRect(0, this.height / 2 + 0 * 12 + 40, this.width / 2 + 0 / 2 + 1000, this.height / 2 + 0 * 10 + 590, 0x66000000, 0x66000000);
    	
    	this.drawDialouge();
    	
    	if(dialouge.getVerse() == 0) {
    		if(currGui == 0) {
    			this.fontRenderer.drawString("Welcome to Nurm's Adventure Emporium! How may I help you today?", this.offsetFromScreenLeft + 162, y + 250, 16777215, true);
    		}
    		} else if(dialouge.getVerse() == 1) {
    			
			this.fontRenderer.drawString("Welcome back! Have you managed to get that eye yet?", this.offsetFromScreenLeft + 162, y + 250, 16777215, true);
		}
    	mc.getTextureManager().bindTexture(BG);
    	
    	 GlStateManager.enableBlend();
         GlStateManager.disableAlpha();
         GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
    	this.drawTexturedModalRect(offsetFromScreenLeft + 600, y + 320, 0, 85, 100, 100);
         GlStateManager.disableBlend();
         GlStateManager.enableAlpha();
    	super.drawScreen(parWidth, parHeight, p_73863_3_);
	}
	
	protected void drawDialouge() {
		this.drawGradientRect(this.width / 2 - 0 / 2 - 212, this.height / 2 + 0 * 12 - 10, this.width / 2 + 0 / 2 + 185, this.height / 2 + 0 * 10 + 30, 0x66000000, 0x66000000);

		this.fontRenderer.drawString(TextFormatting.ITALIC + "Nurm", this.offsetFromScreenLeft + 163, y + 235, 5020550, true);
	}
	
	 protected void actionPerformed(GuiButton parButton) 
	 {	
		IDialogueNurm dialouge = this.player.getCapability(DialogueProviderN.DIALOGUE_CAP, null); 
		 if(parButton == NextDialougeButton) {
			 dialouge.setVerse(1);
		 }
	 }
	static class NextDialougeButton extends GuiButton{
        public NextDialougeButton(int parButtonId, int parPosX, int parPosY)
        {
            super(parButtonId, parPosX, parPosY, 23, 13, "");
        }
        
        @Override
        public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
        	if(visible) {
    	 		  boolean isButtonPressed = (mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height);
    	 		  
    	 		  int i = 2;
                  int j = 11;
    	 		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    	 		  mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/npc/nurm/npc_nurm_starter_gui.png"));
    	 		  

    	 		 final double time = (Sys.getTime() * 700) / Sys.getTimerResolution();
    	 		 final double timePassed = time - timeBefore;

    	 		timeBefore = time;

    	 		if (nextAnimation < 1000)
    	 		{
    	 			nextAnimation += timePassed;
    	 		}
    	 		else
    	 		{
    	 			nextAnimation = 0.0;
    	 		}

    	 		final double anim = nextAnimation;

    	 		if (nextAnimation < 500.0)
    	 		{
    	 			GlStateManager.translate(0, anim / 500.0, 0);
    	 		}
    	 		else if (nextAnimation >= 500.0)
    	 		{
    	 			GlStateManager.translate(0, -((anim - 500.0) / 500.0), 0);
    	 		}
    	 		
                this.drawTexturedModalRect(this.x, this.y, i, j, 11, 8);
        	}
        }
        
        @Override
        public void playPressSound(SoundHandler soundHandlerIn) {
        }
        @Override
        public boolean mousePressed(Minecraft mc, int mouseX, int mouseY)
        {
           return this.enabled && this.visible;
        }
	}
	
	static class ShopButton extends GuiButton {
        public ShopButton(int parButtonId, int parPosX, int parPosY)
        {
            super(parButtonId, parPosX, parPosY, 23, 13, "");
        }
	}
	
	static class TalkButton extends GuiButton {
        public TalkButton(int parButtonId, int parPosX, int parPosY)
        {
            super(parButtonId, parPosX, parPosY, 23, 13, "");
        }
	}
	
	static class ExitButton extends GuiButton {
        public ExitButton(int parButtonId, int parPosX, int parPosY)
        {
            super(parButtonId, parPosX, parPosY, 23, 13, "");
        }
	}
}
