package com.ssh8560.fleamarket.repository;

import com.ssh8560.fleamarket.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserInfoRepository extends JpaRepository<UserInfo, String> {
}
