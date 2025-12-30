package com.cts.orderservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.orderservice.dto.MenuResponseDto;

@FeignClient(name="CARTSERVICE")
public interface CartClient {
	 @GetMapping("cart/get/all-cart-items/for/user-with/{userId}")
	 public ResponseEntity<List<MenuResponseDto>> getAllCartItemsForUser(@PathVariable Long userId);
     @DeleteMapping("cart/clear/cart/{userId}")
     public ResponseEntity<String> deleteAllCartItems(@PathVariable Long userId);
}
