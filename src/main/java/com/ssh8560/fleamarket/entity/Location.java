package com.ssh8560.fleamarket.entity;

import com.ssh8560.fleamarket.client.RegionResponse;
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

    private String code;
    private Double x;
    private Double y;
    @Column(name = "address_name")
    private String addressName;
    private String sido;
    private String gu;
    private String dong;
    private String lee;
    private String detail;

    public Location(Long itemId, String detail,Double x,Double y, RegionResponse.Address address) {
        this.itemId = itemId;
        this.code = address.getCode();
        this.x = x;
        this.y = y;
        this.addressName = address.getAddressName();
        this.sido = address.getRegion1depthName();
        this.gu = address.getRegion2depthName();
        this.dong = address.getRegion3depthName();
        this.lee = address.getRegion4depthName();
        this.detail = detail;
    }
}
