package com.cts.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.orderservice.dto.OrderRequestDto;
import com.cts.orderservice.dto.OrderResponseDto;
import com.cts.orderservice.service.OrderService;
@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@PostMapping("/place/order/{userId}")
	public ResponseEntity<OrderResponseDto> placeOrder(@PathVariable Long userId,@RequestBody OrderRequestDto request){
		return orderService.placeOrder(userId, request);
	}

}
