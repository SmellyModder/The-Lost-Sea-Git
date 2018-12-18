package com.SmellyModder.TheLostSea.client.lighting;

import java.util.ArrayList;

import net.minecraftforge.fml.common.eventhandler.Event;

public class LightGatherer extends Event{
	
	ArrayList<BasicLight> lights = new ArrayList<BasicLight>();
	public LightGatherer(ArrayList<BasicLight> lights){
		super();
		this.lights = lights;
	}
	public ArrayList<BasicLight> getBasicLightList(){
		return lights;
	}
	@Override
	public boolean isCancelable(){
		return false;
	}
}
