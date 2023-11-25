package com.example.tourism_onthe_rail.model;

import lombok.Getter;

@Getter
public class Ticket {

    private Long id;
    private Passenger passenger;
    private Train train;
    private Station departureStation;
    private Station arrivalStation;
    private String departureTime;
    private String arrivalTime;


    public Ticket(Long id, Passenger passenger, Train train, Station departureStation, Station arrivalStation, String departureTime, String arrivalTime) {
        this.id = id;
        this.passenger = passenger;
        this.train = train;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public void setDepartureStation(Station departureStation) {
        this.departureStation = departureStation;
    }

    public void setArrivalStation(Station arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", passenger=" + passenger +
                ", train=" + train +
                ", departureStation=" + departureStation +
                ", arrivalStation=" + arrivalStation +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                '}';
    }
}
