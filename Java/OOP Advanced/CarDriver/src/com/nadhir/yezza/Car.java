package com.nadhir.yezza;

public class Car {
 static int gasLevel = 10;
 
 
public void displayAmout() {
	if (gasLevel<=0) {
		System.out.println("Game Over");
		
	}
	else {
	System.out.println( "Gas remaining:  "+ (int)gasLevel + "/10");	
	}
	 
 }
}
