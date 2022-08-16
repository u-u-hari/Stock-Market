package com.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.models.Company;
import com.stock.models.Customer;
import com.stock.models.CustomerList;
import com.stock.repos.CustomerRepository;
import com.stock.repos.CustomerStockRepository;

@Service
public class CustomerService {

	
	@Autowired CustomerRepository repo;
	@Autowired CustomerStockRepository srepo;
	@Autowired CompanyService cservice;
	
	public Customer saveCustomer(Customer cmp) {
		return repo.save(cmp);
	}
	
	public Customer findCustomer(String email) {
		return repo.findByEmail(email);
	}
	
	public Customer findCustomer(int id) {
		return repo.getById(id);
	}
	
	public List<Customer> allCustomers(){
		return repo.findAll();
	}
	
	public void buyNow(CustomerList css) {
		 //Company cmp=cservice.findCompany(css.getCompid());
		 CustomerList cs=srepo.findByCustomerAndCompany(css.getCustomer(), css.getCompany());
		 if(cs!=null) {
			css.setId(cs.getId()); 
		 	css.setQty(cs.getQty()+css.getQty());
		 }
		 srepo.save(css);
	}
	
	public List<CustomerList> myStocks(int custid){
		Customer cust=repo.getById(custid);
		return srepo.findByCustomer(cust);
	}
	
	public List<CustomerList> myStockHolders(int compid){
		Company cmp=cservice.findCompany(compid);
		return srepo.findByCompany(cmp);
	}
	
	public CustomerList findStockById(int id) {
		return srepo.getById(id);
	}
	
	public void sellNow(int id,int qty) {
		 CustomerList cs=srepo.getById(id);		 
		 if(cs.getQty()==qty) {
			 srepo.delete(cs);
		 } else {
			 cs.setQty(cs.getQty()-qty);
			 srepo.save(cs);
		 }
	}
}
