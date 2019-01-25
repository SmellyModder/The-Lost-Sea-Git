package com.SmellyModder.TheLostSea.common.world.overworld;

import java.util.Random;

import com.SmellyModder.TheLostSea.common.world.overworld.interfaces.IStructure;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import scala.reflect.internal.Trees.Literal;
import scala.reflect.internal.Trees.Tree;
import scala.reflect.internal.Types.Type;
import scala.tools.nsc.Global;
import scala.tools.nsc.transform.patmat.Interface;

public class WorldGenStructureLS extends WorldGenerator implements IStructure {

	public static String structureName;
	
	public WorldGenStructureLS(String name) 
	{
		this.structureName = name;
	}
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) 
	{
		this.generateStructure(worldIn, position);
		return true;
	}
	
	public static void generateStructure(World world, BlockPos pos)
	{
		MinecraftServer mcServer = world.getMinecraftServer();
		TemplateManager manager = worldServer.getStructureTemplateManager();
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, structureName);
		Template template = manager.get(mcServer, location);
		
		if(template != null)
		{
			IBlockState state = world.getBlockState(pos);
			world.notifyBlockUpdate(pos, state, state, 3);
			template.addBlocksToWorldChunk(world, pos, settings);
		}
	}
}
