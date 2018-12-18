package com.SmellyModder.TheLostSea.client.gui;

import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.SmellyModder.TheLostSea.client.gui.font.LSFont;
import com.SmellyModder.TheLostSea.common.entity.EntityAnglerfish;
import com.SmellyModder.TheLostSea.common.entity.EntityTriGuardian;
import com.SmellyModder.TheLostSea.common.entity.EntityVampireSquid;
import com.SmellyModder.TheLostSea.common.entity.passive.EntityShark;
import com.SmellyModder.TheLostSea.common.entity.raid.EntityTitanGuardian;
import com.SmellyModder.TheLostSea.common.init.TLSSounds;
import com.SmellyModder.TheLostSea.core.util.Reference;

import akka.routing.FromConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.collection.generic.Clearable;
import scala.tools.nsc.typechecker.TypeStrings;

@SideOnly(Side.CLIENT)
public class GUILoreBook extends GuiScreen {
	
	private final int bookImageHeight = 210;
	private final int bookImageWidth = 256;
	private int currPage = 0;
	private int Scale;
	//protected World world = mc.world;
	
	Random rand = new Random();
	private GuiButton buttonDone;
	private NumbSelctor VolSelectorM;
	private NumbSelctor VolSelectorG;
	private NumbSelctor VolSelectorA;
    private NextPageButton buttonNextPage;
    private NextPageButton buttonNextPageF;
    private NextPageButton buttonPreviousPage;
    private VolumeArrows volumeNextPage1;
    private VolumeArrows volumePreviousPage1;
    private VolumeArrows volumeNextPage2;
    private VolumeArrows volumePreviousPage2;
    private VolumeArrows volumeNextPage3;
    private VolumeArrows volumePreviousPage3;
    private WhatThisButton buttonWhatThis;
    private ButtonMagnifier magButton;
    
    protected FontRenderer customFontRenderer; 
    //private static final ResourceLocation CUSTOMFONT = new ResourceLocation(Reference.MOD_ID + ":textures/gui/other/smelly_font.png");
    
    private static ResourceLocation next_buttons = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/page_c.png");
    private static ResourceLocation index = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/volume_lost_sea_ls.png");
    private static final ResourceLocation BOOK_GUI_TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/turn_buttons.png");
    
    //Rnd Rips
    private static ResourceLocation rip_1 = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/rips/rip.png");
    private static ResourceLocation rip_2 = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/rips/rip2.png");
    private static ResourceLocation rip_3 = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/rips/rip3.png");
    
    //Icons & overlays
    private static ResourceLocation NPC_ICONS = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/icon/icons_npc.png");
    private static ResourceLocation ENTITY_ICONS = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/icon/entity_icons.png");
    private static ResourceLocation LOCATION_ICONS = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/icon/location_icons.png");
    private static ResourceLocation STATS = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/icon/stats_icons.png");
    private static ResourceLocation MARK = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/ribbon/bookmark3.png");
    private static ResourceLocation STAGE = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/ribbon/bookmark1.png");
    
    private static final int bookTotalPages = 120;
    private boolean pageUnlocked[] = new boolean[bookTotalPages + 1];
    private boolean pageRipped[] = new boolean[bookTotalPages + 1];
    private static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
	private static String[] stringPageText = new String[bookTotalPages];
	private static String[] stringPageText2 = new String[bookTotalPages];
	private static String[] typeStringsE = new String[10];
	
	boolean flip = false;
	int nextButtonBack = 233;
    private ItemStack stack;
    private boolean zoomed = false;
    
	public GUILoreBook(ItemStack stack)
	{
		this.stack = stack;
		bookPageTextures[0] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/lore_book_base_front.png");
		bookPageTextures[1] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/lore_book_base.png");
		
		bookPageTextures[2] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/lore_book_vol1.png");
		bookPageTextures[3] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/lore_book_vol2.png");
		bookPageTextures[4] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/lore_book_vol3.png");
		
		bookPageTextures[5] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/cover/lore_book_cover_page_closed.png");
		bookPageTextures[6] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/cover/lore_book_cover_page_open.png");
		
		bookPageTextures[7] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/lore_book_base_square.png");
		bookPageTextures[8] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/lore_book_boss_s.png");
		
		stringPageText[0] = "Introduction";
		stringPageText[1] = "There are many many places in The Lost Sea, most of them I probably haven't even seen.. ,"
		 		+ "anyways here a some of these locations I have seen in this vast sea.";
		stringPageText[2] = "* - Pirate Cove"
				+ "         * - Siren Caves"
				+ "         * - Skull Island"
				+ "         * - Dwarka Village"
				+ "       * - The Great Trench"
				+ "  * - Brine Seas"
				+ "          * - Atlantis"
				+ "               * - Aegean Sea"
				+ "          * - Aegaeon Tower"
				+ "      * - King's Garden"
				+ "      * - Tasma's Dwelling";
		stringPageText[3] = "The siren caves are home to the 'Sirens', they're know to try to lure you into the cave with their song singing. It's a decent sized cave filled with little water and is quite cold. Many explorers have visited siren cave from being intrigued by the siren's voice,";
		stringPageText2[0] = "the sirens are basically the mythical creature you know as a mermaid, except it's much worse. My only tip for you, don't fall for their singing and get yourself eaten, that would be bad.";
		
		//Page 4
		stringPageText[4] = "Skull Island, even if it does exist that is, here are some things I know about it. I've never personally been there but ol' swashblocker says he has. It's apparently a Island with a huge cave shaped as a skull, says the name.";
		stringPageText2[1] = "Swashblocker is the only one who knows what it looks like because apparently his other crew members died in the storms near the Island. Apparently these are no normal storms, they are like super hurricanes. He says there is also a great treasure in the cave";
	
		stringPageText[5] = "Dwarka village probably has to be the most peaceful place in the sea. It's a village that has a spell cast around it to prevent monsters from getting in, it also has a few survivers from the Atlantis invasion. ";
		stringPageText2[2] = "They're many powerful and ancient people there, including a mighty wizard who claims to have made the guardians. His name is Dromonar, the great Warlock. It's said he started the rebellion against the guardians. Nobody's seen him ever since he put up the magic shield.";
		
		//Page 5
		stringPageText[6] = "This is like most trenches except this is one hell of a trench. Like some other places on this list, I have never personally been there. I once saw it from a distance, it looked like a endless void, apparently it's not and has a bottom.";
		stringPageText2[3] = "Explorers say it plunges so deep it can go to bedrock. It's a spawnplace of many monsters. Some believe an ancient relic was dropped down there by the Guardians, it was one of the 3 king gems. Legend has it, a huge crab lives down there in his dwelling possessing the gem.";
	
		//Pg 6
		stringPageText[7] = "Well well if it isn't the saltiest place in the whole sea. The brine sea comes from the word brine which means salty water, the water is so salty it will crystallize nearly all who step in it's waters. There isn't much life in this place as you may have guessed.";
		stringPageText2[4] = "The life that manages to survive there is most of the time quite powerful, as it takes some strength to live there. A legend has it, a monster known as the 'Brine Beast' lurks in the brine seas haunting it, killing all who attempt to enter the sea.";
		
		//pG 7
		stringPageText[8] = "Ah Atlantis, such a beatiful place, from the outside. I've never been in such a mystical place as Atlantis, only seen from the outside. Not many have been there ever since the Guardian overrule. When I saw it, it was absolutely glorious.";
		stringPageText2[5] = "Though nobody is allowed entrance except for Guardians who work for Aegaeon. It's guarded by a shield and only one gate to get in. The Titade Gate is a magic gate that can only be opened by the Gate Lord unless you have a kings gem that is, no one has seen one in ages";
	
		//pg 8
		stringPageText[9] = "The Aegean sea is not it's own sea and was once called the Great Atlantic. It's the ocean that resides near and in Atlantis. It's name was changed to the Aegean Sea after the Guardian god and overlord himself, Aegeaon. He's been a very chaotic ruler.";
		stringPageText2[6] = "Aegean Sea is a nice place despite it's name after a evil god. Inside the sea are places like Atlantis, Aegaeon Tower, and the King's Garden. It has to be the most scenic place in the sea. A tip for you there though, Aegeaon doesn't like visitor's...";
		
		//Pg 9
		stringPageText[10] = "This is a very ancient building, one of the most ancient in Atlantis. Originally it was called the Prime Sea Spire. It is a tower made by the old Warlocks of Atlantis. It stands the tallest in Atlantis encrusted in pure prismarine and atlantean gold. I have never been here.";
		stringPageText2[7] = "I have only heard the legends from Dromonar, a powerful warlock. It is the birthplace of Aegaeon, which is why it's named after him. It was used to conduct spells of great power in the tower due to it's massive energy levels. It's magic comes from a crystal in the tower.";
	
		//Pg 10
		stringPageText[11] = "The King's Garden, more specifically The Old King's Garden. It was a place of harmony and nature, it's been abandoned ever since the Guardians took over. A variety of species of plants in the sea and fish reside there.";		
		stringPageText2[8] = "What made this place so sacred is that 2 serpents live in the garden. They are gods called The Rainbow Serpents, they heal people as long as they are fed well. They are very powerful creatures. They only give healing to those that feed them, those that don't, get eaten...";
	
		//Pg 11
		stringPageText[12] = "Tasma, who's tasma? Well Tasma is said to be the biggest crab in the sea. He is said to live deep in the great trench. Hiding down there like any other bottom feeder, collecting whatever food falls down to the bottom.";
		stringPageText2[9] = "Also he's a crab who is very greedy and will do whatever it takes to get his hands on any relic or treasure. Many think he has one of the Kings Gems that was tossed down there, except no one has seen the crab in years ever since he went down deep into the Trench.";
	
	
		
	
		//Element Util
		typeStringsE[0] = " Normal ";
		typeStringsE[1] = TextFormatting.ITALIC + " Light ";
		typeStringsE[2] = TextFormatting.DARK_PURPLE + " Dark ";
		typeStringsE[3] = TextFormatting.DARK_RED + " Fighting ";
		typeStringsE[4] = TextFormatting.YELLOW + " Electric ";
		typeStringsE[5] = TextFormatting.WHITE + " Ice ";
		typeStringsE[6] = TextFormatting.LIGHT_PURPLE + " Poison ";
		typeStringsE[7] = TextFormatting.GRAY + " Ghost ";
	}
	
	
	
	/**
	 * Adds the buttons (and other controls) to the screen in question.
	 */
	@Override
	public void initGui() 
	{
		//this.customFontRenderer = new FontRenderer(mc.gameSettings, new ResourceLocation("textures/font/ascii.png"), mc.renderEngine, true);
		NBTTagCompound nbt = stack.getTagCompound();
		
		if(nbt == null) {
		    nbt = new NBTTagCompound();
		}
		nbt = nbt.getCompoundTag("pages");
		int unlocked_pages = 0; 
		if(nbt.hasKey("unlocked_pages"))
		{
		    unlocked_pages = nbt.getInteger("unlocked_pages");
		}
		//System.out.println(unlocked_pages);
		for(int i = 1; i <= bookTotalPages; i++)
        {
            pageUnlocked[i] = false; 
            if(nbt.hasKey("page_" + i)) 
            {
                if(nbt.getBoolean("page_" + i));
                {
                    pageUnlocked[i] = true;     
                }
            }
            //System.out.println(i + ":" + pageUnlocked[i]); //ONLY THIS LINE
        }
		 	buttonList.clear();
	        Keyboard.enableRepeatEvents(true);
	        
	        buttonDone = new GuiButton(0, width / 2 - 49, -25 + bookImageHeight, 98, 20, I18n.format("gui.done", new Object[0])) {
	        	
	        	@Override
	        	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
	            {
	        		GL11.glColor4f(7.0F, 1.0F, 1.0F, 1.0F);
	        		super.drawButton(mc, mouseX, mouseY, partialTicks);
	            }
	        	
	        	@Override
	        	public void playPressSound(SoundHandler soundHandlerIn)
	            {
	                soundHandlerIn.playSound(PositionedSoundRecord.getMasterRecord(TLSSounds.BOOK_CLOSE, 1.0F));
	            }
	        };
	        
	        buttonList.add(buttonDone);
	        
	        
	        int offsetFromScreenLeft = (width - bookImageWidth) / 2;
	        buttonList.add(buttonNextPage = new NextPageButton(1, offsetFromScreenLeft + nextButtonBack, 168, true));
	        buttonList.add(buttonNextPageF = new NextPageButton(1, offsetFromScreenLeft + 167, 168, true));
	       
	        buttonList.add(buttonPreviousPage = new NextPageButton(2, 
	              offsetFromScreenLeft - 2, 168, false));
	        
	        buttonList.add(VolSelectorM = new NumbSelctor(2, 
		              offsetFromScreenLeft + 104, 69, 45, false));
	        buttonList.add(VolSelectorG = new NumbSelctor(2, 
		              offsetFromScreenLeft + 104, 104, 45, true));
	        buttonList.add(VolSelectorA = new NumbSelctor(2, 
		              offsetFromScreenLeft + 104, 139, 45, true));
	        
	        buttonList.add(buttonWhatThis = new WhatThisButton(2, 
	        		offsetFromScreenLeft + 186, 50));
	        
	        buttonList.add(volumeNextPage1 = new VolumeArrows(2, 
		              offsetFromScreenLeft - 2, 26, true, 46));
	        buttonList.add(volumePreviousPage1 = new VolumeArrows(2, 
		              offsetFromScreenLeft - 2, 26, false, 46));
	        
	        buttonList.add(volumeNextPage2 = new VolumeArrows(2, 
		              offsetFromScreenLeft - -20, 26, true, 91));
	        buttonList.add(volumeNextPage3 = new VolumeArrows(2, 
		              offsetFromScreenLeft - -43, 26, true, 136));
	        buttonList.add(magButton = new ButtonMagnifier(777, 
		              offsetFromScreenLeft - -49, 80, zoomed, 136));
	        
	        buttonNextPage.visible = false;
			buttonPreviousPage.visible = false;
			VolSelectorA.visible = currPage == 1;
			VolSelectorG.visible = currPage == 1;
	        VolSelectorM.visible = currPage == 1;
	        volumeNextPage1.visible = currPage > 0 && currPage < 2;
	        volumePreviousPage1.visible = currPage > 2 && currPage < 46;
	        volumeNextPage2.visible = currPage > 0 && currPage < 47;
	        volumeNextPage3.visible = currPage > 0;
	        magButton.visible = currPage < 42 && currPage >= 24;
	}
	/**
	 * Called from the main game loop to update the screen.
	 */
	boolean showMe = false;
	private float mousePosY;
	private float mousePosX;
	
	@Override
	public void updateScreen() 
	{
		buttonNextPage.visible = (currPage < bookTotalPages - 1 && currPage != 0);
 		buttonPreviousPage.visible = currPage > 0;
		buttonNextPageF.visible = currPage == 0;
		
		VolSelectorA.visible = currPage == 1;
		VolSelectorG.visible = currPage == 1;
        VolSelectorM.visible = currPage == 1;
        
        volumeNextPage1.visible = currPage > 0 && currPage < 2;
        volumePreviousPage1.visible = currPage > 2 && currPage < 47;
        volumeNextPage2.visible = currPage > 0 && currPage < 47;
        volumeNextPage3.visible = currPage > 0;
        magButton.visible = currPage < 42 && currPage >= 24;
	}
	
	@Override
	public void drawScreen(int parWidth, int parHeight, float p_73863_3_)
	{
		int offsetFromScreenLeft = (width - bookImageWidth ) / 2;
		int topLeftStart = (bookImageWidth/2);
		int widthOfString;
		mousePosX = parWidth;
		mousePosY = parHeight;
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    if(currPage > 0) {
	    	if(pageUnlocked[currPage] && currPage != 1 && currPage != 66 && currPage != 76) {
	 		   mc.getTextureManager().bindTexture(bookPageTextures[1]);
	 		}
	 	    else if(currPage == 1) {
	 		    mc.getTextureManager().bindTexture(bookPageTextures[0]);
	 		}
	 		else if(currPage == 2) {
	 		    mc.getTextureManager().bindTexture(bookPageTextures[2]);
	 		}
	 		else if(currPage == 3) {
	 		   mc.getTextureManager().bindTexture(bookPageTextures[1]);
	 		}
	 		else if(currPage == 66) {
	 			   mc.getTextureManager().bindTexture(bookPageTextures[3]);
	 		}
	 		else if(currPage == 76) {
	 			   mc.getTextureManager().bindTexture(bookPageTextures[4]);
	 		}
	 		else if( currPage >= 24 && currPage < 42) {
	 			   mc.getTextureManager().bindTexture(bookPageTextures[7]);
	 		}
	 		else if(currPage >= 43 && currPage < 63) {
	 			if(currPage == 43 || currPage == 45 || currPage == 47 || currPage == 49 || currPage == 51 || currPage == 53 || currPage == 55 || currPage == 57 || currPage == 59 || currPage == 61) {
	 				mc.getTextureManager().bindTexture(bookPageTextures[8]);
	 			}else {
	 	 		   mc.getTextureManager().bindTexture(bookPageTextures[1]);
	 			}
	 		}
	 		else
	 		{
	 			if(currPage >= 21 || currPage < 12){
	 				mc.getTextureManager().bindTexture(rip_1);
	 			}else if(currPage >= 57){
	 				mc.getTextureManager().bindTexture(rip_2);
	 			}else {
	 				mc.getTextureManager().bindTexture(rip_3);
	 			}
	 		}
	 	    int newCalc = offsetFromScreenLeft - 110;
	 	    int newCalc2 = newCalc - 2;
	 	    drawTexturedModalRect(offsetFromScreenLeft, 2, 0, 0, bookImageWidth, bookImageHeight);
	 	    
	 	  if(currPage == 1) {
	 	    this.fontRenderer.drawString("Volume Index", (newCalc + 144F), (50), 000000, false);
	 	    
	 	    this.fontRenderer.drawString("A Lost Sea", (newCalc + 150F), (70), 000000, false);
	 	    this.fontRenderer.drawString("The Guardians", (newCalc + 140F), (106), 000000, false);
	 	    this.fontRenderer.drawString("Atlantis", (newCalc + 158F), (141.5F), 000000, false);
	 	    
	 	    
	 	    this.fontRenderer.drawSplitString(TextFormatting.UNDERLINE + "Volume I: A Lost Sea", newCalc + 248, 55, 116, 5592575);
	 	    this.fontRenderer.drawString("", (newCalc +241F), (69F), 000000, false);
	 	    
	 	    this.fontRenderer.drawSplitString(TextFormatting.UNDERLINE + "Volume II: The Guardians Origin", newCalc + 250, 90, 116, 16755200);
	 	    this.fontRenderer.drawString("", (newCalc+245F), (114F), 000000, false);
	 	    
	 	    this.fontRenderer.drawSplitString(TextFormatting.UNDERLINE + "Volume III: Atlantis", newCalc + 250, 135, 116, 11115264);
	 	    this.fontRenderer.drawString("", (newCalc+243F), (146F), 000000, false);
	 	    
	 	  }else if(currPage == 2) {
	 		  this.fontRenderer.drawSplitString(stringPageText[1],newCalc + 241, 45, 116, 0);
	 		  this.fontRenderer.drawSplitString("-------------------", newCalc + 241, 118, 116, 0);
	 		  
	 		  this.fontRenderer.drawSplitString("* - Places on next page(s)", newCalc + 245, 135, 116, 0);
	 	  }else if(currPage == 3) {
	 		  
	 		  this.fontRenderer.drawString("Known Locations", (newCalc + 138F), (41F), 000000, false);
	 		  //this.fontRenderer.drawString("Pirate Cove", (272F), (35F), 65280, true);
	 		  this.fontRenderer.drawSplitString(stringPageText[2], newCalc + 129, 51, 116, 0);
	 		  this.fontRenderer.drawString(TextFormatting.UNDERLINE + "Pirate Cove", (newCalc + 146F), (149F), 65280, true);
	 		 this.fontRenderer.drawSplitString("The Pirate Cove is a..", newCalc + 128, 161, 116, 0);
	 		  this.fontRenderer.drawSplitString("remote island inhabited by pirates who are led by Captain Swashblocker. These pirates are hiding from the Ghost Pirates on this island because they’ve been hunted ever since they stole the treasure from Skull Island, which was Ghost Pirate territory.", newCalc + 247, 40, 105, 0);
	 		  
	 		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		  mc.getTextureManager().bindTexture(LOCATION_ICONS);
	 		  drawModalRectWithCustomSizedTexture(327, 101, 1, 1F, 25, 20, 155, 115);
	 	  }else if(currPage == 4) {
	 		  this.fontRenderer.drawString("Siren Caves", (newCalc + 143F), (43F), 3120639, true);
	 		  this.fontRenderer.drawSplitString("\"Beware the song of the sirens!\" The sirens are mermaids who lure sailors to their death by singing while laying on rocks near shores. They sound beautiful, and their voluptuous bodies are quite attractive to unsuspecting men;", newCalc + 126, 52, 110, 0);
	 		  
	 		  this.fontRenderer.drawSplitString("but when you get close enough, they will eat you alive.The Siren Caves are the home of the sirens. Inside this cave they will lure sailors to their death. It is here where ships often go missing.", newCalc + 247, 52, 105, 0);
	 		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		  mc.getTextureManager().bindTexture(LOCATION_ICONS);
	 		  drawModalRectWithCustomSizedTexture(newCalc +320, 142, 1, 23F, 30, 22, 155, 107);
	 	  }else if(currPage == 5) {
	 		  this.fontRenderer.drawString("Skull Island", (newCalc +143F), (39F), 16722176, true);
	 		  this.fontRenderer.drawSplitString("\"It’s called Skull Island for a reason, ya know. You go there, and you never come back. A lot of skulls pile up there. It’s creepy, if you ask me.\" Skull Island is essentially No Man’s Land. Legend has it that..", newCalc +129, 48, 110, 0);
	 		  
	 		  this.fontRenderer.drawSplitString("many years ago a crew of pirates sailed there for the fabled treasure, and never returned. Now apparently they haunt the island as greedy and malicious ghosts, protecting the treasure they couldn’t get from anyone else. What could have ghosts wanted with a magical cutlass? No clue.", newCalc +244, 40, 111, 0);
	 		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		  mc.getTextureManager().bindTexture(LOCATION_ICONS);
	 		  drawModalRectWithCustomSizedTexture(newCalc +170, 150, 38, 24F, 30, 22, 126.5F, 104);
	 	  }else if(currPage == 6) {
	 		  this.fontRenderer.drawString("Dwarka Village", (newCalc +143F), (43F), 65504, true);
	 		  
	 		  this.fontRenderer.drawSplitString(stringPageText[5], newCalc +126, 52, 110, 0);
	 		  
	 		  this.fontRenderer.drawSplitString(stringPageText2[2], newCalc +247, 36, 105, 0);
	 		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		  mc.getTextureManager().bindTexture(LOCATION_ICONS);
	 		  drawModalRectWithCustomSizedTexture(newCalc +203, 137, 38, 1F, 30, 22, 126.5F, 104);
	 	  }
	 	  else if(currPage == 7) {
	 		  this.fontRenderer.drawString("The Great Trench", (newCalc +133F), (43F), 10092720, true);
	 		  
	 		  this.fontRenderer.drawSplitString(stringPageText[6], newCalc +127, 52, 110, 0);
	 		  
	 		  this.fontRenderer.drawSplitString(stringPageText2[3], newCalc +248, 38, 105, 0);
	 		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		  mc.getTextureManager().bindTexture(LOCATION_ICONS);
	 		  drawModalRectWithCustomSizedTexture(newCalc +184, 153, 1F, 42F, 30, 22, 105F, 99);
	 	  }
	 	  else if(currPage == 8) {
	 		  this.fontRenderer.drawString("Brine Seas", (newCalc2 +147F), (43F), 12189440, true);
	 		  
	 		  this.fontRenderer.drawSplitString(stringPageText[7], newCalc2 +129, 52, 110, 0);
	 		  
	 		  this.fontRenderer.drawSplitString(stringPageText2[4], newCalc2 +250, 41, 105, 0);
	 		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		  mc.getTextureManager().bindTexture(LOCATION_ICONS);
	 		  drawModalRectWithCustomSizedTexture(newCalc2 +208, 153, 78, 0.0F, 30, 22, 126.5F, 106);
	 	  }
	 	  else if(currPage == 9) {
	 		  this.fontRenderer.drawString("Atlantis", (newCalc2 +155F), (38F), 3145727, true);
	 		  
	 		  this.fontRenderer.drawSplitString(stringPageText[8], newCalc2 +126, 47, 113, 0);
	 		  
	 		  fontRenderer.drawSplitString(stringPageText2[5], newCalc2 +250, 38, 105, 0);
	 		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		  mc.getTextureManager().bindTexture(LOCATION_ICONS);
	 		  drawModalRectWithCustomSizedTexture(newCalc2 +175, 153, 80, 20F, 30, 22, 126.5F, 96);
	 	  }
	 	  else if(currPage == 10) {
	 		  this.fontRenderer.drawString("Aegean Sea", (newCalc2 +147), (40F), 65483, true);
	 		  
	 		  this.fontRenderer.drawSplitString(stringPageText[9], newCalc2 +129, 49, 110, 0);
	 		  
	 		  this.fontRenderer.drawSplitString(stringPageText2[6], newCalc2 +250, 41, 105, 0);
	 		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		  mc.getTextureManager().bindTexture(LOCATION_ICONS);
	 		  drawModalRectWithCustomSizedTexture(newCalc2 +315, 154, 34, 48F, 30, 22, 99F, 104);
	 	  }
	 	  else if(currPage == 11) {
	 		  this.fontRenderer.drawString("Aegeaon Tower", (newCalc2 +141), (40F), 7318527, true);
	 		  
	 		  this.fontRenderer.drawSplitString(stringPageText[10], newCalc2 +129, 49, 110, 0);
	 		  
	 		  this.fontRenderer.drawSplitString(stringPageText2[7], newCalc2 +250, 41, 105, 0);
	 		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		  mc.getTextureManager().bindTexture(LOCATION_ICONS);
	 		  drawModalRectWithCustomSizedTexture(newCalc2+331, 136, 3, 55F, 30, 35, 129F, 90);
	 	  }
	 	  else if(currPage == 12) {
	 		  this.fontRenderer.drawString("King's Garden", (newCalc2 +142), (40F), 16767488, true);
	 		  
	 		  this.fontRenderer.drawSplitString(stringPageText[11], newCalc2 +129, 49, 110, 0);
	 		  
	 		  this.fontRenderer.drawSplitString(stringPageText2[8], newCalc2 +250, 41, 105, 0);
	 		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		  mc.getTextureManager().bindTexture(LOCATION_ICONS);
	 		 drawModalRectWithCustomSizedTexture(newCalc2 +175, 150, 33, 73.3F, 30, 22, 116F, 99);
	 	  }
	 	  else if(currPage == 13) {
	 		  this.fontRenderer.drawString("Tasma's Dwelling", (newCalc2 +137), (40F), 14501376, true);
	 		  
	 		  this.fontRenderer.drawSplitString(stringPageText[12], newCalc2 +129, 49, 110, 0);
	 		  
	 		  this.fontRenderer.drawSplitString(stringPageText2[9], newCalc2 +250, 41, 105, 0);
	 		 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		  mc.getTextureManager().bindTexture(LOCATION_ICONS);
	 		 drawModalRectWithCustomSizedTexture(newCalc2 +178, 150, 66.5F, 69F, 30, 22, 105F, 99);
	 	  }
	 	  else if(currPage == 14) {
	 		  this.fontRenderer.drawString("------------------", (newCalc2 +127F), (42), 000000, false);
	 		  this.fontRenderer.drawSplitString("Now for the people of this sea, I know many villagers and people in the sea. I'll list the more important ones and my close friends. Some of these people you may not even think are real.",newCalc + 127, 52, 105, 0);
	 		  this.fontRenderer.drawString("------------------", (newCalc2 +127F), (145), 000000, false);
	 		  
	 		  this.fontRenderer.drawString(TextFormatting.UNDERLINE + "Npc's and People", (newCalc2 +259F), (42), 000000, false);
	 		  this.fontRenderer.drawString("A- Cap'n Swashblocker", newCalc2 +244, 54, 00000, false);
	 		  this.fontRenderer.drawString("A- Cheif Honon", newCalc2 +244.2F, 64, 00000, false);
	 		  this.fontRenderer.drawString("M- Dromonar", newCalc2 +244, 73, 00000, false);
	 		  this.fontRenderer.drawString("D- Atlas", newCalc2 +244, 82, 00000, false);
	 		  this.fontRenderer.drawString("A- Tybalt", newCalc2 +244, 92, 00000, false);
	 		  this.fontRenderer.drawString("A- Dalyns", newCalc2 +244, 102, 00000, false);
	 		  this.fontRenderer.drawString("A- Ace", newCalc2 +244, 113, 00000, false);
	 		  this.fontRenderer.drawString("A- Lunete", newCalc2 +244, 122, 00000, false);
	 		  
	 		  this.fontRenderer.drawString(TextFormatting.BOLD + "D - deceased", newCalc2 +244, 136, 16711680, true);
	 		  this.fontRenderer.drawString(TextFormatting.BOLD + "A - alive", newCalc2 +244, 147, 65280, true);
	 		  this.fontRenderer.drawString(TextFormatting.BOLD + "M - missing", newCalc2 +244, 158, 16776960, true);
	 	  }
	 	  else if(currPage == 15) {
	 		  this.fontRenderer.drawString("Captain Swashblocker", (newCalc2 +125), (42), 13893632, true);
	 		  
	 		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		  mc.getTextureManager().bindTexture(NPC_ICONS);
	 		  drawModalRectWithCustomSizedTexture(newCalc2 +200, 70, 0, 2F, 25, 25, 89, 55);
	 		  this.fontRenderer.drawSplitString("The crazy rumdrinking addict pirate himself, Captain Swashblocker.", newCalc2 +127, 52, 105, 0);
	 		  this.fontRenderer.drawSplitString("He's known as the 'not so normal pirate', for a good reason. The reason he's weird is because he has all these pirate tales and he drinks tons of rum, no one believes the stories.", newCalc2 +127, 96, 111, 0);
	 		  this.fontRenderer.drawSplitString("The stories may seem very unrealistic but they do explain some phenomenons like on how he looks so young. He told me he looks so young from drinking out of a magic goblet. He is the captain of the pirates on Pirate Cove. He is enemies with the 'Ghost Pirates' because he stole their booty.", newCalc2 +245, 42, 111, 0);
	 	  }
	 	  else if(currPage == 16) {
	 		  this.fontRenderer.drawString("Cheif Honon", (newCalc2 +146), (42), 3134198, true);
	 		  this.fontRenderer.drawSplitString("The Chief of Dwarka Village and leader of the Guardian Rebellion.", newCalc2 +127, 52, 105, 0); //He found Dromonar, a powerful wizard and together built Dwarka Village.
	 		  this.fontRenderer.drawSplitString("As a surviver of the Atlantis invasion from the Guardians he had a diehard hate for them. In his hate he started a rebellion against the Guardians. He bears a scar from the invasion.", newCalc2 +127, 87, 111, 0);
	 		  this.fontRenderer.drawSplitString("After wanting to start a new village, he found Dromonar, a powerful wizard and together built Dwarka Village. They took in people of any kind, from fish people to Atlanteans. The rebels had one major goal, to take back Atlantis and bring back peace. A shield surrounds Dwarka Village.", newCalc2 +245, 40, 111, 0);
	 		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		  mc.getTextureManager().bindTexture(NPC_ICONS);
	 		  drawModalRectWithCustomSizedTexture(newCalc2 +214, 60, 25, 2.75F, 25, 25, 100F, 55);
	 	  }
	 	  else if(currPage == 17) {
	 		  this.fontRenderer.drawString("Dromonar", (newCalc2 +153), (42), 8257791, true);
	 		  this.fontRenderer.drawSplitString("Dromonar, 'The Great Warlock' is what he's known as.", newCalc2 +127, 52, 105, 0);
	 		  this.fontRenderer.drawSplitString("When he was a kid nobody ever expected a 13 year old to create a dark golem. He was apprehended for making the golem, but Atlas, The King of Atlantis, had other plans for him.", newCalc2 +127, 78, 111, 0);
	 		  this.fontRenderer.drawSplitString("The king ended up making him a wizard for Atlantis. The king needed a new way of defending the Kingdom from a ancient force that is mostly dark energy, so he asked the grandest warlock. Dromonar created the first guardian, Aegeaon.He disappeared after Dwarka's Construction.", newCalc2 +245, 40, 112, 0);
	 		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		  mc.getTextureManager().bindTexture(NPC_ICONS);
	 		  drawModalRectWithCustomSizedTexture(213, 46, 0, 29.6F, 25, 25, 89, 58);
	 	  }
	 	  else if(currPage == 18) {
	 		  this.fontRenderer.drawString("Atlas", (newCalc2 +158), (42), 6352383, true);
	 		  this.fontRenderer.drawSplitString("Atlas was the King of Atlantis until he died in battle.", newCalc2 +127, 52, 105, 0);
	 		  this.fontRenderer.drawSplitString("He died defending Atlantis from the Guardian's. When he was king he was loved by all and had a powerful trident that was so powerful it could control all water in the sea.", newCalc2 +127, 78, 111, 0);
	 		  this.fontRenderer.drawSplitString("The trident was never seen again after his death in the battle, many believe Aegeaon took the magic gem from the trident to use it as power fuel. Only a being with godlike powers could kill him, and one did, Aegeaon. He locked his most valued treasures in a vault before the attack.", newCalc2 +245, 40, 112, 0);
	 	  }
	 	  else if(currPage == 19) {
	 		  //I18n.format("If you ever need some gear he can make it, fresh out of the 'Forge and Fabricate' shop in Dwarka Village. His gear may be awesome but it's very expensive.", new Object[0])
	 		  this.fontRenderer.drawString("Tybalt", (newCalc2 +159), (42), 11875049, true);
	 		  this.fontRenderer.drawSplitString("My closest friend in Dwarka Village is definitely this guy.", newCalc2 +127, 52, 105, 0);
	 		  this.fontRenderer.drawSplitString(I18n.format("If you ever need some gear he can make it, fresh out of the 'Forge and Fabricate' shop in Dwarka Village. His gear may be awesome but it's very expensive.", new Object[0]), newCalc2 +127, 78, 111, 0);
	 		  this.fontRenderer.drawSplitString("His handy work has benefited the village for years by making weapons, tools, and armor for them. Some of his finest works are 'Gaurds Carver', 'Hatreds Bite' and 'Slice of Life'. These weapons can be purchased in his shop. He can also repair nearly anything, for a price of course.",newCalc2 + 245, 40, 112, 0);
	 		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		  mc.getTextureManager().bindTexture(NPC_ICONS);
	 		  drawModalRectWithCustomSizedTexture(newCalc2 +214, 60, 25, 31F, 25, 25, 100F, 55);
	 	  }
	 	  else if(currPage == 20) {
	 		  this.fontRenderer.drawString("Dalyns", (newCalc2 +155), (42), 3145590, true);
	 		  this.fontRenderer.drawSplitString("Dalyns is Dwarka Village's main farmer, baker, and botanist.", newCalc2 +127, 52, 105, 0);
	 		  this.fontRenderer.drawSplitString("He happened to survive the Guardian invasion like some others in Dwarka Village. This makes him an Atlantean. He is a calm guy so he should never have a problem with you.", newCalc2 +127, 88, 111, 0);
	 		  this.fontRenderer.drawSplitString("Also if you ever need food or plant supplies, come and visit his shop, 'The Sweet Spot' in Dwarka Village. He is very old and wise, he's been around since the Golden Age of Atlantis. He has breeded plants to their perfection and new species. These plants are used in his shop's food.", newCalc2 +245, 40, 112, 0);
	 		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		  mc.getTextureManager().bindTexture(NPC_ICONS);
	 		  drawModalRectWithCustomSizedTexture(newCalc2 +212, 42, 50F, 2.30F, 25, 25, 100F, 55);
	 	  }else if(currPage == 21) {
	 		  this.fontRenderer.drawString("Commander Ace", (newCalc2 +138), (42), 16768256, true);
	 		  this.fontRenderer.drawSplitString("Commander Ace, 'The Fearless' is what he's known as.", newCalc2 +127, 52, 105, 0);
	 		  this.fontRenderer.drawSplitString("Known to have no fear to anything and has taken on monsters of great magnitude. He was the best warrior and commander in Altantis. Once was the head master of Titade's Gate in Atlantis.", newCalc2 +127, 80, 111, 0);
	 		  this.fontRenderer.drawSplitString("He faught long and hard to protect the gate during the invasion, but it was too much for the gaurds. After the gate falling he left in fear for the first time. Later he met up with people in Dwarka Village guarding its gate, seeking revenge to the Guardians who killed his family.", newCalc2 +245, 40, 112, 0);
	 		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		  mc.getTextureManager().bindTexture(NPC_ICONS);
	 		  drawModalRectWithCustomSizedTexture(newCalc2 +213, 59, 74.89F, 2.30F, 25, 25, 100F, 55);
	 	  }
	 	  else if(currPage == 22) {
	 		  this.fontRenderer.drawString("Lunete", (newCalc2 +158), (42), 16742288, true);
	 		  this.fontRenderer.drawSplitString("Lunete is Dwarka Villages caretaker and animal person.", newCalc2 +127, 58, 105, 0);
	 		  this.fontRenderer.drawSplitString("Her family for many years has been taking care of children and animals. Sadly her family were visiting Atlantis on the day the Guardian invasion happened, they died. ", newCalc2 +127, 85, 105, 0);
	 		  this.fontRenderer.drawSplitString("After the fall of Atlantis, the Guardians raided local villages, she managed to escape the trouble and found Dwarka Village. She continues her family's legacy there with the pet shop, 'Bark 'n Bubbles'. The shop can sell you pets and companions to help you on your journeys.", newCalc2 +245, 40, 112, 0);
	 		  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		  mc.getTextureManager().bindTexture(NPC_ICONS);
	 		  drawModalRectWithCustomSizedTexture(newCalc2 +212, 36, 49F, 30F, 25, 25, 98.5F, 56);	  
	 	  }
	 	 else if(currPage == 23) {
	 		 this.fontRenderer.drawString("------------------", (newCalc2 +127F), (42), 000000, false);
	 		 this.fontRenderer.drawSplitString("The Lost Sea is very vast and has a plethora of different life. They're far too many creatures for me to list and to have seen them all, but I have documented many here.", newCalc2 +127, 52, 105, 0);
	 		 this.fontRenderer.drawString("------------------", (newCalc2 +127F), (148), 000000, false);
	 		 
	 		this.fontRenderer.drawString(TextFormatting.UNDERLINE + "Sea Creatures", (newCalc2 +259F), (40), 000000, false);
	 		this.fontRenderer.drawSplitString("Crustanceans: 4", newCalc2 +244, 52, 105, 00000);
	 		this.fontRenderer.drawSplitString("Fish: 5", newCalc2 +244, 115, 105, 00000);
	 		this.fontRenderer.drawSplitString("Cephalopods: 4", newCalc2 +244, 84, 105, 00000);
	 		this.fontRenderer.drawSplitString("Other: 4", newCalc2 +244, 144, 125, 00000);
	 		this.fontRenderer.drawSplitString("Note: Guardians documented in Vol. 2", newCalc2 +244, 154, 125, 00000);
	 	 }
	 	 else if(currPage == 24) {
	 		this.fontRenderer.drawString("Isopods", (newCalc2 +156F), (39), 16756385, true);
	 		
	 		//Stats
	 		this.fontRenderer.drawString(" 3-75HP ", (newCalc2 +181F), (50), 0, false);
	 		this.fontRenderer.drawString(" 0 ", (newCalc2 +181F), (62), 0, false);
	 		this.fontRenderer.drawString(" 0-25 ", (newCalc2 +181F), (75), 0, false);
	 		this.fontRenderer.drawString(" 1-3b/s ", (newCalc2 +188F), (97.5F), 0, false);
	 		this.fontRenderer.drawString(typeStringsE[0], (newCalc2 +138.3F), (97.5F), 0, false);
	 		this.fontRenderer.drawString("-------------------", (newCalc2 +124.5F), (105), 000000, true);
	 		
	 		this.fontRenderer.drawSplitString("Isopod stats go up the more they are fed. They're peaceful creatures and can be pets. Good at food collecting.", newCalc2 +124, 116, 125, 00000);
	 		this.fontRenderer.drawSplitString("These creatures seem peaceful and harmless, but of course there is a catch. These cute to some crustaceans are the lost sea's roaches, they are known to steal your favorite snacks >:(. Whatever you do, never drop food when on the ocean floor, one may just steal your food!", newCalc2 +243, 40, 115, 000000);
	 		int mousePosX = parWidth;
	 	    int mousePosY = parHeight;
	 		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		mc.getTextureManager().bindTexture(STATS);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +175, 49, 0F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 61, 10F, 0F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 74, 20F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +182, 97, 10F, 10F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +131, 96, 0F, 10F, 10, 10, 40F, 20);
	 		
//	 		int i = (this.width - this.bookImageWidth) / 2;
//	        int j = (this.height - this.bookImageHeight) / 2;
//	 		EntityTitanGuardian angler = new EntityTitanGuardian(mc.world);
//	 		GuiInventory.drawEntityOnScreen(65, 70, 25, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, angler);
	 	 }else if(currPage == 25) {
	 		this.fontRenderer.drawString("Crabs", (newCalc2 +163F), (39), 15597568, true);
	 		this.fontRenderer.drawString(" 5,12,22HP ", (newCalc2 +181F), (50), 0, false);
	 		this.fontRenderer.drawString(" 4,5,6 ", (newCalc2 +181F), (62), 0, false);
	 		this.fontRenderer.drawString(" 0,1,3 ", (newCalc2 +181F), (75), 0, false);
	 		this.fontRenderer.drawString(" 0.5-3b/s ", (newCalc2 +188F), (97.5F), 0, false);
	 		this.fontRenderer.drawString(typeStringsE[3], (newCalc2 +138.3F), (97.5F), 0, false);
	 		this.fontRenderer.drawString("-------------------", (newCalc2 +124.5F), (105), 000000, true);
	 		
	 		this.fontRenderer.drawSplitString("They're many different types of crabs in the lost sea, some are bigger and slower. Passive, some can be pets.", newCalc2 +126, 116, 115, 00000);
	 		this.fontRenderer.drawSplitString("Red, blue, spotted, so many different crabs! Can be feeding on the ocean floor or swimming peacefully. They won't try to attack you, but don't get close they will most likely give you one nice pinch. They come in many sizes so their stats can vary. Quite fast runners on the land.", newCalc2 +243, 40, 115, 000000);
	 		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		mc.getTextureManager().bindTexture(STATS);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +175, 49, 0F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 61, 10F, 0F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 74, 20F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +182, 97, 10F, 10F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +131, 96, 0F, 10F, 10, 10, 40F, 20);
	 	 }else if(currPage == 26) {
	 		this.fontRenderer.drawString("Shrimps", (newCalc2 +161F), (39), 16748106, true);
	 		
	 		this.fontRenderer.drawString(" 1-2HP ", (newCalc2 +181F), (50), 0, false);
	 		this.fontRenderer.drawString(" 0 ", (newCalc2 +181F), (62), 0, false);
	 		this.fontRenderer.drawString(" 0 ", (newCalc2 +181F), (75), 0, false);
	 		this.fontRenderer.drawString(" 0.5b/s ", (newCalc2 +188F), (97.5F), 0, false);
	 		this.fontRenderer.drawString(typeStringsE[0], (newCalc2 +138.3F), (97.5F), 0, false);
	 		this.fontRenderer.drawString("-------------------", (newCalc2 +124.5F), (105), 000000, true);
	 		
	 		this.fontRenderer.drawSplitString("These creatures come in different sizes, which can vary stats. They're also peaceful, and quite slow.", newCalc2 +126, 116, 110, 00000);
	 		this.fontRenderer.drawSplitString("Being slow and small leads to lots of predators feeding on the shrimps, mostly whales. Most of the time they come in a orange color. They feed on algae and come in large groups, you will rarely see a shrimp alone. Along with lots of animals feeding on them, they are also popular with people.", newCalc2 +243, 40, 115, 000000);

	 		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		mc.getTextureManager().bindTexture(STATS);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +175, 49, 0F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 61, 10F, 0F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 74, 20F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +182, 97, 10F, 10F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +131, 96, 0F, 10F, 10, 10, 40F, 20);
	 		
	 	 }else if(currPage == 27) {
	 		this.fontRenderer.drawString("Lobsters", (newCalc2 +156F), (39), 10424320, true);
	 		
	 		this.fontRenderer.drawString(" 10,25HP ", (newCalc2 +181F), (50), 0, false);
	 		this.fontRenderer.drawString(" 6,9 ", (newCalc2 +181F), (62), 0, false);
	 		this.fontRenderer.drawString(" 3,5 ", (newCalc2 +181F), (75), 0, false);
	 		this.fontRenderer.drawString(" 0.7-1b/s ", (newCalc2 +188F), (97.5F), 0, false);
	 		this.fontRenderer.drawString(typeStringsE[3], (newCalc2 +138.3F), (97.5F), 0, false);
	 		this.fontRenderer.drawString("-------------------", (newCalc2 +124.5F), (105), 000000, true);
	 		
	 		this.fontRenderer.drawSplitString("There are 2 types of lobster. 1 type is passive, the other is aggresive. They're quite slow creatures.", newCalc2 +126, 116, 115, 00000);
	 		this.fontRenderer.drawSplitString("Lobsters like shrimp are a popular food choice in the Lost Sea. Similar to the crabs they will not try to hurt you, but don't get close because they will sure pinch you, except unlike the crabs, this pinch hurts a lot more. Most of the time they're red, but rarely come in blue or orange.",newCalc2 + 243, 40, 115, 000000);

	 		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		mc.getTextureManager().bindTexture(STATS);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +175, 49, 0F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 61, 10F, 0F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 74, 20F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +182, 97, 10F, 10F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +131, 96, 0F, 10F, 10, 10, 40F, 20);
	 	 }else if(currPage == 28) {	
	 		this.fontRenderer.drawString("Sunfish", (newCalc2 +161F), (39), 12690079, true);
	 		
	 		this.fontRenderer.drawString(" 35HP ", (newCalc2 +181F), (50), 0, false);
	 		this.fontRenderer.drawString(" 0 ", (newCalc2 +181F), (62), 0, false);
	 		this.fontRenderer.drawString(" 0 ", (newCalc2 +181F), (75), 0, false);
	 		this.fontRenderer.drawString(" 1.3b/s ", (newCalc2 +188F), (97.5F), 0, false);
	 		this.fontRenderer.drawString(typeStringsE[0], (newCalc2 +138.3F), (97.5F), 0, false);
	 		this.fontRenderer.drawString("-------------------", (newCalc2 +124.5F), (105), 000000, true);
	 		
	 		this.fontRenderer.drawSplitString("The sunfish can come in 2 colors, brown, and gray. Peaceful mobs and move gracefully through waters near the surface.", newCalc2 +126, 113, 110, 00000);
	 		this.fontRenderer.drawSplitString("They're called sunfish for their shape and that they are usually found swimming near openings to the surface that the sun shines through. Usually move slowly and gracefully through the water, feeding on fish and shrimp near the surface. Also they're pretty big and travel alone most of the time.", newCalc2 +243, 40, 115, 000000);
	 		
	 		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		mc.getTextureManager().bindTexture(STATS);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +175, 49, 0F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 61, 10F, 0F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 74, 20F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +182, 97, 10F, 10F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +131, 96, 0F, 10F, 10, 10, 40F, 20);
	 	 }else if(currPage == 29) {	
	 		this.fontRenderer.drawString("Barracuda", (newCalc2 +153F), (39), 13836578, true);
	 		
	 		this.fontRenderer.drawString(" 30HP ", (newCalc2 +181F), (50), 0, false);
	 		this.fontRenderer.drawString(" 9 ", (newCalc2 +181F), (62), 0, false);
	 		this.fontRenderer.drawString(" 0 ", (newCalc2 +181F), (75), 0, false);
	 		this.fontRenderer.drawString(" 6.4b/s ", (newCalc2 +188F), (97.5F), 0, false);
	 		this.fontRenderer.drawString(typeStringsE[2], (newCalc2 +138.3F), (97.5F), 0, false);
	 		this.fontRenderer.drawString("-------------------", (newCalc2 +124.5F), (105), 000000, true);
	 		
	 		this.fontRenderer.drawSplitString("Barracudas are fearsome fish, they are hostile. Can be found in dark areas and 'The Great Trench'.", newCalc2 +126, 116, 107, 00000);
	 		this.fontRenderer.drawSplitString("You can find barracudas swimming in dark areas near the edges of coral reefs, but they are most common the 'The Great Trench'. I once saw one feeding on fish at the edge of a coral reef. Be careful, barracudas are known to take no hesitation to charge after you hastily and kill you.", newCalc2 +243, 40, 115, 000000);
	 		
	 		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		mc.getTextureManager().bindTexture(STATS);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +175, 49, 0F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 61, 10F, 0F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 74, 20F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +182, 97, 10F, 10F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +131, 96, 0F, 10F, 10, 10, 40F, 20);
	 	 }else if(currPage == 30) {	
	 		this.fontRenderer.drawString("Anglerfish", (newCalc2 +153F), (39), 65506, true);
	 		
	 		this.fontRenderer.drawString(" 13HP ", (newCalc2 +181F), (50), 0, false);
	 		this.fontRenderer.drawString(" 4 ", (newCalc2 +181F), (62), 0, false);
	 		this.fontRenderer.drawString(" 1.65 ", (newCalc2 +181F), (75), 0, false);
	 		this.fontRenderer.drawString(" 1.75b/s ", (newCalc2 +188F), (97.5F), 0, false);
	 		this.fontRenderer.drawString(typeStringsE[2], (newCalc2 +138.3F), (97.5F), 0, false);
	 		this.fontRenderer.drawString("-------------------", (newCalc2 +124.5F), (104), 000000, true);
	 		
	 		this.fontRenderer.drawSplitString("The Anglerfish are small fish who're passive to players, but the opposite to smaller fish. Found only in 'The Great Trench'.", newCalc2 +126, 113, 107, 00000);
	 		this.fontRenderer.drawSplitString("Sometimes anglerfish can be found around the hole that descends into 'The Great Trench', although they're mostly found deeper into the trench. Anglerfish use their light that hangs from their head to lure in other fish to eat them. Anglerfish rely on the light as a main hunting method.", newCalc2 +243, 40, 115, 000000);
	 		
	 		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		mc.getTextureManager().bindTexture(STATS);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +175, 49, 0F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 61, 10F, 0F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 74, 20F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +182, 97, 10F, 10F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +131, 96, 0F, 10F, 10, 10, 40F, 20);
	 		
	 		int i = (this.width - this.bookImageWidth) / 2;
	        int j = (this.height - this.bookImageHeight) / 2;
	 		EntityAnglerfish angler = new EntityAnglerfish(mc.world);
	 		angler.isFlipped = flip;
	 		GuiInventory.drawEntityOnScreen(150, 78, 30 + Scale, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, angler);
	 	 }
	 	else if(currPage == 31) {	
	 		this.fontRenderer.drawString("Eels", (newCalc2 +167F), (39), 9520896, true);
	 		
	 		this.fontRenderer.drawString(" 22,35HP ", (newCalc2 +181F), (50), 0, false);
	 		this.fontRenderer.drawString(" 5,8", (newCalc2 +181F), (62), 0, false);
	 		this.fontRenderer.drawString(" 0 ", (newCalc2 +181F), (75), 0, false);
	 		this.fontRenderer.drawString(" 1,2b/s ", (newCalc2 +188F), (97.5F), 0, false);
	 		this.fontRenderer.drawString(" Normal-", (newCalc2 +138.3F), (97.5F), 0, false);
	 		this.fontRenderer.drawString(typeStringsE[4], (newCalc2 +138.3F), (105.5F), 0, false);
	 		this.fontRenderer.drawString("-------------------", (newCalc2 +124.5F), (112), 000000, true);
	 		
	 		this.fontRenderer.drawSplitString("Slippery slimy Eels, they're 2 types of eels, the eel, and the Electric Eel. That can be found hiding in coral reef rocks.", newCalc2 +126, 119, 107, 00000);
	 		this.fontRenderer.drawSplitString("Normal eels are known to not attack people, but their evil cousin the Electric Eel does. Eels hide in rocks waiting for fish to come for them to eat. Electric Eels, surprisingly enough, are actually electric and have been known to paralize people. Watch out for electric eels in reefs.", newCalc2 +243, 40, 115, 000000);
	 		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		mc.getTextureManager().bindTexture(STATS);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +175, 49, 0F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 61, 10F, 0F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 74, 20F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +182, 97, 10F, 10F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +131, 96, 0F, 10F, 10, 10, 40F, 20);
	 	 }
	 	else if(currPage == 32) {	
	 		this.fontRenderer.drawString("Creeper fish", (newCalc2 +150F), (39), 3849216, true);
	 		
	 		this.fontRenderer.drawString(" 18HP ", (newCalc2 +181F), (50), 0, false);
	 		this.fontRenderer.drawString(" 1-12*", (newCalc2 +181F), (62), 0, false);
	 		this.fontRenderer.drawString(" 0 ", (newCalc2 +181F), (75), 0, false);
	 		this.fontRenderer.drawString(" 0-1.2b/s ", (newCalc2 +188F), (97.5F), 0, false);
	 		this.fontRenderer.drawString(" Normal ", (newCalc2 +138.3F), (97.5F), 0, false);
	 		this.fontRenderer.drawString("-------------------", (newCalc2 +124.5F), (105), 000000, true);
	 		
			this.fontRenderer.drawSplitString("Even water creepers you say? Well kinda in a way, these kinds of creepers are much slower and when you get close will puff...",newCalc2 + 126, 113, 107, 00000);
	 		this.fontRenderer.drawSplitString("up and begin to float upwards, then KABOOM! They're a little weaker than normal creepers. One time I saw one explode, it was hilarious, imagine a fat green fish that puffs into an obese living navalmine. Of course like creepers, are hostile and blow your bases up. You thought you'd be safe from creepers in the sea.", newCalc2 +243, 40, 115, 000000);
	 		
	 		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		mc.getTextureManager().bindTexture(STATS);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +175, 49, 0F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 61, 10F, 0F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 74, 20F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +182, 97, 10F, 10F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +131, 96, 0F, 10F, 10, 10, 40F, 20);
	 	 }
	 	else if(currPage == 33) {	
	 		this.fontRenderer.drawString("Octopus", (newCalc2 +158F), (39), 11241826, true);
	 		
	 		this.fontRenderer.drawString(" 16HP ", (newCalc2 +181F), (50), 0, false);
	 		this.fontRenderer.drawString(" 0,6 ", (newCalc2 +181F), (62), 0, false);
	 		this.fontRenderer.drawString(" 0 ", (newCalc2 +181F), (75), 0, false);
	 		this.fontRenderer.drawString(" 2-4b/s ", (newCalc2 +188F), (97.5F), 0, false);
	 		this.fontRenderer.drawString(" Normal,", (newCalc2 +138.3F), (97.5F), 0, false);
	 		this.fontRenderer.drawString(typeStringsE[6], (newCalc2 +138.3F), (105.5F), 0, false);
	 		this.fontRenderer.drawString("-------------------", (newCalc2+124.5F), (112), 000000, true);
	 		
	 		this.fontRenderer.drawSplitString("Octopuses, the cousin of the squids and cuttlefish. They're 2 types of octopuses, the normal octopus and..", newCalc2 +126, 119, 107, 00000);
	 		this.fontRenderer.drawSplitString("the Venom Octopus. Normal octopuses will not harm you and are peaceful, on the other hand, Venom Octo will be aggresive and will grab you, inflicting a slowing venom. Normal octopuses are known to be able to pretend to look like other animals. Octopuses remain slow, but can speed up for a short time.", newCalc2 +243, 40, 115, 000000);
	 		
	 		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		mc.getTextureManager().bindTexture(STATS);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +175, 49, 0F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 61, 10F, 0F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 74, 20F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +182, 97, 10F, 10F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +131, 96, 0F, 10F, 10, 10, 40F, 20);
	 	 }
	 	else if(currPage == 34) {	
	 		this.fontRenderer.drawString("Cuttlefish", (newCalc2 +155F), (39), 11241869, true);
	 		
	 		this.fontRenderer.drawString(" 13HP ", (newCalc2 +181F), (50), 0, false);
	 		this.fontRenderer.drawString(" 0 ", (newCalc2 +181F), (62), 0, false);
	 		this.fontRenderer.drawString(" 0 ", (newCalc2 +181F), (75), 0, false);
	 		this.fontRenderer.drawString(" 1-1.8b/s ", (newCalc2 +188F), (97.5F), 0, false);
	 		this.fontRenderer.drawString(" Normal,", (newCalc2 +138.3F), (97.5F), 0, false);
	 		this.fontRenderer.drawString(typeStringsE[6], (newCalc2 +138.3F), (105.5F), 0, false);
	 		this.fontRenderer.drawString("-------------------", (newCalc2 +124.5F), (112), 000000, true);
	 		
	 		this.fontRenderer.drawSplitString("The cuttlefish are known for their cute look and ability to change their color. If you like cuttlin', they can be pets.", newCalc2 +126, 119, 107, 00000);
	 		this.fontRenderer.drawSplitString("Will often move slowly and gracefully through the ocean, especially near edges of coral reefs. Not very powerful at all, but their cool abilities are that they're poisonious to consume, their greatest boon of all though would have to be that they can change their skin color and look psychedelic. ",newCalc2 + 243, 40, 115, 000000);
	 		
	 		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		mc.getTextureManager().bindTexture(STATS);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +175, 49, 0F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 61, 10F, 0F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 74, 20F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +182, 97, 10F, 10F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +131, 96, 0F, 10F, 10, 10, 40F, 20);
	 	 }
	 	else if(currPage == 35) {	
	 		this.fontRenderer.drawString("Vampire Squid", (newCalc2 +147.5F), (39), 3093247, true);
	 		
	 		this.fontRenderer.drawString(" 20HP ", (newCalc2 +181F), (50), 0, false);
	 		this.fontRenderer.drawString(" 14 ", (newCalc2 +181F), (62), 0, false);
	 		this.fontRenderer.drawString(" 0 ", (newCalc2 +181F), (75), 0, false);
	 		this.fontRenderer.drawString(" 0.5b/s ", (newCalc2 +188F), (97.5F), 0, false);
	 		this.fontRenderer.drawString(typeStringsE[2], (newCalc2 +138.3F), (97.5F), 0, false);
	 		this.fontRenderer.drawString("-------------------", (newCalc2 +124.5F), (105), 000000, true);
	 		
	 		this.fontRenderer.drawSplitString("The blood-sucking squid with 4 jaws and a huge tongue, the Vampire Squid. This squid is very hostile towards squids and people.", newCalc2 +126, 112, 107, 00000);
	 		this.fontRenderer.drawSplitString("This species of squid can only be found deep in 'The Great Trench', you may think your safe then, but it's known that it can pull fish and people deep into the trench to drown and eat. It pulls in pray with it's tongue nearly 5x it's own body length! Luckily it's pretty slow, a few sword hits should do the trick.", newCalc2 +243, 40, 115, 000000);
	 		
	 		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		mc.getTextureManager().bindTexture(STATS);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +175, 49, 0F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 61, 10F, 0F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 74, 20F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +182, 97, 10F, 10F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +131, 96, 0F, 10F, 10, 10, 40F, 20);
	 		
	 		int i = (this.width - this.bookImageWidth) / 2;
	        int j = (this.height - this.bookImageHeight) / 2;
	 		EntityVampireSquid angler = new EntityVampireSquid(mc.world);
	 		angler.isFlipped = flip;
	 		GuiInventory.drawEntityOnScreen(newCalc2 +150, 76, 18 + Scale, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, angler);
	 	 }else if(currPage == 36) {	
		 		this.fontRenderer.drawString("Nautilus", (newCalc2 +156F), (39), 9080575, true);
		 		
		 		this.fontRenderer.drawSplitString("The Nautilus is an interesting looking creature, its a type of mollusk that's related to Squids, Octopuses, and Cuttlefish. ", newCalc2 +126, 112, 107, 00000);
		 		this.fontRenderer.drawSplitString("It looks like a little snail hiding in a shell that floats in a sort of drowsy motion. It's little tentacles at the front are used to capture prey. They're peaceful mobs that mostly feed on small fishes, crabs, and shrimps. If you like nautiluses they can be baught as pets in Dwarka Village.", newCalc2 +243, 40, 115, 000000);
		 		
		 		this.fontRenderer.drawString(" 12HP ", (newCalc2 +181F), (50), 0, false);
		 		this.fontRenderer.drawString(" 0 ", (newCalc2 +181F), (62), 0, false);
		 		this.fontRenderer.drawString(" 2 ", (newCalc2 +181F), (75), 0, false);
		 		this.fontRenderer.drawString(" 0.8b/s ", (newCalc2 +188F), (97.5F), 0, false);
		 		this.fontRenderer.drawString(typeStringsE[0], (newCalc2 +138.3F), (97.5F), 0, false);
		 		this.fontRenderer.drawString("-------------------", (newCalc2 +124.5F), (105), 000000, true);
		 		
		 		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		 		mc.getTextureManager().bindTexture(STATS);
		 		drawModalRectWithCustomSizedTexture(newCalc2 +175, 49, 0F, 1F, 10, 10, 40F, 22);
		 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 61, 10F, 0F, 10, 10, 40F, 20);
		 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 74, 20F, 1F, 10, 10, 40F, 22);
		 		drawModalRectWithCustomSizedTexture(newCalc2 +182, 97, 10F, 10F, 10, 10, 40F, 20);
		 		drawModalRectWithCustomSizedTexture(newCalc2 +131, 96, 0F, 10F, 10, 10, 40F, 20);
	 	 }else if(currPage == 37) {	
	 		this.fontRenderer.drawString("Starfish", (newCalc2 +156F), (39), 16760575, true);
	 		
	 		this.fontRenderer.drawString(" 4-9HP ", (newCalc2 +181F), (50), 0, false);
	 		this.fontRenderer.drawString(" 0 ", (newCalc2 +181F), (62), 0, false);
	 		this.fontRenderer.drawString(" 0 ", (newCalc2 +181F), (75), 0, false);
	 		this.fontRenderer.drawString(" 0-0.1b/s ", (newCalc2 +188F), (97.5F), 0, false);
	 		this.fontRenderer.drawString(" Normal-", (newCalc2 +138.3F), (97.5F), 0, false);
	 		this.fontRenderer.drawString(typeStringsE[6], (newCalc2 +138.3F), (105.5F), 0, false);
	 		this.fontRenderer.drawString("-------------------", (newCalc2 +124.5F), (112), 000000, true);
	 		
	 		this.fontRenderer.drawSplitString("The six legged echinoderm, well only for one species. There's two types of these, Starfish, and the Thorn Star.", newCalc2 +126, 119, 110, 00000);
	 		this.fontRenderer.drawSplitString("Thorn starfish have 8 legs along with protruding spikes that are venomous to the touch. Both species are peaceful, just don't touch the Thorn Star. Both specimens are known to barely move, but can travel over long periods of time. They often graze out on rocks in reefs feeding on shelled creatures.", newCalc2 +243, 40, 115, 000000);
	 		
	 		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		mc.getTextureManager().bindTexture(STATS);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +175, 49, 0F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 61, 10F, 0F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 74, 20F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +182, 97, 10F, 10F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +131, 96, 0F, 10F, 10, 10, 40F, 20);
	 	 }else if(currPage == 38) {	
		 	this.fontRenderer.drawString("Barnacles", (newCalc2 +152F), (39), 23738, true);
		 	
		 	this.fontRenderer.drawString(" 1HP ", (newCalc2 +181F), (50), 0, false);
	 		this.fontRenderer.drawString(" 0 ", (newCalc2 +181F), (62), 0, false);
	 		this.fontRenderer.drawString(" 2 ", (newCalc2 +181F), (75), 0, false);
	 		this.fontRenderer.drawString(" 0b/s ", (newCalc2 +188F), (97.5F), 0, false);
	 		this.fontRenderer.drawString(typeStringsE[0], (newCalc2 +138.3F), (97.5F), 0, false);
	 		this.fontRenderer.drawString("-------------------", (newCalc2 +124.5F), (105), 000000, true);
	 		
	 		this.fontRenderer.drawSplitString("Barnacles are tiny stud shaped creatures that can get very aggravating due to them growing on nearly any block.", newCalc2 +126, 112, 107, 00000);
	 		this.fontRenderer.drawSplitString("Luckily they can only spread by breeding and growing onto the block next to them. One time they began to grow on my house so I cut them off with just a few sword swipes. They're practically immobilized and cannot hurt you in any way, they mostly feed on microbes and plankton.",newCalc2 + 243, 40, 115, 000000);
		 	
	 		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		mc.getTextureManager().bindTexture(STATS);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +175, 49, 0F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 61, 10F, 0F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 74, 20F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +182, 97, 10F, 10F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +131, 96, 0F, 10F, 10, 10, 40F, 20);
		 }else if(currPage == 39) {	
			this.fontRenderer.drawString("Pirates", (newCalc2 +158F), (39), 11591616, true);
			this.fontRenderer.drawString(" 20HP ", (newCalc2 +181F), (50), 0, false);
		 	this.fontRenderer.drawString(" 7 ", (newCalc2 +181F), (62), 0, false);
		 	this.fontRenderer.drawString(" 3 ", (newCalc2 +181F), (75), 0, false);
		 	this.fontRenderer.drawString(" 4.5b/s ", (newCalc2 +188F), (97.5F), 0, false);
		 	this.fontRenderer.drawString(" Normal-", (newCalc2 +138.3F), (97.5F), 0, false);
	 		this.fontRenderer.drawString(typeStringsE[7], (newCalc2 +138.3F), (105.5F), 0, false);
	 		this.fontRenderer.drawString("-------------------", (newCalc2 +124.5F), (112), 000000, true);
		 		
	 		this.fontRenderer.drawSplitString("\"Arr matey\", Is one of their famous quotes often used by local pirates. The pirates that are home to pirate cove are..", newCalc2 +126, 119, 110, 00000);
	 		this.fontRenderer.drawSplitString("led by a crazy intoxicated man only known as, Cap'n Swashblocker. Pirates are often only nice to their \"mates\" and hijack enemy ships to loot them. Ghost pirates are similar with the exception that they live on 'Skull Island'. If you ever meet the pirates on Pirate Cove make sure to join their crew!", newCalc2 +243, 40, 115, 000000);
			 
	 		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		mc.getTextureManager().bindTexture(STATS);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +175, 49, 0F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 61, 10F, 0F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 74, 20F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +182, 97, 10F, 10F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +131, 96, 0F, 10F, 10, 10, 40F, 20);
		 }else if(currPage == 40) {	
			 this.fontRenderer.drawString("Sharks", (newCalc2 +158F), (39), 11583936, true);
				 		
			 this.fontRenderer.drawString(" 45,50HP ", (newCalc2 +181F), (50), 0, false);
		 	 this.fontRenderer.drawString(" 12 ", (newCalc2 +181F), (62), 0, false);
		 	 this.fontRenderer.drawString(" 0 ", (newCalc2 +181F), (75), 0, false);
		 	 this.fontRenderer.drawString(" 5b/s ", (newCalc2 +188F), (97.5F), 0, false);
		 	this.fontRenderer.drawString(" Normal-", (newCalc2 +138.3F), (97.5F), 0, false);
	 		this.fontRenderer.drawString(typeStringsE[2], (newCalc2 +138.3F), (105.5F), 0, false);
	 		this.fontRenderer.drawString("-------------------", (newCalc2 +124.5F), (112), 000000, true);
	 		
	 		this.fontRenderer.drawSplitString("Ever seen a Dolphin? Well make sure to not get these confused, they can be vicious when its hungry, but only to sea life.", newCalc2 +126, 119, 110, 00000);
	 		this.fontRenderer.drawSplitString("Sharks are adept hunters, luckily though they're passive to humans, but that doesn't mean you can hit them. Normal sharks are not vicious, but Zombie Sharks will be out to get ya'. Sharks are usually found near edges of coral reefs and sometimes out in the open ocean. ", newCalc2 +243, 40, 115, 000000);
			
	 		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		mc.getTextureManager().bindTexture(STATS);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +175, 49, 0F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 61, 10F, 0F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 74, 20F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +182, 97, 10F, 10F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +131, 96, 0F, 10F, 10, 10, 40F, 20);
			
			int i = (this.width - this.bookImageWidth) / 2;
	        int j = (this.height - this.bookImageHeight) / 2;
	 		EntityShark angler = new EntityShark(mc.world);
	 		GuiInventory.drawEntityOnScreen(newCalc2 +150, 76, 18 + Scale, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, angler);
		 }else if(currPage == 41) {	
			this.fontRenderer.drawString("Sirens", (newCalc2 +158F), (39), 9090047, true);
		 		
			this.fontRenderer.drawString(" 35HP ", (newCalc2 +181F), (50), 0, false);
		 	this.fontRenderer.drawString(" 9 ", (newCalc2 +181F), (62), 0, false);
		 	this.fontRenderer.drawString(" 5 ", (newCalc2 +181F), (75), 0, false);
		 	this.fontRenderer.drawString(" 2b/s ", (newCalc2 +188F), (97.5F), 0, false);
		 	this.fontRenderer.drawString(" Water,", (newCalc2 +138.3F), (97.5F), 3093247, false);
	 		this.fontRenderer.drawString(typeStringsE[2], (newCalc2 +138.3F), (105.5F), 0, false);
	 		this.fontRenderer.drawString("-------------------", (newCalc2 +124.5F), (112), 000000, true);
	 		
	 		this.fontRenderer.drawSplitString("\"The song singers of death\", is what their often called by Sailors and Pirates. That saying comes..", newCalc2 +126, 119, 110, 00000);
	 		this.fontRenderer.drawSplitString("from the tales of them luring sailors to their death by making them crash ships into shores. They're hostile towards nearly anything that dares to get near their cave, that includes Humans. Not much info is known about the sirens because many say that, \"Once you hear the song, your probably dead..\".", newCalc2 +243, 40, 115, 000000);
			
	 		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		mc.getTextureManager().bindTexture(STATS);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +175, 49, 0F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 61, 10F, 0F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +174, 74, 20F, 1F, 10, 10, 40F, 22);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +182, 97, 10F, 10F, 10, 10, 40F, 20);
	 		drawModalRectWithCustomSizedTexture(newCalc2 +131, 96, 0F, 10F, 10, 10, 40F, 20);
		 } else if(currPage == 42) {
			this.fontRenderer.drawString("------------------", (newCalc2 +127F), (42), 000000, false);
	 		this.fontRenderer.drawSplitString("Now that basic creatures have been discussed I want to tell the tales of other creatures. Be warned because the creatures in this chapter are the baddest of the bad, one could even call them, \"bosses\".", newCalc2 +127, 52, 105, 0);
	 		this.fontRenderer.drawString("------------------", (newCalc2 +127F), (150), 000000, false);
	 		
	 		this.fontRenderer.drawSplitString(TextFormatting.UNDERLINE + "Boss List", newCalc2 +275, 42, 116, 11141120);
	 		this.fontRenderer.drawSplitString("Aegaeon: The Eldest One", newCalc2 +245, 54, 110, 3134975);
	 		this.fontRenderer.drawSplitString("The Rainbow Serpents", newCalc2 +245, 72, 110, 3125916);
	 		this.fontRenderer.drawSplitString("Raidne: The Death Singer", newCalc2 +245, 82, 110, 3093094);
	 		this.fontRenderer.drawSplitString("Tasma: The Greedy", newCalc2 +245, 101, 112, 13513216);
	 		this.fontRenderer.drawSplitString("Captain Blackeye", newCalc2 +245, 110, 110, 3133599);
	 		this.fontRenderer.drawSplitString("The Kraken", newCalc2 +245, 128, 110, 3093241);
	 		this.fontRenderer.drawSplitString("The Brine Beast", newCalc2 +245, 119, 110, 3132203);
	 		this.fontRenderer.drawSplitString("The Gorgons", newCalc2 +245, 137, 110, 7680817);
	 		this.fontRenderer.drawSplitString("The Reef Eater", newCalc2 +245, 146, 110, 13389639);
	 		this.fontRenderer.drawSplitString("The Great Graboid", newCalc2 +245, 155, 110, 12161943);
		 } else if(currPage == 43) {
		 	 this.fontRenderer.drawString("Aegaeon: The Eldest", newCalc2 +127, 39, 3134975, true);
		 	 this.fontRenderer.drawString("One", newCalc2 +127, 48, 3134975, true);
		 	 
		 	this.fontRenderer.drawString(" ? ", (newCalc2 +136F), (125), 0, false);
		 	this.fontRenderer.drawString(" ? ", (newCalc2 +137F), (137), 0, false);
		 	this.fontRenderer.drawString(" 0-∞ ", (newCalc2 +137F), (149), 0, false);
		 	this.fontRenderer.drawString(" 0-5b/s ", (newCalc2 +137F), (161F), 0, false);
			this.fontRenderer.drawString("------------------", (newCalc2 +245F), (65), 000000, false);
			this.fontRenderer.drawString(" Water, ", (newCalc2 +250), (41F), 3093247, false);
			this.fontRenderer.drawString(TextFormatting.DARK_PURPLE + " Dark ", (newCalc2 +283), (41F), 0, false);
			this.fontRenderer.drawString(" Difficulty: ", (newCalc2 +241), (55F), 0, false);
			this.fontRenderer.drawString(" Veteran ", (newCalc2 +292), (55F), 7667951, true);
			
	 		this.fontRenderer.drawSplitString("Aegaeon, \"The Eldest One\", is what he is known by to nearly all in the sea. He get's the term, \"The Eldest One\" from him being the first ever guardian to be created, making him the 'eldest guardian'. ....", newCalc2 +244, 72, 110, 0);
			
		 	
		 	 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		 	 mc.getTextureManager().bindTexture(STATS);
		 	 drawModalRectWithCustomSizedTexture(newCalc2 +130, 124, 0F, 1F, 10, 10, 40F, 22);
		 	 drawModalRectWithCustomSizedTexture(newCalc2 +130, 136, 10F, 0F, 10, 10, 40F, 20);
		 	 drawModalRectWithCustomSizedTexture(newCalc2 +130, 148, 20F, 1F, 10, 10, 40F, 22);
			 drawModalRectWithCustomSizedTexture(newCalc2 +130, 160, 10F, 10F, 10, 10, 40F, 20);
			 drawModalRectWithCustomSizedTexture(newCalc2 +243, 40, 0F, 10F, 10, 10, 40F, 20);
		 }else if(currPage == 44) {
		 	this.fontRenderer.drawString("Aegaeon continued", newCalc2 +129, 39, 3134975, true);
		 	this.fontRenderer.drawSplitString("Guardians get more powerful over time as you may know. Aegaeon is very old, some even believe that he's over 10,000 years old! Being so old grants him unimaginable powers, such as his ability to bend other Guardians to his will. He is so powerful in fact that many call..", newCalc2 +127, 49, 105, 0);
		 	this.fontRenderer.drawSplitString("him a god. He resides deep in Atlantis laying on his throne in Aegaeon Tower. The only one who can even stand a chance against him is Atlas and even he fell to Aegaeon's dark arts. Many hate him for invading Atlantis and many are waiting for a 'God Slayer' to come and liberate Atlantis.", newCalc2 +243, 40, 110, 0);
		 }else if(currPage == 45) {
		 	this.fontRenderer.drawString("The Rainbow Serpents", newCalc2 +126, 39, 3125916, true);
		 	 
		 	this.fontRenderer.drawString(" ? ", (newCalc2 +136F), (125), 0, false);
		 	this.fontRenderer.drawString(" ? ", (newCalc2 +137F), (137), 0, false);
		 	this.fontRenderer.drawString(" Element Guarded ", (newCalc2 +137F), (149), 0, false);
		 	this.fontRenderer.drawString(" 0-7b/s ", (newCalc2 +137F), (161F), 0, false);
			this.fontRenderer.drawString("------------------", (newCalc2 +245F), (65), 000000, false);
			this.fontRenderer.drawString(" Omni-type ", (newCalc2 +250), (41F), 9408141, false);
			this.fontRenderer.drawString(" Difficulty: ", (newCalc2 +241), (55F), 0, false);
			this.fontRenderer.drawString(" Hard ", (newCalc2 +292), (55F), 12189696, true);
			
	 		this.fontRenderer.drawSplitString("\"The lustrous serpents of the sea\", 'The Rainbow Serpents'. You may be thinking, Serpents? Well they're slender snakes that are usually magical in some way and yes they're is 2 rainbow serpents. Truth be..", newCalc2 +244, 72, 114, 0);
			
		 	
		 	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		 	mc.getTextureManager().bindTexture(STATS);
		 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 124, 0F, 1F, 10, 10, 40F, 22);
		 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 136, 10F, 0F, 10, 10, 40F, 20);
		 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 148, 20F, 1F, 10, 10, 40F, 22);
			drawModalRectWithCustomSizedTexture(newCalc2 +130, 160, 10F, 10F, 10, 10, 40F, 20);
			drawModalRectWithCustomSizedTexture(newCalc2 +243, 40, 0F, 10F, 10, 10, 40F, 20);
		 }else if(currPage == 46) {
			 	this.fontRenderer.drawString("R-Serpents continued", newCalc2 +127, 39, 3125916, true);
			 	this.fontRenderer.drawSplitString("told they're actually rainbow, each serpent has half of a rainbows colors on their side scales. The serpents live in the 'King's Garden' sleeping in their cave. They we're once used in Atlantis to heal and extend peoples lives, but only when they're fed they'll heal you.", newCalc2 +126, 49, 105, 0);
			 	this.fontRenderer.drawSplitString("On the contrary, if they're not fed they do the opposite to people, they will consume their life force. Ever since Aegaeon took over Atlantis, he has not fed the serpents one bit. Their immune to all attacks except for the element bound to the rainbows on their sides.", newCalc2 +243, 40, 110, 0);
		 
		 }else if(currPage == 47) {
			    this.fontRenderer.drawString("Raidne: The Death", newCalc2 +126, 39, 3093210, true);
			 	 this.fontRenderer.drawString("Singer", newCalc2 +126, 48, 3093210, true);
			 	this.fontRenderer.drawString(" 565HP ", (newCalc2 +136F), (125), 0, false);
			 	this.fontRenderer.drawString(" ? ", (newCalc2 +137F), (137), 0, false);
			 	this.fontRenderer.drawString(" 15 ", (newCalc2 +137F), (149), 0, false);
			 	this.fontRenderer.drawString(" 0-6b/s ", (newCalc2 +137F), (161F), 0, false);
				this.fontRenderer.drawString("------------------", (newCalc2 +245F), (65), 000000, false);
				this.fontRenderer.drawString(" Water, ", (newCalc2 +250), (41F), 3093247, false);
				this.fontRenderer.drawString(TextFormatting.DARK_PURPLE + " Dark ", (newCalc2 +283), (41F), 0, false);
				this.fontRenderer.drawString(" Difficulty: ", (newCalc2 +241), (55F), 0, false);
				this.fontRenderer.drawString(" Normal ", (newCalc2 +292), (55F), 16776960, true);
				
		 		this.fontRenderer.drawSplitString("\"It is she who sings the song of death\", Raidne: 'The Death Singer' is the queen of the Sirens in 'Siren Cave'. She's called 'The Death Singer' for a good reason, her song is known to lead all that hear it..", newCalc2 +244, 72, 110, 0);

				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			 	mc.getTextureManager().bindTexture(STATS);
			 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 124, 0F, 1F, 10, 10, 40F, 22);
			 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 136, 10F, 0F, 10, 10, 40F, 20);
			 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 148, 20F, 1F, 10, 10, 40F, 22);
				drawModalRectWithCustomSizedTexture(newCalc2 +130, 160, 10F, 10F, 10, 10, 40F, 20);
				drawModalRectWithCustomSizedTexture(newCalc2 +243, 40, 0F, 10F, 10, 10, 40F, 20);
		 }else if(currPage == 48) {
			 this.fontRenderer.drawString("Raidne continued", newCalc2 +134, 39, 3093210, true);
			 	this.fontRenderer.drawSplitString("to their demise in her cave. She has a shell tied around her neck and that legend has it, the shell can call upon other sirens to your aid. Some have searched for the shell; most end up dead or barely making it out alive. Swashblocker told me one time, \"Me", newCalc2 +126, 49, 105, 0);
			 	this.fontRenderer.drawSplitString("crew once we be testin' out our newest Man-O-War 'n then them damn Sirens led me crew t' death! I know so!\" If you want to be Swashblocker's first mate, getting that shell would make him like you. I once sailed my ship near the cave and heard singing, I sailed away instantly.", newCalc2 +243, 40, 110, 0);
		 }else if(currPage == 49) {
			this.fontRenderer.drawString("Tasma: The Greedy", newCalc2 +130, 39, 13513216, true);
		 	this.fontRenderer.drawString(" 1250HP ", (newCalc2 +136F), (125), 0, false);
		 	this.fontRenderer.drawString(" ? ", (newCalc2 +137F), (137), 0, false);
		 	this.fontRenderer.drawString(" 50 ", (newCalc2 +137F), (149), 0, false);
		 	this.fontRenderer.drawString(" 0-2b/s ", (newCalc2 +137F), (161F), 0, false);
			this.fontRenderer.drawString("------------------", (newCalc2 +245F), (65), 000000, false);
			this.fontRenderer.drawString(typeStringsE[3] + ",", (newCalc2 +250), (41F), 3093247, false);
			this.fontRenderer.drawString(TextFormatting.DARK_PURPLE + " Dark ", (newCalc2 +294), (41F), 0, false);
			this.fontRenderer.drawString(" Difficulty: ", (newCalc2 +241), (55F), 0, false);
			this.fontRenderer.drawString(" Normal ", (newCalc2 +292), (55F), 16776960, true);
			
	 		this.fontRenderer.drawSplitString("Well well, if it isn't the wealthiest crab in the whole sea, Tasma. Tasma is known to be very rich and quite intelligent compared to your average crab. He hides deep in 'The Great Trench' in a cave overflowing with treasure.", newCalc2 +244, 72, 110, 0);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		 	mc.getTextureManager().bindTexture(STATS);
		 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 124, 0F, 1F, 10, 10, 40F, 22);
		 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 136, 10F, 0F, 10, 10, 40F, 20);
		 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 148, 20F, 1F, 10, 10, 40F, 22);
			drawModalRectWithCustomSizedTexture(newCalc2 +130, 160, 10F, 10F, 10, 10, 40F, 20);
			drawModalRectWithCustomSizedTexture(newCalc2 +243, 40, 0F, 10F, 10, 10, 40F, 20);
		 }else if(currPage == 50) {
			 this.fontRenderer.drawString("Tasma continued", newCalc2 +134, 39, 13513216, true);
			 	this.fontRenderer.drawSplitString("Nearly every treasure that's gone missing is blamed on Tasma, for a good reason too, his cave is said to have nearly every type of treasure in the sea. Many have tried to get the goodies in his cave, most never return and/or die of water pressure.", newCalc2 +126, 49, 105, 0);
			 	this.fontRenderer.drawSplitString("Legend has it that during the invasion of Atlantis, a soldier was ordered by King Atlas to hide two 'King's Gems' and that one was dropped deep into the trench. Tasma collects nearly everything that falls into the trench, so it wouldn't be surpising if he posseses the mythical gem.", newCalc2 +243, 40, 110, 0);
		 }else if(currPage == 51) {
				this.fontRenderer.drawString("Captain Blackeye", newCalc2 +136, 39, 3133599, true);
			 	this.fontRenderer.drawString(" 125HP(Respawns) ", (newCalc2 +136F), (125), 0, false);
			 	this.fontRenderer.drawString(" ? ", (newCalc2 +137F), (137), 0, false);
			 	this.fontRenderer.drawString(" 0 ", (newCalc2 +137F), (149), 0, false);
			 	this.fontRenderer.drawString(" 0-5.4b/s ", (newCalc2 +137F), (161F), 0, false);
				this.fontRenderer.drawString("------------------", (newCalc2 +245F), (65), 000000, false);
				this.fontRenderer.drawString(typeStringsE[7], (newCalc2 +250), (41F), 3093247, false);
				this.fontRenderer.drawString(" Difficulty: ", (newCalc2 +241), (55F), 0, false);
				this.fontRenderer.drawString(" Hard ", (newCalc2 +292), (55F), 12189696, true);
				
		 		this.fontRenderer.drawSplitString("The infamous pirate of the old days, Cap'n Blackeye. He was a very well known pirate back then in the lost sea. His main fame comes from his crew's notorious record of succesful ship raids, 1227 to 0, making him..", newCalc2 +244, 72, 110, 0);

				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			 	mc.getTextureManager().bindTexture(STATS);
			 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 124, 0F, 1F, 10, 10, 40F, 22);
			 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 136, 10F, 0F, 10, 10, 40F, 20);
			 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 148, 20F, 1F, 10, 10, 40F, 22);
				drawModalRectWithCustomSizedTexture(newCalc2 +130, 160, 10F, 10F, 10, 10, 40F, 20);
				drawModalRectWithCustomSizedTexture(newCalc2 +243, 40, 0F, 10F, 10, 10, 40F, 20);
		 }else if(currPage == 52) {
			 this.fontRenderer.drawString("Blackeye continued", newCalc2 +132, 39, 3133599, true);
			 this.fontRenderer.drawSplitString("the greatest pirate ever. His most famous adventure is when his crew sailed to 'Skull Island' in search for a fabled cutlass. When he touched the cutlass he and his crew we're turned into ghosts that now forever guard a treasure they cannot posses.", newCalc2 +126, 49, 105, 0);
			 this.fontRenderer.drawSplitString("The Ghost Pirates cannot truly die and will respawn after death. Many have searched for the cutlass after them including Captain Swashblocker, when Swashblocker's crew sailed there he was the only one to make it out alive and managed to snag some goods from a chest.", newCalc2 +243, 40, 110, 0);
		 }else if(currPage == 53) {
				this.fontRenderer.drawString("The Kraken", newCalc2 +147, 39, 3093241, true);
			 	this.fontRenderer.drawString(" ? ", (newCalc2 +136F), (125), 0, false);
			 	this.fontRenderer.drawString(" ? ", (newCalc2 +137F), (137), 0, false);
			 	this.fontRenderer.drawString(" 10 ", (newCalc2 +137F), (149), 0, false);
			 	this.fontRenderer.drawString(" 0-5.8b/s ", (newCalc2 +137F), (161F), 0, false);
				this.fontRenderer.drawString("------------------", (newCalc2 +245F), (65), 000000, false);
				this.fontRenderer.drawString(" Water, ", (newCalc2 +250), (41F), 3093247, false);
				this.fontRenderer.drawString(TextFormatting.DARK_PURPLE + " Dark ", (newCalc2 +283), (41F), 0, false);
				
				this.fontRenderer.drawString(" Difficulty: ", (newCalc2 +241), (55F), 0, false);
				this.fontRenderer.drawString(" Hard ", (newCalc2 +292), (55F), 12189696, true);
				
		 		this.fontRenderer.drawSplitString("You've probably heard the tales of the mighty 'Kraken' squid, well it's no legend, lemme tell ya. The Kraken is a gargantuan squid that I've seen with my own eyes. It's known to most from the tales of it..", newCalc2 +244, 72, 110, 0);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			 	mc.getTextureManager().bindTexture(STATS);
			 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 124, 0F, 1F, 10, 10, 40F, 22);
			 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 136, 10F, 0F, 10, 10, 40F, 20);
			 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 148, 20F, 1F, 10, 10, 40F, 22);
				drawModalRectWithCustomSizedTexture(newCalc2 +130, 160, 10F, 10F, 10, 10, 40F, 20);
				drawModalRectWithCustomSizedTexture(newCalc2 +243, 40, 0F, 10F, 10, 10, 40F, 20);
		 }else if(currPage == 54) {
			 this.fontRenderer.drawString("Kraken continued", newCalc2 +134, 39, 3093241, true);
			 this.fontRenderer.drawSplitString("sinking ships with it's enormous tentacles. Long ago a crew of pirates managed to damage the Kraken enough that it fled deep into the sea, never to be seen again. Many believe the Kraken still lives to this day. If you ever get a chance to see it, you..", newCalc2 +126, 49, 105, 0);
			 this.fontRenderer.drawSplitString("might notice that it's missing one of it's eyes. It turns out it's eye belongs to Aegaeon, the Atlanteans used the Kraken's eye when creating him so that he could have the most potent eye of any Guardian, and he surely does.", newCalc2 +243, 40, 110, 0);
		 }else if(currPage == 55) {
				this.fontRenderer.drawString("The Brine Beast", newCalc2 +139, 39, 3132203, true);
			 	this.fontRenderer.drawString(" ? ", (newCalc2 +136F), (125), 0, false);
			 	this.fontRenderer.drawString(" ? ", (newCalc2 +137F), (137), 0, false);
			 	this.fontRenderer.drawString(" ? ", (newCalc2 +137F), (149), 0, false);
			 	this.fontRenderer.drawString(" 0-2b/s ", (newCalc2 +137F), (161F), 0, false);
				this.fontRenderer.drawString("------------------", (newCalc2 +245F), (65), 000000, false);
				this.fontRenderer.drawString(" Water, ", (newCalc2 +250), (41F), 3093247, false);
				this.fontRenderer.drawString(TextFormatting.GRAY + " Ghost ", (newCalc2 +283), (41F), 0, false);
				
		 		this.fontRenderer.drawSplitString("There's an old ghost story called, 'The Legend of the Briny Deep', it's an old folktale that many tell their children so that they stay away from the salty 'Brine Seas'. The story goes a little like this,..", newCalc2 +244, 72, 110, 0);

				this.fontRenderer.drawString(" Difficulty: ", (newCalc2 +241), (55F), 0, false);
				this.fontRenderer.drawString(" Normal ", (newCalc2 +292), (55F), 16776960, true);
				
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			 	mc.getTextureManager().bindTexture(STATS);
			 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 124, 0F, 1F, 10, 10, 40F, 22);
			 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 136, 10F, 0F, 10, 10, 40F, 20);
			 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 148, 20F, 1F, 10, 10, 40F, 22);
				drawModalRectWithCustomSizedTexture(newCalc2 +130, 160, 10F, 10F, 10, 10, 40F, 20);
				drawModalRectWithCustomSizedTexture(newCalc2 +243, 40, 0F, 10F, 10, 10, 40F, 20);
		 }else if(currPage == 56) {
			 this.fontRenderer.drawString("Brine continued", newCalc2 +137, 39, 3132203, true);
			 this.fontRenderer.drawSplitString("long ago three men traveled to an unknown sea known as 'The Briny Deep'. These men were searching for a special type of crystal that grows there from the salty waters. When they were searching one of the men dropped their food and..", newCalc2 +126, 49, 105, 0);
			 this.fontRenderer.drawSplitString("a creature sniffed out his food then killed the men by crystallizing them into salt crystals. Strange if you ask me. The beast according to the story was apparently like a sort of, ghost whale? Interesting. I wonder what crystal they were after?", newCalc2 +243, 40, 110, 0);
		 }else if(currPage == 57) {
				this.fontRenderer.drawString("The Gorgons", newCalc2 +144, 39, 7680817, true);
			 	this.fontRenderer.drawString(" ? ", (newCalc2 +136F), (125), 0, false);
			 	this.fontRenderer.drawString(" 1(Stonifies) ", (newCalc2 +137F), (137), 0, false);
			 	this.fontRenderer.drawString(" ? ", (newCalc2 +137F), (149), 0, false);
			 	this.fontRenderer.drawString(" 0-3b/s ", (newCalc2 +137F), (161F), 0, false);
				this.fontRenderer.drawString("------------------", (newCalc2 +245F), (65), 000000, false);
				this.fontRenderer.drawString(" Psychic, ", (newCalc2 +250), (41F), 16724699, false);
				this.fontRenderer.drawString(TextFormatting.DARK_PURPLE + " Dark ", (newCalc2 +291), (41F), 0, false);
				
		 		this.fontRenderer.drawSplitString("Now I know you've been hit by a guardian's beam before, but this beam is like no other. Other Guardians at least give you time to get a out of their sight, these Guardians do not and have a unique beam ability.", newCalc2 +244, 72, 110, 0);

				this.fontRenderer.drawString(" Difficulty: ", (newCalc2 +241), (55F), 0, false);
				this.fontRenderer.drawString(" Hard ", (newCalc2 +292), (55F), 12189696, true);
				
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			 	mc.getTextureManager().bindTexture(STATS);
			 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 124, 0F, 1F, 10, 10, 40F, 22);
			 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 136, 10F, 0F, 10, 10, 40F, 20);
			 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 148, 20F, 1F, 10, 10, 40F, 22);
				drawModalRectWithCustomSizedTexture(newCalc2 +130, 160, 10F, 10F, 10, 10, 40F, 20);
				drawModalRectWithCustomSizedTexture(newCalc2 +243, 40, 0F, 10F, 10, 10, 40F, 20);
		 }else if(currPage == 58) {
			 this.fontRenderer.drawString("Gorgons continued", newCalc2 +131, 39, 7680817, true);
			 this.fontRenderer.drawSplitString("Their inital beam damage is not so bad, but when you've been in their beam for just even a meer 3 seconds, you will be frozen. These Guardians are able to turn anything living to stone in just a few seconds! Their ability isn't..", newCalc2 +126, 49, 105, 0);
			 this.fontRenderer.drawSplitString("the only thing unique about them. These Guardians have long tentacles that trail behind them and have eyes that are oval shaped that can glow a deep red. Luckily there is only three of these guardians living currently and can only be found in the, 'Maze of Convolution', Atlantis.", newCalc2 +243, 40, 110, 0);
			 
		 }else if(currPage == 59) {
				this.fontRenderer.drawString("The Reef Eater", newCalc2 +141, 39, 13389639, true);
			 	this.fontRenderer.drawString(" 235HP ", (newCalc2 +136F), (125), 0, false);
			 	this.fontRenderer.drawString(" 11-14 ", (newCalc2 +137F), (137), 0, false);
			 	this.fontRenderer.drawString(" 5 ", (newCalc2 +137F), (149), 0, false);
			 	this.fontRenderer.drawString(" 0-3b/s ", (newCalc2 +137F), (161F), 0, false);
				this.fontRenderer.drawString("------------------", (newCalc2 +245F), (65), 000000, false);
				this.fontRenderer.drawString(" Fire, ", (newCalc2 +250), (41F), 15138816, false);
				this.fontRenderer.drawString(" Earth ", (newCalc2 +273), (41F), 5516800, false);
				
				this.fontRenderer.drawString(" Difficulty: ", (newCalc2 +241), (55F), 0, false);
				this.fontRenderer.drawString(" Easy ", (newCalc2 +292), (55F), 65280, true);
				
		 		this.fontRenderer.drawSplitString("The Reef Eater, a weird name you may think, but he get's it for a good reason. Often recollected as 'The Reef Eater' because he's been a real pain to Dwarka Village and the surrounding reefs. He's been, well", newCalc2 +244, 72, 110, 0);

				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			 	mc.getTextureManager().bindTexture(STATS);
			 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 124, 0F, 1F, 10, 10, 40F, 22);
			 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 136, 10F, 0F, 10, 10, 40F, 20);
			 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 148, 20F, 1F, 10, 10, 40F, 22);
				drawModalRectWithCustomSizedTexture(newCalc2 +130, 160, 10F, 10F, 10, 10, 40F, 20);
				drawModalRectWithCustomSizedTexture(newCalc2 +243, 40, 0F, 10F, 10, 10, 40F, 20);
		 }else if(currPage == 60) {
			 this.fontRenderer.drawString("Reef continued", newCalc2 +140, 39, 13389639, true);
			 this.fontRenderer.drawSplitString("quite literatly eating the reef. The people of Dwarka have been trying to stop his feeding on the reef's life and terrain, but have never succeded in killing him, only slowed his eating. I once went on a scouting mission to hunt down and kill..", newCalc2 +126, 49, 105, 0);
			 this.fontRenderer.drawSplitString("him, we almost got him, but he was able to summon little rock minions to his aid. He can also shoot a tube of bubbles to push and suck people in, which is a real pain. If someone were to kill him, they would be well respected throughout Dwarka Village and maybe even get a reward.", newCalc2 +243, 40, 110, 0);
		 }else if(currPage == 61) {
				this.fontRenderer.drawString("The Great Graboid", newCalc2 +133, 39, 12161943, true);
			 	this.fontRenderer.drawString(" 450HP ", (newCalc2 +136F), (125), 0, false);
			 	this.fontRenderer.drawString(" 3-13* ", (newCalc2 +137F), (137), 0, false);
			 	this.fontRenderer.drawString(" 7 ", (newCalc2 +137F), (149), 0, false);
			 	this.fontRenderer.drawString(" 0b/s ", (newCalc2 +137F), (161F), 0, false);
				this.fontRenderer.drawString("------------------", (newCalc2 +245F), (65), 000000, false);
				this.fontRenderer.drawString(" Bug, ", (newCalc2 +250), (41F), 10157824, false);
				this.fontRenderer.drawString(" Earth ", (newCalc2 +271), (41F), 5516800, false);
				
		 		this.fontRenderer.drawSplitString("The greatest worm of the whole sea, mainly for his giant size. The species of sea worm known as Graboids are worms that hide in holes waiting for prey to swim over their hole to pretrude their..", newCalc2 +244, 72, 110, 0);

				this.fontRenderer.drawString(" Difficulty: ", (newCalc2 +241), (55F), 0, false);
				this.fontRenderer.drawString(" Easy ", (newCalc2 +292), (55F), 65280, true);
				
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			 	mc.getTextureManager().bindTexture(STATS);
			 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 124, 0F, 1F, 10, 10, 40F, 22);
			 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 136, 10F, 0F, 10, 10, 40F, 20);
			 	drawModalRectWithCustomSizedTexture(newCalc2 +130, 148, 20F, 1F, 10, 10, 40F, 22);
				drawModalRectWithCustomSizedTexture(newCalc2 +130, 160, 10F, 10F, 10, 10, 40F, 20);
				drawModalRectWithCustomSizedTexture(newCalc2 +243, 40, 0F, 10F, 10, 10, 40F, 20);
		 }else if(currPage == 62) {
			 this.fontRenderer.drawString("Graboid continued", newCalc2 +134, 39, 12161943, true);
			 this.fontRenderer.drawSplitString("extremely lengthy bodies out to grab and pull prey into their hole. Except this graboid is not quite the same, it's known to pull in massive sea creatures such as whales! The graboids only come out of their hole every once in a while, so..", newCalc2 +126, 49, 105, 0);
			 this.fontRenderer.drawSplitString("seeing this creature will not be easy. Many have tried to slay it to get it's shiny scales which are said to be worth millions and can be used to craft very powerful tools and armor. I have only heard the legends of this creature, although I'd try to kill it myself.", newCalc2 +243, 40, 110, 0);
		 }
		 else if(currPage == 63) {
			 this.fontRenderer.drawString("------------------", (newCalc2 +127F), (42), 000000, false);
		 	 this.fontRenderer.drawSplitString("I have explained nearly all that I know about the dimension from my travels and it's components. This is the last chapter of Volume I. I have documented all the dimensions lore that I know in this chapter, enjoy", newCalc2 +127, 52, 105, 0);
		 	 this.fontRenderer.drawString("------------------", (newCalc2 +127F), (160), 000000, false);
			 this.fontRenderer.drawSplitString("When I first arrived in the dimension I was in a sort of ruins, I noticed there was no portal. It was filled with water, but luckily I brought some potions so I managed to survive for a while. I looked for days hoping to find anything to help me get home. Eventually I found a village...", newCalc2 +243, 40, 110, 0);
		 }
		 else if(currPage == 64) {
			 this.fontRenderer.drawSplitString("and the village was suprisngly benign, they guessed that I escaped from the Guardians? Either way I was safe now. I stayed in The Lost Sea for years, I never knew if I could ever make it home. ", newCalc2 +126, 46, 105, 0);
			 
		 }
	    }else {
	 		if(showMe == true) {
	        	bookPageTextures[5] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/cover/lore_book_cover_page_clicked.png");
	 		}
	 		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 		mc.getTextureManager().bindTexture(bookPageTextures[5]);
	 	    drawTexturedModalRect(offsetFromScreenLeft + 65, 2, 0, 0, bookImageWidth, bookImageHeight);
	 	   if(showMe == true) {
		 		this.fontRenderer.drawSplitString(TextFormatting.UNDERLINE + "What's This Book?", 321, 40, 112, 0);
		 		this.fontRenderer.drawSplitString(TextFormatting.ITALIC + "The Aquapedia is a journal that contains Jack's old writings about the Lost Sea, some pages are lost.", 321, 50, 90, 0);
	 	   }
	    }
	  super.drawScreen(parWidth, parHeight, p_73863_3_);
	  }
	
	@Override
    protected void mouseClickMove(int parMouseX, int parMouseY, int parLastButtonClicked, long parTimeSinceMouseClick) 
    {
    }
	
	

    @Override
    protected void actionPerformed(GuiButton parButton) 
    {
    	int offsetFromScreenLeft = (width - bookImageWidth) / 2;
     if (parButton == buttonDone)
     {
         // You can send a packet to server here if you need server to do something
        
         mc.displayGuiScreen((GuiScreen)null);
     }
        else if (parButton == buttonNextPage)
        {
        	//buttonNextPage.visible = (currPage < bookTotalPages - 1 && currPage != 0);
     		//buttonPreviousPage.visible = currPage > 0;
            if (currPage < bookTotalPages - 1)
            {
                ++currPage;
            }
        }
        else if (parButton == buttonPreviousPage)
        {
        	//buttonNextPage.visible = (currPage < bookTotalPages - 1 && currPage != 0);
     		//buttonPreviousPage.visible = currPage > 0;
            if (currPage > 0)
            {
                --currPage;
            }
        }
        else if(parButton == VolSelectorG) {
        	currPage = 66;
        }
        else if(parButton == VolSelectorA) {
        	currPage = 76;
        }else if(parButton == VolSelectorM){
        	currPage = 2;
        }
        else if(parButton == buttonNextPageF){
        	currPage = 1;
        	//buttonNextPage.visible = (currPage < bookTotalPages - 1 && currPage != 0);
     		//buttonPreviousPage.visible = currPage > 0;
        }
        else if(parButton == buttonWhatThis){
        	if(showMe == false) {
        		showMe = true;
        	}else {
        		showMe = false;
        	}
        }
        else if(parButton == buttonWhatThis){
        	
        }else if(parButton == volumeNextPage1) {
        	currPage = 2;
        }
        else if(parButton == volumePreviousPage1) {
        	currPage = 2;
        }else if(parButton == magButton) {
        	if(zoomed) {
        		Scale -= 5;
        		zoomed = false;
        		magButton.isMag = false;
        	}else if(!zoomed) {
        		Scale += 5;
        		zoomed = true;
        		magButton.isMag = true;
        	}
        }
   }
	@Override
	public void onGuiClosed() 
	{
		this.flip = true;
	}
	/**
	 * Returns true if this GUI should pause the game when it is displayed in 
	 * single-player
	 */
	@Override
	public boolean doesGuiPauseGame()
	{
	    return false;
	}
	
	
	
	@SideOnly(Side.CLIENT)
    static class NextPageButton extends GuiButton
    {
        private final boolean isNextButton;

        public NextPageButton(int parButtonId, int parPosX, int parPosY, boolean parIsNextButton)
        {
            super(parButtonId, parPosX, parPosY, 23, 13, "");
            isNextButton = parIsNextButton;
        }
       
        @Override
        public void playPressSound(SoundHandler soundHandlerIn)
        {
           soundHandlerIn.playSound(PositionedSoundRecord.getMasterRecord(TLSSounds.PAGE_FLIP , 1.2F));
        }

        /**
         * Draws this button to the screen.
         */
        @Override
        public void drawButton(Minecraft mc, int parX, int parY, float partial)
        {
            if (visible)
            {
                boolean isButtonPressed = (parX >= x && parY >= y && parX < x + width && parY < y + height);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                mc.getTextureManager().bindTexture(BOOK_GUI_TEXTURES);
                int i = 0;
                int j = 192;

                if (isButtonPressed)
                {
                    i += 23;
                }
                
                

                if (!isNextButton)
                {
                    j += 13;
                }

                this.drawTexturedModalRect(this.x, this.y, i, j, 23, 13);
            }
        }
    }
	
	@SideOnly(Side.CLIENT)
    static class NumbSelctor extends GuiButton
    {
		private static int pageNumb;
		boolean sound;
		Random rand = new Random();
        public NumbSelctor(int parButtonId, int parPosX, int parPosY, int numb, boolean soundIs)
        {
            super(parButtonId, parPosX, parPosY, 23, 13, I18n.format("+", new Object[0])); 
            this.pageNumb = numb;
            sound = soundIs;
        }
        
        @Override
        public void playPressSound(SoundHandler soundHandlerIn) {
        	if(sound == true) {
        		soundHandlerIn.playSound(PositionedSoundRecord.getMasterRecord(TLSSounds.PAGE_FLIP, 1.2F));
        		soundHandlerIn.playSound(PositionedSoundRecord.getMasterRecord(TLSSounds.PAGE_FLIP, 1.6F));
        		soundHandlerIn.playSound(PositionedSoundRecord.getMasterRecord(TLSSounds.PAGE_FLIP, 0.15F));
        	}else {
        		soundHandlerIn.playSound(PositionedSoundRecord.getMasterRecord(TLSSounds.PAGE_FLIP, rand.nextFloat() * 1.74F));
        	}
        }
    }
	@SideOnly(Side.CLIENT)
    static class WhatThisButton extends GuiButton
    {
		boolean showBox;
		Random rand = new Random();
        public WhatThisButton(int parButtonId, int parPosX, int parPosY)
        {
            super(parButtonId, parPosX, parPosY, 23, 13, I18n.format("", new Object[0])); 
        }
        @Override
        public void drawButton(Minecraft mc, int parX, int parY, float partial)
        {
            if (visible)
            {
                boolean isButtonPressed = (parX >= x && parY >= y && parX < x + width && parY < y + height);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                if(isButtonPressed) {
                	bookPageTextures[5] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/cover/lore_book_cover_page_open.png");
                	
                }else {
                	bookPageTextures[5] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lore/cover/lore_book_cover_page_closed.png");
                }
                
                if(showBox == true) {
                    //mc.getTextureManager().bindTexture(BOOK_GUI_TEXTURES);
                }
            }
        }
    }
	
	static class VolumeArrows extends GuiButton{
		
		private final boolean isNextButton;
		private final int ID;

        public VolumeArrows(int parButtonId, int parPosX, int parPosY, boolean parIsNextButton, int buttonID)
        {
            super(parButtonId, parPosX, parPosY, 23, 13, "");
            isNextButton = parIsNextButton;
            ID = buttonID;
        }
		@Override
        public void drawButton(Minecraft mc, int parX, int parY, float partial)
        {
            if (visible)
            {
            	boolean isButtonPressed = (parX >= x && parY >= y && parX < x + width && parY < y + height);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                mc.getTextureManager().bindTexture(BOOK_GUI_TEXTURES);
                int i = ID;
                int j = 192;
                

                if (isButtonPressed)
                {
                    i += 23;
                }
                
                if (!isNextButton)
                {
                    j += 13;
                }

                this.drawTexturedModalRect(this.x, this.y, i, j, 23, 13);
            }
        }
	}
	static class ButtonMagnifier extends GuiButton{
		
		private boolean isMag;
        public ButtonMagnifier(int parButtonId, int parPosX, int parPosY, boolean isZoom, int buttonID)
        {
            super(parButtonId, parPosX, parPosY, 23, 13, "");
            isMag = isZoom;
        }
		@Override
        public void drawButton(Minecraft mc, int parX, int parY, float partial)
        {
            if (visible)
            {
            	boolean isButtonPressed = (parX >= x && parY >= y && parX < x + width && parY < y + height);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                mc.getTextureManager().bindTexture(BOOK_GUI_TEXTURES);
                int j = 192;
                int i = 188;

                if (isButtonPressed)
                {
                   j += 24;
                }
                
                if (isMag)
                {
                   j += 12;
                }

                this.drawTexturedModalRect(this.x, this.y, i, j, 23, 12);
            }
        }
	}
}
