package com.ssh8560.fleamarket.user;

import lombok.Data;

@Data
public class UserPostRequest {
    private String username;
    private String password;
    private String nickname;
}
