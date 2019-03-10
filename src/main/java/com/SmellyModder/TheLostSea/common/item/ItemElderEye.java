package com.SmellyModder.TheLostSea.common.item;

import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.api.LostSeaAPI;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemElderEye extends ItemBase {

	public ItemElderEye(String name) {
		super(name);
		this.setCreativeTab(TheLostSea.TLS_SPECIAL);
	}

}
