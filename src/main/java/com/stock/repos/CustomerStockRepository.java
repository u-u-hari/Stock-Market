package com.stock.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.models.Company;
import com.stock.models.Customer;
import com.stock.models.CustomerList;

@Repository
public interface CustomerStockRepository extends JpaRepository<CustomerList, Integer> {
	CustomerList findByCustomerAndCompany(Customer custid,Company compid);
	
	List<CustomerList> findByCustomer(Customer custid);
	List<CustomerList> findByCompany(Company compid);
	
}
