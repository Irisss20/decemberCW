package com.example.delivery_service.repository;

import com.example.delivery_service.entity.ChatMessage;
import com.example.delivery_service.entity.DeliveryOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findByOrderOrderByCreatedAtAsc(DeliveryOrder order);
}
