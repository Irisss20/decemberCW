package com.example.delivery_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Courier {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransportType transportType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public enum TransportType { FOOT, BIKE, CAR }
    public enum Status { AVAILABLE, BUSY, OFFLINE }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public TransportType getTransportType() { return transportType; }
    public void setTransportType(TransportType transportType) { this.transportType = transportType; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
