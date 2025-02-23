package com.SpringApplication.Employe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="emp3")
public class Employe {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="employe_name")
	private String name;
	@Column(name="employe_role")
	private String role;
	
	
	public Employe() {
		
	}

	
	

	public Employe(String name, String role) {
		super();
		this.name = name;
		this.role = role;
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


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Employe [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
	
	
	
}
