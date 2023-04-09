package com.hdbtool.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdbtool.constant.ErrorConstant;
import com.hdbtool.dto.UserDTO;
import com.hdbtool.exception.ApiException;
import com.hdbtool.model.User;
import com.hdbtool.service.UserManageService;
import com.hddtool.vo.ApiResponse;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private static Logger log = Logger.getLogger(UserController.class);

	@Autowired
	UserManageService userManageService;

	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addUser(@RequestBody UserDTO userDTO) {
		User user = null;
		try {
			user = userManageService.getBuyerDetails(userDTO);
		} catch (ApiException e) {
			log.error("Exception", e);
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Exception", e);
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(new ApiResponse(user, ErrorConstant.SUCESS), HttpStatus.OK);
	}

}
