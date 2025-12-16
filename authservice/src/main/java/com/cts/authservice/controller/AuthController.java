package com.cts.authservice.controller;

import com.cts.authservice.dto.JwtResponseDto;
import com.cts.authservice.dto.UserDetailsDto;
import com.cts.authservice.dto.UserLoginDto;
import com.cts.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/user-register/{role}")
    public ResponseEntity<String> registerUser(@PathVariable String role, @RequestBody UserDetailsDto userDetailsDto){
       return authService.registerUser(role,userDetailsDto);

    }
    @PostMapping("/user-login")
    public ResponseEntity<JwtResponseDto> validateUserLogin(@RequestBody UserLoginDto userLoginDto){
        return authService.checkLoginDetails(userLoginDto);
    }
    @PutMapping ("/update/email/by-authId/{authId}/{email}")
    public String updateEmail(@PathVariable Long authId,@PathVariable String email){
      return authService.updateEmail(authId,email);
    }
    @DeleteMapping("delete/the/user/by/{authId}")
    public String deleteUserByAuthId(@PathVariable Long authId){
        return authService.deleteUserById(authId);
    }


}
