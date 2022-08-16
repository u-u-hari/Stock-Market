package com.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.models.Company;
import com.stock.models.Customer;
import com.stock.models.HelpDesk;
import com.stock.repos.HelpDeskRepository;

@Service
public class HelpDeskService {
	
	@Autowired HelpDeskRepository repo;
	
	public void saveTicket(HelpDesk hd) {
		repo.save(hd);
	}
	
	public List<HelpDesk> listCustomerTickets(Customer cust){
		return repo.findByCustomer(cust);
	}
	
	public List<HelpDesk> listCompanyTickets(Company cmp){
		return repo.findByCompany(cmp);
	}
	
	public HelpDesk findTicket(int id) {
		return repo.getById(id);
	}
	
	public void updateTicket(int id,String solution) {
		HelpDesk hd=repo.getById(id);
		hd.setSolution(solution);
		hd.setStatus("Done");
		repo.save(hd);
	}
}
