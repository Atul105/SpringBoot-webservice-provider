package magar.atul.webservice.entity;

import java.util.Date;

public class Product {
	
	private int id;
	private String name;
	private double price;
	private String description;
	private boolean isAvailable;
	private Date createdAt;
	
	//constructor
	public Product() {
		super();
	}
	
	public Product(int id, String name, double price, String description, boolean isAvailable, Date createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.isAvailable = isAvailable;
		this.createdAt = createdAt;
	}
	//getters and setters
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", isAvailable=" + isAvailable + ", createdAt=" + createdAt + "]";
	}
	
	

}
