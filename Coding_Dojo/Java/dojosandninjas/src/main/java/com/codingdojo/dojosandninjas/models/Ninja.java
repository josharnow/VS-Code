package com.codingdojo.dojosandninjas.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninjas")
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@NotEmpty(message = "Please enter a first name.")
	@Size(max = 255, message = "First name must be less than {max} characters.")
    private String firstName;
    
	@NotEmpty(message = "Please enter a last name.")
	@Size(max = 255, message = "Last name must be less than {max} characters.")
    private String lastName;
    
	@NotNull(message = "Please enter an age.")
	@Min(value = 13, message = "Age must be at least {value} years old.")
	@Max(value = 200, message = "Age must be less than or equal to {value} years old.")
//	@Size(min = 13, max = 200, message = "Age must be between {min} and {max} years old.")
    private byte age;
    
    @Column(updatable=false)
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
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="dojos_id")
    private Dojo dojo;
    
    public Ninja() {
        
    }
    
    public Ninja(@NotEmpty @Size(max = 255) String firstName,
    		@NotEmpty @Size(max = 255) String lastName,
    		@NotNull @Min(value = 13) @Max(value = 200) byte age) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    public Ninja(@NotEmpty(message = "Please enter a first name.") @Size(max = 255, message = "First name must be less than {max} characters.") String firstName,
    		@NotEmpty(message = "Please enter a last name.") @Size(max = 255, message = "Last name must be less than {max} characters.") String lastName,
    		@NotNull(message = "Please enter an age.") @Min(value = 13, message = "Age must be at least {value} years old.") @Max(value = 200, message = "Age must be less than or equal to {value} years old.") byte age,
    		Dojo dojo) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dojo = dojo;
    }
    
    // GETTERS AND SETTERS
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
	 * @return the age
	 */
	public byte getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(byte age) {
		this.age = age;
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
	/**
	 * @return the dojo
	 */
	public Dojo getDojo() {
		return dojo;
	}
	/**
	 * @param dojo the dojo to set
	 */
	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}
}
