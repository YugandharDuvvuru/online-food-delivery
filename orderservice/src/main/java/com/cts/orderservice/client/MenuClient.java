package com.cts.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name="MENUSERVICE")
public interface MenuClient {
    @PutMapping("menu/update/no-of-items-delivered/{itemId}/{estimatedItemsDelivered}")
    public ResponseEntity<String> updateEstimatedItemsDelivered(@PathVariable Long itemId, @PathVariable Integer estimatedItemsDelivered);
}
