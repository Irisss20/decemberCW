package com.example.delivery_service.service;

import com.example.delivery_service.entity.DeliveryOrder;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class LocationService {
    private final Random random = new Random();
    /**
     * Симуляция времени доставки: base + множители за вес, количество, и немного случайных минут.
     */
    public int estimateDeliveryMinutes(DeliveryOrder order) {
        double baseTime = 20;
        double extraWeight = Math.max(0, order.getTotalWeightKg() - 5) * 2;
        double extraItems = Math.max(0, order.getItems() != null ? order.getItems().size() - 3 : 0) * 3;
        double randomMinutes = random.nextInt(10); // 0..9
        return (int) (baseTime + extraWeight + extraItems + randomMinutes);
    }
}
