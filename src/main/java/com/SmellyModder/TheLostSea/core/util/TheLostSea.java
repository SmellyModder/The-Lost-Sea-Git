package com.SmellyModder.TheLostSea.core.util;

import com.SmellyModder.TheLostSea.client.overlay.stats.OverlayCoinAmount;
import com.SmellyModder.TheLostSea.client.overlay.stats.OverlayCoins;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSFluids;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.config.Config;
import com.SmellyModder.TheLostSea.core.mob_events.EyeDropEvent;
import com.SmellyModder.TheLostSea.core.packets.MessageCoins;
import com.SmellyModder.TheLostSea.core.packets.MessageRequestCoins;
import com.SmellyModder.TheLostSea.core.proxy.CommonProxy;
import com.SmellyModder.TheLostSea.core.util.handlers.CapabilityHandler;
import com.SmellyModder.TheLostSea.core.util.handlers.CoinEventHandler;
import com.SmellyModder.TheLostSea.core.util.handlers.GUIHandler;
import com.SmellyModder.TheLostSea.core.util.handlers.RegistryHandler;
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
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class TheLostSea {

	@Instance
	public static TheLostSea instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) {
		Config.load(event);
		RegistryHandler.preInitRegistries();
		CapabilityHandler.register();
		NETWORK.registerMessage(MessageRequestCoins.HandleRequestCoins.class, MessageRequestCoins.class, 0, Side.SERVER);
		NETWORK.registerMessage(MessageCoins.HandleMessageCoins.class, MessageCoins.class, 0, Side.CLIENT);
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		RegistryHandler.initRegistries();
		
		/* Register Gui Handler */
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GUIHandler());
		
		MinecraftForge.EVENT_BUS.register(new EyeDropEvent());
		/**
		 * Handles Data
		 */
		MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
	    MinecraftForge.EVENT_BUS.register(new CoinEventHandler());
	    //MinecraftForge.EVENT_BUS.register(new OverlayCoinAmount());
	    OreDictionaryLS.register();
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event) {
			System.out.println("Player Data Loaded");
			
	}
	
	@SideOnly(Side.CLIENT)
    @EventHandler
    public static void preinitSide(FMLPreInitializationEvent event) {
		 RegistryHandler.preInitRegistriesSide();
		 MinecraftForge.EVENT_BUS.register(new OverlayCoins());
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
		
//	public static CreativeTabs TLS_VEHICLES = new CreativeTabs("The-Lost-Sea-Vehicles") {
//		@Override
//		public ItemStack createIcon() { 
//			return new ItemStack(TLSItems.BLUE_SUBMARINE);
//	}
//	};
	
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
