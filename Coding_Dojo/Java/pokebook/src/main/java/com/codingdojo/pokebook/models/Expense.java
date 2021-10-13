package com.codingdojo.pokebook.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "expenses")
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Please enter an expense name.")
	@Size(min = 0, max = 200, message = "Expense name must be less than {max} characters long.")
//	@Max(value = 200, message = "")
	private String expenseName;
	
	@NotEmpty(message = "Please enter a vendor.")
	@Size(min = 0, max = 200, message = "Vendor must be less than {max} characters long.")
	private String vendor;
	
	@NotNull(message = "Please enter an amount.")
	@DecimalMin(value = "0.00", message = "Amount must be ${min} or greater.")
	@DecimalMax(value = "1000000000.00", message = "Amount must be ${max} or less.")
	private Double cost;
	
	@NotEmpty(message = "Please enter a description.")
	@Size(min = 0, max = 1000000, message = "Description must be less than {max} characters.") // Custom error message
	private String description;
	
	// This will not allow the createdAt column to be updated after creation
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate(){
			this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
			this.updatedAt = new Date();
	}
		
	// CONSTRUCTOR(S)
	public Expense() { 
	}
	public Expense(String expenseName, String vendor, Double cost, String description) {
		this.expenseName = expenseName;
		this.vendor = vendor;
		this.cost = cost;
		this.description = description;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the expenseName
	 */
	public String getExpenseName() {
		return expenseName;
	}
	/**
	 * @param expenseName the expenseName to set
	 */
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}
	/**
	 * @return the vendor
	 */
	public String getVendor() {
		return vendor;
	}
	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	/**
	 * @return the cost
	 */
	public Double getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}
	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}