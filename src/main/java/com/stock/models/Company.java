package com.stock.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String logo;
	private int stockprice;
	private int currentprice;
	
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStockprice() {
		return stockprice;
	}
	public void setStockprice(int stockprice) {
		this.stockprice = stockprice;
	}
	public int getCurrentprice() {
		return currentprice;
	}
	public void setCurrentprice(int currentprice) {
		this.currentprice = currentprice;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", address=" + address
				+ ", stockprice=" + stockprice + ", currentprice=" + currentprice + "]";
	}
	public Company() {
		// TODO Auto-generated constructor stub
	}
	
	
}
