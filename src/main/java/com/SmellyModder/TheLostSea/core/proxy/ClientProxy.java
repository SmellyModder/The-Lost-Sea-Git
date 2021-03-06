package com.SmellyModder.TheLostSea.core.proxy;

import java.util.EnumMap;
import java.util.Map;

import com.SmellyModder.TheLostSea.client.gui.GUILoreBook;
import com.SmellyModder.TheLostSea.client.gui.npc.GuiNurmNpc;
import com.SmellyModder.TheLostSea.client.model.armor.ModelNeptunumArmor;
import com.SmellyModder.TheLostSea.client.render.tile.TileEntityStarterChestFullRenderer;
import com.SmellyModder.TheLostSea.client.render.tile.TileEntityStarterChestRenderer;
import com.SmellyModder.TheLostSea.common.tileentity.rewards.TileEntityStarterChest;
import com.SmellyModder.TheLostSea.common.tileentity.rewards.TileEntityStarterChestFull;
import com.SmellyModder.TheLostSea.core.util.handlers.RenderHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;


public class ClientProxy extends CommonProxy{

	//private final Map<EntityEquipmentSlot, ModelBiped> neptunumArmorModel = new EnumMap<>(EntityEquipmentSlot.class);
	
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}

	@Override
	public void preInit() {
		RenderHandler.registerEntityRenders();
	}
	
	@Override
	public void init() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStarterChestFull.class, new TileEntityStarterChestFullRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStarterChest.class, new TileEntityStarterChestRenderer());
		
//		neptunumArmorModel.put(EntityEquipmentSlot.HEAD, new ModelNeptunumArmor(EntityEquipmentSlot.HEAD, 0.01f));
//		neptunumArmorModel.put(EntityEquipmentSlot.CHEST, new ModelNeptunumArmor(EntityEquipmentSlot.CHEST, 0.01f));
//		neptunumArmorModel.put(EntityEquipmentSlot.LEGS, new ModelNeptunumArmor(EntityEquipmentSlot.CHEST, 0.01f));
//		neptunumArmorModel.put(EntityEquipmentSlot.FEET, new ModelNeptunumArmor(EntityEquipmentSlot.CHEST, 0.01f));
	}
	
	@Override
	public void openMyGui(ItemStack stack)
	{
	    Minecraft.getMinecraft().displayGuiScreen(new GUILoreBook(stack));
	}
	
	public void OpenNurmGUI(EntityPlayer player) {
		Minecraft.getMinecraft().displayGuiScreen(new GuiNurmNpc(player));
	}
	
}
