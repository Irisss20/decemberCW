package com.example.delivery_service.repository;

import com.example.delivery_service.entity.Product;
import com.example.delivery_service.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByPlace(Place place);
}
