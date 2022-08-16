package com.stock.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CustomerList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="compid")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name="custid")
	private Customer customer;
	
	private int qty;
	private int buyprice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getBuyprice() {
		return buyprice;
	}
	public void setBuyprice(int buyprice) {
		this.buyprice = buyprice;
	}
	@Override
	public String toString() {
		return "CustomerStock [id=" + id + ", compid=" + company + ", custid=" + customer + ", qty=" + qty + ", buyprice="
				+ buyprice + ", currentprice=" + "]";
	}
	
	
}
