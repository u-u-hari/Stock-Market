package com.stock.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	Company findByEmail(String email);
}
