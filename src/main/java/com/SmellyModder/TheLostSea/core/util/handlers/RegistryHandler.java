package com.SmellyModder.TheLostSea.core.util.handlers;

import com.SmellyModder.TheLostSea.client.render.tile.TileEntityStarterChestFullRenderer;
import com.SmellyModder.TheLostSea.common.init.DimensionInit;
import com.SmellyModder.TheLostSea.common.init.TLSBiomes;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSEnchants;
import com.SmellyModder.TheLostSea.common.init.TLSEntities;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.common.init.TLSSmeltebles;
import com.SmellyModder.TheLostSea.common.init.TLSSounds;
import com.SmellyModder.TheLostSea.common.init.TLSTileEntities;
import com.SmellyModder.TheLostSea.common.init.TLSVehicles;
import com.SmellyModder.TheLostSea.common.init.client.TileEntityRenders;
import com.SmellyModder.TheLostSea.common.tileentity.rewards.TileEntityStarterChest;
import com.SmellyModder.TheLostSea.common.tileentity.rewards.TileEntityStarterChestFull;
import com.SmellyModder.TheLostSea.core.util.CommandDimensionTP;
import com.SmellyModder.TheLostSea.core.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(TLSItems.ITEMS.toArray(new Item [0]));
		 
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(TLSBlocks.BLOCKS.toArray(new Block [0]));
		TLSTileEntities.registerTileEntities();
		TileEntityRenders.register();
	}
	
	@SubscribeEvent
	public static void onEnchantmentRegistry(RegistryEvent.Register<Enchantment> event) {
		event.getRegistry().registerAll(TLSEnchants.ENCHANTS.toArray(new Enchantment[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		TileEntityStarterChestFull chest = new TileEntityStarterChestFull();
		TileEntityStarterChest chest1 = new TileEntityStarterChest();
		
		for(Item item : TLSItems.ITEMS) {
			
			if(item instanceof IHasModel) {
				
				((IHasModel)item).registerModels();
				
			}
			
		}
		for(Block block : TLSBlocks.BLOCKS) {
			
			if(block instanceof IHasModel) {
				
				((IHasModel)block).registerModels();
				
		        
			}
			
		    Item.getItemFromBlock(TLSBlocks.STARTER_CHEST_FULL).setTileEntityItemStackRenderer(new TileEntityItemStackRenderer() {
		            @Override
		            public void renderByItem(ItemStack stack) {
		                TileEntityRendererDispatcher.instance.render(chest, 0.0, 0.0, 0.0, 0.0F, 1.0F);
		            }
		    });
		    Item.getItemFromBlock(TLSBlocks.STARTER_CHEST).setTileEntityItemStackRenderer(new TileEntityItemStackRenderer() {
	            @Override
	            public void renderByItem(ItemStack stack) {
	                TileEntityRendererDispatcher.instance.render(chest1, 0.0, 0.0, 0.0, 0.0F, 1.0F);
	            }
		    });
		}
	}
	
	public static void initRegistries() {

        TLSBiomes.registerBiomes();
        SoundHandler.registerSounds();
        TLSSounds.registerSounds();
        TLSSmeltebles.init();
    }
	
	public static void preInitRegistries() {

        TLSEntities.registerEntities();
        TLSEntities.registerEntities2();
        TLSVehicles.registerVehicles();
        
        DimensionInit.registerDimensions();
	}
	
	public static void serverRegistries(FMLServerStartingEvent event) {

        event.registerServerCommand(new CommandDimensionTP());

    }
}
