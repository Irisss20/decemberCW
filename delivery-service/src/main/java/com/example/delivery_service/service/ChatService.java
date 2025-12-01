package com.example.delivery_service.service;

import com.example.delivery_service.entity.ChatMessage;
import com.example.delivery_service.entity.DeliveryOrder;
import com.example.delivery_service.entity.ChatMessage.SenderType;
import com.example.delivery_service.repository.ChatMessageRepository;
import com.example.delivery_service.repository.DeliveryOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {
    private final ChatMessageRepository chatRepo;
    private final DeliveryOrderRepository orderRepo;

    @Autowired
    public ChatService(ChatMessageRepository chatRepo, DeliveryOrderRepository orderRepo) {
        this.chatRepo = chatRepo;
        this.orderRepo = orderRepo;
    }

    @Transactional
    public void sendUserMessage(Long orderId, String message) {
        DeliveryOrder order = orderRepo.findById(orderId).orElseThrow();
        ChatMessage userMsg = new ChatMessage();
        userMsg.setOrder(order);
        userMsg.setSenderType(SenderType.USER);
        userMsg.setMessage(message);
        userMsg.setCreatedAt(LocalDateTime.now());
        chatRepo.save(userMsg);

        // Симуляция ответа курьера-бота по статусу заказа
        ChatMessage botMsg = new ChatMessage();
        botMsg.setOrder(order);
        botMsg.setSenderType(SenderType.COURIER_BOT);
        botMsg.setCreatedAt(LocalDateTime.now().plusSeconds(1));
        String botText = switch (order.getStatus()) {
            case ASSIGNED, IN_DELIVERY -> "Курьер приняли заказ, доставка в пути, ожидание: "
                    + order.getEstimatedMinutes() + " мин.";
            case DELIVERED -> "Заказ уже доставлен!";
            case CANCELED -> "Заказ отменён.";
            default -> "Заказ обрабатывается.";
        };
        botMsg.setMessage(botText);
        chatRepo.save(botMsg);
    }

    public List<ChatMessage> getHistory(Long orderId) {
        DeliveryOrder order = orderRepo.findById(orderId).orElseThrow();
        return chatRepo.findByOrderOrderByCreatedAtAsc(order);
    }
}
