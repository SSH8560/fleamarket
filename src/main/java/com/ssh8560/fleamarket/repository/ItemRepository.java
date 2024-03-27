package com.ssh8560.fleamarket.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssh8560.fleamarket.entity.Item;
import com.ssh8560.fleamarket.entity.QItem;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ssh8560.fleamarket.entity.QItem.item;

@Repository
public class ItemRepository {
    private final JPAQueryFactory queryFactory;

    public ItemRepository(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    public List<Item> findByParams(
        String gu, String dong
    ){
        return queryFactory
            .selectFrom(item)
            .where(item.location.gu.contains(gu).and(item.location.dong.contains(dong)))
            .fetch();
    }
}
