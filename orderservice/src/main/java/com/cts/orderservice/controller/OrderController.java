package com.cts.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.orderservice.dto.OrderEntityDto;
import com.cts.orderservice.entity.OrderEntity;
import com.cts.orderservice.service.OrderService;
@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@PostMapping("/place/order")
	public ResponseEntity<String> placeOrder(OrderEntityDto orderEntityDto){
		return orderService.placeOrder(orderEntityDto);
	}

}
