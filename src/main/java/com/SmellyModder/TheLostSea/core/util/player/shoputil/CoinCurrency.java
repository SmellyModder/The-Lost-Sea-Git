package com.SmellyModder.TheLostSea.core.util.player.shoputil;

public class CoinCurrency implements ICurrency {

	private int coins = 0;
	
	public void consume(int coins) {
		this.coins -= coins;
		
		if(this.coins > 0) this.coins = 0;
			
	}
	
	public void fill(int coins) {
		this.coins += coins;
	}

	
	public void set(int coins) {
		this.coins = coins;
	}

	
	public int getCoins() {
		return this.coins;
	}

	
}
