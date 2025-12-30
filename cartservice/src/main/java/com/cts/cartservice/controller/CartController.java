package com.cts.cartservice.controller;


import com.cts.cartservice.dto.CartItemDto;
import com.cts.cartservice.dto.MenuResponseDto;
import com.cts.cartservice.dto.MessageResponse;
import com.cts.cartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @PostMapping("/add/item/to-cart")
    public ResponseEntity<MessageResponse> addItemToCart(@RequestBody CartItemDto cartItemDto){
      return cartService.addItemToCart(cartItemDto);
    }
    @DeleteMapping("/clear/cart/{userId}")
    public ResponseEntity<MessageResponse> deleteAllCartItems(@PathVariable Long userId){
     return cartService.clearCartItems(userId);
    }
    @PutMapping("/update/cart/item")
    public ResponseEntity<MessageResponse> updateCartItem(@RequestBody CartItemDto cartItemDto){
      return cartService.updateCartitem(cartItemDto);
    }
    @DeleteMapping("/delete/item/{userId}/{itemId}")
    public ResponseEntity<MessageResponse> deleteItemByUserIdAndItemId(@PathVariable Long userId,@PathVariable Long itemId){
        return cartService.deleteItemByUserIdAndItemId(userId,itemId);
    }
    @GetMapping("/get/all-cart-items/for/user-with/{userId}")
    public ResponseEntity<List<MenuResponseDto>> getAllCartItemsForUser(@PathVariable Long userId){
        return cartService.getAllCartItemsForUser(userId);
    }
}
