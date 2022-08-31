package com.jamesnguyen.zookeeper1;

public class Mammal {
	//member variable
	protected int energyLevel;
	
	
	//constructor
	public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public Mammal() {
		this.energyLevel = 100;
	}


	public int getEnergyLevel() {
		return energyLevel;
	}


	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	
	//method
	
	public int displayEnergy() {
		return this.energyLevel;
	}
	
	

	
}
