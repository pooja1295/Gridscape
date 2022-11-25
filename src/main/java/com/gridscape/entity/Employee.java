package com.gridscape.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "employee")
@Table(name="Employee")

public class Employee {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String dob;
	private String address;
	@Column(unique = true)
	private String email;
	private String password;
	private String role;
	private String mno;
	private String state;
	private String city;
	private String img;
	private String profession;
	
	
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	


	
	public Employee(int id, String name, String dob, String address, String email, String password, String role,
			String mno, String state, String city, String img, String profession, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.email = email;
		this.password = password;
		this.role = role;
		this.mno = mno;
		this.state = state;
		this.city = city;
		this.img = img;
		this.profession = profession;
		this.department = department;
	}


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	


	public String getMno() {
		return mno;
	}


	public void setMno(String mno) {
		this.mno = mno;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}
	
	


	public String getProfession() {
		return profession;
	}


	public void setProfession(String profession) {
		this.profession = profession;
	}
	


	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Department getDepartment() {
		return department;
	}




	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + ", address=" + address + ", email=" + email
				+ ", password=" + password + ", role=" + role + ", mno=" + mno + ", state=" + state + ", city=" + city
				+ ", img=" + img + ", profession=" + profession + ", department=" + department + "]";
	}


	

	

       


	
	



	

	
	

}
