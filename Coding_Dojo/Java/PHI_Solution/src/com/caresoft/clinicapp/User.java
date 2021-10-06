package com.caresoft.clinicapp;

public class User {
	private Integer id;
	private int pin;
	
	public User() {}
	
	public User(Integer id, int pin) {
		this.id = id;
		this.pin = pin;
		
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
	
	
}