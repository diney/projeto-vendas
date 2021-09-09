package com.diney.vendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.diney.vendas.dto.SaleSuccessDTO;
import com.diney.vendas.dto.SaleSumDTO;
import com.diney.vendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query("SELECT new com.diney.vendas.dto.SaleSumDTO(obj.seller,SUM(obj.amount))"
			+ " FROM Sale AS obj GROUP BY obj.seller   ")
	List<SaleSumDTO> amountGroupedBySaller();
	
	@Query("SELECT new com.diney.vendas.dto.SaleSuccessDTO(obj.seller,SUM(obj.visited),SUM(obj.deals))"
			+ " FROM Sale AS obj GROUP BY obj.seller   ")
	List<SaleSuccessDTO> successGroupedBySaller();

}
