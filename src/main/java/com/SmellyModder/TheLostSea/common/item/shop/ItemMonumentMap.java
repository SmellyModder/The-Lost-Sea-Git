package com.SmellyModder.TheLostSea.common.item.shop;

import java.util.Locale;

import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.util.IHasModel;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapData;
import net.minecraft.world.storage.MapDecoration;

public class ItemMonumentMap extends ItemMap implements IHasModel{
	
	public ItemMonumentMap(String name) {
		this.setRegistryName(name);
		this.setTranslationKey(name);
		this.setCreativeTab(null);
		
		TLSItems.ITEMS.add(this);
	}
	
	public static ItemStack stack;
	
	public ItemMonumentMap(String name, EntityPlayer player) {
		this.setRegistryName(name);
		this.setTranslationKey(name);
		this.setCreativeTab(null);
		
		TLSItems.ITEMS.add(this);
		
		World world = player.getEntityWorld();
        BlockPos blockpos = world.findNearestStructure("Monument", player.getPosition(), true);

        if (blockpos != null)
        {
            stack = ItemMap.setupNewMap(world, (double)blockpos.getX(), (double)blockpos.getZ(), (byte)2, true, true);
            ItemMap.renderBiomePreviewMap(world, stack);
            MapData.addTargetDecoration(stack, blockpos, "+", MapDecoration.Type.MONUMENT);
        }
	}

	@Override
	public void registerModels() {
		TheLostSea.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
