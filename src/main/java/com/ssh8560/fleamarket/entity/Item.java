package com.ssh8560.fleamarket.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Item extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String category;

    private String content;

    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_info_id")
    private UserInfo userInfo;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private List<Image> images;

    @OneToOne(mappedBy = "item")
    private Location location;

    public Item(UserInfo userInfo, String title, String category, String content, Integer price) {
        this.userInfo = userInfo;
        this.title = title;
        this.category = category;
        this.content = content;
        this.price = price;
    }
}
