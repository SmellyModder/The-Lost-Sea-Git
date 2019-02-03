package com.SmellyModder.TheLostSea.core.api.capabilites;

import com.SmellyModder.TheLostSea.core.api.relics.IEquippable;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.interfaces.IDialogueNurm;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class LostSeaWorldCapabilties implements ICapabilitySerializable<NBTBase> { 
	
	@CapabilityInject(IOverworldData.class) 
	public static final Capability<IOverworldData> NURM_SHOP_CAP = null; 

	private IOverworldData instance = NURM_SHOP_CAP.getDefaultInstance();

	@Override 
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) 
	{ 
		return capability == NURM_SHOP_CAP; 
	} 

	@Override 
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) 
	{ 
		return capability == NURM_SHOP_CAP ? NURM_SHOP_CAP.<T> cast(this.instance) : null; 
	} 

	@Override 
	public NBTBase serializeNBT() 
	{ 
		return NURM_SHOP_CAP.getStorage().writeNBT(NURM_SHOP_CAP, this.instance, null); 
	} 

	@Override 
	public void deserializeNBT(NBTBase nbt) 
	{ 
		NURM_SHOP_CAP.getStorage().readNBT(NURM_SHOP_CAP, this.instance, null, nbt); 
	}

}
