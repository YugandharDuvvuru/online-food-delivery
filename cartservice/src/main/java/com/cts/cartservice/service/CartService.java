package com.cts.cartservice.service;

import com.cts.cartservice.dto.CartItemDto;
import com.cts.cartservice.dto.MenuResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CartService {
    public ResponseEntity<String> addItemToCart(CartItemDto cartItemDto);
    public ResponseEntity<String> clearCartItems(Long userId);
    public ResponseEntity<String> updateCartitem(CartItemDto cartItemDto);
    public ResponseEntity<String> deleteItemByUserIdAndItemId(Long userId,Long itemId);
    public ResponseEntity<List<MenuResponseDto>> getAllCartItemsForUser(Long userId);
}
