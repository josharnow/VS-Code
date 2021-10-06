package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;
public class AdminUser extends User {
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
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
    
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}
	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}
	@Override
	public int getPin() {
		// TODO Auto-generated method stub
		return super.getPin();
	}
	@Override
	public void setPin(int pin) {
		// TODO Auto-generated method stub
		super.setPin(pin);
	}
}