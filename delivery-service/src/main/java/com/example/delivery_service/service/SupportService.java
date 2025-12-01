package com.example.delivery_service.service;

import com.example.delivery_service.dto.SupportTicketDto;
import com.example.delivery_service.entity.SupportTicket;
import com.example.delivery_service.entity.User;
import com.example.delivery_service.repository.SupportTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupportService {
    private final SupportTicketRepository supportTicketRepository;

    @Autowired
    public SupportService(SupportTicketRepository supportTicketRepository) {
        this.supportTicketRepository = supportTicketRepository;
    }

    public SupportTicketDto create(User user, String subject, String message) {
        SupportTicket ticket = new SupportTicket();
        ticket.setUser(user);
        ticket.setSubject(subject);
        ticket.setMessage(message);
        ticket.setStatus(SupportTicket.Status.OPEN);
        ticket.setCreatedAt(LocalDateTime.now());
        return toDto(supportTicketRepository.save(ticket));
    }

    public List<SupportTicketDto> findByUser(User user) {
        return supportTicketRepository.findByUser(user).stream().map(SupportService::toDto).collect(Collectors.toList());
    }

    public static SupportTicketDto toDto(SupportTicket t) {
        return new SupportTicketDto(t.getId(), t.getSubject(), t.getMessage(), t.getStatus(), t.getCreatedAt());
    }
}
