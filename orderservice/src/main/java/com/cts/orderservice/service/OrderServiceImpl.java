package com.cts.orderservice.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.cts.orderservice.client.MenuClient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.orderservice.Repository.OrderRepository;
import com.cts.orderservice.client.CartClient;
import com.cts.orderservice.dto.MenuResponseDto;
import com.cts.orderservice.dto.OrderRequestDto;
import com.cts.orderservice.dto.OrderResponseDto;
import com.cts.orderservice.entity.OrderEntity;
import com.cts.orderservice.entity.OrderItems;
import com.cts.orderservice.exception.CartEmptyException;
import com.cts.orderservice.exception.ItemUnavailableException;
import com.cts.orderservice.exception.PaymentFailedException;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private CartClient cartClient;
    @Autowired
    private MenuClient menuClient;

	@Override
    @Transactional
	public ResponseEntity<OrderResponseDto> placeOrder(Long userId, OrderRequestDto request) {
		List<MenuResponseDto> cartItems=cartClient.getAllCartItemsForUser(userId).getBody();
		if(cartItems.size()==0) {
            System.out.println("cart items is empty");
			throw new CartEmptyException("Cart is empty");
		}
		Integer total=0;
		List<OrderItems> orderItems = new ArrayList<>();
		for(MenuResponseDto item:cartItems) {
			if(item.getEstimatedItemsDelivered()<item.getQuantity()) {
				throw new ItemUnavailableException("Item is not availaible at the moment (out of stock) for "+item.getItemName()+" in this restuarant");
			}
            menuClient.updateEstimatedItemsDelivered(item.getItemId(),item.getEstimatedItemsDelivered()-item.getQuantity());
			OrderItems items=new OrderItems();
			items.setItemId(item.getItemId());
			items.setItemName(item.getItemName());
			items.setRestaurantId(item.getRestaurantId());
			items.setPrice(item.getPrice());
			items.setCategory(item.getCategory());
			items.setAvailaible(item.isAvailaible());
			items.setQuantity(item.getQuantity());
			orderItems.add(items);
			total += item.getPrice() * item.getQuantity();
		}
        System.out.println(orderItems);
		boolean paymentSuccess = true;
        if (!paymentSuccess) {
            throw new PaymentFailedException("Payment failed");
        }
        OrderEntity entity=new OrderEntity();
        entity.setUserId(userId);
        entity.setAddress(request.getDeliveryAddress());
        entity.setInvoiceNumber(UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        entity.setTotalAmount(total);
        entity.setStatus("Paid");
        entity.setOrderTime(LocalDateTime.now());
        orderItems.forEach(i->i.setOrder(entity));
        entity.setOrderItems(orderItems);
        orderRepo.save(entity);
        OrderResponseDto dto=new OrderResponseDto(entity);
        cartClient.deleteAllCartItems(userId);
        
		return ResponseEntity.ok(dto);
	}

}
