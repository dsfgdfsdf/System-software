package com.example.tourism_onthe_rail.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origin;
    private String destination;
    private String trainDetails;
    // Конструктор без параметрів (потрібен для JPA)
    public Route(){}
    // Конструктор з параметрами
    public Route(String origin, String destination, String trainDetails) {
        this.origin = origin;
        this.destination = destination;
        this.trainDetails = trainDetails;
        // Ініціалізуйте інші поля за потреби
    }

    // Гетери та сетери для всіх полів
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTrainDetails() {
        return trainDetails;
    }

    public void setTrainDetails(String trainDetails) {
        this.trainDetails = trainDetails;
    }

}
