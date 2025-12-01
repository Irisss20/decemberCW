package com.example.delivery_service.repository;

import com.example.delivery_service.entity.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourierRepository extends JpaRepository<Courier, Long> {
    List<Courier> findByStatus(Courier.Status status);
}
