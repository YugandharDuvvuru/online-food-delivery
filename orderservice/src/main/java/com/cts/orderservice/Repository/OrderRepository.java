package com.cts.orderservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.orderservice.entity.OrderEntity;
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long>{
}
