package com.example.delivery_service.dto;

public class ProductDto {
    private Long id;
    private Long placeId;
    private String name;
    private double price;
    private double weightKg;

    public ProductDto() {}
    public ProductDto(Long id, Long placeId, String name, double price, double weightKg) {
        this.id = id;
        this.placeId = placeId;
        this.name = name;
        this.price = price;
        this.weightKg = weightKg;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPlaceId() { return placeId; }
    public void setPlaceId(Long placeId) { this.placeId = placeId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public double getWeightKg() { return weightKg; }
    public void setWeightKg(double weightKg) { this.weightKg = weightKg; }
}
