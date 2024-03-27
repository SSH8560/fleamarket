package com.ssh8560.fleamarket.domain.item.dto;

import lombok.Data;


@Data
public class ItemPostRequest {
    private String title;
    private String content;
    private Integer price;
    private Double x;
    private Double y;
    private String locationDetail;
}
