package com.Scaler.BookMy.Show.repository;

import com.Scaler.BookMy.Show.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RegionRepository extends JpaRepository<Region,Long> {
    @Override
    Optional<Region> findById(Long regionId);
    @Override
    Region save(Region region);
}
