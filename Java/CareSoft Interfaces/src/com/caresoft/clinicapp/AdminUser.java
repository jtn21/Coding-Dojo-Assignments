package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser,HIPAACompliantAdmin {


//... imports class definition...
    
    // Inside class:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();
    
    
    
    //constructor
    
	public AdminUser(Integer id, Integer employeeID, String role) {
		super(id);
		this.employeeID = employeeID;
		this.role = role;
	}
	
	
    
    public AdminUser(int id, String role) {
		super(id);
		this.role = role;
	}



	// TO DO: Implement a constructor that takes an ID and a role
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    

	//methods
	

	public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

    
    public boolean assignPin(int pin) {
    	String data = String.valueOf(pin);
    	if(data.length() != 6) {
    		return false;
    	}else {
    		return true;
    	}
    }
    
    
    public boolean accessAuthorized(Integer id) {
    	if(id == this.id) {
    		return true;
    	}else {
    		authIncident();
    		return false;
    	}
    }
    
    public ArrayList<String>reportSecurityIncidents(){
    	return getSecurityIncidents();
    }
    
    
    
    
    // TO DO: Setters & Getters

    public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
	
	
	
	
	
	}


	
	
