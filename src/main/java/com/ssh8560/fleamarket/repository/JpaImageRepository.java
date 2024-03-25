package com.ssh8560.fleamarket.repository;

import com.ssh8560.fleamarket.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaImageRepository extends JpaRepository<Image, String> {
    List<Image> findByItemId(Long itemId);
}
