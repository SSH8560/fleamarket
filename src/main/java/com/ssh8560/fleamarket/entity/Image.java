package com.ssh8560.fleamarket.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "item_id")
    private Long itemId;
    @Column(name = "image_key")
    private String imageKey;

    public Image(Long itemId, String imageKey) {
        this.itemId = itemId;
        this.imageKey = imageKey;
    }
}
