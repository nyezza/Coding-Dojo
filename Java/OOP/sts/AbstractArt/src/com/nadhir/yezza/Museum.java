package com.nadhir.yezza;

import java.util.ArrayList;

public class Museum {

	public static void main(String[] args) {
		Painting p1 = new Painting();
		Painting p2 = new Painting();
		Painting p3 = new Painting();
		
		p1.setPaintType("oil");
		p1.setTitle("testNadhir");
		p1.setAuthor("Nedhir");
		p1.setDescrption("testing printing artwork");
		p2.setPaintType("Watercolor");
		p3.setPaintType("Acrylic");
		
		System.out.println(p2.getPaintType());
		
		Sculpture s1 = new Sculpture();
		Sculpture s2 = new Sculpture();
		
		ArrayList<String> museum = new ArrayList<String>();
		
		museum.add(p1.getPaintType());
		museum.add(p2.getPaintType());
		museum.add(p3.getPaintType());
		
		p1.viewArt();
		s1.viewArt();

	}

}
