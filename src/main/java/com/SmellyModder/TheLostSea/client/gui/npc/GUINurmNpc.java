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
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GUINurmNpc extends GuiScreen {
	
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
	
	//Response 2:
	private ResponseButton ResponeButton4;
	private ResponseButton ResponeButton5;
	
	//Response 3:
	private ResponseButton ResponeButton6;
	
	//Response 4:
	private ResponseButton ResponeButton7;
	private ResponseButton ResponeButton8;
	
	//Response 5:
	private ResponseButton ResponeButton9;
	private ResponseButton ResponeButton10;
	
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
		buttonList.add(NextDialougeButton = new NextDialougeButton(1, offsetFromScreenLeft + 295, y + 145));
		
		buttonList.add(TalkButton = new TalkButton(2, offsetFromScreenLeft + 243, y + 175));
		buttonList.add(ShopButton = new ShopButton(3, offsetFromScreenLeft + 243, y + 200));
		buttonList.add(ExitButton = new ExitButton(4, offsetFromScreenLeft + 243, y + 225));
		
		//Response 1:
		buttonList.add(ResponeButton1 = new ResponseButton(5, offsetFromScreenLeft - 57, y + 175, 184, "What do you know about Guardians?"));
		buttonList.add(ResponeButton2 = new ResponseButton(6, offsetFromScreenLeft - 57, y + 195, 206, "What kind of stuff does your shop sell?"));
		buttonList.add(ResponeButton3 = new ResponseButton(7, offsetFromScreenLeft - 57, y + 215, 30, "Back"));
		
		
		buttonList.add(ResponeButton4 = new ResponseButton(8, offsetFromScreenLeft - 57, y + 195, 77, "Nope, Goodbye"));
		
		buttonList.add(ResponeButton6 = new ResponseButton(9, offsetFromScreenLeft - 57, y + 175, 28, "Yes"));
		
		
		buttonList.add(ResponeButton7 = new ResponseButton(10, offsetFromScreenLeft - 57, y + 175, 160, "Maybe, but what's in it for me?"));
		buttonList.add(ResponeButton8 = new ResponseButton(11, offsetFromScreenLeft - 57, y + 195, 121, "No thank you, goodbye"));


		buttonList.add(ResponeButton9 = new ResponseButton(10, offsetFromScreenLeft - 57, y + 175, 64, "Yes, I'm in"));
		buttonList.add(ResponeButton10 = new ResponseButton(11, offsetFromScreenLeft - 57, y + 195, 70, "No, goodbye"));
		
        Keyboard.enableRepeatEvents(true);
        this.NextDialougeButton.visible = false;
        
        this.ExitButton.visible = currGui == 0;
		this.TalkButton.visible = currGui == 0;
		this.ShopButton.visible = currGui == 0;
		this.ResponeButton1.visible = currGui == 1 && currDialogue == 0 || currGui == 1 && currDialogue == 2;
		this.ResponeButton2.visible = currGui == 1 && currDialogue == 0;
		this.ResponeButton3.visible = currGui == 1 && currDialogue == 0;
		
		this.ResponeButton4.visible = currGui == 1 && currDialogue == 2 || currGui == 1 && currDialogue == 4;
		
		this.ResponeButton6.visible = currGui == 1 && currDialogue == 4;
		
		
		this.ResponeButton7.visible = currGui == 1 && currDialogue == 7;
		this.ResponeButton8.visible = currGui == 1 && currDialogue == 7;
		
		this.ResponeButton9.visible = currGui == 1 && currDialogue == 9;
		this.ResponeButton10.visible = currGui == 1 && currDialogue == 9;
		
		super.initGui();
	}
	protected void actionPerformed(GuiButton parButton) {	
		IDialogueNurm dialouge = this.player.getCapability(DialogueProviderN.DIALOGUE_CAP, null); 
		 if(parButton.id == 4) {
	         mc.displayGuiScreen((GuiScreen)null);
	         
		 } else if(parButton.id == 2) {
			 this.currGui = 1;
		 } 
		 else if(parButton.id == 7 || parButton.id == 8) {
			 this.currGui = 0;
		 }
		 else if(parButton.id == 6) {
			 this.currDialogue = 1;
		 }
		 else if(parButton.id == 5) {
			 this.currDialogue = 3;
		 }
		 else if(parButton.id == 1) {
			 if(currDialogue == 1) {
				 currDialogue = 2;
			 } else if(currDialogue == 3) {
				 currDialogue = 4;
			 } else if(currDialogue == 5) {
				 currDialogue = 6;
			 } else if(currDialogue == 6) {
				 currDialogue = 7;
			 }
			 else if(currDialogue == 8) {
				 currDialogue = 9;
			 }
		 }
		 else if(parButton.id == 9) {
			 currDialogue = 5;
		 }
		 else if(parButton.id == 10) {
			 currDialogue = 8;
		 } else if(parButton.id == 11) {
	         mc.displayGuiScreen((GuiScreen)null);
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
		
		this.ResponeButton1.visible = currGui == 1 && currDialogue == 0 || currGui == 1 && currDialogue == 2;
		this.ResponeButton2.visible = currGui == 1 && currDialogue == 0;
		this.ResponeButton3.visible = currGui == 1 && currDialogue == 0;
		
		this.NextDialougeButton.visible = currGui == 1 && currDialogue == 1 || currGui == 1 && currDialogue == 3 || currGui == 1 && currDialogue == 5 || currGui == 1 && currDialogue == 6 
				|| currGui == 1 && currDialogue == 8;
		
		this.ResponeButton4.visible = currGui == 1 && currDialogue == 2 || currGui == 1 && currDialogue == 4;
		
		this.ResponeButton6.visible = currGui == 1 && currDialogue == 4;
		
		
		this.ResponeButton7.visible = currGui == 1 && currDialogue == 7;
		this.ResponeButton8.visible = currGui == 1 && currDialogue == 7;
		
		this.ResponeButton9.visible = currGui == 1 && currDialogue == 9;
		this.ResponeButton10.visible = currGui == 1 && currDialogue == 9;
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
    			if(currDialogue == 0) {
        			this.fontRenderer.drawString("Yes what is that you need?", offsetFromScreenLeft - 53, y + 120, 16777215, true);
    			} else if(currDialogue == 1) {
        			this.fontRenderer.drawString("My shop sells supplies for all adventurers and explorers alike.", offsetFromScreenLeft - 53, y + 120, 16777215, true);
        			this.fontRenderer.drawString("I sell compasses, maps, and so much more.", offsetFromScreenLeft - 53, y + 130, 16777215, true);
    			}
    			else if(currDialogue == 2) {
        			this.fontRenderer.drawString("Anything else you need?", offsetFromScreenLeft - 53, y + 120, 16777215, true);
    			}
    			else if(currDialogue == 3) {
        			this.fontRenderer.drawString("Well I know quite a lot actually, more than I should I'm afraid. ", offsetFromScreenLeft - 53, y + 120, 16777215, true);
        			this.fontRenderer.drawString("I could tell you the legend of 'The Lost Sea', the Guardians homeworld.", offsetFromScreenLeft - 53, y + 130, 16777215, true);
    			} 
    			else if(currDialogue == 4) {
        			this.fontRenderer.drawString("Would you like to know?", offsetFromScreenLeft - 53, y + 120, 16777215, true);
        			
    			}
    			else if(currDialogue == 5) {
        			this.fontRenderer.drawString("Well I'd tell you a lot, but it does bring back haunting memories.", offsetFromScreenLeft - 53, y + 120, 16777215, true);
        			this.fontRenderer.drawString("I had a friend, his name was Jack and he was a brave adventurer.", offsetFromScreenLeft - 53, y + 131, 16777215, true);
        			this.fontRenderer.drawString("He once found a not so ordinary sea temple.", offsetFromScreenLeft - 53, y + 142, 16777215, true);
    			}
    			else if(currDialogue == 6) {
        			this.fontRenderer.drawString("He opened a gate to another world in the temple.", offsetFromScreenLeft - 53, y + 120, 16777215, true);
        			this.fontRenderer.drawString("Being him, he wanted to explore this new world. Eventually he returned..", offsetFromScreenLeft - 53, y + 131, 16777215, true);
        			this.fontRenderer.drawString("many years later, and came back with a strange curse.", offsetFromScreenLeft - 53, y + 142, 16777215, true);
    			}
    			else if(currDialogue == 7) {
        			this.fontRenderer.drawString("The curse made him unable to speak and he was dying slowly.", offsetFromScreenLeft - 53, y + 120, 16777215, true);
        			this.fontRenderer.drawString("And I've been wondering for so many years as to how he was cursed.", offsetFromScreenLeft - 53, y + 131, 16777215, true);
        			this.fontRenderer.drawString("Perhaps you could unravel the mystery?", offsetFromScreenLeft - 53, y + 142, 16777215, true);
    			}
    			else if(currDialogue == 8) {
        			this.fontRenderer.drawString("Well there's a lot in it for you actually.", offsetFromScreenLeft - 53, y + 120, 16777215, true);
        			this.fontRenderer.drawString("It's a new world, who knows what treasure it may have?", offsetFromScreenLeft - 53, y + 131, 16777215, true);
        			this.fontRenderer.drawString("And I'll be sure to reward you, just for going there.", offsetFromScreenLeft - 53, y + 142, 16777215, true);
    			}
    			else if(currDialogue == 9) {
        			this.fontRenderer.drawString("Jack died a couple days after he returned from the dimension.", offsetFromScreenLeft - 53, y + 120, 16777215, true);
        			this.fontRenderer.drawString("Avenging his death would mean the world to me, I mean it.", offsetFromScreenLeft - 53, y + 131, 16777215, true);
        			this.fontRenderer.drawString("So, are you in?", offsetFromScreenLeft - 53, y + 142, 16777215, true);
    			}
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
		public ResponseButton(int parButtonId, int parPosX, int parPosY,int wordWidth, String text)
        {
            super(parButtonId, parPosX, parPosY, wordWidth, 20, "");
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
