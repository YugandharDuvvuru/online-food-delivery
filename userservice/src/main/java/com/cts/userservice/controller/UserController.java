package com.cts.userservice.controller;

import com.cts.userservice.dto.UserAddressResponseDto;
import com.cts.userservice.entity.UserEntity;
import com.cts.userservice.dto.UserAddressDto;
import com.cts.userservice.dto.UserDetailsDto;
import com.cts.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/save-details")
    public ResponseEntity<String> saveUserDetails(@RequestBody UserEntity userEntity){
        return userService.saveUserDetails(userEntity);
    }
    @GetMapping("/get-details-by-id/{id}")
    public ResponseEntity<UserDetailsDto> getUserDetails(@PathVariable Long id){
      return userService.getUserDetailsById(id);
    }
    @PostMapping("/add-address/{userId}")
    public ResponseEntity<String> addUserAddress(@PathVariable Long userId, @RequestBody UserAddressDto userAddress){
        return userService.addUserAddress(userId,userAddress);
    }
    @GetMapping("/get-address/{userId}")
    public ResponseEntity<List<UserAddressResponseDto>> getUserAddresses(@PathVariable Long userId){
        return userService.getUserAddress(userId);
    }
    @PutMapping("/update/user-details/{userId}")
    public ResponseEntity<UserDetailsDto> updateUserDetails(@PathVariable Long userId,@RequestBody UserDetailsDto userDetails){
        return userService.updateUserById(userId,userDetails);
    }
    @DeleteMapping("/delete/user-by/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long userId){
        return userService.deleteUserById(userId);
    }
}
