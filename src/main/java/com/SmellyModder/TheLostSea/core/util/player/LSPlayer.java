package com.SmellyModder.TheLostSea.core.util.player;

import com.mojang.authlib.GameProfile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class LSPlayer implements ILostSeaPlayer{

	private final EntityPlayer entity;
	
	public LSPlayer()
	{
		this.entity = null;
	}
	
	public LSPlayer(final EntityPlayer entity)
	{
		this.entity = entity;
	}
	
//	public static LSPlayer getPlayer(final Entity player)
//	{
//		if (player == null)
//		{
//			return null;
//		}
//
//		if (!LSPlayer.hasCapability(player))
//		{
//			return null;
//		}
//
//		return (LSPlayer) player.getCapability(LSCapabilities.PLAYER_DATA, null);
//	}


	@Override
	public EntityPlayer getEntity() {
		return entity;
	}

	@Override
	public void write(NBTTagCompound tag) {
	}

	@Override
	public void read(NBTTagCompound tag) {
	}

	@Override
	public void onEntityJoinWorld() {
	}

	
}
