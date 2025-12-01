package com.example.delivery_service.controller;

import com.example.delivery_service.entity.ChatMessage;
import com.example.delivery_service.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders/{orderId}/chat")
public class ChatController {
    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public void sendUserMessage(@PathVariable Long orderId, @RequestBody ChatMessageDto message) {
        chatService.sendUserMessage(orderId, message.getMessage());
    }

    @GetMapping
    public List<ChatMessageDto> getChatHistory(@PathVariable Long orderId) {
        return chatService.getHistory(orderId).stream().map(ChatMessageDto::of).collect(Collectors.toList());
    }

    // внутренний DTO (можно потом вынести)
    public static class ChatMessageDto {
        private ChatMessage.SenderType senderType;
        private String message;
        private LocalDateTime createdAt;

        public ChatMessageDto() {}
        public static ChatMessageDto of(ChatMessage m) {
            ChatMessageDto dto = new ChatMessageDto();
            dto.senderType = m.getSenderType();
            dto.message = m.getMessage();
            dto.createdAt = m.getCreatedAt();
            return dto;
        }
        public ChatMessage.SenderType getSenderType() { return senderType; }
        public void setSenderType(ChatMessage.SenderType senderType) { this.senderType = senderType; }
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        public LocalDateTime getCreatedAt() { return createdAt; }
        public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    }
}
