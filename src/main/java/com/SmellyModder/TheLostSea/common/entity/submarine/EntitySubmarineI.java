package com.SmellyModder.TheLostSea.common.entity.submarine;

import com.SmellyModder.TheLostSea.common.entity.bases.AbstractSubmarine;
import com.SmellyModder.TheLostSea.common.init.TLSItems;

import java.util.List;

import com.SmellyModder.TheLostSea.common.blocks.util.BlockSubmarineArmPart;

import com.SmellyModder.TheLostSea.common.blocks.util.ItemSubType;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBoat;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
/**
 * 
 * @author SmellyModder
 *
 */

public class EntitySubmarineI extends AbstractSubmarine{

	private static final DataParameter<Integer> SUBMARINE_COLOR = EntityDataManager.<Integer>createKey(EntitySubmarineI.class, DataSerializers.VARINT);
	
	public EntitySubmarineI(World worldIn) {
		super(worldIn);
		this.setSize(2.2F, 1.95F);
	}
	
	protected void initEntityAI()
    {
        this.tasks.addTask(9, new EntityAISwimming(this));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(125.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(125.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(6.0D);
    }
    
    
    @Override
    public boolean shouldDismountInWater(Entity rider)
    {
        return false;
    }
    
    @Override
    public boolean isPushedByWater()
    {
        return false;
    }
    
    @Override
    protected float getWaterSlowDown() {
    	
    	return 0.92F;
    }
    
    protected void entityInit()
    {
    	super.entityInit();
    	this.dataManager.register(SUBMARINE_COLOR, Integer.valueOf(15));
    }
    
    public Item getItemBoat()
    {
        switch (this.getBoatType())
        {
            case RED:
            default:
                return TLSItems.RED_SUBMARINE;
            case ORANGE:
                return TLSItems.ORANGE_SUBMARINE;
            case YELLOW:
                return TLSItems.YELLOW_SUBMARINE;
            case LIME:
                return TLSItems.LIME_SUBMARINE;
            case GREEN:
                return TLSItems.GREEN_SUBMARINE;
            case BLUE:
                return TLSItems.BLUE_SUBMARINE;
            case LIGHTBLUE:
                return TLSItems.LIGHTBLUE_SUBMARINE;
            case CYAN:
                return TLSItems.CYAN_SUBMARINE;
            case PURPLE:
                return TLSItems.PURPLE_SUBMARINE;
            case MAGENTA:
                return TLSItems.MAGENTA_SUBMARINE;
        }
    }

    
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        compound.setString("Type", this.getBoatType().getName());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        if (compound.hasKey("Type", 8))
        {
            this.setBoatType(EntitySubmarineI.Type.getTypeFromString(compound.getString("Type")));
        }
    }
    
    public void setBoatType(EntitySubmarineI.Type boatType)
    {
        this.dataManager.set(SUBMARINE_COLOR, Integer.valueOf(boatType.ordinal()));
    }

    public EntitySubmarineI.Type getBoatType()
    {
        return EntitySubmarineI.Type.byId(((Integer)this.dataManager.get(SUBMARINE_COLOR)).intValue());
    }
   
    public int getSubType() {
        return this.dataManager.get(SUBMARINE_COLOR);
    }
 
    public void setSubType(int subtype) {
        this.dataManager.set(SUBMARINE_COLOR, Integer.valueOf(subtype));
    }
    /*
     * Magic color shit- Just notifies which order to put it in
     */
    public static enum Type
    {
        RED(BlockSubmarineArmPart.EnumType.RED.getMetadata(), "red"),
        ORANGE(BlockSubmarineArmPart.EnumType.ORANGE.getMetadata(), "orange"),
        YELLOW(BlockSubmarineArmPart.EnumType.YELLOW.getMetadata(), "yellow"),
        LIME(BlockSubmarineArmPart.EnumType.LIMEGREEN.getMetadata(), "lime"),
        GREEN(BlockSubmarineArmPart.EnumType.GREEN.getMetadata(), "green"),
        BLUE(BlockSubmarineArmPart.EnumType.BLUE.getMetadata(), "blue"),
        LIGHTBLUE(BlockSubmarineArmPart.EnumType.LIGHTBLUE.getMetadata(), "lightblue"),
        CYAN(BlockSubmarineArmPart.EnumType.CYAN.getMetadata(), "cyan"),
        PURPLE(BlockSubmarineArmPart.EnumType.PURPLE.getMetadata(), "purple"),
        MAGENTA(BlockSubmarineArmPart.EnumType.MAGENTA.getMetadata(), "magenta"),
        PINK(BlockSubmarineArmPart.EnumType.PINK.getMetadata(), "pink"),
        BROWN(BlockSubmarineArmPart.EnumType.BROWN.getMetadata(), "brown"),
        BLACK(BlockSubmarineArmPart.EnumType.BLACK.getMetadata(), "black"),
        GRAY(BlockSubmarineArmPart.EnumType.GRAY.getMetadata(), "gray"),
        LIGHTGRAY(BlockSubmarineArmPart.EnumType.LIGHTGRAY.getMetadata(), "lightgray"),
        WHITE(BlockSubmarineArmPart.EnumType.WHITE.getMetadata(), "white");

        private final String name;
        private final int metadata;

        private Type(int metadataIn, String nameIn)
        {
            this.name = nameIn;
            this.metadata = metadataIn;
        }

        public String getName()
        {
            return this.name;
        }

        public int getMetadata()
        {
            return this.metadata;
        }

        public String toString()
        {
            return this.name;
        }

        /**
         * Get a boat type by it's enum ordinal
         */
        public static EntitySubmarineI.Type byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }

            return values()[id];
        }

        public static EntitySubmarineI.Type getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getName().equals(nameIn))
                {
                    return values()[i];
                }
            }

            return values()[0];
        }
    }
	@Override
	public void onInventoryChanged(IInventory invBasic) {
		
	}
}
