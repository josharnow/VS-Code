package com.codingdojo.counter.models;
public class Counter {
	// MEMBER VARIABLES
	private int count;
	
	// CONSTRUCTOR
	/**
	 * @param count
	 */
	public Counter(int count) {
		super();
		this.count = count;
	}

	// GETTERS AND SETTERS
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}


	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
}
