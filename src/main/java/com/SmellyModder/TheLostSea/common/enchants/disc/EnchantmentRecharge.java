package com.SmellyModder.TheLostSea.common.enchants.disc;

import com.SmellyModder.TheLostSea.common.init.TLSEnchants;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;

public class EnchantmentRecharge extends Enchantment{

	public EnchantmentRecharge(EntityEquipmentSlot... slots) {
		super(Rarity.VERY_RARE, EnumEnchantmentType.ALL, slots);
		this.setName("recharge");
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":recharge"));
		
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
		return 3;
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		return super.canApplyTogether(ench) && ench != TLSEnchants.DOUBLE_TROUBLE;
	}


}
