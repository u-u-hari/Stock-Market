package com.stock.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.models.UnitPrice;

@Repository
public interface StockPriceRepository extends JpaRepository<UnitPrice, Integer>{
	List<UnitPrice> findByCompidOrderByDate(int compid);
}
