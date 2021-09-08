package com.diney.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diney.vendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
