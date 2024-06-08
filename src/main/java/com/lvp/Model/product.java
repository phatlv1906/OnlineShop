package com.lvp.Model;

public class product {
	public int id;
	public String name;
	public String description;
	public double proprice;
	private String imgLink;
	private int categoryId;
	private int sellerId;
	private int amount;
	
	public product() {
		super();
	}

	public product(int id, String name, String description, double proprice, String imgLink, int categoryId,
			int sellerId, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.proprice = proprice;
		this.imgLink = imgLink;
		this.categoryId = categoryId;
		this.sellerId = sellerId;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getProprice() {
		return proprice;
	}

	public void setProprice(double proprice) {
		this.proprice = proprice;
	}

	public String getImgLink() {
		return imgLink;
	}

	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
