package org.iti.hrmManager.hrm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@MappedSuperclass
@Table(name="external_staff")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
		name="business",
		discriminatorType=DiscriminatorType.STRING
)
public class ExternalStaff implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2740703043297793512L;
	
	private int id;
	private String name;
	private String surname;
	private float salary;
	private String companyName;
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	
	public void setFirstName(String name) {
		this.name = name;
	}
	
	public String getFirstName() {
		return name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public float getSalary() {
		return salary;
	}

	@Column(name="company_name")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}