package com.jamesnguyen.firstjsp.models;

public class Assignment {
	private String title;
	private int difficulty;
	
	//constructor
	
	public Assignment() {
		
	}

	public Assignment(String title, int difficulty) {
		super();
		this.title = title;
		this.difficulty = difficulty;
	}
	
	//getters and setters

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	

}
