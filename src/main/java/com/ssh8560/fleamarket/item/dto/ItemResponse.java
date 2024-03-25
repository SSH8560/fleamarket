package com.ssh8560.fleamarket.item.dto;

import com.ssh8560.fleamarket.entity.Item;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItemResponse {
    private final Long id;
    private final String userId;
    private final String title;
    private final String category;
    private final Integer price;
    private final String content;
    private final LocalDateTime createdDate;
    private final LocalDateTime updatedDate;


    public ItemResponse(Item item) {
        this.id = item.getId();
        this.userId = item.getUserInfo().getId();
        this.title = item.getTitle();
        this.category = item.getCategory();
        this.price = item.getPrice();
        this.content = item.getContent();
        this.createdDate = item.getCreatedDate();
        this.updatedDate = item.getUpdatedDate();
    }
}
