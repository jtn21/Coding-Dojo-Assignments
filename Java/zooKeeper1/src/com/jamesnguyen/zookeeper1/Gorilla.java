package com.jamesnguyen.zookeeper1;

public class Gorilla extends Mammal {

	//constructor
	public Gorilla() {
		super();
		
	}

	
	
	//method
	public int throwSomething() {
		this.energyLevel -= 5;
		return energyLevel;
	}
	
	
	public int eatBananas() {
		System.out.println("Yum, that was good!");
		this.energyLevel += 10;
		return energyLevel;
	}
	
	
	public int climb() {
		System.out.println("Successfully climbed tree");
		this.energyLevel -= 10;
		return energyLevel;
	}
	
}
