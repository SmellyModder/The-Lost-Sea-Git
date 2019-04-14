package com.SmellyModder.TheLostSea.core.proxy;

import com.SmellyModder.TheLostSea.client.particle.LostSeaParticles;
import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.packets.npc.MessageVerseN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.DialogueProviderN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.IDialogueNurm;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CommonProxy {
	
	public void registerItemRenderer(Item item, int Meta, String string) {
		
	}
	
	public void openMyGui(ItemStack stack)
	{
	}
	
	public void openScreen() {
		
	}
	
	public void initCapabilites() {
		 
	}
	
	public void coinOverlay()
	{
		
	}

	public void preInit() {}
	
	public void init() {}
	
	public void OpenNurmGUI(EntityPlayer player) {
	}

}
