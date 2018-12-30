package com.SmellyModder.TheLostSea.common.tileentity.rewards;

import java.util.Random;

import com.SmellyModder.TheLostSea.client.particle.LostSeaParticles;
import com.SmellyModder.TheLostSea.common.init.TLSSounds;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class TileEntityStarterChest extends TileEntityChest {

	public int ticksSinceSync2;
	static boolean open = false;
	
    @Override
    public String getName() {
        return hasCustomName() ? customName : "tile.lostsea.starter_chest.name";
    }
    
    @Override
	public void update()
	{
		if (!this.world.isRemote && this.numPlayersUsing != 0 && (this.ticksSinceSync2 + pos.getX() + pos.getY() + pos.getZ()) % 200 == 0)
        {
            this.numPlayersUsing = 0;
            float f = 5.0F;

            for (EntityPlayer entityplayer : this.world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB((double)((float)pos.getX() - 5.0F), (double)((float)pos.getY() - 5.0F), (double)((float)pos.getZ() - 5.0F), (double)((float)(pos.getX() + 1) + 5.0F), (double)((float)(pos.getY() + 1) + 5.0F), (double)((float)(pos.getZ() + 1) + 5.0F))))
            {
                if (entityplayer.openContainer instanceof ContainerChest)
                {
                    if (((ContainerChest)entityplayer.openContainer).getLowerChestInventory() == this)
                    {
                        ++this.numPlayersUsing;
                    }
                }
            }
        }
		
        this.prevLidAngle = this.lidAngle;
        float f1 = 0.1F;

        if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F)
        {
            double d1 = (double)pos.getX() + 0.5D;
            double d2 = (double)pos.getZ() + 0.5D;
            this.world.playSound((EntityPlayer)null, d1, (double)pos.getY() + 0.5D, d2, TLSSounds.COMMON_LOOT, SoundCategory.BLOCKS, 1.5F, 1F);
        }

        if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F)
        {
            float f2 = this.lidAngle;

            if (this.numPlayersUsing > 0)
            {
                this.lidAngle += 0.1F;
            }
            else
            {
                this.lidAngle -= 0.1F;
            }

            if (this.lidAngle > 1.0F)
            {
                this.lidAngle = 1.0F;
            }

            float f3 = 0.5F;

            if (this.lidAngle < 0.5F && f2 >= 0.5F)
            {
                double d3 = (double)pos.getX() + 0.5D;
                double d0 = (double)pos.getZ() + 0.5D;
                this.world.playSound((EntityPlayer)null, d3, (double)pos.getY() + 0.5D, d0, TLSSounds.COMMON_LOOT, SoundCategory.BLOCKS, 0.7F, 1F);
            }

            if (this.lidAngle < 0.0F)
            {
                this.lidAngle = 0.0F;
            }  
        }
        if(this.isOpen()) {
            	World world = this.getWorld();
            	Random rand = new Random();
            	for (int i = 0; i < 1; ++i)
                {
            		double d0 = (double)((float)pos.getX() + rand.nextFloat());
                    double d1 = (double)((float)pos.getY() + rand.nextFloat());
                    double d2 = (double)((float)pos.getZ() + rand.nextFloat());
                    double d3 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
                    double d4 = ((double)rand.nextFloat() - 0.5D) * (Math.random() * 0.5D);
                    double d5 = ((double)rand.nextFloat() - 0.5D) * (Math.random() * 0.5D);
            		LostSeaParticles.GOLD_DUST.spawn(world, d0, d1, d2, d3, d4, d5);
                }
            }
	}
    
    protected boolean isOpen() {
    	return this.lidAngle > 0 ? true : false;
    }
}
