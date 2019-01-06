package com.SmellyModder.TheLostSea.common.entity.projectiles;

import javax.annotation.Nullable;

import com.SmellyModder.TheLostSea.client.render.RenderDisc;
import com.SmellyModder.TheLostSea.common.init.TLSItems;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class EntityFinnedArrowTest extends EntityArrow
{
	
	public EntityFinnedArrowTest(World worldIn, double x, double y, double z)
	{
		super(worldIn);
		this.setPosition(x, y, z);
	}
	
	public EntityFinnedArrowTest(World worldIn, EntityLivingBase shooter)
    {
        super(worldIn, shooter);
    }

	
	public EntityFinnedArrowTest(World worldIn) {
		super(worldIn);
		setSize(1.0F, 1.0F);
		this.setVelocity(5.0F, 5.0F, 5.0F);
	}
	
	@Override
	protected ItemStack getArrowStack() 
	{
		return new ItemStack(TLSItems.FINNED_ARROW);
	}
	
	@Override
	public double getDamage() {
		return 5.0F;
	}
	
	@Override
	public void onEntityUpdate() 
	{
		if(this.isInWater())
		{
			this.setVelocity(5.0F * 2, 5.0F * 2, 5.0F * 2);
		}
		super.onEntityUpdate();
	}
	
}
