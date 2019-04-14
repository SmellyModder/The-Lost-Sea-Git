package com.SmellyModder.TheLostSea.core.util;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class LSMathHelper {

	 public static final float SQRT_2 = sqrt(2.0F);
	    /** A table of sin values computed from 0 (inclusive) to 2*pi (exclusive), with steps of 2*PI / 65536. */
	    private static final float[] SIN_TABLE = new float[65536];
	    private static final Random RANDOM = new Random();
	    
	    public static float sqrt(float value)
	    {
	        return (float)Math.sqrt((double)value);
	    }
	    
	    /**
	     * sin looked up in a table
	     */
	    public static float sin(float value)
	    {
	        return SIN_TABLE[(int)(value * 10430.378F) & 65535];
	    }

	    /**
	     * cos looked up in the sin table with the appropriate offset
	     */
	    public static float cos(float value)
	    {
	        return SIN_TABLE[(int)(value * 10430.378F + 16384.0F) & 65535];
	    }
	    
	    public static float flap(Entity entity, float partial)
	    {
	        return sin((entity.ticksExisted + partial) * 0.5F) * 0.6F;
	    }
	    
	    public static float flapInverted(float value, Entity entity, float partial)
	    {
	        return -cos((entity.ticksExisted + partial) * 0.5F) * 0.6F;
	    }
	    
	    public static float square(float value) {
	    	return value * value;
	    }
	    
	    public static float squareInverted(float value) {
	    	return (float) ((value * value) / MathHelper.fastInvSqrt(value));
	    }
}
