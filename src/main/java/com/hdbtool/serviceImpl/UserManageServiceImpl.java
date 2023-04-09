package com.hdbtool.serviceImpl;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import com.hdbtool.dto.UserDTO;
import com.hdbtool.exception.ApiException;
import com.hdbtool.model.Provider;
import com.hdbtool.model.User;
import com.hdbtool.repository.UserRepository;
import com.hdbtool.repository.UserTypeRepository;
import com.hdbtool.service.UserManageService;

public class UserManageServiceImpl implements UserManageService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserTypeRepository userTypeRepository;

	@Override
	public User getBuyerDetails(UserDTO userDTO) {
		User user = null;
		if (userDTO.getName() == null || userDTO.getUserName() == null || userDTO.getPassword() == null || userDTO.getEmail() == null
				|| userDTO.getPhoneNumber() == null || userDTO.getUserTypeName() == null) {
			throw new ApiException("Please fillup the required fields");
		}else {
			if(userDTO.getId() != null) {
				Optional<User> optionalUser = userRepository.findById(userDTO.getId());
				if(optionalUser.isPresent()) {
					user = optionalUser.get();
				}else {
					throw new ApiException("User Not Found With Given Id:-"+userDTO.getId());
				}
			}else {
				user = new User();
			}
			user.setName(userDTO.getName());
			user.setUserName(userDTO.getUserName());
			user.setProvider(Provider.LOCAL);
			user.setEmail(userDTO.getEmail());
			user.setPhoneNumber(userDTO.getPhoneNumber());
			user.setPassword(hashPassword(userDTO.getPassword()));
			user.setRoles(userTypeRepository.finByName(userDTO.getUserTypeName()));
			
		}
			return user;
	}
	
	private String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	
	private boolean checkPass(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword))
			return true;
		else
			return false;
	}

}
