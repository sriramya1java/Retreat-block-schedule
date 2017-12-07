package com.vaurology.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="physicians")
public class Physicians implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="physiciansId")
    private int physiciansId;  
	@Column(name="FirstName")
    private String firstName;
	@Column(name="MiddleInitial")	
	private String middleInitial;
	@Column(name="LastName")
	private String lastName;
	@Column(name="EmpId")
	private int empId;
	public int getPhysicianId() {
		return physiciansId;
	}
	public void setPhysicianId(int pid) {
		this.physiciansId = pid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String fname) {
		this.firstName = fname;
	}
	public String getMiddleInitial(){
		return middleInitial;
	}
	public void setMiddleInitial(String minitial){
		this.middleInitial= minitial;
	}
	public String getLastName(){
		return lastName;
	}
	public void setLastName(String lname){
		this.lastName= lname;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empid) {
		this.empId = empid;
	}
}
