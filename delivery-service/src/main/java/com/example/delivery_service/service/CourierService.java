package com.example.delivery_service.service;

import com.example.delivery_service.dto.CourierDto;
import com.example.delivery_service.entity.Courier;
import com.example.delivery_service.repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourierService {
    private final CourierRepository courierRepository;

    @Autowired
    public CourierService(CourierRepository courierRepository) {
        this.courierRepository = courierRepository;
    }

    /**
     * Найти первого доступного курьера (AVAILABLE) для автоматического назначения.
     */
    public Optional<Courier> findAvailable() {
        return courierRepository.findByStatus(Courier.Status.AVAILABLE).stream().findFirst();
    }

    @Transactional
    public void setStatus(Courier courier, Courier.Status status) {
        courier.setStatus(status);
        courierRepository.save(courier);
    }

    public static CourierDto toDto(Courier c) {
        return new CourierDto(c.getId(), c.getName(), c.getTransportType(), c.getStatus());
    }
}
