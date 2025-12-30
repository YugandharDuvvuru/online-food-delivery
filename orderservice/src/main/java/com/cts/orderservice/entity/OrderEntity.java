package com.cts.orderservice.entity;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }

    public DeliveryAddress getAddress() {
        return address;
    }

    public void setAddress(DeliveryAddress address) {
        this.address = address;
    }

    public OrderEntity() {
    }

    public OrderEntity(Long orderId,
                       Long userId,
                       Integer totalAmount,
                       String invoiceNumber,
                       String status,
                       LocalDateTime orderTime,
                       List<OrderItems> orderItems,
                       DeliveryAddress address) {
        this.orderId = orderId;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.invoiceNumber = invoiceNumber;
        this.status = status;
        this.orderTime = orderTime;
        this.orderItems = orderItems;
        this.address = address;
    }

}