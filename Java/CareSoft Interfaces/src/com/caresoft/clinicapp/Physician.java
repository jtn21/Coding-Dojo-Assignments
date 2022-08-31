package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser  {

	
//... imports class definition...
	
	
    // constructor
    public Physician(Integer id, ArrayList<String> patientNotes) {
		super(id);
		this.patientNotes = patientNotes;
	}
    
    public Physician(Integer id) {
		super(id);
	}
    
    

	// Inside class:    
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
    // TO DO: Implement HIPAACompliantUser!
    @Override
    public boolean assignPin(int pin) {
    	String data = String.valueOf(pin);
    	if(data.length() != 4) {
    		System.out.println(data.length());
    		return false;
    	}else {
    		return true;
    	}
    }
    
    public boolean accessAuthorized(Integer id) {
    	if( id == this.id) {
    		return true;
    	}else {
    		return false;
    	}
    	
    }
    
    
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    
    
    // TO DO: Setters & Getters
    
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	

    
    

	
}
