package com.hdbtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdbtool.model.SellHistory;

@Repository
public interface SellHistoryRepository extends JpaRepository<SellHistory, String>{

}
