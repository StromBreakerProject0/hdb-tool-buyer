package com.hdbtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdbtool.model.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, String>{

}
