package main.java.transport.Train;

import java.util.Scanner;

public class Administrator {

    private static final String COMMAND_SCHEDULE = "Розклад";
    private static final String COMMAND_EXIT = "Вихід";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ScheduleQueue scheduleQueue = new ScheduleQueue();

            while (true) {
                System.out.println("Введіть команду ('" + COMMAND_SCHEDULE + "' або '" + COMMAND_EXIT + "'): ");
                String command = scanner.nextLine();

                if (command.equalsIgnoreCase(COMMAND_SCHEDULE)) {
                    handleScheduleCommand(scheduleQueue, scanner);
                } else if (command.equalsIgnoreCase(COMMAND_EXIT)) {
                    break;
                } else {
                    System.out.println("Невідома команда. Спробуйте ще раз.");
                }
            }
        }
    }

    private static void handleScheduleCommand(ScheduleQueue scheduleQueue, Scanner scanner) {
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
        scheduleQueue.displayFreeTimesWithoutSelectedTime(selectedDay, selectedTime);
    }
    private static String getTimeInput(Scanner scanner) {
        System.out.println("Введіть час в (гг:хх):");
        return scanner.nextLine();
    }

    private static int getIntInput(String prompt, Scanner scanner) {
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

    private static String getStringInput(Scanner scanner) {
        System.out.println("Введіть маршрут:");
        scanner.nextLine(); // Clear buffer
        return scanner.nextLine();
    }

    private static void displayTripDetails(TrainDeparture newDeparture, int trainNumber, String trainRoute, int numberOfCars) {
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
