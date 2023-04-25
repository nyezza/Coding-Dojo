package com.nadhir.yezza;

public class BatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bat bat = new Bat();
		
		bat.attackTown();
		bat.attackTown();
		bat.attackTown();
		bat.eatHuman();
		bat.eatHuman();
		bat.fly();
		bat.fly();
		System.out.println(bat.getEnergyLevel());
	}

}
