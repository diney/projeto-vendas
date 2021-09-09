package com.diney.vendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diney.vendas.dto.SaleDTO;
import com.diney.vendas.dto.SaleSuccessDTO;
import com.diney.vendas.dto.SaleSumDTO;
import com.diney.vendas.service.SaleService;

@RestController
@RequestMapping(value ="/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping(value="/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amounGroupedBySaller(){
		List<SaleSumDTO> list = service.amountGroupedBySaller();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO> list = service.fingAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value="/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySaller(){
		List<SaleSuccessDTO> list = service.successGroupedBySaller();
		return ResponseEntity.ok(list);
	}

}
