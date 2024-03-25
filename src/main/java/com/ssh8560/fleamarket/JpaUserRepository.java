package com.ssh8560.fleamarket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaUserRepository extends JpaRepository<User, String> {
    List<User> findByUsername(String username);
}
