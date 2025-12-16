package com.cts.ownerservice.service;

import com.cts.ownerservice.dto.OwnerDetailsDto;
import com.cts.ownerservice.dto.RestaurantDetailsDto;
import com.cts.ownerservice.dto.RestaurantResponseDto;
import com.cts.ownerservice.entity.OwnerEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OwnerService {
    public ResponseEntity<String> saveOwnerDetails(OwnerEntity ownerEntity);
    public ResponseEntity<OwnerDetailsDto>getOwnerDetailsById(Long id);
    public ResponseEntity<String> addRestaurants(Long ownerId, RestaurantDetailsDto restaurantDetails);
    public ResponseEntity<List<RestaurantResponseDto>> getResataurantsOfOwner(Long ownerId);
    public ResponseEntity<RestaurantResponseDto> getRestaurantsById(Long restaurantId);
    public ResponseEntity<String> toggleOpenStatus(boolean status,Long restaurantId);
    public ResponseEntity<List<RestaurantResponseDto>> searchRestaurantByName(String name);
    public ResponseEntity<RestaurantResponseDto> updateRestaurantById(Long restaurantId,RestaurantDetailsDto restaurantDetails);
    public ResponseEntity<String> deleteRestaurantById(Long restaurantId);
    public ResponseEntity<OwnerDetailsDto> updateOwnerById(Long ownerId,OwnerDetailsDto ownerDetails);
    public ResponseEntity<String> deleteOwnerById(Long ownerId);
}
