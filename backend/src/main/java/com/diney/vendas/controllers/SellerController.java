package com.diney.vendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diney.vendas.dto.SellerDTO;
import com.diney.vendas.service.SellerService;

@RestController
@RequestMapping(value ="/sellers")
public class SellerController {
	@Autowired
	private SellerService service;
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll(){
		List<SellerDTO> list = service.fingAll();
		return ResponseEntity.ok(list);
	}

}
