package com.nadhir.yezza;

public class Sculpture extends Art {
	
	private String material;

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
	public void viewArt() {
		System.out.println("the Material is : "+getMaterial());
	}
	
}
