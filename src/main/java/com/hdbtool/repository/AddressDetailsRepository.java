package com.hdbtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdbtool.model.AddressDetails;

@Repository
public interface AddressDetailsRepository extends JpaRepository<AddressDetails, String>{

}
