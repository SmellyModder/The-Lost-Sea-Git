package com.SmellyModder.TheLostSea.core.util;

import com.SmellyModder.TheLostSea.client.overlay.stats.OverlayCoins;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.config.Config;
import com.SmellyModder.TheLostSea.core.mob_events.EyeDropEvent;
import com.SmellyModder.TheLostSea.core.mob_events.FinDropEvent;
import com.SmellyModder.TheLostSea.core.packets.MessageSetVerse;
import com.SmellyModder.TheLostSea.core.packets.MessageCoins;
import com.SmellyModder.TheLostSea.core.packets.MessageRequestCoins;
import com.SmellyModder.TheLostSea.core.packets.npc.MessageRequestVerseN;
import com.SmellyModder.TheLostSea.core.packets.npc.MessageVerseN;
import com.SmellyModder.TheLostSea.core.proxy.CommonProxy;
import com.SmellyModder.TheLostSea.core.util.client_events.FovUpdater;
import com.SmellyModder.TheLostSea.core.util.events.GameplayEventHandler;
import com.SmellyModder.TheLostSea.core.util.handlers.CapabilityHandler;
import com.SmellyModder.TheLostSea.core.util.handlers.CoinEventHandler;
import com.SmellyModder.TheLostSea.core.util.handlers.GUIHandler;
import com.SmellyModder.TheLostSea.core.util.handlers.RegistryHandler;
import com.SmellyModder.TheLostSea.core.util.handlers.npc.NPCEventHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class TheLostSea {

	@Instance
	public static TheLostSea instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
	public static final SimpleNetworkWrapper NETWORK_NPC = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID + "_npc");
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) {
		proxy.preInit();
		Config.load(event);
		RegistryHandler.preInitRegistries();
		CapabilityHandler.register();
		NETWORK.registerMessage(MessageRequestCoins.HandleRequestCoins.class, MessageRequestCoins.class, 0, Side.SERVER);
		NETWORK.registerMessage(MessageCoins.HandleMessageCoins.class, MessageCoins.class, 1, Side.CLIENT);
		
		NETWORK.registerMessage(MessageRequestVerseN.HandleRequestVerse.class, MessageRequestVerseN.class, 2, Side.SERVER);
		NETWORK.registerMessage(MessageVerseN.HandleMessageVerse.class, MessageVerseN.class, 3, Side.CLIENT);
		NETWORK.registerMessage(MessageSetVerse.HandleMessageSetVerse.class, MessageSetVerse.class, 4, Side.SERVER);
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		proxy.init();
		RegistryHandler.initRegistries();
		
		/* Register Gui Handler */
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GUIHandler());
		
		MinecraftForge.EVENT_BUS.register(new EyeDropEvent());
		MinecraftForge.EVENT_BUS.register(new FinDropEvent());
		/**
		 * Handles Data
		 */
		MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
	    MinecraftForge.EVENT_BUS.register(new CoinEventHandler());
	    MinecraftForge.EVENT_BUS.register(new GameplayEventHandler());
	    OreDictionaryLS.register();
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event) {
		System.out.println("Player Data Loaded");
	}

	public static CreativeTabs TLS = new CreativeTabs("The-Lost-Sea-Items") {
		@Override
		public ItemStack createIcon() { 
			  return new ItemStack(TLSItems.PEARL);
		}
		};
		
	public static CreativeTabs TLS_BLOCKS = new CreativeTabs("The-Lost-Sea-Blocks") {
			@Override
			public ItemStack createIcon() { 
				  return new ItemStack(TLSBlocks.PRISMARINE_EYE_TEMPLE);
			}
			};
		
	public static CreativeTabs TLS_ORES = new CreativeTabs("The-Lost-Sea-Ores") {
		@Override
		public ItemStack createIcon() { 
			return new ItemStack(TLSBlocks.DEEPSEA_GOLDORE);
		}
		};
	
	public static CreativeTabs TLS_GEAR = new CreativeTabs("The-Lost-Sea-Gear") {
		@Override
		public ItemStack createIcon() { 
			return new ItemStack(TLSItems.PRISMARINE_HELMET);
	}
	};
	
	public static CreativeTabs TLS_MUSIC = new CreativeTabs("The-Lost-Sea-Music") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(TLSItems.PIRATE_CREW_DISC);
		}
	};
	@EventHandler
	public static void serverInit(FMLServerStartingEvent event) {
	        RegistryHandler.serverRegistries(event);
	        System.out.println("A temple hums with energy...");
	}
}
