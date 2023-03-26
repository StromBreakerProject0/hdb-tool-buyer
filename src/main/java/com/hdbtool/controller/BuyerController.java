package com.hdbtool.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdbtool.constant.ErrorConstant;
import com.hdbtool.dto.BuyHistoryDTO;
import com.hdbtool.dto.BuyerDetailsDTO;
import com.hdbtool.exception.ApiException;
import com.hdbtool.projection.ProductProjection;
import com.hdbtool.service.BuyerService;
import com.hddtool.vo.ApiResponse;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

	private static Logger log = Logger.getLogger(BuyerController.class);

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
	
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addBuyer(@RequestBody BuyerDetailsDTO buyerDetailsDTO) {
		BuyerDetailsDTO result = null;
		try {
			result = buyerService.addBuyer(buyerDetailsDTO);
		} catch (ApiException e) {
			log.error("Exception", e);
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Exception", e);
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(new ApiResponse(result, ErrorConstant.SUCESS), HttpStatus.OK);
	}
	
	@GetMapping("/cartDetails/{buyerId}")
	public ResponseEntity<ApiResponse> getCartDetailsByBuyerId(@PathVariable String buyerId) {
		List<ProductProjection> productList = null;
		try {
			productList = buyerService.getCartDetailsByBuyerId(buyerId);
		} catch (ApiException e) {
			log.error("Exception", e);
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Exception", e);
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(new ApiResponse(productList, ErrorConstant.SUCESS), HttpStatus.OK);
	}
	
//	@GetMapping("/buyProduct")
//	public ResponseEntity<ApiResponse> buyProduct(@RequestBody BuyProductDTO buyProductDTO) {
//		List<BuyProductDTO> bu = null;
//		try {
//			productList = buyerService.getCartDetailsByBuyerId(buyerId);
//		} catch (ApiException e) {
//			log.error("Exception", e);
//			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
//		} catch (Exception e) {
//			log.error("Exception", e);
//			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return new ResponseEntity<>(new ApiResponse(productList, ErrorConstant.SUCESS), HttpStatus.OK);
//	}
	
	@GetMapping("/buy/history")
	public ResponseEntity<ApiResponse> getBuyHistory(@PathVariable String buyerId) {
		List<BuyHistoryDTO> buyHistory = null;
		try {
			buyHistory = buyerService.getBuyHistory(buyerId);
		} catch (ApiException e) {
			log.error("Exception", e);
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Exception", e);
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(new ApiResponse(buyHistory, ErrorConstant.SUCESS), HttpStatus.OK);
	}

}
