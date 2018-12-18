package com.SmellyModder.TheLostSea.common.blocks.fluid;

import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidDarkWater extends Fluid {
	
    private static final ResourceLocation STILL = new ResourceLocation(Reference.MOD_ID, "blocks/darkwater_still");
    private static final ResourceLocation FLOWING = new ResourceLocation(Reference.MOD_ID , "blocks/darkwater_flow");

    public FluidDarkWater() {
        super("darkwater", STILL, FLOWING);
        setUnlocalizedName(Reference.MOD_ID + ".darkwater");
        setDensity(3000);
        setViscosity(3000);
        setLuminosity(15);
        setTemperature(400);
    }
}
