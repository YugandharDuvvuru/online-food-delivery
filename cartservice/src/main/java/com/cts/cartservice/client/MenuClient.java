package com.cts.cartservice.client;

import com.cts.cartservice.dto.MenuResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MENUSERVICE")
public interface MenuClient {
    @GetMapping("menu/get-item/details/{itemId}")
    public ResponseEntity<MenuResponseDto> getParticularItemDetails(@PathVariable Long itemId);
}
