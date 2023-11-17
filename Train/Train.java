// Train.java
package main.java.transport.Train;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private int trainNumber;
    private String route; // Додано поле для маршруту
    private String destination;
    private String departureTime;
    private List<PassengerCar> passengerCars;

    // Конструктор без параметрів
    public Train() {
        this.passengerCars = new ArrayList<>();
    }

    // Конструктор з параметрами
    public Train(int trainNumber, String destination, String departureTime, String route) {
        this.trainNumber = trainNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.route = route;
        this.passengerCars = new ArrayList<>();
    }

    public String getRoute() {
        return route;
    }

    // Геттер для номера потяга
    public int getTrainNumber() {
        return trainNumber;
    }

    // Сеттер для номера потяга
    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
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
