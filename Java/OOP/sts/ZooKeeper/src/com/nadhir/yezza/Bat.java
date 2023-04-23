package com.nadhir.yezza;

public class Bat extends Mammal {
	private int energyLevel = 300;
	
	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	public void fly() {
		System.out.println("the bat take off");
		energyLevel =- 50;
		
	}
	
	public void eatHuman() {
		System.out.println("the bat eat human");
		energyLevel =+ 25;
		
	}
	
	public void attackTown() {
		System.out.println("the bat attack town, waaaaaaaaaaaaa");
		energyLevel =+100;
		
	}
}
