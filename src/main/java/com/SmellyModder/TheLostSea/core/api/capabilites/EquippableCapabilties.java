package com.SmellyModder.TheLostSea.core.api.capabilites;

import com.SmellyModder.TheLostSea.core.api.relics.IEquippable;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class EquippableCapabilties {
	@CapabilityInject(IEquippableItemHandler.class)
	public static final Capability<IEquippableItemHandler> CAPABILITY_EQUIPPABLES = null;

	@CapabilityInject(IEquippable.class)
	public static final Capability<IEquippable> CAPABILITY_ITEM_EQUIPPABLES = null;

	public static class CapabilityEquippable<T extends IEquippableItemHandler> implements IStorage<IEquippableItemHandler> {

		@Override
		public NBTBase writeNBT (Capability<IEquippableItemHandler> capability, IEquippableItemHandler instance, EnumFacing side) {
			return null;
		}
		
		@Override
		public void readNBT (Capability<IEquippableItemHandler> capability, IEquippableItemHandler instance, EnumFacing side, NBTBase nbt) {}
	}
	
	public static class CapabilityItemEquippableStorage implements IStorage<IEquippable> {

		@Override
		public NBTBase writeNBT (Capability<IEquippable> capability, IEquippable instance, EnumFacing side) {
			return null;
		}

		@Override
		public void readNBT (Capability<IEquippable> capability, IEquippable instance, EnumFacing side, NBTBase nbt) {

		}
	}
	
}
