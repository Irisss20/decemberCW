package com.example.delivery_service.dto;

import com.example.delivery_service.entity.Place;

public class PlaceDto {
    private Long id;
    private String name;
    private Place.PlaceType type;
    private String city;
    private String street;
    private String house;

    public PlaceDto() {}
    public PlaceDto(Long id, String name, Place.PlaceType type, String city, String street, String house) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.city = city;
        this.street = street;
        this.house = house;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Place.PlaceType getType() { return type; }
    public void setType(Place.PlaceType type) { this.type = type; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getHouse() { return house; }
    public void setHouse(String house) { this.house = house; }
}
