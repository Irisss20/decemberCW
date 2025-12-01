package com.example.delivery_service.repository;

import com.example.delivery_service.entity.SupportTicket;
import com.example.delivery_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long> {
    List<SupportTicket> findByUser(User user);
}
