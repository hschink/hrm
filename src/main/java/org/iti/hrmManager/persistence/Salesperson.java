package org.iti.hrmManager.persistence;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="salespersons")
public class Salesperson extends Employee {
	
	private static final long serialVersionUID = 4725508334848580910L;

	private Set<Customer> takesCareOf;
	private String account = "Akquise";
	private String companyCarLicensePlate;

	@OneToMany
	@JoinTable(
			name="salespersons_customers",
			joinColumns = { @JoinColumn(name="id_salesperson") },
			inverseJoinColumns = { @JoinColumn(name="id_customer", unique=true) }
	)
	public Set<Customer> getTakesCareOf() {
		return takesCareOf;
	}

	public void setTakesCareOf(Set<Customer> takesCareOf) {
		this.takesCareOf = takesCareOf;
	}
	
	public String getAccount() {
		return account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name="company_car_license_plate")
	public String getCompanyCarLicensePlate() {
		return companyCarLicensePlate;
	}

	public void setCompanyCarLicensePlate(String companyCarLicensePlate) {
		this.companyCarLicensePlate = companyCarLicensePlate;
	}
}
