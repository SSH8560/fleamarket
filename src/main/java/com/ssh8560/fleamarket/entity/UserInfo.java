package com.ssh8560.fleamarket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserInfo {
    @Id
    private String id;
    private String nickname;

    public UserInfo(UUID id, String nickname) {
        this.id = id.toString();
        this.nickname = nickname;
    }
}
