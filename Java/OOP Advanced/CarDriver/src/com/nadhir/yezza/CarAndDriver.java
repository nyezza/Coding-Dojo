package com.nadhir.yezza;

public class CarAndDriver {

	public static void main(String[] args) {
		Driver drive = new Driver();
		
		System.out.println(Driver.gasLevel);
		drive.drive();
		drive.drive();
		drive.drive();
		drive.drive();
		
		drive.booster();
		
		drive.refuel();
		drive.refuel();
		drive.refuel();


	}

}
