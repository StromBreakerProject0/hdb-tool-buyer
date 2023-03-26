package com.hdbtool.service;

import java.util.List;

import com.hdbtool.dto.BuyHistoryDTO;
import com.hdbtool.dto.BuyerDetailsDTO;
import com.hdbtool.projection.ProductProjection;

public interface BuyerService {

	BuyerDetailsDTO getBuyerDetails(String id);

	BuyerDetailsDTO addBuyer(BuyerDetailsDTO buyerDetailsDTO);

	List<ProductProjection> getCartDetailsByBuyerId(String buyerId);

	List<BuyHistoryDTO> getBuyHistory(String buyerId);

}
