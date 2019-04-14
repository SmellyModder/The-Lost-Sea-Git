package com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class DialogueStorageN implements IStorage<IDialogueNurm> {
	@Override 
	public NBTBase writeNBT(Capability<IDialogueNurm> capability, IDialogueNurm instance, EnumFacing side) { 
		return new NBTTagInt(instance.getVerse()); 
	}
	
	@Override 
	public void readNBT(Capability<IDialogueNurm> capability, IDialogueNurm instance, EnumFacing side, NBTBase nbt) { 
		instance.setVerse(((NBTPrimitive) nbt).getInt()); 
	}
}
