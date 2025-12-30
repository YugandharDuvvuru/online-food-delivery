package com.cts.orderservice.service;

import org.springframework.http.ResponseEntity;

<<<<<<< HEAD
import com.cts.orderservice.dto.OrderRequestDto;
import com.cts.orderservice.dto.OrderResponseDto;

public interface OrderService {
	public ResponseEntity<OrderResponseDto> placeOrder(Long userId,OrderRequestDto request);
=======
import com.cts.orderservice.dto.OrderEntityDto;

public interface OrderService {
	public ResponseEntity<String> placeOrder(OrderEntityDto entityDto);
>>>>>>> 139106114d557b4e10880cd7fa32ac7fa6de98fb

}
