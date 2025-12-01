package com.example.delivery_service.controller;

import com.example.delivery_service.dto.SupportTicketDto;
import com.example.delivery_service.entity.User;
import com.example.delivery_service.repository.UserRepository;
import com.example.delivery_service.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/support")
public class SupportController {
    private final SupportService supportService;
    private final UserRepository userRepository;

    @Autowired
    public SupportController(SupportService supportService, UserRepository userRepository) {
        this.supportService = supportService;
        this.userRepository = userRepository;
    }

    @PostMapping
    public SupportTicketDto createTicket(@RequestParam Long userId,
                                         @RequestParam String subject,
                                         @RequestParam String message) {
        User user = userRepository.findById(userId).orElseThrow();
        return supportService.create(user, subject, message);
    }

    @GetMapping
    public List<SupportTicketDto> getTickets(@RequestParam Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return supportService.findByUser(user);
    }
}
