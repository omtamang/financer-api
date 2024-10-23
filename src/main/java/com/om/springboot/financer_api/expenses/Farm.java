package com.om.springboot.financer_api.expenses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.om.springboot.financer_api.users.Users;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Farm {
	
	protected Farm() {
		
	}
	
	@GeneratedValue
	@Id
	private int id;
	private float labour;
	private float fertilizer;
	private float pesticides;
	private float seeds;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "users_id") // Ensure this annotation is used to set the correct foreign key
	@JsonIgnore
	private Users users;
	
	public Farm(int id, float labour, float fertilizer, float pesticides, float seeds, Users users) {
		super();
		this.id = id;
		this.labour = labour;
		this.fertilizer = fertilizer;
		this.pesticides = pesticides;
		this.seeds = seeds;
		this.users = users;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public float getLabour() {
		return labour;
	}

	public void setLabour(float labour) {
		this.labour = labour;
	}

	public float getFertilizer() {
		return fertilizer;
	}

	public void setFertilizer(float fertilizer) {
		this.fertilizer = fertilizer;
	}

	public float getPesticides() {
		return pesticides;
	}

	public void setPesticides(float pesticides) {
		this.pesticides = pesticides;
	}

	public float getSeeds() {
		return seeds;
	}

	public void setSeeds(float seeds) {
		this.seeds = seeds;
	}

	@Override
	public String toString() {
		return "Farm [id=" + id + ", labour=" + labour + ", fertilizer=" + fertilizer + ", pesticides=" + pesticides
				+ ", seeds=" + seeds + ", users=" + users + "]";
	}
	
}
