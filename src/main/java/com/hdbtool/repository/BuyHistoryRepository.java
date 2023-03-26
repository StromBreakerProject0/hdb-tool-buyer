package com.hdbtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdbtool.model.BuyHistory;

@Repository
public interface BuyHistoryRepository extends JpaRepository<BuyHistory, String>{

}
