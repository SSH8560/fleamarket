package com.ssh8560.fleamarket;

import com.ssh8560.fleamarket.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaItemRepository extends JpaRepository<Item,Long> {
}
