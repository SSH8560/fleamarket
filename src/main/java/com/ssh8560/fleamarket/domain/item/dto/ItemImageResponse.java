package com.ssh8560.fleamarket.domain.item.dto;

import lombok.Data;

import java.util.List;

@Data
public class ItemImageResponse {
    private final List<String> images;

    public ItemImageResponse(List<String> images) {
        this.images = images;
    }
}
