package com.cts.orderservice.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderItemsId;
	private Long itemId;
    private Long restaurantId;
    private String itemName;
    private Integer price;
    private Integer estimatedItemsDelivered;
    private boolean availaible;
    private String category;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private OrderEntity order;

}
