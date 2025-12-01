package com.example.delivery_service.dto;

public class OrderItemDto {
    private Long id;
    private Long productId;
    private int quantity;
    private double pricePerUnit;
    private double total;

    public OrderItemDto() {}
    public OrderItemDto(Long id, Long productId, int quantity, double pricePerUnit, double total) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.total = total;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getPricePerUnit() { return pricePerUnit; }
    public void setPricePerUnit(double pricePerUnit) { this.pricePerUnit = pricePerUnit; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}
