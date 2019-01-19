package com.SmellyModder.TheLostSea.client.gui.npc;

import java.util.Arrays;

import javax.crypto.Cipher;
import javax.swing.text.html.parser.Entity;

import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.SmellyModder.TheLostSea.client.gui.npc.shop.SaleButtons;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.common.item.ItemBase;
import com.SmellyModder.TheLostSea.common.item.ItemElderEye;
import com.SmellyModder.TheLostSea.core.api.inventory.ILSShopItem;
import com.SmellyModder.TheLostSea.core.api.inventory.IShopButton;
import com.SmellyModder.TheLostSea.core.packets.MessageSetVerse;
import com.SmellyModder.TheLostSea.core.packets.npc.MessageRequestVerseN;
import com.SmellyModder.TheLostSea.core.packets.npc.MessageVerseN;
import com.SmellyModder.TheLostSea.core.util.Reference;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.interfaces.IDialogueNurm;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.controller.DialogueControllerN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.provider.DialogueProviderN;
import com.SmellyModder.TheLostSea.core.util.player.CoinProvider;
import com.SmellyModder.TheLostSea.core.util.player.shoputil.ICurrency;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.reflect.internal.Trees.This;


@SideOnly(Side.CLIENT)
public class GuiNurmNpc extends GuiScreen {
	
	EntityPlayer player;
	Minecraft mine = Minecraft.getMinecraft();
	ScaledResolution resolution = new ScaledResolution(mine);
    double screenHeight = resolution.getScaledHeight_double();
    
    private boolean showError = false;
    int fade;

    private int shopScreenID;
	private static double nextAnimation;
	private static double timeBefore;

	private final int WIDTH = 256;
	private final int HEIGHT = 256;
	private int currGui = 0;
	private int currDialogue = 0;
	private int dialogueID = 0;
	private Item currItem;
	private int price;
	private int prevPrice;
	private String description;
	private int amount;
	private static final ResourceLocation BG = new ResourceLocation(Reference.MOD_ID + ":textures/gui/npc/nurm/npc_nurm_starter_gui.png");
	 
	/*
	 * Buttons
	 */
	private NextDialougeButton NextDialougeButton;
	private AmountArrow addArrow;
	private AmountArrow subtractArrow;
	private BuyButton buyButton;
	private BuyButton sellButton;
	private SaleButton saleButton;
	private SaleButton SaleButton;
	private SaleButton SaleButton2;
	
	
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
	
	//Response 6:
	private ResponseButton ResponeButton11;
	private ResponseButton ResponeButton12;
	
	//Response 7:
	private ResponseButton ResponeButton13;
	private ResponseButton ResponeButton14;
	
	//Give Buttons
	private ResponseButton ResponeButtonEye;
	
	private ResponseButton ResponeButtonChest;
	
	public GuiNurmNpc(EntityPlayer player) {
		this.player = player;
		IDialogueNurm dialouge = this.player.getCapability(DialogueProviderN.DIALOGUE_CAP, null);
		dialogueID = dialouge.getVerse();
	}
	
	@Override
	public void initGui() {
		
		int offsetFromScreenLeft = (width - WIDTH) / 2;
		IDialogueNurm dialouge = this.player.getCapability(DialogueProviderN.DIALOGUE_CAP, null); 

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


		buttonList.add(ResponeButton9 = new ResponseButton(12, offsetFromScreenLeft - 57, y + 175, 60, "Yes, I'm in"));
		buttonList.add(ResponeButton10 = new ResponseButton(13, offsetFromScreenLeft - 57, y + 195, 69, "No, goodbye"));
		
		buttonList.add(ResponeButton11 = new ResponseButton(14, offsetFromScreenLeft - 57, y + 175, 76, "Yes, I'm ready"));
		buttonList.add(ResponeButton12 = new ResponseButton(15, offsetFromScreenLeft - 57, y + 195, 140, "Maybe another time, thanks"));
		
		buttonList.add(ResponeButton13 = new ResponseButton(16, offsetFromScreenLeft - 57, y + 175, 75, "Yes, I have it"));
		buttonList.add(ResponeButton14 = new ResponseButton(17, offsetFromScreenLeft - 57, y + 195, 126, "No, I still need to get it."));
	
		
		buttonList.add(ResponeButtonEye = new ResponseButton(18, offsetFromScreenLeft - 57, y + 175, 51, "Give Eye"));
		buttonList.add(ResponeButtonChest = new ResponseButton(19, offsetFromScreenLeft - 57, y + 175, 61, "Take Chest"));
		
		buttonList.add(SaleButton = new SaleButton(Items.COMPASS, 15, "The classic minecraft spawn finder tool.", 30, offsetFromScreenLeft + 48, y + 160, 16, 16, ""));
		buttonList.add(SaleButton2 = new SaleButton(Items.MAP, 10, "The classic minecraft map.", 31, offsetFromScreenLeft + 66, y + 160, 16, 16, ""));
		
		buttonList.add(addArrow = new AmountArrow(1001, offsetFromScreenLeft + 153, y + 54, true));
		buttonList.add(subtractArrow = new AmountArrow(1002, offsetFromScreenLeft + 118, y + 54, false));
		
		buttonList.add(buyButton = new BuyButton(1500, offsetFromScreenLeft + 30, y + 87, false));
		buttonList.add(sellButton = new BuyButton(1501, offsetFromScreenLeft + 30, y + 115, true));

        Keyboard.enableRepeatEvents(true);
        
        
        this.NextDialougeButton.visible = false;
        
        this.ExitButton.visible = currGui == 0;
		this.TalkButton.visible = currGui == 0;
		this.ShopButton.visible = currGui == 0;
		this.ResponeButton1.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 0 || currGui == 1 && currDialogue == 2;
		this.ResponeButton2.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 0;
		this.ResponeButton3.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 0;
		
		this.NextDialougeButton.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 1 || dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 3 || dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 5 || dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 6 
				|| dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 8 || dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 10 || dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 12 
				|| dialouge.getVerse() == 2 && currGui == 1 && currDialogue == 0 || dialouge.getVerse() == 2 && currGui == 1 && currDialogue == 2 || dialouge.getVerse() == 2 && currGui == 1 && currDialogue == 3
						|| dialouge.getVerse() == 2 && currGui == 1 && currDialogue == 5;
		
		this.ResponeButton4.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 2 || dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 4;
		
		this.ResponeButton6.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 4;
		
		
		this.ResponeButton7.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 7;
		this.ResponeButton8.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 7;
		
		this.ResponeButton9.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 9;
		this.ResponeButton10.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 9;
		
		this.ResponeButton11.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 11;
		this.ResponeButton12.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 11;

		this.ResponeButton13.visible = dialouge.getVerse() == 1 && currGui == 1 && currDialogue == 0;
		this.ResponeButton14.visible = dialouge.getVerse() == 1 && currGui == 1 && currDialogue == 0;
		
		this.ResponeButtonEye.visible = dialouge.getVerse() == 1 && currGui == 1 && currDialogue == 3;
		
		this.ResponeButtonChest.visible = dialouge.getVerse() == 2 && currGui == 1 && currDialogue == 4;
		
		
		
		
		SaleButton.visible = this.currGui == 2;
		SaleButton2.visible = this.currGui == 2;
		
		addArrow.visible = this.currGui == 2;
		subtractArrow.visible = this.currGui == 2;
		
		buyButton.visible = this.currGui == 2;
		sellButton.visible = this.currGui == 2;
		super.initGui();
	}
	
	public boolean isInvEmpty(EntityPlayer player, ItemStack stackIn)
    {
        return player.inventory.add(-1, stackIn);
    }
	
	public boolean invFull(EntityPlayer p) {          
	    return p.inventory.mainInventory.size() == -1;
	}

	
	protected void actionPerformed(GuiButton parButton) {	
		IDialogueNurm dialouge = this.player.getCapability(DialogueProviderN.DIALOGUE_CAP, null); 
		 if(parButton.id == 4) {
	         mc.displayGuiScreen((GuiScreen)null);
	         
		 } else if(parButton.id == 2) {
			 if(dialouge.getVerse() < 3) {
				 this.currGui = 1;
			 } else {
				 
			 }
		 }
		 else if(parButton.id == 3) {
	         currGui = 2;
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
			 } else if(currDialogue == 5 && dialouge.getVerse() == 0) {
				 currDialogue = 6;
			 } else if(currDialogue == 6) {
				 currDialogue = 7;
			 }
			 else if(currDialogue == 8) {
				 currDialogue = 9;
			 }
			 else if(currDialogue == 10) {
				 currDialogue = 11;
			 }
			 else if(currDialogue == 12) {
				 dialouge.setVerse(1);
				 TheLostSea.NETWORK.sendToServer(new MessageSetVerse(1));
		         mc.displayGuiScreen((GuiScreen)null);
			 }
			 else if(currDialogue == 0 && dialouge.getVerse() == 2) {
				 currDialogue = 2;
			 }
			 else if(currDialogue == 2 && dialouge.getVerse() == 2) {
				 currDialogue = 3;
			 }
			 else if(currDialogue == 3 && dialouge.getVerse() == 2) {
				 currDialogue = 4;
			 }
			 else if(currDialogue == 5 && dialouge.getVerse() == 2) {
				 dialouge.setVerse(3);
				 TheLostSea.NETWORK.sendToServer(new MessageSetVerse(3));
		         mc.displayGuiScreen((GuiScreen)null);
			 }
			 else if(currDialogue == 5 && dialouge.getVerse() == 1) {
				 mc.displayGuiScreen((GuiScreen)null);
			 }
		 }
		 else if(parButton.id == 9) {
			 currDialogue = 5;
		 }
		 else if(parButton.id == 10) {
			 currDialogue = 8;
		 } else if(parButton.id == 11 || parButton.id == 13 || parButton.id == 15) {
	         mc.displayGuiScreen((GuiScreen)null);
		 }
		 else if(parButton.id == 12) {
			 currDialogue = 10;
		 }
		 else if(parButton.id == 14) {
			 currDialogue = 12;
		 }
		 else if(parButton.id == 16) {
			 currDialogue = 1;
		 } 
		 else if(parButton.id == 17) {
			 currDialogue = 5;
		 }
		 else if(parButton.id == 18) {
			int offsetFromScreenLeft = (width - WIDTH) / 2;
			int y = (this.height - HEIGHT) / 2;
			 ItemStack itemstack = this.findEye(player);
			 if(!itemstack.isEmpty()) {
				 if(itemstack.getItem() instanceof ItemElderEye) {
					 itemstack.shrink(1);
					 dialouge.setVerse(2);
					 TheLostSea.NETWORK.sendToServer(new MessageSetVerse(2));
					 this.currDialogue = 0;
				 }
			 } else {
				 this.showError = true;
			}
		 }
		 else if(parButton.id == 19) {
			 if(!this.isInvEmpty(player, new ItemStack(Items.AIR)) && player.inventory.getFirstEmptyStack() != -1) {
				 player.inventory.addItemStackToInventory(new ItemStack(TLSBlocks.STARTER_CHEST_FULL, 1));
				 this.currDialogue = 5;
			 } else {
				 this.showError = true;
			 }
		 }
		 
		 
		 
		 if(parButton instanceof IShopButton) {
			 currItem = ((IShopButton) parButton).getItem();
			 prevPrice = ((IShopButton) parButton).setPrice();
			 description = ((IShopButton) parButton).getDescription();
		 }
		 if(parButton.id == 1001 && currItem != null && this.amount < currItem.getItemStackLimit()) {
			 amount++;
			 this.price = this.prevPrice * this.amount;
		 } else if(parButton.id == 1002 && currItem != null && this.amount > 0)
			 amount--;
		 	 this.price = this.prevPrice * this.amount;
	 	 }
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	public void updateScreen() 
	{
		IDialogueNurm dialouge = this.player.getCapability(DialogueProviderN.DIALOGUE_CAP, null); 
		this.ExitButton.visible = currGui == 0;
		this.TalkButton.visible = currGui == 0;
		this.ShopButton.visible = currGui == 0;
		
		this.ResponeButton1.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 0 || dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 2;
		this.ResponeButton2.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 0;
		this.ResponeButton3.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 0;
		
		this.NextDialougeButton.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 1 || dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 3 || dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 5 || dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 6 
				|| dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 8 || dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 10 || dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 12 
				|| dialouge.getVerse() == 2 && currGui == 1 && currDialogue == 0 || dialouge.getVerse() == 2 && currGui == 1 && currDialogue == 2 || dialouge.getVerse() == 2 && currGui == 1 && currDialogue == 3
						|| dialouge.getVerse() == 2 && currGui == 1 && currDialogue == 5 || dialouge.getVerse() == 1 && currGui == 1 && currDialogue == 5;
		
		this.ResponeButton4.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 2 || dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 4;
		
		this.ResponeButton6.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 4;
		
		
		this.ResponeButton7.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 7;
		this.ResponeButton8.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 7;
		
		this.ResponeButton9.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 9;
		this.ResponeButton10.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 9;
		
		this.ResponeButton11.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 11;
		this.ResponeButton12.visible = dialouge.getVerse() == 0 && currGui == 1 && currDialogue == 11;
	
		this.ResponeButton13.visible = dialouge.getVerse() == 1 && currGui == 1 && currDialogue == 0;
		this.ResponeButton14.visible = dialouge.getVerse() == 1 && currGui == 1 && currDialogue == 0;
		
		this.ResponeButtonEye.visible = dialouge.getVerse() == 1 && currGui == 1 && currDialogue == 1;
		this.ResponeButtonChest.visible = dialouge.getVerse() == 2 && currGui == 1 && currDialogue == 4;
		
		if(showError) {
			fade++;
		}
		if(fade >= 100) {
			showError = false;
			fade = 0;
		}
		
		SaleButton.visible = this.currGui == 2;
		SaleButton2.visible = this.currGui == 2;
		
		addArrow.visible = this.currGui == 2;
		subtractArrow.visible = this.currGui == 2;
		
		buyButton.visible = this.currGui == 2;
		sellButton.visible = this.currGui == 2;
	}
	
	@Override
	public void onGuiClosed() {
		IDialogueNurm dialouge = this.player.getCapability(DialogueProviderN.DIALOGUE_CAP, null);
		TheLostSea.NETWORK.sendToServer(new MessageRequestVerseN());
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
		ICurrency coins = this.player.getCapability(CoinProvider.COIN_CAP, null); 
		

		this.drawGradientRect(0, 0, this.width, this.height, -1072689136, -804253680);
		
    	this.drawGradientRect(0, this.height / 2 + 0 * 12 + 40, this.width / 2 + 0 / 2 + 1000, this.height / 2 + 0 * 10 + 590, 0x66000000, 0x66000000);
    	
    	if(currGui >= 0) {
    		if(currGui == 0 || currGui == 1) {
    			this.drawDialouge();
    		}
    		else if(currGui == 2) {
        		
        		mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/npc/nurm/shop.png"));
        		this.drawModalRectWithCustomSizedTexture(offsetFromScreenLeft + 0, y - 6, 0, 0, 256, 256, 256, 256);
        		
        		this.fontRenderer.drawString("Shop", offsetFromScreenLeft + (int)42.5F, y + 13, 4210752);
        		this.fontRenderer.drawString("Cost", offsetFromScreenLeft + (int)187F, y + 40, 4210752);
        		
        		
        		this.fontRenderer.drawString(String.valueOf(coins.getCoins()), offsetFromScreenLeft + (int)181, y + 13, 4210752);
        		
        		
        		this.fontRenderer.drawString(String.valueOf(this.price), offsetFromScreenLeft + (int)184, y + 59, 4210752);
        		
        		/*
        		 * Note: Gui has a limit to how far it can display an Item's name. So add an if to check for it that would say, ex. Vanadium Ches...
        		 */
        		if(this.currItem != null) {
        			 this.fontRenderer.drawString(this.currItem.getItemStackDisplayName(new ItemStack(currItem)), offsetFromScreenLeft + (int)31, y + 40, 4210752);
        	
        			 this.fontRenderer.drawSplitString(this.description, offsetFromScreenLeft + (int)132, y + 85, 85, 4210752);
        		}
        		
        		
        		if(this.amount < 10) {
        			this.fontRenderer.drawString(String.valueOf(this.amount), offsetFromScreenLeft + (int)137, y + 59, 4210752);
        		}
        		else {
        			this.fontRenderer.drawString(String.valueOf(this.amount), offsetFromScreenLeft + (int)134, y + 59, 4210752);
        		}
        		
        		mc.getRenderItem().renderItemIntoGUI(new ItemStack(this.currItem), offsetFromScreenLeft + (int)51, y + 54);
        		
    		}
    	}
    	
    	
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
    			else if(currDialogue == 10) {
        			this.fontRenderer.drawString("Alright, good, I truly appreciate it. Anyways, getting to the dimension..", offsetFromScreenLeft - 53, y + 120, 16777215, true);
        			this.fontRenderer.drawString("is not so easy. To open the portal we're gonna need an Elder.. ", offsetFromScreenLeft - 53, y + 131, 16777215, true);
        			this.fontRenderer.drawString("Guardian's Eye. Which could be hard to get.", offsetFromScreenLeft - 53, y + 142, 16777215, true);
    			}
    			else if(currDialogue == 11) {
        			this.fontRenderer.drawString("To get the eye you must slay an Elder Guardian.", offsetFromScreenLeft - 53, y + 120, 16777215, true);
        			this.fontRenderer.drawString("Once you get the eye, return it to me. I can forge it into a portal key.", offsetFromScreenLeft - 53, y + 131, 16777215, true);
        			this.fontRenderer.drawString("So adventurer, ready to start your journey?", offsetFromScreenLeft - 53, y + 142, 16777215, true);
    			}
    			else if(currDialogue == 12) {
        			this.fontRenderer.drawString("Awesome! I wish you luck on your adventure.", offsetFromScreenLeft - 53, y + 120, 16777215, true);
        			this.fontRenderer.drawString("Remeber to return to me once you get the eye. Goodbye and good luck!", offsetFromScreenLeft - 53, y + 131, 16777215, true);
    			}
    		}
    		} else if(dialouge.getVerse() == 1) {
    			if(currGui == 0) {
        			this.fontRenderer.drawString("Welcome back! Have you managed to get that eye yet?", offsetFromScreenLeft - 53, y + 120, 16777215, true);
    			}
    			else if(currGui == 1) {
    				if(currDialogue == 0) {
            			this.fontRenderer.drawString("So did you get it?", offsetFromScreenLeft - 53, y + 120, 16777215, true);
        			}
    				else if(currDialogue == 1) {
            			this.fontRenderer.drawString("Nice, hand over the eye to me.", offsetFromScreenLeft - 53, y + 120, 16777215, true);
        			}
    				else if(currDialogue == 2) {
            			this.fontRenderer.drawString("Excellent, now the real journey can begin.", offsetFromScreenLeft - 53, y + 120, 16777215, true);
            			this.fontRenderer.drawString("Before you go, I have a chest of supplies for you.", offsetFromScreenLeft - 53, y + 131, 16777215, true);
            			this.fontRenderer.drawString("The chest has many things that will help you on your journey.", offsetFromScreenLeft - 53, y + 142, 16777215, true);
    				}
    				else if(currDialogue == 5) {
            			this.fontRenderer.drawString("That's fine, just return to me as soon as you get the eye.", offsetFromScreenLeft - 53, y + 120, 16777215, true);
    				}
    			}
    		} else if(dialouge.getVerse() == 2) {
    			if(currGui == 1) {
    				if(currDialogue == 0) {
    					this.fontRenderer.drawString("Excellent, now the real journey can begin.", offsetFromScreenLeft - 53, y + 120, 16777215, true);
    					this.fontRenderer.drawString("Before you go, I have a chest of supplies for you.", offsetFromScreenLeft - 53, y + 131, 16777215, true);
    					this.fontRenderer.drawString("The chest has many things that will help you on your journey.", offsetFromScreenLeft - 53, y + 142, 16777215, true);
    				} else if(currDialogue == 2) {
    					this.fontRenderer.drawString("Inside the chest I have put the eye.", offsetFromScreenLeft - 53, y + 120, 16777215, true);
    					this.fontRenderer.drawString("I have also engineered the eye to look in the direction to the temple.", offsetFromScreenLeft - 53, y + 131, 16777215, true);
    					this.fontRenderer.drawString("There are two other things I've put in the chest that will be useful.", offsetFromScreenLeft - 53, y + 142, 16777215, true);
    				} else if(currDialogue == 3) {
    					this.fontRenderer.drawString("I put some of the dimension's so called 'currency' in there as well.", offsetFromScreenLeft - 53, y + 120, 16777215, true);
    					this.fontRenderer.drawString("Lastly, Jack wrote notes on the dimension in a journal.", offsetFromScreenLeft - 53, y + 131, 16777215, true);
    					this.fontRenderer.drawString("Most of the pages are lost, but I'll give it to you anyway.", offsetFromScreenLeft - 53, y + 142, 16777215, true);
    				} else if(currDialogue == 4) {
    					this.fontRenderer.drawString("Maybe you can find some of the lost pages ey?", offsetFromScreenLeft - 53, y + 120, 16777215, true);
    					this.fontRenderer.drawString("Well anyway, you best be getting going. Good luck out there.", offsetFromScreenLeft - 53, y + 131, 16777215, true);
    					this.fontRenderer.drawString("Take the chest and begin your journey.", offsetFromScreenLeft - 53, y + 142, 16777215, true);
    				}
    				else if(currDialogue == 5) {
    					this.fontRenderer.drawString("You can go now, good luck. Don't die out there, friend.", offsetFromScreenLeft - 53, y + 120, 16777215, true);
    				}
    		}
    	}
    	else if(dialouge.getVerse() == 3) {
    		if(currGui == 0) {
				this.fontRenderer.drawString("Welcome back friend, what is it you need?", offsetFromScreenLeft - 53, y + 120, 16777215, true);
    		}
    		else if(currGui == 1) {
    			
    		}
    	}
    	
    	mc.getTextureManager().bindTexture(BG);
    	super.drawScreen(parWidth, parHeight, p_73863_3_);
    	if(currGui == 0) {
    		this.fontRenderer.drawString("Talk", offsetFromScreenLeft + 272, y + 177, 16777215, true);
        	this.fontRenderer.drawString("Shop", offsetFromScreenLeft + 271, y + 202, 16777215, true);
        	this.fontRenderer.drawString("Exit", offsetFromScreenLeft + 273, y + 227, 16777215, true);
    	}
    	
    	if(this.showError) {
    		if(dialouge.getVerse() == 1) {
    		 this.fontRenderer.drawString(TextFormatting.BOLD + "No Eye In Inventory!", offsetFromScreenLeft + 202, y + 180, 16711680, true);
    		} else if(dialouge.getVerse() == 2){
   			 this.fontRenderer.drawString(TextFormatting.BOLD + "Inventory Slots Full!", offsetFromScreenLeft + 202, y + 180, 16711680, true);
    		}
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
    	 		  
    	 		  GlStateManager.pushMatrix();

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
                GlStateManager.popMatrix();
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
	
	protected boolean isEye(ItemStack stack)
	{
	   return stack.getItem() instanceof ItemBase;
	}
	
	private ItemStack findEye(EntityPlayer player)
    {
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
            {
                ItemStack itemstack = player.inventory.getStackInSlot(i);

                if (this.isEye(itemstack))
                {
                    return itemstack;
                }
            }
            return ItemStack.EMPTY;
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
	
	@SideOnly(Side.CLIENT)
	public static class SaleButton extends GuiButton implements IShopButton {
	
		Item itemForSale;
		int price;
		String description;
		public SaleButton(Item itemForSale, int price, String desc, int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
			super(buttonId, x, y, widthIn, heightIn, buttonText);
			this.itemForSale = itemForSale;
			this.price = price;
			this.description = desc;
		}
		
		@Override
		public Item getItem() {
			return this.itemForSale;
		}
		
		@Override
		public int setPrice() {
			return price;
		}
		
		@Override
		public String getDescription() {
			return this.description;
		}
		
		public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
			if (this.visible)
            {	
				
				mc.getRenderItem().renderItemAndEffectIntoGUI(new ItemStack(this.itemForSale), this.x, this.y);
				
                boolean flag = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/npc/nurm/shop_buttons.png"));
                int i = 42;
                int j = 100;

                if (flag)
                {
                    j -= 59;
                }
                
                GlStateManager.enableBlend();
                GlStateManager.disableAlpha();
   			 	GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
   			 	this.drawTexturedModalRect(this.x, this.y, i, j, 16, 16);
   			 	GlStateManager.disableBlend();
   			 	GlStateManager.enableAlpha();
            }
		}
		
		@Override
		public void playPressSound(SoundHandler soundHandlerIn) {
		}
		
		}
	
	@SideOnly(Side.CLIENT)
    static class AmountArrow extends GuiButton
    {
            private final boolean isForward;

            public AmountArrow(int buttonId, int x, int y, boolean isForwardIn)
            {
                super(buttonId, x, y, 23, 13, "");
                this.isForward = isForwardIn;
            }

            public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
            {
                if (this.visible)
                {
                    boolean flag = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
                    GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                    mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/npc/nurm/shop_buttons.png"));
                    int i = 32;
                    int j = 2;

                    if (flag)
                    {
                        j += 19;
                    }

                    if (this.isForward)
                    {
                        i += 23;
                    }

                    this.drawTexturedModalRect(this.x, this.y, i, j, 8, 17);
                }
           }
     }
	
	static class BuyButton extends GuiButton
    {
        private final boolean isSell;

        public BuyButton(int buttonId, int x, int y, boolean isSell)
        {
            super(buttonId, x, y, 43, 20, "");
            this.isSell = isSell;
        }

        public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
        {
            if (this.visible)
            {
                boolean flag = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/npc/nurm/shop_buttons.png"));
                int i = 0;
                int j = 41;

                if (flag)
                {
                    j += 20;
                }

                this.drawTexturedModalRect(this.x, this.y, i, j, 42, 20);
                
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                
                if(!this.isSell) {
                	mc.fontRenderer.drawString("Buy", (float)((this.x + this.width / 2) - mc.fontRenderer.getStringWidth("Buy") / 2), this.y + (this.height - 8) / 2, 4210752, false);
                }
                else {
                	mc.fontRenderer.drawString("Sell", (float)((this.x + this.width / 2) - mc.fontRenderer.getStringWidth("Buy") / 2), this.y + (this.height - 8) / 2, 4210752, false);
                }
            }
       }
  }
}
