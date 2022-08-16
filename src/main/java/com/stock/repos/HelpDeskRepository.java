package com.stock.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.models.Company;
import com.stock.models.Customer;
import com.stock.models.HelpDesk;

@Repository
public interface HelpDeskRepository extends JpaRepository<HelpDesk, Integer>{
	List<HelpDesk> findByCustomer(Customer custid); 
	List<HelpDesk> findByCompany(Company custid); 
}
