package com.ssh8560.fleamarket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    private String id;
    private String username;
    private String password;

    public User(UUID uuid, String username, String password) {
        this.id = uuid.toString();
        this.username = username;
        this.password = password;
    }
}
