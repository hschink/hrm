package org.iti.hrmManager.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="janitors")
public class Janitor extends Employee {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4738804821625007632L;

	private String address;
	private String companyName;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="company_name")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}