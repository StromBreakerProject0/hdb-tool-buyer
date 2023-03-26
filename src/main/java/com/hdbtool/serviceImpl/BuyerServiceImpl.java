package com.hdbtool.serviceImpl;

import java.util.List;

import com.hdbtool.dto.BuyHistoryDTO;
import com.hdbtool.dto.BuyerDetailsDTO;
import com.hdbtool.exception.ApiException;
import com.hdbtool.model.Buyer;
import com.hdbtool.model.User;
import com.hdbtool.projection.ProductProjection;
import com.hdbtool.service.BuyerService;

public class BuyerServiceImpl implements BuyerService{

	@Override
	public BuyerDetailsDTO getBuyerDetails(String id) {
		User user = new User();
		return null;
	}

	@Override
	public BuyerDetailsDTO addBuyer(BuyerDetailsDTO buyerDetailsDTO) {
		if(buyerDetailsDTO.getFirstName() == null || buyerDetailsDTO.getLastName()== null || buyerDetailsDTO.getEmail() == null || buyerDetailsDTO.getPhoneNumber() == null || buyerDetailsDTO.getPassword() == null) {
			throw new ApiException("Please fill up the mandatory fields");
		}else {
			Buyer buyer = new Buyer();
			
		}
		return null;
	}

	@Override
	public List<ProductProjection> getCartDetailsByBuyerId(String buyerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuyHistoryDTO> getBuyHistory(String buyerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
