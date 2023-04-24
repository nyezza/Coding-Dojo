package com.nadhir.yezza;

public abstract class Art {
	//member variable
	private String title;
	private String Author;
	private String descrption;
	
	
	//getter & setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	
	public abstract void viewArt();
}
