package com.SmellyModder.TheLostSea.core.api.worlddata;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;

public class NurmWorldData extends WorldSavedData {

	private static final String NURM_SHOP = "thelostsea" + "nurm_shops";
	
	private static NBTTagCompound data = new NBTTagCompound();
	
	public NurmWorldData() {
		super(NURM_SHOP);
	}
	
	public NurmWorldData(String name) {
		super(name);
	}
	
	public static void setInt() {
		data.getCompoundTag("shops").setInteger("shops_generated", 1);
	}
	
	public static int getInt() {
		return data.getCompoundTag("shops").getInteger("shops_generated");
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		data.getCompoundTag("shops").getInteger("shops_generated");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setTag("shops", data);
		return compound;
	}
	
	@Override
	public void markDirty() {
		super.markDirty();
	}
	
	public NBTTagCompound getData() {
        return data;
    }
	
	public static NurmWorldData get(World world) {
		MapStorage storage = world.getMapStorage();
		NurmWorldData instance = (NurmWorldData) storage.getOrLoadData(NurmWorldData.class, NURM_SHOP);
		if (instance == null) {
			    instance = new NurmWorldData();
			    storage.setData(NURM_SHOP, instance);
		}
		return instance;
	}
}
