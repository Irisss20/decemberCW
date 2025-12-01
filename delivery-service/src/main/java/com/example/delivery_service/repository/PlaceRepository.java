package com.example.delivery_service.repository;

import com.example.delivery_service.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findByNameContainingIgnoreCase(String name);
    List<Place> findByType(Place.PlaceType type);
}
