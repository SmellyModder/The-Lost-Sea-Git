package com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.storage;

import com.SmellyModder.TheLostSea.core.util.npc.dialogue.I.IStepGetterN;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class StepStorageN implements IStorage<IStepGetterN> {

	@Override 
	public NBTBase writeNBT(Capability<IStepGetterN> capability, IStepGetterN instance, EnumFacing side) 
	{ 
		return new NBTTagInt(instance.getStep()); 
	} 

	@Override 
	public void readNBT(Capability<IStepGetterN> capability, IStepGetterN instance, EnumFacing side, NBTBase nbt) 
	{ 
		instance.setStep(((NBTPrimitive) nbt).getInt()); 
	}
}
