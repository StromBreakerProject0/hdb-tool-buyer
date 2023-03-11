package com.hdbtool.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdbtool.constant.ErrorConstant;
import com.hdbtool.dto.BuyerDetailsDTO;
import com.hdbtool.exception.ApiException;
import com.hdbtool.service.BuyerService;
import com.hdbtool.vo.ApiResponse;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

	private static Logger log = Logger.getLogger(UserLoginController.class);

	@Autowired
	BuyerService buyerService;

	@GetMapping("/details/{id}")
	public ResponseEntity<ApiResponse> getBuyerDetail(@PathVariable String id) {
		BuyerDetailsDTO buyerDetailsDTO = null;
		try {
			buyerDetailsDTO = buyerService.getBuyerDetails(id);
		} catch (ApiException e) {
			log.error("Exception", e);
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Exception", e);
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(new ApiResponse(buyerDetailsDTO, ErrorConstant.SUCESS), HttpStatus.OK);
	}

}
