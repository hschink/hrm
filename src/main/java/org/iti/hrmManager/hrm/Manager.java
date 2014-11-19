package org.iti.hrmManager.hrm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "managers")
public class Manager extends Employee {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5510057309739688470L;

	private String account = "Akquise";
	private String companyCarLicensePlate;
	
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
