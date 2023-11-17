package main.java.transport.Train;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private int trainNumber;
    private String destination;
    private String departureTime;
    private List<PassengerCar> passengerCars;

    // Конструктор без параметрів
    public Train() {
        this.passengerCars = new ArrayList<>();
    }

    // Конструктор з параметрами
    public Train(int trainNumber, String destination, String departureTime) {
        this.trainNumber = trainNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.passengerCars = new ArrayList<>();
    }

    // Інші методи та геттери/сеттери...

    // Додайте метод для додавання пасажирського вагону
    public void addPassengerCar(int carNumber, int capacity) {
        PassengerCar car = new PassengerCar(carNumber, capacity);
        passengerCars.add(car);
    }
    public List<PassengerCar> getPassengerCars() {
        return passengerCars;
    }
    // Додайте інші методи та геттери/сеттери за необхідності...
}
