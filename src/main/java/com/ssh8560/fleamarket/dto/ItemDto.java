package com.ssh8560.fleamarket.dto;

import com.ssh8560.fleamarket.entity.Item;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItemDto {
    private final Long id;
    private final String title;
    private final Integer price;
    private final String content;
    private final LocalDateTime createdDate;
    private final LocalDateTime updatedDate;


    public ItemDto(Item item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.price = item.getPrice();
        this.content = item.getContent();
        this.createdDate = item.getCreatedDate();
        this.updatedDate = item.getUpdatedDate();
    }
}
