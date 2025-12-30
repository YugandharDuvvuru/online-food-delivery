package com.cts.ownerservice.controller;

import com.cts.ownerservice.dto.MessageResponse;
import com.cts.ownerservice.dto.RestaurantDetailsDto;
import com.cts.ownerservice.dto.RestaurantResponseDto;
import com.cts.ownerservice.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {
    @Autowired
    private OwnerService ownerService;
    @PostMapping("/add-restaurant-details/{ownerId}")
    public ResponseEntity<MessageResponse> addRestaurant(@PathVariable Long ownerId, @RequestBody RestaurantDetailsDto restaurantDetailsDto){
        return ownerService.addRestaurants(ownerId,restaurantDetailsDto);
    }
    @GetMapping("/get-restaurant-details/{ownerId}")
    public ResponseEntity<List<RestaurantResponseDto>> getRestaurantsOfOwner(@PathVariable Long ownerId){
        return ownerService.getResataurantsOfOwner(ownerId);
    }
    @GetMapping("/get-restaurant/{restaurantId}")
    public ResponseEntity<RestaurantResponseDto> getRestaurantById(@PathVariable Long restaurantId){
        return ownerService.getRestaurantsById(restaurantId);
    }
    @PostMapping("/toggle-open-status/{status}/{restaurantId}")
    public ResponseEntity<MessageResponse> toggleOpenStatus(@PathVariable boolean status,@PathVariable Long restaurantId){
        return ownerService.toggleOpenStatus(status,restaurantId);
    }
    @GetMapping("/get-restaurant/by-name/{restaurantName}")
    public ResponseEntity<List<RestaurantResponseDto>> getRestaurantsByName(@PathVariable String restaurantName){
     return ownerService.searchRestaurantByName(restaurantName);
    }
    @PutMapping("/update/restaurant/{restaurantId}")
    public ResponseEntity<RestaurantResponseDto> updateRestaurantById(@PathVariable Long restaurantId,@RequestBody RestaurantDetailsDto restaurantDetails){
     return  ownerService.updateRestaurantById(restaurantId,restaurantDetails);
    }
    @DeleteMapping("/delete/restaurant/{restaurantId}")
    public ResponseEntity<MessageResponse> detelteRestaurantById(@PathVariable Long restaurantId){
        return ownerService.deleteRestaurantById(restaurantId);
    }
}
