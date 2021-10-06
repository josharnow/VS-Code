package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User implements PHICompliantUser{
	
	private String firstName;
	private String lastName;
	private String role;
	Physician primaryCarePhysician;
	ArrayList<Integer> currentPrescriptionsByRX;
	int providerCode;
	int memberNumber;
	PatientRecord medicalHistory;
	
	public Patient() {}
	
	public Patient(Integer id, int pin, String role, String firstName, String lastName) {
		super(id, pin);
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public boolean assignPin(int pin) {					
			if(pin == 1234 || pin == 4321 || pin > 9999 || pin < 1000) {
				return false;
			} 		
		return true;
	}
	
	@Override
	public boolean isAuthorized(Integer confirmedAuthID) {
		if( confirmedAuthID == this.getId()) {
			return true;
		} else {
			return false;			
		}
	}
	
	public boolean requestAppointment(Date date, Physician doctor) {
		boolean successfullyAdded = false;
		// you see existing code to find and schedule an appointment
		return successfullyAdded;
	}
	
	void addChartNotes(String notes) {
		this.medicalHistory.getCharts().add(notes);
	}
	
	// getters and setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Physician getPrimaryCarePhysician() {
		return primaryCarePhysician;
	}

	public void setPrimaryCarePhysician(Physician primaryCarePhysician) {
		this.primaryCarePhysician = primaryCarePhysician;
	}

	public ArrayList<Integer> getCurrentPrescriptionsByRX() {
		return currentPrescriptionsByRX;
	}

	public void setCurrentPrescriptionsByRX(ArrayList<Integer> currentPrescriptionsByRX) {
		this.currentPrescriptionsByRX = currentPrescriptionsByRX;
	}

	public int getProviderCode() {
		return providerCode;
	}

	public void setProviderCode(int providerCode) {
		this.providerCode = providerCode;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public PatientRecord getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(PatientRecord medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
	
	
}