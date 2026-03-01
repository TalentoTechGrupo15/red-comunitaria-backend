package com.redcomunitaria.talentotech.repository;

import com.redcomunitaria.talentotech.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
}
