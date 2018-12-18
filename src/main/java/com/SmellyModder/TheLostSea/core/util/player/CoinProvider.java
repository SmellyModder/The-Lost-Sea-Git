package com.SmellyModder.TheLostSea.core.util.player;

import com.SmellyModder.TheLostSea.core.util.player.shoputil.ICurrency;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class CoinProvider implements ICapabilitySerializable<NBTBase> 
{ 
	@CapabilityInject(ICurrency.class) 
	public static final Capability<ICurrency> COIN_CAP = null; 

	private ICurrency instance = COIN_CAP.getDefaultInstance(); 

	@Override 
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) 
	{ 
		return capability == COIN_CAP; 
	} 

	@Override 
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) 
	{ 
		return capability == COIN_CAP ? COIN_CAP.<T> cast(this.instance) : null; 
	} 

	@Override 
	public NBTBase serializeNBT() 
	{ 
		return COIN_CAP.getStorage().writeNBT(COIN_CAP, this.instance, null); 
	} 

	@Override 
	public void deserializeNBT(NBTBase nbt) 
	{ 
		COIN_CAP.getStorage().readNBT(COIN_CAP, this.instance, null, nbt); 
	} 

}
