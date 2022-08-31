package com.jamesnguyen.zookeeper1;

public class Bat extends Mammal {
	//constructor
	public Bat() {
		super(300);
	}
	
	
	//method
	
	public int fly() {
		System.out.println("flap flap flap");
		this.energyLevel -= 50;
		return energyLevel;
	}
	
	public int eatHumans() {
		System.out.println("CHOMP");
		this.energyLevel += 25;
		return energyLevel;
		
	}
	
	public int attackTown() {
		System.out.println("BURRRRRRRRRN");
		this.energyLevel -= 100;
		return energyLevel;
	}
	
	
	
}
