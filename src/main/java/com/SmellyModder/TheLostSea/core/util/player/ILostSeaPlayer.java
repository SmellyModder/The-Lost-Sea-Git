package com.SmellyModder.TheLostSea.core.util.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public interface ILostSeaPlayer {

	/**
	 * @return The {@link EntityPlayer} entity this capability belongs to.
	 */
	EntityPlayer getEntity();
	
	/**
	 * Writes this capability to {@param tag}.
	 * @param tag The {@link NBTTagCompound} to write to
	 */
	void write(NBTTagCompound tag);

	/**
	 * Updates this capability from {@param tag}.
	 * @param tag The {@link NBTTagCompound} to read from
	 */
	void read(NBTTagCompound tag);

	/**
	 * Called when a player logs in.
	 */
	void onEntityJoinWorld();
}
