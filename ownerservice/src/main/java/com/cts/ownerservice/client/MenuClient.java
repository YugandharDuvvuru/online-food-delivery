package com.cts.ownerservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MENUSERVICE")
public interface MenuClient {
	@DeleteMapping("menu/delete/items/by/{restaurantId}")
    public void deleteItemsOfRestaurant(@PathVariable Long restaurantId);
}
