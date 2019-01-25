package com.SmellyModder.TheLostSea.common.world.overworld.interfaces;

import net.minecraft.network.play.client.CPacketPlayer.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraftforge.fml.common.FMLCommonHandler;

public interface IStructure {
	public static final WorldServer worldServer = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(0);
	public static final PlacementSettings settings = (new PlacementSettings()).setChunk(null).setIgnoreEntities(false).setIgnoreStructureBlock(true).setMirror(Mirror.NONE).setRotation(net.minecraft.util.Rotation.NONE);
}