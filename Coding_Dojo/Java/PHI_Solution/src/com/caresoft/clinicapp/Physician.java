package com.caresoft.clinicapp;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashSet;
public class Physician extends User implements PHICompliantUser, PHIAdminCompliant{
    
    Integer employeeID;
    String role;
    private HashSet<Patient> patients;
    private ArrayList<String> securityIncidents;
    
    // ... other existing member variables. ...
    
    // TO DO: Constructor
    public Physician() {}
    
    public Physician(Integer id, int pin, String role, Integer employeeID) {
    	super(id, pin);
    	this.role = role;
    	this.employeeID = employeeID;	
    }
    
    @Override
	public boolean assignPin(int pin) {	
		if(pin > 999999 || pin < 100000) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean isAuthorized(Integer confirmedAuthID) {
		authIncident();
		if( confirmedAuthID == this.getId()) {
			return true;
		} else {
			return false;			
		}
	}
	
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return securityIncidents;
	}    
      
    
    public void prescribeRXTo(Patient patient, Integer rxNumber) {
        patient.currentPrescriptionsByRX.add(rxNumber);
    }
      
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.getId(), notes
        );
        securityIncidents.add(report);
    }
    
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.getId(), "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

 // TO DO: Setters & Getters
	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer id) {
		this.employeeID = id;
	}

	public HashSet<Patient> getPatients() {
		return patients;
	}

	public void setPatients(HashSet<Patient> patients) {
		this.patients = patients;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}


}