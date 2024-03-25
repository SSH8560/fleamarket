package com.ssh8560.fleamarket.userinfo;

import com.ssh8560.fleamarket.entity.UserInfo;
import lombok.Data;

@Data
public class UserInfoResponse {
    private final String nickname;

    public UserInfoResponse(UserInfo userInfo) {
        this.nickname = userInfo.getNickname();
    }
}
