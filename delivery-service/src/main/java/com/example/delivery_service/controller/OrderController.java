package com.example.delivery_service.controller;

import com.example.delivery_service.dto.DeliveryOrderDto;
import com.example.delivery_service.service.OrderService;
import com.example.delivery_service.entity.DeliveryOrder;
import com.example.delivery_service.repository.DeliveryOrderRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;
    private final DeliveryOrderRepository orderRepository;

    @Autowired
    public OrderController(OrderService orderService, DeliveryOrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public DeliveryOrderDto createOrder(@RequestParam Long userId,
                                        @RequestBody @Valid List<OrderService.OrderCreateItem> items,
                                        @RequestParam String address) {
        return orderService.createOrder(userId, items, address);
    }

    @GetMapping
    public List<DeliveryOrderDto> getOrders(@RequestParam Long userId) {
        return orderRepository.findByUser(new com.example.delivery_service.entity.User() {{ setId(userId); }})
                .stream().map(OrderService::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DeliveryOrderDto getOrder(@PathVariable Long id) {
        DeliveryOrder o = orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Order not found"));
        return OrderService.toDto(o);
    }
}
