package com.diney.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diney.vendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
