package com.cts.menuservice.client;

import com.cts.menuservice.dto.RestaurantResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="OWNERSERVICE")
public interface RestaurantClient {
    @GetMapping("restaurant/get-restaurant/{restaurantId}")
    public ResponseEntity<RestaurantResponseDto> getRestaurantById(@PathVariable Long restaurantId);
}
