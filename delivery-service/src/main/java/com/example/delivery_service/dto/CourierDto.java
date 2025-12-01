package com.example.delivery_service.dto;

import com.example.delivery_service.entity.Courier;

public class CourierDto {
    private Long id;
    private String name;
    private Courier.TransportType transportType;
    private Courier.Status status;

    public CourierDto() {}
    public CourierDto(Long id, String name, Courier.TransportType transportType, Courier.Status status) {
        this.id = id;
        this.name = name;
        this.transportType = transportType;
        this.status = status;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Courier.TransportType getTransportType() { return transportType; }
    public void setTransportType(Courier.TransportType transportType) { this.transportType = transportType; }
    public Courier.Status getStatus() { return status; }
    public void setStatus(Courier.Status status) { this.status = status; }
}
