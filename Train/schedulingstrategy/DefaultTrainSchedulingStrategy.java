// DefaultTrainSchedulingStrategy.java
package main.java.transport.Train.schedulingstrategy;

import main.java.transport.Train.ScheduleQueue;
import main.java.transport.Train.TrainDeparture;
import main.java.transport.Train.PassengerCar;

import java.util.Scanner;

public class DefaultTrainSchedulingStrategy implements TrainSchedulingStrategy {
    @Override
    public void scheduleTrain(ScheduleQueue scheduleQueue, Scanner scanner) {
        scheduleQueue.displayFreeTimes();
        System.out.println("Оберіть день та час для додавання потяга:");
        String selectedDay = scanner.nextLine();
        String selectedTime = getTimeInput(scanner);

        TrainDeparture newDeparture = new TrainDeparture(selectedDay, selectedTime);

        int trainNumber = getIntInput("Введіть номер потяга:", scanner);
        String trainRoute = getStringInput(scanner);
        int numberOfCars = getIntInput("Введіть кількість пасажирських вагонів:", scanner);

        for (int j = 0; j < numberOfCars; j++) {
            int carNumber = getIntInput("Введіть номер пасажирського вагону " + (j + 1) + ":", scanner);
            int capacity = getIntInput("Введіть кількість місць для Вагону " + (j + 1) + ":", scanner);

            newDeparture.getTrain().addPassengerCar(carNumber, capacity);
        }

        displayTripDetails(newDeparture, trainNumber, trainRoute, numberOfCars);

        if (scheduleQueue.enqueue(newDeparture)) {
            System.out.println("Потяг успішно додано до розкладу!");
            System.out.println("Код квитка для цього маршруту: " + newDeparture.getTicketCode());
            scheduleQueue.displayUpdatedSchedule(); // Додано вивід оновленого розкладу
        } else {
            System.out.println("Помилка при додаванні потягу до розкладу.");
        }
    }

    private String getTimeInput(Scanner scanner) {
        System.out.println("Введіть час в (гг:хх):");
        return scanner.nextLine();
    }

    private int getIntInput(String prompt, Scanner scanner) {
        while (true) {
            try {
                System.out.println(prompt);
                int input = scanner.nextInt();
                if (input < 0) {
                    System.out.println("Номер потяга та кількість місць не можуть бути від'ємними.");
                    continue;
                }
                return input;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Введено некоректне число. Спробуйте ще раз.");
                scanner.nextLine(); // Очистити буфер введення
            }
        }
    }

    private String getStringInput(Scanner scanner) {
        System.out.println("Введіть маршрут:");
        scanner.nextLine(); // Очистити буфер введення
        return scanner.nextLine();
    }

    private void displayTripDetails(TrainDeparture newDeparture, int trainNumber, String trainRoute, int numberOfCars) {
        System.out.println("Деталі поїздки:");
        System.out.println("Призначений день: " + newDeparture.getDay());
        System.out.println("Призначений час: " + newDeparture.getTime());
        System.out.println("Маршрут: " + trainRoute);
        System.out.println("Номер потягу: " + trainNumber);
        System.out.println("Кількість вагонів: " + numberOfCars);
        System.out.println("Пасажирські місця:");

        for (PassengerCar car : newDeparture.getTrain().getPassengerCars()) {
            System.out.println("Вагон " + car.getCarNumber() + ": " + car.getCapacity() + " місць");
        }
    }
}
