package com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.provider;

import com.SmellyModder.TheLostSea.core.util.npc.dialogue.I.IStepGetterN;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class StepProviderN implements ICapabilitySerializable<NBTBase> { 
	
	@CapabilityInject(IStepGetterN.class) 
	public static final Capability<IStepGetterN> CAP_S = null; 

	private IStepGetterN instance = CAP_S.getDefaultInstance(); 

	@Override 
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) 
	{ 
		return capability == CAP_S;
	} 

	@Override 
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) 
	{ 
		return capability == CAP_S ? CAP_S.<T> cast(this.instance) : null; 
	} 

	@Override 
	public NBTBase serializeNBT() 
	{ 
		return CAP_S.getStorage().writeNBT(CAP_S, this.instance, null); 
	} 

	@Override 
	public void deserializeNBT(NBTBase nbt) 
	{ 
		CAP_S.getStorage().readNBT(CAP_S, this.instance, null, nbt); 
	} 


}
