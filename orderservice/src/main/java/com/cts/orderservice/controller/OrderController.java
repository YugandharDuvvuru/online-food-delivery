package com.cts.orderservice.controller;

import com.cts.orderservice.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cts.orderservice.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@PostMapping("/place/order/{userId}")
	public ResponseEntity<OrderResponseDto> placeOrder(@PathVariable Long userId,@RequestBody OrderRequestDto request){
		return orderService.placeOrder(userId, request);
	}
    @PutMapping("toggle/orderStatus/{status}/{orderId}")
    public ResponseEntity<MessageResponse> toogleOrderStatus(@PathVariable String status,@PathVariable Long orderId){
        return orderService.toggleOrderStatus(status,orderId);
    }
    @GetMapping("/get-order/details/{orderId}")
    public ResponseEntity<OrderResponseDto> getOrderDetails(@PathVariable Long orderId){
        return orderService.getOrderDetails(orderId);
    }
    @DeleteMapping("/cancel/order/{orderId}")
    public ResponseEntity<MessageResponse> cancelOrder(@PathVariable Long orderId){
        return orderService.cancelOrder(orderId);
    }
    @GetMapping("show/orders/for-particular-restaurant/{restaurantId}")
    public ResponseEntity<List<RestaurantOrderSummaryDto>> getIncommingOrders(@PathVariable Long restaurantId){
        return orderService.showIncommingOrdersToRestaurant(restaurantId);
    }
    @GetMapping("/get/order/history/for-user/{userId}")
    public ResponseEntity<List<OrderResponseDto>> getOrderHistory(@PathVariable Long userId){
        return orderService.getOrderHistory(userId);
    }

}
