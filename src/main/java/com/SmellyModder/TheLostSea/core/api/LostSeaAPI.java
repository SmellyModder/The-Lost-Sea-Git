package com.SmellyModder.TheLostSea.core.api;

import com.SmellyModder.TheLostSea.client.model.items.ModelLSShield;
import com.SmellyModder.TheLostSea.core.api.capabilites.EquippableCapabilties;
import com.SmellyModder.TheLostSea.core.api.capabilites.IEquippableItemHandler;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LostSeaAPI {
	
	String[] name;
	
	public void doThis() {
		name = new String[2];
	}
	
	public static IEquippableItemHandler getEquippableHandler(EntityPlayer player) {
		IEquippableItemHandler handler = player.getCapability(EquippableCapabilties.CAPABILITY_EQUIPPABLES, null);
		handler.setPlayer(player);
		return handler;
	}
	
	public static int isEquippableEquipped(EntityPlayer player, Item equippable) {
		IEquippableItemHandler handler = getEquippableHandler(player);
		for (int i = 0; i < handler.getSlots(); i++) {
			if (!handler.getStackInSlot(i).isEmpty() && handler.getStackInSlot(i).getItem() == equippable) 
				return i;
		}
		return -1;
	}
	
	/*
	 * Contains useful methods to make registering easier 
	 */
	public static class RegistryUtils {
		
		/*
		 *  @param {Item} item - The Item to create the render of
		 *  @param {ModelLSShield} s - The Shield to make the item render as
		 *  @param {String} resource - The Texture of the model
		 */
		@SideOnly(Side.CLIENT)
		public static void createShieldRender(Item item, ModelLSShield s, String resource) {
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
		
		/*
		 *  @param {Block} block - The Block to create the render of
		 *  @param {TileEntity} t - The TileEntity to create the render of
		 */
		@SideOnly(Side.CLIENT)
		public static void createTERender(Block block, TileEntity t) {
				Item.getItemFromBlock(block).setTileEntityItemStackRenderer(new TileEntityItemStackRenderer() {
		    	
		    	@Override
	            public void renderByItem(ItemStack stack) {
	                TileEntityRendererDispatcher.instance.render(t, 0.0, 0.0, 0.0, 0.0F, 1.0F);
	            }
		    });
		}
		
	}
	
	
	public static float getPercentedValue(float value, float percent, boolean increase) {
		float result;
		if(increase) {
			result = (value * percent) + value;
		} else {
			result = value * percent;
		}
		return result;
	}
	
}
