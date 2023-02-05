package com.hdbtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdbtool.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}
