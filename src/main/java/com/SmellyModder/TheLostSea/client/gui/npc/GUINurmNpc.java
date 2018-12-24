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
	
	
	//Response 1: 
	private ResponseButton ResponeButton1;
	private ResponseButton ResponeButton2;
	private ResponseButton ResponeButton3;
	
	
	public GUINurmNpc(EntityPlayer player) {
		this.player = player;
		IDialogueNurm dialouge = this.player.getCapability(DialogueProviderN.DIALOGUE_CAP, null);
		dialogueID = dialouge.getVerse();
	}
	
	@Override
	public void initGui() {
		
		int offsetFromScreenLeft = (width - WIDTH) / 2;

		buttonList.clear();
		int y = (this.height - HEIGHT) / 2;
		buttonList.add(NextDialougeButton = new NextDialougeButton(1, offsetFromScreenLeft + 535, y + 273));
		
		buttonList.add(TalkButton = new TalkButton(2, offsetFromScreenLeft + 243, y + 175));
		buttonList.add(ShopButton = new ShopButton(3, offsetFromScreenLeft + 243, y + 200));
		buttonList.add(ExitButton = new ExitButton(4, offsetFromScreenLeft + 243, y + 225));
		
		//Response 1:
		buttonList.add(ResponeButton1 = new ResponseButton(5, offsetFromScreenLeft - 57, y + 175, 184, "What do you know about Guardians?"));
		buttonList.add(ResponeButton2 = new ResponseButton(6, offsetFromScreenLeft - 57, y + 195, 206, "What kind of stuff does your shop sell?"));
		buttonList.add(ResponeButton3 = new ResponseButton(7, offsetFromScreenLeft - 57, y + 215, 30, "Back"));
		
		
        Keyboard.enableRepeatEvents(true);
        this.NextDialougeButton.visible = false;
        
        this.ExitButton.visible = currGui == 0;
		this.TalkButton.visible = currGui == 0;
		this.ShopButton.visible = currGui == 0;
		this.ResponeButton1.visible = currGui == 1 && currDialogue == 0;
		this.ResponeButton2.visible = currGui == 1 && currDialogue == 0;
		this.ResponeButton3.visible = currGui == 1 && currDialogue == 0;
		super.initGui();
	}
	protected void actionPerformed(GuiButton parButton) {	
		IDialogueNurm dialouge = this.player.getCapability(DialogueProviderN.DIALOGUE_CAP, null); 
		 if(parButton == NextDialougeButton) {
			 dialouge.setVerse(1);
		 }
		 if(parButton.id == 4) {
	         mc.displayGuiScreen((GuiScreen)null);
		 } else if(parButton.id == 2) {
			 this.currGui = 1;
		 }
		 
		 if(parButton.id == 7) {
			 this.currGui = 0;
		 } else if(parButton.id == 6) {
			 
		 }
		 else if(parButton.id == 5) {
			 
		 }
	 }
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	public void updateScreen() 
	{
		this.ExitButton.visible = currGui == 0;
		this.TalkButton.visible = currGui == 0;
		this.ShopButton.visible = currGui == 0;
		
		this.ResponeButton1.visible = currGui == 1 && currDialogue == 0;
		this.ResponeButton2.visible = currGui == 1 && currDialogue == 0;
		this.ResponeButton3.visible = currGui == 1 && currDialogue == 0;
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
	{
		int offsetFromScreenLeft = (width - WIDTH) / 2;	
		int y = (this.height - HEIGHT) / 2;
		IDialogueNurm dialouge = this.player.getCapability(DialogueProviderN.DIALOGUE_CAP, null); 
	
		

		this.drawGradientRect(0, 0, this.width, this.height, -1072689136, -804253680);
		
    	this.drawGradientRect(0, this.height / 2 + 0 * 12 + 40, this.width / 2 + 0 / 2 + 1000, this.height / 2 + 0 * 10 + 590, 0x66000000, 0x66000000);
    	
    	this.drawDialouge();
    	
    	if(dialouge.getVerse() == 0) {
    		if(currGui == 0) {
    			this.fontRenderer.drawString("Welcome to my Adventure Emporium! How may I help you today?", offsetFromScreenLeft - 53, y + 120, 16777215, true);
    		} else if(currGui == 1) {
    			this.fontRenderer.drawString("Yes what is that you need?", offsetFromScreenLeft - 53, y + 120, 16777215, true);
    		}
    		} else if(dialouge.getVerse() == 1) {
			this.fontRenderer.drawString("Welcome back! Have you managed to get that eye yet?", offsetFromScreenLeft - 53, y + 120, 16777215, true);
		}
    	mc.getTextureManager().bindTexture(BG);
    	super.drawScreen(parWidth, parHeight, p_73863_3_);
    	if(currGui == 0) {
    		this.fontRenderer.drawString("Talk", offsetFromScreenLeft + 272, y + 177, 16777215, true);
        	this.fontRenderer.drawString("Shop", offsetFromScreenLeft + 271, y + 202, 16777215, true);
        	this.fontRenderer.drawString("Exit", offsetFromScreenLeft + 273, y + 227, 16777215, true);
    	}
	}
	
	protected void drawDialouge() {
		
		this.drawGradientRect(this.width / 2 - 0 / 2 - 185, this.height / 2 + 0 * 12 - 10, this.width / 2 + 0 / 2 + 185, this.height / 2 + 0 * 10 + 30, 0x66000000, 0x66000000);
		
		int offsetFromScreenLeft = (width - WIDTH) / 2;	
		int y = (this.height - HEIGHT) / 2;
		this.fontRenderer.drawString(TextFormatting.ITALIC + "Nurm", offsetFromScreenLeft - 53, y + 107, 5020550, true);
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
            super(parButtonId, parPosX, parPosY, 70, 20, "");
        }
        
        @Override
        public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
        	if(visible) {
  	 		    boolean isButtonPressed = (mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height);

        		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        		mc.getTextureManager().bindTexture(BG);
        		
        		 GlStateManager.enableBlend();
                 GlStateManager.disableAlpha();
                 GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        		 this.drawTexturedModalRect(this.x + 10, this.y - 30, 0, 80, 60, 45);
        		 GlStateManager.disableBlend();
        		 GlStateManager.enableAlpha();
        		
        		
        		if(isButtonPressed) {
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
       	 			//GlStateManager.translate(0, anim / 500.0, 0);
       	 		}
       	 		else if (nextAnimation >= 500.0)
       	 		{
       	 			//GlStateManager.translate(0, -((anim - 500.0) / 500.0), 0);
       	 		}
                    this.drawTexturedModalRect(this.x + 55, this.y + 2.5F, 2, 11, 11, 8);
        		}
        	}
        }
	}
	
	static class TalkButton extends GuiButton {
        public TalkButton(int parButtonId, int parPosX, int parPosY)
        {
            super(parButtonId, parPosX, parPosY, 70, 20, "");
        }
        @Override
        public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
        	if(visible) {
  	 		    boolean isButtonPressed = (mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height);
        		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        		mc.getTextureManager().bindTexture(BG);
        		
        		 GlStateManager.enableBlend();
                 GlStateManager.disableAlpha();
                 GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        		 this.drawTexturedModalRect(this.x + 10, this.y - 30, 0, 80, 60, 45);
        		 GlStateManager.disableBlend();
        		 GlStateManager.enableAlpha();
        		
        		if(isButtonPressed) {
                	
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
       	 			//GlStateManager.translate(0, anim / 500.0, 0);
       	 		}
       	 		else if (nextAnimation >= 500.0)
       	 		{
       	 			//GlStateManager.translate(0, -((anim - 500.0) / 500.0), 0);
       	 		}
                    this.drawTexturedModalRect(this.x + 55, this.y + 2.5F, 2, 11, 11, 8);
        		}
        	}
        }
	}
	
	static class ExitButton extends GuiButton {
        public ExitButton(int parButtonId, int parPosX, int parPosY)
        {
            super(parButtonId, parPosX, parPosY, 70, 20, "");
        } @Override
        public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
        	if(visible) {
  	 		    boolean isButtonPressed = (mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height);
        		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        		mc.getTextureManager().bindTexture(BG);
        		
        		 GlStateManager.enableBlend();
                 GlStateManager.disableAlpha();
                 GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        		 this.drawTexturedModalRect(this.x + 10, this.y - 30, 0, 80, 60, 45);
        		 GlStateManager.disableBlend();
        		 GlStateManager.enableAlpha();
        		
        		
        		if(isButtonPressed) {
        			

        		
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
       	 			//GlStateManager.translate(0, anim / 500.0, 0);
       	 		}
       	 		else if (nextAnimation >= 500.0)
       	 		{
       	 			//GlStateManager.translate(0, -((anim - 500.0) / 500.0), 0);
       	 		}
                    this.drawTexturedModalRect(this.x + 55, this.y + 2.5F, 2, 11, 11, 8);
        		}
        	}
        }
	}
	
	static class ResponseButton extends GuiButton {
		
		int width;
		String text;
		public ResponseButton(int parButtonId, int parPosX, int parPosY, int wordWidth, String text)
        {
            super(parButtonId, parPosX, parPosY, 70, 20, "");
            width = wordWidth;
            this.text = text;
        }
		@Override
		public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
			if(visible) {
			 boolean isButtonPressed = (mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height);
    		 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    		 mc.getTextureManager().bindTexture(BG);
    		
    		 int i = 80;
    		 
    		 if(isButtonPressed) {
    			 this.drawTexturedModalRect(this.x, this.y - 30, 0, 157, width, 43);
    		 } else {
    			 GlStateManager.enableBlend();
    			 GlStateManager.disableAlpha();
    			 GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
    			 this.drawTexturedModalRect(this.x, this.y - 30, 0, 80, width, 43);
    			 
    			 GlStateManager.disableBlend();
    		 	 GlStateManager.enableAlpha();
    		 }
    		 mc.fontRenderer.drawString(text, this.x + 3, this.y, 16777215, true);
		}
	  } 
	}
}
