package com.example.delivery_service.dto;

import com.example.delivery_service.entity.SupportTicket;
import java.time.LocalDateTime;

public class SupportTicketDto {
    private Long id;
    private String subject;
    private String message;
    private SupportTicket.Status status;
    private LocalDateTime createdAt;

    public SupportTicketDto() {}
    public SupportTicketDto(Long id, String subject, String message, SupportTicket.Status status, LocalDateTime createdAt) {
        this.id = id;
        this.subject = subject;
        this.message = message;
        this.status = status;
        this.createdAt = createdAt;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public SupportTicket.Status getStatus() { return status; }
    public void setStatus(SupportTicket.Status status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
