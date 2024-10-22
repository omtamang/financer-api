package com.om.springboot.financer_api.users;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.om.springboot.financer_api.expenses.Farm;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Users {
	
	protected Users() {
		
	}
	
	@GeneratedValue
	@Id
	private int id;
	private String name;
	private String phoneNumber;
	private String password;
	
	@OneToMany(mappedBy = "users")
	@JsonIgnore
	private List<Farm> farm;
	
	public Users(int id, String name, String phoneNumber, String password) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
	
	public List<Farm> getFarm() {
		return farm;
	}

	public void setFarm(List<Farm> farm) {
		this.farm = farm;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", password=" + password + "]";
	}
	
}
