package com.diney.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diney.vendas.dto.SaleDTO;
import com.diney.vendas.dto.SaleSuccessDTO;
import com.diney.vendas.dto.SaleSumDTO;
import com.diney.vendas.entities.Sale;
import com.diney.vendas.repositories.SaleRepository;
import com.diney.vendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sallerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> fingAll(Pageable pageable){
		sallerRepository.findAll();
		Page<Sale> result =  repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySaller(){
		return  repository.amountGroupedBySaller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySaller(){
		return  repository.successGroupedBySaller();
	}

}
