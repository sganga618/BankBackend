package com.bank.dto;

public class Bank {
	public Bank() {}
	
	private String id;
	private String name;
	private String type;
	private String city;
	private String state;
	private String zipCode;
	
	public Bank(String id, String name, String type, String city, String state, String zipCode) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
}
