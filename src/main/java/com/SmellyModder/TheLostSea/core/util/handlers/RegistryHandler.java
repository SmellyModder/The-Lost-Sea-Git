package com.SmellyModder.TheLostSea.core.util.handlers;

import com.SmellyModder.TheLostSea.client.model.items.ModelLSShield;
import com.SmellyModder.TheLostSea.client.model.items.ModelVanadiumShield;
import com.SmellyModder.TheLostSea.client.render.tile.TileEntityStarterChestFullRenderer;
import com.SmellyModder.TheLostSea.client.render.tile.TileEntityStarterChestRenderer;
import com.SmellyModder.TheLostSea.common.init.DimensionInit;
import com.SmellyModder.TheLostSea.common.init.TLSBiomes;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSEnchants;
import com.SmellyModder.TheLostSea.common.init.TLSEntities;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.common.init.TLSSmeltebles;
import com.SmellyModder.TheLostSea.common.init.TLSSounds;
import com.SmellyModder.TheLostSea.common.init.TLSTileEntities;
import com.SmellyModder.TheLostSea.common.init.client.TileEntityRenders;
import com.SmellyModder.TheLostSea.common.tileentity.rewards.TileEntityStarterChest;
import com.SmellyModder.TheLostSea.common.tileentity.rewards.TileEntityStarterChestFull;
import com.SmellyModder.TheLostSea.core.util.CommandDimensionTP;
import com.SmellyModder.TheLostSea.core.util.IHasModel;
import com.SmellyModder.TheLostSea.core.util.Reference;
import com.SmellyModder.TheLostSea.core.util.interfaces.ILSShield;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.BannerTextures;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
			
			
			if(item instanceof ILSShield) {
				
				ModelLSShield model = ((ILSShield)item).shieldModel();
				
				if(item == TLSItems.VANADIUM_SHIELD) {
					RegistryHandler.createRender(item, model, ":textures/models/shield/vanadium_shield.png");
				}
				else if(item == TLSItems.NEPTUNUM_SHIELD) {
					RegistryHandler.createRender(item, model, ":textures/models/shield/cobalt_shield.png");
				}
			}
		}
		for(Block block : TLSBlocks.BLOCKS) {
			
			if(block instanceof IHasModel) {
				
				((IHasModel)block).registerModels();
				
		        
			}
			
			if(block == TLSBlocks.STARTER_CHEST) {
				RegistryHandler.createBlockRender(block, chest1);
			}
			else if(block == TLSBlocks.STARTER_CHEST_FULL) {
				RegistryHandler.createBlockRender(block, chest);
			}
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
        
        DimensionInit.registerDimensions();
	}
	
	public static void serverRegistries(FMLServerStartingEvent event) {

        event.registerServerCommand(new CommandDimensionTP());

    }
	
	@SideOnly(Side.CLIENT)
	private static void createRender(Item item, ModelLSShield s, String resource) {
		item.setTileEntityItemStackRenderer(new TileEntityItemStackRenderer() {
            @Override
            public void renderByItem(ItemStack stack) {
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + resource));
                GlStateManager.pushMatrix();
                GlStateManager.scale(1.0F, -1.0F, -1.0F);
                s.render();
                GlStateManager.popMatrix();
            }
	    });
	}
	
	@SideOnly(Side.CLIENT)
	private static void createBlockRender(Block block, TileEntity t) {
		Item.getItemFromBlock(block).setTileEntityItemStackRenderer(new TileEntityItemStackRenderer() {
	    	
	    	@Override
            public void renderByItem(ItemStack stack) {
                TileEntityRendererDispatcher.instance.render(t, 0.0, 0.0, 0.0, 0.0F, 1.0F);
            }
	    });
	}
}
