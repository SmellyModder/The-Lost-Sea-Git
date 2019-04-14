package com.SmellyModder.TheLostSea.core;

import com.SmellyModder.TheLostSea.client.overlay.stats.OverlayCoins;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.common.tileentity.TileEntitySeaStoneFurnace;
import com.SmellyModder.TheLostSea.common.tileentity.rewards.TileEntityStarterChest;
import com.SmellyModder.TheLostSea.common.tileentity.rewards.TileEntityStarterChestFull;
import com.SmellyModder.TheLostSea.common.world.dimension.feature.WorldGenPalmTree;
import com.SmellyModder.TheLostSea.common.world.gen.chunk.IslandTerrainHandler;
import com.SmellyModder.TheLostSea.common.world.overworld.handler.LSVillageHandler;
import com.SmellyModder.TheLostSea.core.api.LostSeaLootTables;
import com.SmellyModder.TheLostSea.core.config.Config;
import com.SmellyModder.TheLostSea.core.mob_events.EyeDropEvent;
import com.SmellyModder.TheLostSea.core.mob_events.FinDropEvent;
import com.SmellyModder.TheLostSea.core.packets.MessageSetVerse;
import com.SmellyModder.TheLostSea.core.packets.MessageCoins;
import com.SmellyModder.TheLostSea.core.packets.MessageRequestCoins;
import com.SmellyModder.TheLostSea.core.packets.npc.MessageRequestVerseN;
import com.SmellyModder.TheLostSea.core.packets.npc.MessageSetCoins;
import com.SmellyModder.TheLostSea.core.packets.npc.MessageVerseN;
import com.SmellyModder.TheLostSea.core.packets.npc.shop.MessageGiveItems;
import com.SmellyModder.TheLostSea.core.packets.npc.shop.MessageTakeItems;
import com.SmellyModder.TheLostSea.core.proxy.CommonProxy;
import com.SmellyModder.TheLostSea.core.util.OreDictionaryLS;
import com.SmellyModder.TheLostSea.core.util.Reference;
import com.SmellyModder.TheLostSea.core.util.client_events.FovUpdater;
import com.SmellyModder.TheLostSea.core.util.handlers.CapabilityHandler;
import com.SmellyModder.TheLostSea.core.util.handlers.CoinEventHandler;
import com.SmellyModder.TheLostSea.core.util.handlers.GUIHandler;
import com.SmellyModder.TheLostSea.core.util.handlers.RegistryHandler;
import com.SmellyModder.TheLostSea.core.util.handlers.npc.NPCEventHandler;
import com.SmellyModder.TheLostSea.core.util.player.events.PlayerBreakEvents;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.structure.MapGenStructureIO;
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
import net.minecraftforge.fml.common.registry.GameRegistry;
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
		MinecraftForge.TERRAIN_GEN_BUS.register(IslandTerrainHandler.class);
		
		Config.load(event);
		RegistryHandler.preInitRegistries();
		CapabilityHandler.register();
		
		//Coins
		NETWORK.registerMessage(MessageRequestCoins.HandleRequestCoins.class, MessageRequestCoins.class, 0, Side.SERVER);
		NETWORK.registerMessage(MessageCoins.HandleMessageCoins.class, MessageCoins.class, 1, Side.CLIENT);
		NETWORK.registerMessage(MessageSetCoins.HandleMessageSetCoins.class, MessageSetCoins.class, 2, Side.SERVER);
		
		//Npc
		NETWORK.registerMessage(MessageRequestVerseN.HandleRequestVerse.class, MessageRequestVerseN.class, 3, Side.SERVER);
		NETWORK.registerMessage(MessageVerseN.HandleMessageVerse.class, MessageVerseN.class, 4, Side.CLIENT);
		NETWORK.registerMessage(MessageSetVerse.HandleMessageSetVerse.class, MessageSetVerse.class, 5, Side.SERVER);
		
		//Shop
		NETWORK.registerMessage(MessageGiveItems.HandleGiveItems.class, MessageGiveItems.class, 6, Side.SERVER);
		NETWORK.registerMessage(MessageTakeItems.HandleTakeItems.class, MessageTakeItems.class, 7, Side.SERVER);
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		proxy.init();
		RegistryHandler.initRegistries();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GUIHandler());
		
		MinecraftForge.EVENT_BUS.register(new EyeDropEvent());
		MinecraftForge.EVENT_BUS.register(new FinDropEvent());
		MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
		MinecraftForge.EVENT_BUS.register(new PlayerBreakEvents());
	    MinecraftForge.EVENT_BUS.register(new CoinEventHandler());
	    
	    LSVillageHandler.initNurmShop();
	    OreDictionaryLS.register();
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event) {}

	public static CreativeTabs TLS = new CreativeTabs("LSItems") {
		@Override
		public ItemStack createIcon() { 
			  return new ItemStack(TLSItems.PEARL);
		}
	};
		
	public static CreativeTabs TLS_BLOCKS = new CreativeTabs("LSBlocks") {
		@Override
		public ItemStack createIcon() { 
				  return new ItemStack(TLSBlocks.SEA_ROCK);
		}
	};
	
	public static CreativeTabs TLS_GEAR = new CreativeTabs("LSGear") {
		@Override
		public ItemStack createIcon() { 
			return new ItemStack(TLSItems.DISC_NEPTUNUM);
		}
	};
	
	public static CreativeTabs TLS_PLANTS = new CreativeTabs("LSPlants") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(TLSBlocks.PALM_SAPLING);
		}
	};
	
	public static CreativeTabs TLS_SPECIAL = new CreativeTabs("LSSpecial") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(TLSItems.GOLDEN_ELDER_EYE);
		}
	};
	
	@EventHandler
	public static void serverInit(FMLServerStartingEvent event) {
	    RegistryHandler.serverRegistries(event);
	    System.out.println("A temple hums with energy...");
	}
}
