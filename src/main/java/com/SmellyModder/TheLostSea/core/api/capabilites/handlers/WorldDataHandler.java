package com.SmellyModder.TheLostSea.core.api.capabilites.handlers;

import com.SmellyModder.TheLostSea.core.api.capabilites.IOverworldData;
import com.SmellyModder.TheLostSea.core.api.capabilites.LostSeaWorldCapabilties;
import com.SmellyModder.TheLostSea.core.api.capabilites.controllers.OverworldDataController;
import com.SmellyModder.TheLostSea.core.api.capabilites.storage.OverworldDataStorage;
import com.SmellyModder.TheLostSea.core.util.Reference;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.provider.DialogueProviderN;
import com.SmellyModder.TheLostSea.core.util.player.CoinProvider;
import com.SmellyModder.TheLostSea.core.util.player.shoputil.CoinCurrency;
import com.SmellyModder.TheLostSea.core.util.player.shoputil.CoinStorage;
import com.SmellyModder.TheLostSea.core.util.player.shoputil.ICurrency;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WorldDataHandler {

	public static final ResourceLocation NURM_SHOP_CAP = new ResourceLocation(Reference.MOD_ID, "nurm_shop_cap");
	
	public static void register()
    {
        CapabilityManager.INSTANCE.register(IOverworldData.class, new OverworldDataStorage(), OverworldDataController.class);
    }
	
	@SubscribeEvent 
	public void attachCapability(AttachCapabilitiesEvent<World> event) 
	{
		event.addCapability(NURM_SHOP_CAP, new LostSeaWorldCapabilties()); 
	}
}
