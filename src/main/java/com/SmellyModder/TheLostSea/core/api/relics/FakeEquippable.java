package com.SmellyModder.TheLostSea.core.api.relics;

import com.SmellyModder.TheLostSea.common.item.ItemBase;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;

public class FakeEquippable implements IEquippable
{
	private EquippableType equippableType;

	public FakeEquippable(EquippableType type) {
		equippableType = type;
	}

	@Override
	public EquippableType getEquippableType(ItemStack stack) {
		return equippableType;
	}

}
