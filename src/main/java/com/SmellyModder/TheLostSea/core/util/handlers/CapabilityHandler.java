package com.SmellyModder.TheLostSea.core.util.handlers;

import com.SmellyModder.TheLostSea.core.util.Reference;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.player.CoinProvider;
import com.SmellyModder.TheLostSea.core.util.player.shoputil.CoinCurrency;
import com.SmellyModder.TheLostSea.core.util.player.shoputil.CoinStorage;
import com.SmellyModder.TheLostSea.core.util.player.shoputil.ICurrency;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class CapabilityHandler {

	public static final ResourceLocation COIN_CAP = new ResourceLocation(Reference.MOD_ID, "coins");
	
	public static void register()
    {
        CapabilityManager.INSTANCE.register(ICurrency.class, new CoinStorage(), CoinCurrency.class);
    }
	
	@SubscribeEvent 
	public void attachCapability(AttachCapabilitiesEvent event) 
	{
		if (!(event.getObject() instanceof EntityPlayer)) return; 

		event.addCapability(COIN_CAP, new CoinProvider()); 
	} 
}
