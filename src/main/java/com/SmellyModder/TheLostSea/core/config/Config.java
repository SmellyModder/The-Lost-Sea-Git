package com.SmellyModder.TheLostSea.core.config;

import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
public class Config {

	private static final String LANG_PREFIX = Reference.MOD_ID + ".config.";

	private static Configuration config;
	
	public static int DIM_ID;
	public static int QuestGuiID;
	public static int difficulty;
	public static boolean exoticEnabled;
	public static boolean isCoinOverlayTop;

	public static void load(FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());
		reloadConfig();

		MinecraftForge.EVENT_BUS.register(Config.class);
	}

	private static void reloadConfig() {
		//Basics
		DIM_ID = config.getInt("LostSeaDimId", Configuration.CATEGORY_GENERAL, -9, -150, 150, " Use for compatibility purposes.", LANG_PREFIX + "The Lost Sea Dimension ID");
		QuestGuiID = config.getInt("QuestGuiID", Configuration.CATEGORY_GENERAL, 33, 15, 150, " Use for compatibility purposes.", LANG_PREFIX + "QuestGuiID");
		isCoinOverlayTop = config.getBoolean("CoinOverlayIsTop", Configuration.CATEGORY_CLIENT, false, "False - Coin Overlay is located on the bottom right, True - It's located middle top", LANG_PREFIX + "CoinOverlayIsTop");
		if (config.hasChanged()) {
			config.save();
		}
	}
	
	@SubscribeEvent
	public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equals(Reference.MOD_ID)) {
			reloadConfig();
		}
	}
}
