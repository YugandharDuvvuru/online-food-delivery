package com.cts.orderservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.orderservice.dto.OrderEntityDto;
@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public ResponseEntity<String> placeOrder(OrderEntityDto entityDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
