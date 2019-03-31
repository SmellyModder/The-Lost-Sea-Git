package com.SmellyModder.TheLostSea.common.enchants.disc;

import com.SmellyModder.TheLostSea.common.init.TLSEnchants;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;

public class EnchantmentZeusThrower extends Enchantment {

	public EnchantmentZeusThrower(EntityEquipmentSlot... slots) {
		super(Rarity.RARE, EnumEnchantmentType.ALL, slots);
		this.setName("zeus_thrower");
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":zeus_thrower"));
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
		return super.canApplyTogether(ench);
	}
}
