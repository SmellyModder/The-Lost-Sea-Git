package com.SmellyModder.TheLostSea.common.entity.npc;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityLunete extends EntityLSNpcBase{

	private BlockPos spawned;
	
	public EntityLunete(World worldIn) {
		super(worldIn);
	}
	@Override
	public void onUpdate()
	{
		this.posX = this.prevPosX;
		this.posZ = this.prevPosZ;

		this.setHealth(this.getMaxHealth());
		this.isDead = false;

		if (this.spawned == null)
		{
			this.spawned = this.getPosition();
			this.setHomePosAndDistance(this.spawned, 3);
		}

		super.onUpdate();

		this.posX = this.prevPosX;
		this.posZ = this.prevPosZ;
	}
	@Override
	public int getID() {
		return 9;
	}

}
