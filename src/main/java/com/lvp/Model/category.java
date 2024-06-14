package com.lvp.Model;


public class category {
	private int id;
	private String cateName;
	private String icon;
	
	public category() {
		super();
	}
	public category(int id, String cateName, String icon) {
		super();
		this.id = id;
		this.cateName = cateName;
		this.icon = icon;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
}
