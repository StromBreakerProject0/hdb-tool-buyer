package com.hdbtool.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdbtool.model.Provider;
import com.hdbtool.model.User;
import com.hdbtool.repository.UserRepository;
import com.hdbtool.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void processOAuthPostLogin(String username) {
		User existUser = userRepository.findByUserName(username);

		if (existUser == null) {
			User newUser = new User();
			newUser.setUserName(username);
			newUser.setProvider(Provider.GOOGLE);
			newUser.setEnabled(true);

			userRepository.save(newUser);

			System.out.println("Created new user: " + username);
		}

	}

}
