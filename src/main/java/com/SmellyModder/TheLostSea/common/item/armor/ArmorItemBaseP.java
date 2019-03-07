package com.SmellyModder.TheLostSea.common.item.armor;

import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

import java.util.List;

public class ArmorItemBaseP extends ItemArmor implements IHasModel{

	public ArmorItemBaseP(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(TheLostSea.TLS_GEAR);
		TLSItems.ITEMS.add(this);
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
		if (isInCreativeTab(tab)) {
			ItemStack istack = new ItemStack(this);
			switch (this.armorType) {
				case HEAD:
					istack.addEnchantment(Enchantments.RESPIRATION, 10);
					break;
				case CHEST:
					istack.addEnchantment(Enchantments.PROTECTION, 10);
					break;
				case LEGS:
					istack.addEnchantment(Enchantments.THORNS, 10);
					break;
				case FEET:
					istack.addEnchantment(Enchantments.DEPTH_STRIDER, 5);
					break;
				default:
					break;
			}
			list.add(istack);
		}
	}
	
	@Override
	public void registerModels() {
		
		TheLostSea.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	@Override
	public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
		list.add("Rarity:" + " §5§lLegendary§r");
	}
	
}
