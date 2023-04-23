package com.nadhir.yezza;

public class Gorilla extends Mammal {
	
	public void throwSomethings() {
		System.out.println("the gorilla has thrown something");
		energyLevel =-5;
	}
	
	
	public void eatBananas() {
		System.out.println("the gorilla eats Bananas");
		energyLevel =+ 10;
		
	}
	
	public void climb() {
		System.out.println("after climbing a tree the gorilla has lost Energy Level");
		energyLevel =- 10;
	}
	
	

}
