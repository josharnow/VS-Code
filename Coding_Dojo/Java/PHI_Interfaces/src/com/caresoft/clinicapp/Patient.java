package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {
    
    private String firstName;
    private String lastName;
    // .. other personal identifying information .. //
    
    Physician primaryCarePhysician;
    ArrayList<Integer> currentPrescriptionsByRX;
    int providerCode;
    int memberNumber;
    PatientRecord medicalHistory;
    
    // Constructor
    /**
    * @param firstName
    * @param lastName
    * @param primaryCarePhysician
    * @param currentPrescriptionsByRX
    * @param providerCode
    * @param memberNumber
    * @param medicalHistory
    */
    public Patient(String firstName, String lastName, Physician primaryCarePhysician,
    		ArrayList<Integer> currentPrescriptionsByRX, int providerCode, int memberNumber,
    		PatientRecord medicalHistory) {
    	super();
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.primaryCarePhysician = primaryCarePhysician;
    	this.currentPrescriptionsByRX = currentPrescriptionsByRX;
    	this.providerCode = providerCode;
    	this.memberNumber = memberNumber;
    	this.medicalHistory = medicalHistory;
    }
    
    public boolean requestAppointment(Date date, Physician doctor) {
        boolean successfullyAdded = false;
        // you see existing code to find and schedule an appointment
    	// (Leave as is for the assignment, no need to implement anything here.)
        return successfullyAdded;
    }
    
	void addChartNotes(String notes) {
        this.medicalHistory.getCharts().add(notes);
    }

	// Setters & Getters
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the primaryCarePhysician
	 */
	public Physician getPrimaryCarePhysician() {
		return primaryCarePhysician;
	}

	/**
	 * @param primaryCarePhysician the primaryCarePhysician to set
	 */
	public void setPrimaryCarePhysician(Physician primaryCarePhysician) {
		this.primaryCarePhysician = primaryCarePhysician;
	}

	/**
	 * @return the currentPrescriptionsByRX
	 */
	public ArrayList<Integer> getCurrentPrescriptionsByRX() {
		return currentPrescriptionsByRX;
	}

	/**
	 * @param currentPrescriptionsByRX the currentPrescriptionsByRX to set
	 */
	public void setCurrentPrescriptionsByRX(ArrayList<Integer> currentPrescriptionsByRX) {
		this.currentPrescriptionsByRX = currentPrescriptionsByRX;
	}

	/**
	 * @return the providerCode
	 */
	public int getProviderCode() {
		return providerCode;
	}

	/**
	 * @param providerCode the providerCode to set
	 */
	public void setProviderCode(int providerCode) {
		this.providerCode = providerCode;
	}

	/**
	 * @return the memberNumber
	 */
	public int getMemberNumber() {
		return memberNumber;
	}

	/**
	 * @param memberNumber the memberNumber to set
	 */
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	/**
	 * @return the medicalHistory
	 */
	public PatientRecord getMedicalHistory() {
		return medicalHistory;
	}

	/**
	 * @param medicalHistory the medicalHistory to set
	 */
	public void setMedicalHistory(PatientRecord medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
}