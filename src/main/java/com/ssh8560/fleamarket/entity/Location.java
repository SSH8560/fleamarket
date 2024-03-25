package com.ssh8560.fleamarket.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Location {
    @Id
    @Column(name = "item_id")
    private Long itemId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
    private Double x;
    private Double y;
    @Column(name = "address_name")
    private String addressName;
    private String sido;
    private String gu;
    private String dong;
    private String detail;

    public Location(Long itemId, Double x, Double y, String addressName, String sido, String gu, String dong, String detail) {
        this.itemId = itemId;
        this.x = x;
        this.y = y;
        this.addressName = addressName;
        this.sido = sido;
        this.gu = gu;
        this.dong = dong;
        this.detail = detail;
    }
}
