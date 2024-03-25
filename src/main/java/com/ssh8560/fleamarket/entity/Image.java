package com.ssh8560.fleamarket.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Image {
    @Id
    private String id;
    @Column(name = "item_id")
    private Long itemId;

    public Image(String id, Long itemId) {
        this.id = id;
        this.itemId = itemId;
    }
}
