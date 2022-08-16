package com.stock.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stock.models.Company;
import com.stock.models.UnitPrice;
import com.stock.repos.CompanyRepository;
import com.stock.repos.StockPriceRepository;

@Service
public class CompanyService {

	@Autowired CompanyRepository repo;
	@Autowired ServletContext ctx;
	@Autowired StockPriceRepository srepo;
	
	public Company saveCompany(Company cmp,MultipartFile photo) {
		try {
			Files.copy(photo.getInputStream(), Paths.get(ctx.getRealPath("/logos/"), photo.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			cmp.setLogo("/logos/"+photo.getOriginalFilename());
			Company comp= repo.save(cmp);
			UnitPrice sp=new UnitPrice();
			sp.setCompid(comp.getId());
			sp.setDate(LocalDate.now());
			sp.setPrice(cmp.getStockprice());
			srepo.save(sp);
			return comp;
		}catch(Exception ex) {
			System.err.println("Error "+ex);
			return null;
		}
		
	}
	
	public void addStockPrice(UnitPrice sp) {
		srepo.save(sp);
		Company stk=repo.getById(sp.getCompid());
		stk.setCurrentprice(sp.getPrice());
		repo.save(stk);
	}
	
	public List<UnitPrice> getPriceDetails(int compid){
		return srepo.findByCompidOrderByDate(compid);
	}
	
	public Company findCompany(String email) {
		return repo.findByEmail(email);
	}
	
	public Company findCompany(int id) {
		return repo.getById(id);
	}
	
	public List<Company> getAll(){
		return repo.findAll();
	}
}
