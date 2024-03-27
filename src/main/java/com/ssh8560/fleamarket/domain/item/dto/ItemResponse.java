package com.ssh8560.fleamarket.domain.item.dto;

import com.ssh8560.fleamarket.config.Constants;
import com.ssh8560.fleamarket.dto.ItemDto;
import com.ssh8560.fleamarket.dto.LocationDto;
import com.ssh8560.fleamarket.dto.UserInfoDto;
import com.ssh8560.fleamarket.entity.Item;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ItemResponse {
    private UserInfoDto user;
    private ItemDto item;
    private LocationDto location;
    private List<String> imagesUrl;

    public ItemResponse(Item itemEntity) {
        item = new ItemDto(itemEntity);
        user = new UserInfoDto(itemEntity.getUserInfo());
        location = new LocationDto(itemEntity.getLocation());
        imagesUrl = itemEntity.getImages().stream().map(image -> Constants.CLOUD_IMAGE_URL + image.getImageKey()).collect(Collectors.toList());
    }
}
