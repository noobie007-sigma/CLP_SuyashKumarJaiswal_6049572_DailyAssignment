package com.example.springboot_assignment_1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="trainee")
public class Trainee {
	@Id
	private Integer id;
	private String name;
	private String domain;
	private String location;
	public Trainee() {
		super();
	}
	public Trainee(Integer id, String name, String domain, String location) {
		super();
		this.id = id;
		this.name = name;
		this.domain = domain;
		this.location = location;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Trainee [id=" + id + ", name=" + name + ", domain=" + domain + ", location=" + location + "]";
	}
	
}
