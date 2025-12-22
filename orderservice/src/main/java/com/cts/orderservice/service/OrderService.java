package com.cts.orderservice.service;

import org.springframework.http.ResponseEntity;

import com.cts.orderservice.dto.OrderEntityDto;

public interface OrderService {
	public ResponseEntity<String> placeOrder(OrderEntityDto entityDto);

}
