package com.cts.menuservice.controller;

import com.cts.menuservice.dto.FilterDto;
import com.cts.menuservice.dto.MenuAndRestaurantDto;
import com.cts.menuservice.dto.MenuDto;
import com.cts.menuservice.dto.MenuResponseDto;
import com.cts.menuservice.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @PostMapping("/add-item/{restaurantId}")
    public ResponseEntity<String> addItemsToMenu(@PathVariable Long restaurantId, @RequestBody MenuDto menuDto) {
        return menuService.addItemToMenu(restaurantId, menuDto);
    }

    @GetMapping("/get-items/restaurant/{restaurantId}")
    public ResponseEntity<List<MenuResponseDto>> getItemsFromRestaurant(@PathVariable Long restaurantId) {
        return menuService.getItemsFromRestaurant(restaurantId);
    }

    @GetMapping("/get-item/details/{itemId}")
    public ResponseEntity<MenuResponseDto> getParticularItemDetails(@PathVariable Long itemId) {
        return menuService.getParticularItemDetails(itemId);
    }

    @PatchMapping("/toggle/availaibility/item/{itemId}/{status}")
    public ResponseEntity<String> toggleAvailbility(@PathVariable Long itemId, @PathVariable boolean status) {
        return menuService.toggleAvailbility(itemId, status);
    }

    @PutMapping("/update/item-details/{itemId}")
    public ResponseEntity<MenuResponseDto> updateItem(@PathVariable Long itemId, @RequestBody MenuDto menuDto) {
        return menuService.updateItem(itemId, menuDto);
    }

    @GetMapping("/get-item-by-name/{name}")
    public ResponseEntity<List<MenuAndRestaurantDto>> searchItem(@PathVariable String name) {
        return menuService.searchItemByName(name);
    }

    @GetMapping("/filter/item-by/category-or-price")
    public ResponseEntity<List<MenuAndRestaurantDto>> filterItemsBasedOnCategoryAndPrice(@RequestBody FilterDto filterDto) {
        return menuService.fitlterByCategoryAndPrice(filterDto);
    }

    @DeleteMapping("/remove/item/{itemId}")
    public ResponseEntity<String> deleteItemById(@PathVariable Long itemId) {
        return menuService.deleteItemById(itemId);
    }

    @PatchMapping("/update/no-of-items-delivered/{itemId}/{estimatedItemsDelivered}")
    public ResponseEntity<String> updateEstimatedItemsDelivered(@PathVariable Long itemId,@PathVariable Integer estimatedItemsDelivered){
        return menuService.updateEstimatedItemsDelivered(itemId,estimatedItemsDelivered);
    }
}
