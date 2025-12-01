package com.example.delivery_service.entity;

import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private DeliveryOrder order;

    @ManyToOne(optional = false)
    private Product product;

    private int quantity;
    private double weightKg;
    private double pricePerUnit;
    private double total;

    // Геттеры/сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public DeliveryOrder getOrder() { return order; }
    public void setOrder(DeliveryOrder order) { this.order = order; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getWeightKg() { return weightKg; }
    public void setWeightKg(double weightKg) { this.weightKg = weightKg; }
    public double getPricePerUnit() { return pricePerUnit; }
    public void setPricePerUnit(double pricePerUnit) { this.pricePerUnit = pricePerUnit; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}
