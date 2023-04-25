package com.nadhir.yezza;

public class Painting  extends Art {
	private String paintType;

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}
	
	public void viewArt() {
		System.out.println("the author is : "+getAuthor());
		System.out.println("the title is : " + getTitle());
		System.out.println("finaly it's desrciption : " + getDescrption());
		System.out.println("the painting type is : "+getPaintType());
		
	}
	
}
