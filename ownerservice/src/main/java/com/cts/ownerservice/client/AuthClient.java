package com.cts.ownerservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@FeignClient(name="AUTHSERVICE")
public interface AuthClient {
    @PutMapping("auth/update/email/by-authId/{authId}/{email}")
    public String updateEmail(@PathVariable Long authId, @PathVariable String email);

    @DeleteMapping("auth/delete/the/user/by/{authId}")
    public String deleteUserByAuthId(@PathVariable Long authId);
}
