package main.java.transport.Train;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train {
    private int number;
    private String destination;
    private String departureTime;
    private List<PassengerCar> passengerCars;

    public Train(int number, String destination, String departureTime) {
        this.number = number;
        this.destination = destination;
        this.departureTime = departureTime;
        this.passengerCars = new ArrayList<>();
    }

    public void addPassengerCar(int carNumber, int capacity) {
        PassengerCar passengerCar = new PassengerCar(carNumber, capacity);
        passengerCars.add(passengerCar);
    }

    public void displayTrainInfo() {
        System.out.println("Потяг " + number);
        System.out.println("Пункт призначення: " + destination);
        System.out.println("Час відправлення: " + departureTime);
        System.out.println("Пасажирський вагон:");
        for (PassengerCar car : passengerCars) {
            System.out.println("Вагон " + car.getCarNumber() + ": Кількість місць - " + car.getCapacity());
        }
    }

    public static void main(String[] args) {
        Train train1 = new Train(101, "м.Первомайськ", "08:00");
        train1.addPassengerCar(1, 50);
        train1.addPassengerCar(2, 40);
        train1.displayTrainInfo();
        // Додано можливість введення через консоль
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть номер Потяга:");
        int trainNumber = scanner.nextInt();

        System.out.println("Введіть пункт призначення:");
        scanner.nextLine(); // Очищає буфер після введення числа
        String destination = scanner.nextLine();

        System.out.println("Введіть час відправлення:");
        String departureTime = scanner.nextLine();

        Train train = new Train(trainNumber, destination, departureTime);

        System.out.println("Введіть кількість пасажирських вагонів");
        int numberOfCars = scanner.nextInt();

        for (int i = 0; i < numberOfCars; i++) {
            System.out.println("Введіть номер пасажирського вагону " + (i + 1) + ":");
            int carNumber = scanner.nextInt();

            System.out.println("Введіть кількість місць у вагоні " + (i + 1) + ":");
            int capacity = scanner.nextInt();

            train.addPassengerCar(carNumber, capacity);
        }

        train.displayTrainInfo();

        // Закриття Scanner
        scanner.close();
    }
}