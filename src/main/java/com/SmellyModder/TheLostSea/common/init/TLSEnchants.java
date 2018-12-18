package com.SmellyModder.TheLostSea.common.init;

import java.util.ArrayList;
import java.util.List;

import com.SmellyModder.TheLostSea.common.enchants.disc.EnchantmentDoubleTrouble;
import com.SmellyModder.TheLostSea.common.enchants.disc.EnchantmentRecharge;
import com.SmellyModder.TheLostSea.common.enchants.disc.EnchantmentZeusThrower;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class TLSEnchants {
	
	public static final List<Enchantment> ENCHANTS = new ArrayList<Enchantment>();
	
	public static final Enchantment ZEUS_THROWER = new EnchantmentZeusThrower(new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
	
	public static final Enchantment DOUBLE_TROUBLE = new EnchantmentDoubleTrouble(new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
	
	public static final Enchantment RECHARGE = new EnchantmentRecharge(new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
}
