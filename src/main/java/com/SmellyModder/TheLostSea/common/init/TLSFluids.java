package com.SmellyModder.TheLostSea.common.init;

import com.SmellyModder.TheLostSea.common.blocks.fluid.FluidDarkWater;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class TLSFluids {

	public static final Fluid DARKWATER = new FluidDarkWater();

    public static void register() {
        FluidRegistry.registerFluid(DARKWATER);
        FluidRegistry.addBucketForFluid(DARKWATER);
        FluidRegistry.enableUniversalBucket();
    }
}
