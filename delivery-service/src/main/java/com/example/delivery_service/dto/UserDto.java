package com.example.delivery_service.dto;

import com.example.delivery_service.entity.User;

public class UserDto {
    private Long id;
    private String email;
    private String name;
    private String phone;
    private User.Role role;

    public UserDto() {}
    public UserDto(Long id, String email, String name, String phone, User.Role role) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.role = role;
    }

    // Геттеры/сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public User.Role getRole() { return role; }
    public void setRole(User.Role role) { this.role = role; }
}
