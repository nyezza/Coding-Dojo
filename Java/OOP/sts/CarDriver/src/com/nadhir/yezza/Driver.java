package com.nadhir.yezza;

public class Driver extends Car {
	
	public void drive() {
		gasLevel = gasLevel -1;
		displayAmout();
	}
	
	public void booster() {
		if (gasLevel<=3) {
			System.out.println("sorry you haven't enough gas");
		}
		else {
			gasLevel  =gasLevel-3;
			displayAmout();
		}
		
	}
	
	public void refuel() {
		if (gasLevel >=8) {
			System.out.println("refuel is not allowed");
		}
		else {
			gasLevel=gasLevel+2;
			displayAmout();
	}
		}
		
}
