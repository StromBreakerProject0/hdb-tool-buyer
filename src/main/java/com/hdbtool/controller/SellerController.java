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
import com.hdbtool.dto.BuyerDetailsDTO;
import com.hdbtool.exception.ApiException;
import com.hdbtool.service.SellerService;
import com.hddtool.vo.ApiResponse;

@RestController
@RequestMapping("/seller")
public class SellerController {
	
	private static Logger log = Logger.getLogger(SellerController.class);
	
	@Autowired
	SellerService sellerService;
	
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addSeller(@RequestBody BuyerDetailsDTO buyerDetailsDTO) {
		BuyerDetailsDTO result = null;
		try {
			result = sellerService.addSeller(buyerDetailsDTO);
		} catch (ApiException e) {
			log.error("Exception", e);
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Exception", e);
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(new ApiResponse(result, ErrorConstant.SUCESS), HttpStatus.OK);
	}

}
