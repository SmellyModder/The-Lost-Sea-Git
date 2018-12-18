package com.SmellyModder.TheLostSea.common.item.specialtools;

import com.SmellyModder.TheLostSea.common.entity.EntityAnglerfish;
import com.SmellyModder.TheLostSea.common.entity.submarine.EntitySubmarineI;
import com.SmellyModder.TheLostSea.common.item.ItemBase;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemFishBucket extends ItemBase {

	
	public ItemFishBucket(String name) {
		super(name);
	}
	
	@Override
	public EnumActionResult onItemUseFirst(EntityPlayer entity, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ,
			EnumHand hand) {
		float var4 = 1.0F;
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();

		if (true) {
			 world.playSound((EntityPlayer)null, entity.posX, entity.posY, entity.posZ, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		}

		if (true) {
			if (entity != null && !world.isRemote) {
				EntityAnglerfish sentity = new EntityAnglerfish(world);
				sentity.setLocationAndAngles(i, j, k, world.rand.nextFloat() * 360F, 0.0F);
				world.spawnEntity(sentity);
			}
		}

		return EnumActionResult.PASS;
	}

}
