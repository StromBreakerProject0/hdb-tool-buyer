package com.hdbtool.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdbtool.exception.ApiException;
import com.hdbtool.model.User;
import com.hdbtool.repository.UserRepository;
import com.hdbtool.service.UserLoginService;

import java.util.Optional;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User getUserDetails(String id) {
		User user = null;
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			user = new User();
			user = optionalUser.get();
		} else {
			throw new ApiException("No User Found With given User Id:" + id);
		}
		return user;
	}
}
