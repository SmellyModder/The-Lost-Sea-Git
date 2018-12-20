package com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.provider;


import com.SmellyModder.TheLostSea.core.util.npc.dialogue.interfaces.IDialogueNurm;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class DialogueProviderN implements ICapabilitySerializable<NBTBase> { 
	
		@CapabilityInject(IDialogueNurm.class) 
		public static final Capability<IDialogueNurm> DIALOGUE_CAP = null; 

		private IDialogueNurm instance = DIALOGUE_CAP.getDefaultInstance(); 

		@Override 
		public boolean hasCapability(Capability<?> capability, EnumFacing facing) 
		{ 
			return capability == DIALOGUE_CAP; 
		} 

		@Override 
		public <T> T getCapability(Capability<T> capability, EnumFacing facing) 
		{ 
			return capability == DIALOGUE_CAP ? DIALOGUE_CAP.<T> cast(this.instance) : null; 
		} 

		@Override 
		public NBTBase serializeNBT() 
		{ 
			return DIALOGUE_CAP.getStorage().writeNBT(DIALOGUE_CAP, this.instance, null); 
		} 

		@Override 
		public void deserializeNBT(NBTBase nbt) 
		{ 
			DIALOGUE_CAP.getStorage().readNBT(DIALOGUE_CAP, this.instance, null, nbt); 
		} 

	}
