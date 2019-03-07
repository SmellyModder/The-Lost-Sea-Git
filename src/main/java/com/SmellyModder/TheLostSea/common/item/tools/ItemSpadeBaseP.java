package com.SmellyModder.TheLostSea.common.item.tools;

import java.util.List;

import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemSpadeBaseP extends ItemSpade implements IHasModel{

	public ItemSpadeBaseP(String name, ToolMaterial material) 
	{ 
		super(material);
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
			istack.addEnchantment(Enchantments.EFFICIENCY, 2);
			list.add(istack);
		}
	}

	@Override
	public void registerModels() {
	
		TheLostSea.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
