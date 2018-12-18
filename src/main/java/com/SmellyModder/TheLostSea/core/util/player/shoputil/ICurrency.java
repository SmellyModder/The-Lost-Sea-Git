package com.SmellyModder.TheLostSea.core.util.player.shoputil;

public interface ICurrency {
	
	public void consume(int coins); 
	public void fill(int coins); 
	public void set(int coins); 
	
	public int getCoins();
}
