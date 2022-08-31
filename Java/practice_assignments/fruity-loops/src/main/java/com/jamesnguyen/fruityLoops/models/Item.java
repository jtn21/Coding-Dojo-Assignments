package com.jamesnguyen.fruityLoops.models;

public class Item {
	private String name;
	private double price;
	
	
	//constructor
	
	public Item() {
		
	}


	public Item(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	//getters and setters
	
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
	
	

	
	
	

}
