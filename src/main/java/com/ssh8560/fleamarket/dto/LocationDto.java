package com.ssh8560.fleamarket.dto;

import com.ssh8560.fleamarket.entity.Item;
import com.ssh8560.fleamarket.entity.Location;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class LocationDto {
    private Double x;
    private Double y;
    private String addressName;
    private String sido;
    private String gu;
    private String dong;
    private String detail;

    public LocationDto(Location location) {
        this.x = location.getX();
        this.y = location.getY();
        this.addressName = location.getAddressName();
        this.sido = location.getSido();
        this.gu = location.getGu();
        this.dong = location.getDong();
        this.detail = location.getDetail();
    }
}
