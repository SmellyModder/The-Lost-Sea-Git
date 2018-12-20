package com.SmellyModder.TheLostSea.core.util.handlers;

import com.SmellyModder.TheLostSea.core.util.Reference;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.I.IDialogueNurm;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.I.IStepGetterN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.controller.DialogueControllerN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.controller.StepControllerN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.provider.DialogueProviderN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.provider.StepProviderN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.storage.StepStorageN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.storage.VerseStorageN;
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
	public static final ResourceLocation NURM_DIALOGUE_CAP = new ResourceLocation(Reference.MOD_ID, "nurm_cap");
	public static final ResourceLocation NURM_STEP_CAP = new ResourceLocation(Reference.MOD_ID, "nurm_step_cap");
	
	public static void register()
    {
        CapabilityManager.INSTANCE.register(ICurrency.class, new CoinStorage(), CoinCurrency.class);
        CapabilityManager.INSTANCE.register(IDialogueNurm.class, new VerseStorageN(), DialogueControllerN.class);
        CapabilityManager.INSTANCE.register(IStepGetterN.class, new StepStorageN(), StepControllerN.class);
    }
	
	@SubscribeEvent 
	public void attachCapability(AttachCapabilitiesEvent event) 
	{
		if (!(event.getObject() instanceof EntityPlayer)) return; 

		event.addCapability(COIN_CAP, new CoinProvider()); 
		event.addCapability(NURM_DIALOGUE_CAP, new DialogueProviderN());
		event.addCapability(NURM_STEP_CAP, new StepProviderN());
	}
}
