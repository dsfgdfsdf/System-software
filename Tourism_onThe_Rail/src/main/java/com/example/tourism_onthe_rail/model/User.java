package com.example.tourism_onthe_rail.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    // Конструктор
    public User() {
        // Порожній конструктор, який може бути потрібен JPA для створення об'єктів з результатів запитів з бази даних
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // Геттери
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    // Сеттери
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
