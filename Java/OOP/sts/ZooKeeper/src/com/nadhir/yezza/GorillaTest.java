package com.nadhir.yezza;

public class GorillaTest {

	public static void main(String[] args) {

		Gorilla g = new Gorilla();
		
		System.out.println(Gorilla.energyLevel);
		g.throwSomethings();
		g.throwSomethings();
		g.throwSomethings();
		g.eatBananas();
		g.eatBananas();
		g.climb();
		System.out.println(Gorilla.energyLevel);
		
	}

}
