package com.SmellyModder.TheLostSea.core.util.player.shoputil;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class CoinStorage implements IStorage<ICurrency> {

	@Override 
	public NBTBase writeNBT(Capability<ICurrency> capability, ICurrency instance, EnumFacing side) 
	{ 
		return new NBTTagInt(instance.getCoins()); 
	} 

	@Override 
	public void readNBT(Capability<ICurrency> capability, ICurrency instance, EnumFacing side, NBTBase nbt) 
	{ 
		instance.set(((NBTPrimitive) nbt).getInt()); 
	} 
}
