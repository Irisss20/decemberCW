package com.example.delivery_service.dto;

import com.example.delivery_service.entity.DeliveryOrder;
import java.util.List;

public class DeliveryOrderDto {
    private Long id;
    private Long userId;
    private List<OrderItemDto> items;
    private double totalWeightKg;
    private DeliveryOrder.Status status;
    private String address;
    private Integer estimatedMinutes;
    private Long courierId;

    public DeliveryOrderDto() {}

    public DeliveryOrderDto(Long id, Long userId, List<OrderItemDto> items, double totalWeightKg,
                            DeliveryOrder.Status status, String address, Integer estimatedMinutes, Long courierId) {
        this.id = id;
        this.userId = userId;
        this.items = items;
        this.totalWeightKg = totalWeightKg;
        this.status = status;
        this.address = address;
        this.estimatedMinutes = estimatedMinutes;
        this.courierId = courierId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public List<OrderItemDto> getItems() { return items; }
    public void setItems(List<OrderItemDto> items) { this.items = items; }
    public double getTotalWeightKg() { return totalWeightKg; }
    public void setTotalWeightKg(double totalWeightKg) { this.totalWeightKg = totalWeightKg; }
    public DeliveryOrder.Status getStatus() { return status; }
    public void setStatus(DeliveryOrder.Status status) { this.status = status; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public Integer getEstimatedMinutes() { return estimatedMinutes; }
    public void setEstimatedMinutes(Integer estimatedMinutes) { this.estimatedMinutes = estimatedMinutes; }
    public Long getCourierId() { return courierId; }
    public void setCourierId(Long courierId) { this.courierId = courierId; }
}
