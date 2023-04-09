package com.hdbtool.service;

import com.hdbtool.dto.UserDTO;
import com.hdbtool.model.User;

public interface UserManageService {

	User getBuyerDetails(UserDTO userDTO);

}
