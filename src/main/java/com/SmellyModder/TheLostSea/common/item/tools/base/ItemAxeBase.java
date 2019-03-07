package com.SmellyModder.TheLostSea.common.item.tools.base;

import java.util.List;

import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ItemAxeBase extends ItemAxe implements IHasModel {
	
	public ItemAxeBase(String name, ToolMaterial material) 
	{ 
		super(material, 8.0F, -3.2F);
		setRegistryName(name);
		setTranslationKey(name);
		setCreativeTab(TheLostSea.TLS_GEAR);
		TLSItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		
		TheLostSea.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
}
