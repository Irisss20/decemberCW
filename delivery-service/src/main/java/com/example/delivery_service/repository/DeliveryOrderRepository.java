package com.example.delivery_service.repository;

import com.example.delivery_service.entity.DeliveryOrder;
import com.example.delivery_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, Long> {
    List<DeliveryOrder> findByUser(User user);
}
