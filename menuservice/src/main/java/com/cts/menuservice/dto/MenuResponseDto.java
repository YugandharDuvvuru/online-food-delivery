package com.cts.menuservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuResponseDto {
    private Long itemId;
    private Long restaurantId;
    private String itemName;
    private Integer price;
    private boolean availaible;
    private String category;
}
