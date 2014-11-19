package org.iti.hrmManager.hrm;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {

	private int id;
	private String firstname;
	private String surname;
	private String address;
	private String telephoneNumber;
	private Salesperson takenCareOfBy;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstname;
	}
	
	public void setFirstName(String name) {
		this.firstname = name;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="telephone")
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	
	public void setTelephoneNumber(String telefoneNumber) {
		this.telephoneNumber = telefoneNumber;
	}
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="taken_care_of_by")
	public Salesperson getTakenCareOfBy() {
		return takenCareOfBy;
	}
	
	public void setTakenCareOfBy(Salesperson takenCareOfBy) {
		this.takenCareOfBy = takenCareOfBy;
	}
}