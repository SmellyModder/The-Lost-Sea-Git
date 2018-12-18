package com.SmellyModder.TheLostSea.core.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TP extends Teleporter{

	private final WorldServer world;
	private double x,y,z;
	
	
	public TP(WorldServer world, double x, double y, double z) {
		super(world);
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public void placeInPortal(Entity entityIn, float rotationYaw) {
		
		this.world.getBlockState(new BlockPos((int)this.x, (int)this.y, (int)this.z));
		entityIn.setPosition(x, y, z);
		entityIn.motionX = 0f;
		entityIn.motionY = 0f;
		entityIn.motionZ = 0f;
	}
	
	public static void TeleportToDimension(EntityPlayer player, int dimension, double x, double y, double z) {
		
		int oldDimension = player.getEntityWorld().provider.getDimension();
		EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;
		MinecraftServer server = player.getEntityWorld().getMinecraftServer();
		WorldServer worldserver = server.getWorld(dimension);
		
		if(worldserver == null || server == null) throw new IllegalArgumentException("Dimension: " + dimension + " Cannot be found");
		worldserver.getMinecraftServer().getPlayerList().transferPlayerToDimension(entityPlayerMP, dimension, new TP(worldserver, x, y, z));
		player.setPositionAndUpdate(x, y, z);
	}

}
