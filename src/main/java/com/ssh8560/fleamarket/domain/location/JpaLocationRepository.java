package com.ssh8560.fleamarket.domain.location;

import com.ssh8560.fleamarket.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaLocationRepository extends JpaRepository<Location, Long> {
}
