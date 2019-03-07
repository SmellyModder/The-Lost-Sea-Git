package com.SmellyModder.TheLostSea.common.item.tools;

import java.util.List;
import java.util.Set;

import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemPickaxeBaseP extends ItemPickaxe  implements IHasModel{

	public ItemPickaxeBaseP(String name, ToolMaterial material) 
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
