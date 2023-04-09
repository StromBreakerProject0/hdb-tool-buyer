package com.hdbtool.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdbtool.model.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, String>{
	
	Set<UserType> finByName(String userTypeName);

}
