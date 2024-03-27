package com.ssh8560.fleamarket.dto;

import com.ssh8560.fleamarket.entity.UserInfo;
import lombok.Data;

@Data
public class UserInfoDto {
    private final String id;
    private final String nickname;

    public UserInfoDto(UserInfo userInfo) {
        this.id = userInfo.getId();
        this.nickname = userInfo.getNickname();
    }
}
