package com.example.tourism_onthe_rail.model;

import lombok.Getter;

@Getter
public class Station {
    private Long id;
    private String name;
    private String location;


    public Station(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }


    // Сетери
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Інші методи, які можуть знадобитися
}
