package com.SmellyModder.TheLostSea.common.enchants.tools;

import com.SmellyModder.TheLostSea.common.init.TLSEnchants;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class EnchantmentAntiChloride extends Enchantment{
	
	public EnchantmentAntiChloride(EntityEquipmentSlot... slots) {
		super(Rarity.VERY_RARE, EnumEnchantmentType.ALL, slots);
		this.setName("anti_chloride");
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":anti_chloride"));
		
		TLSEnchants.ENCHANTS.add(this);
	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return 20 * enchantmentLevel;
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return this.getMinEnchantability(enchantmentLevel) + 10;
	}
	
	@Override
	public int getMaxLevel() {
		return 1;
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		return true;
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return false;
	}
	
	@Override
	public boolean isTreasureEnchantment() {
		return true;
	}
}
