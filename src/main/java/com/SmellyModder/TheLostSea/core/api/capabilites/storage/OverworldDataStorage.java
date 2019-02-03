package com.SmellyModder.TheLostSea.core.api.capabilites.storage;

import com.SmellyModder.TheLostSea.core.api.capabilites.IOverworldData;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.interfaces.IDialogueNurm;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class OverworldDataStorage implements IStorage<IOverworldData> {

	@Override 
	public NBTBase writeNBT(Capability<IOverworldData> capability, IOverworldData instance, EnumFacing side) 
	{ 
		return new NBTTagInt(instance.getNurmShopGenerated()); 
	} 

	@Override 
	public void readNBT(Capability<IOverworldData> capability, IOverworldData instance, EnumFacing side, NBTBase nbt) 
	{ 
		instance.setNurmShopGenerated(((NBTPrimitive) nbt).getInt()); 
	}

}
