package com.cts.menuservice.service;

import com.cts.menuservice.dto.FilterDto;
import com.cts.menuservice.dto.MenuAndRestaurantDto;
import com.cts.menuservice.dto.MenuDto;
import com.cts.menuservice.dto.MenuResponseDto;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface MenuService {
    public ResponseEntity<String> addItemToMenu(Long restaurantId, MenuDto menuDto);
    public ResponseEntity<List<MenuResponseDto>> getItemsFromRestaurant(Long restaurantId);
    public ResponseEntity<MenuResponseDto> getParticularItemDetails(Long itemID);
    public ResponseEntity<String> toggleAvailbility(Long itemId,boolean status);
    public ResponseEntity<MenuResponseDto> updateItem(Long itemId,MenuDto menuDto);
    public ResponseEntity<List<MenuAndRestaurantDto>> searchItemByName(String name);
    public ResponseEntity<List<MenuAndRestaurantDto>> fitlterByCategoryAndPrice(FilterDto filterDto);
    public ResponseEntity<String> deleteItemById(Long itemId);
    public ResponseEntity<String> updateEstimatedItemsDelivered(Long itemId,Integer itemsDelivered);

}
