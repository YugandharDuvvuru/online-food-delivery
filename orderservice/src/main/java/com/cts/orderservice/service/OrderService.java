package com.cts.orderservice.service;

import org.springframework.http.ResponseEntity;

import com.cts.orderservice.dto.OrderRequestDto;
import com.cts.orderservice.dto.OrderResponseDto;

public interface OrderService {
	public ResponseEntity<OrderResponseDto> placeOrder(Long userId,OrderRequestDto request);

}
