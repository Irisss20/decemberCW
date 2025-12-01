package com.example.delivery_service.service;

import com.example.delivery_service.dto.DeliveryOrderDto;
import com.example.delivery_service.dto.OrderItemDto;
import com.example.delivery_service.entity.*;
import com.example.delivery_service.exception.ApiException;
import com.example.delivery_service.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final DeliveryOrderRepository orderRepository;
    private final CourierService courierService;
    private final LocationService locationService;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderService(DeliveryOrderRepository orderRepository, CourierService courierService, LocationService locationService,
                        ProductRepository productRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.courierService = courierService;
        this.locationService = locationService;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public DeliveryOrderDto createOrder(Long userId, List<OrderCreateItem> items, String address) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ApiException("Пользователь не найден"));
        List<OrderItem> orderItems = new ArrayList<>();
        double totalWeight = 0;
        double totalSum = 0;
        for (OrderCreateItem dto : items) {
            Product product = productRepository.findById(dto.productId()).orElseThrow(() -> new ApiException("Товар не найден"));
            double weight = product.getWeightKg() * dto.quantity();
            double sum = product.getPrice() * dto.quantity();
            totalWeight += weight;
            totalSum += sum;
            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(dto.quantity());
            item.setWeightKg(weight);
            item.setPricePerUnit(product.getPrice());
            item.setTotal(sum);
            orderItems.add(item);
        }
        if (totalWeight > 15.0) {
            throw new ApiException("Суммарный вес заказа не может превышать 15 кг");
        }
        Courier courier = courierService.findAvailable()
                .orElseThrow(() -> new ApiException("Нет доступных курьеров, повторите позже"));
        courierService.setStatus(courier, Courier.Status.BUSY);
        DeliveryOrder order = new DeliveryOrder();
        order.setUser(user);
        order.setItems(orderItems);
        for (OrderItem item : orderItems) item.setOrder(order);
        order.setTotalWeightKg(totalWeight);
        order.setStatus(DeliveryOrder.Status.ASSIGNED);
        order.setAddress(address);
        order.setCourier(courier);
        int estimated = locationService.estimateDeliveryMinutes(order);
        order.setEstimatedMinutes(estimated);
        DeliveryOrder saved = orderRepository.save(order);
        return toDto(saved);
    }

    public static DeliveryOrderDto toDto(DeliveryOrder o) {
        List<OrderItemDto> itemDtos = new ArrayList<>();
        if (o.getItems()!=null)
            for (OrderItem i : o.getItems())
                itemDtos.add(new OrderItemDto(i.getId(),i.getProduct().getId(),i.getQuantity(),i.getPricePerUnit(),i.getTotal()));
        return new DeliveryOrderDto(o.getId(), o.getUser().getId(), itemDtos, o.getTotalWeightKg(), o.getStatus(), o.getAddress(), o.getEstimatedMinutes(),
                o.getCourier()!=null ? o.getCourier().getId() : null);
    }

    public record OrderCreateItem(Long productId, int quantity) {}
}
