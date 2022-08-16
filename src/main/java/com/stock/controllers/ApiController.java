package com.stock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.stock.models.UnitPrice;
import com.stock.service.CompanyService;

@RestController
public class ApiController {
	
	@Autowired CompanyService cmpservice;

	@GetMapping("/api/data/{id}")
	public List<UnitPrice> chartData(@PathVariable("id")int id) {
		List<UnitPrice> plist= cmpservice.getPriceDetails(id);
		return plist;
	}
}
