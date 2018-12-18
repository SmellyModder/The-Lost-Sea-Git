package com.SmellyModder.TheLostSea.common.item.specialtools.exotics;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.item.ItemTool;

public class ItemSpecial extends ItemTool {

	protected ItemSpecial(float attackDamageIn, float attackSpeedIn, ToolMaterial materialIn,
			Set<Block> effectiveBlocksIn) {
		super(attackDamageIn, attackSpeedIn, materialIn, effectiveBlocksIn);
	}

}
