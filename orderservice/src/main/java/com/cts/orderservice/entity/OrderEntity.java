package com.cts.orderservice.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	private Long userId;
	private Integer totalAmount;
	private String invoiceNumber;
	private String status;
	private LocalDateTime orderTime;
	@OneToMany(mappedBy = "order",fetch = FetchType.LAZY,cascade = CascadeType.ALL )
	private List<OrderItems> orderItems;
	@Embedded
	private DeliveryAddress address;

}
