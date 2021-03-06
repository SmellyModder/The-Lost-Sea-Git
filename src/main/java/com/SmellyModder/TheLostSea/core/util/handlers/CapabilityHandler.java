package com.SmellyModder.TheLostSea.core.util.handlers;

import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.api.capabilites.EquippableCapabilties;
import com.SmellyModder.TheLostSea.core.api.capabilites.IEquippableItemHandler;
import com.SmellyModder.TheLostSea.core.api.relics.EquippableType;
import com.SmellyModder.TheLostSea.core.api.relics.FakeEquippable;
import com.SmellyModder.TheLostSea.core.api.relics.IEquippable;
import com.SmellyModder.TheLostSea.core.util.Reference;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.DialogueControllerN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.DialogueProviderN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.IDialogueNurm;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.DialogueStorageN;
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
	public static final ResourceLocation EQUIPPABLE_ITEM_HANDLER_CAP = new ResourceLocation(Reference.MOD_ID, "equip_cap");
	public static final ResourceLocation EQUIPPABLE_CAP = new ResourceLocation(Reference.MOD_ID, "equip_cap");
	
	public static void register() {
        CapabilityManager.INSTANCE.register(ICurrency.class, new CoinStorage(), CoinCurrency.class);
        CapabilityManager.INSTANCE.register(IDialogueNurm.class, new DialogueStorageN(), DialogueControllerN.class);
        CapabilityManager.INSTANCE.register(IEquippable.class, new EquippableCapabilties.CapabilityItemEquippableStorage(), () -> new FakeEquippable(EquippableType.RELIC));
    }
	
	@SubscribeEvent 
	public void attachCapability(AttachCapabilitiesEvent event) {
		if (!(event.getObject() instanceof EntityPlayer)) return;
		event.addCapability(COIN_CAP, new CoinProvider());
		event.addCapability(NURM_DIALOGUE_CAP, new DialogueProviderN());
	}
}
