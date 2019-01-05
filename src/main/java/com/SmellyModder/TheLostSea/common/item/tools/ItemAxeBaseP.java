package com.SmellyModder.TheLostSea.common.item.tools;

import java.util.List;

import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.util.IHasModel;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ItemAxeBaseP extends ItemAxe implements IHasModel {
	
	public ItemAxeBaseP(String name, ToolMaterial material) 
	{ 
		super(material, 6.0F, -3.2F);
		setRegistryName(name);
		setTranslationKey(name);
		setCreativeTab(TheLostSea.TLS_GEAR);
		TLSItems.ITEMS.add(this);
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
		if (isInCreativeTab(tab)) {
			ItemStack istack = new ItemStack(this);
			istack.addEnchantment(Enchantments.KNOCKBACK, 2);
			istack.addEnchantment(Enchantments.SHARPNESS, 2);
			list.add(istack);
		}
	}
	
	@Override
	public void registerModels() {
		
		TheLostSea.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	
	
}
