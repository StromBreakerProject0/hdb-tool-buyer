package com.hdbtool.service;

import org.springframework.stereotype.Service;

import com.hdbtool.model.User;

@Service
public interface UserLoginService {
    User getUserDetails(String id);
}
