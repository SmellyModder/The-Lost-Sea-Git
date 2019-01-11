package com.SmellyModder.TheLostSea.common.item.armor;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.SmellyModder.TheLostSea.common.init.TLSEnchants;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.util.IHasModel;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemArmorBase extends ItemArmor implements IHasModel{

	public ItemArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(TheLostSea.TLS_GEAR);
		TLSItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		
		TheLostSea.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
