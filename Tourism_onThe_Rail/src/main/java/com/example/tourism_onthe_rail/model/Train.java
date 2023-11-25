package com.example.tourism_onthe_rail.model;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private Long id;
    private String name;
    private String route;
    private List<Passenger> passengers;


    public Train(Long id, String name, String route) {
        this.id = id;
        this.name = name;
        this.route = route;
        this.passengers = new ArrayList<>();
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRoute() {
        return route;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    // Додавання пасажира до потягу
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    // Інші методи, які можуть знадобитися
}
