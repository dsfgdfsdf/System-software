package main.java.transport.Train;
import java.util.Scanner;

public class Administrator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Створюю екземпляр класу Schedule
        Schedule schedule = new Schedule();
        // Виведення розкладу
        schedule.displaySchedule();
        //Введення користувачем дня тижня
        System.out.println("Введіть день:");
        int selectedDayNumber = scanner.nextInt();
        scanner.nextLine(); // Очищення буфера після nextInt()

        String selectedDay = schedule.getDayByNumber(selectedDayNumber);
        //Отримання розкладу для вибраного дня
        String[] selectedDaySchedule = schedule.getDailySchedule(selectedDay);
        if (selectedDaySchedule != null) {
            System.out.println("Вибраний розклад для " + selectedDay + ": " + String.join(", ", selectedDaySchedule));
        } else {
            System.out.println("Вибраний недійсний день.");
        }




        System.out.println("Введіть кількість потягів для створення:");
        int numberOfTrains = scanner.nextInt();

        for (int i = 0; i < numberOfTrains; i++) {
            System.out.println("Введіть номер потяга " + (i + 1) + ":");
            int trainNumber = scanner.nextInt();

            System.out.println("Введіть пункт призначення поїзда " + (i + 1) + ":");
            scanner.nextLine(); // Clear buffer
            String destination = scanner.nextLine();

            System.out.println("Введіть час відправлення поїзда " + (i + 1) + ":");
            String departureTime = scanner.nextLine();

            Train train = new Train(trainNumber, destination, departureTime);

            System.out.println("Введіть кількість пасажирських вагонів " + (i + 1) + "?");
            int numberOfCars = scanner.nextInt();

            for (int j = 0; j < numberOfCars; j++) {
                System.out.println("Введіть номер пасажирського вагону " + (j + 1) + " для Вагону " + (i + 1) + ":");
                int carNumber = scanner.nextInt();

                System.out.println("Введіть кількість місць  " + (j + 1) + " для Вагону " + (i + 1) + ":");
                int capacity = scanner.nextInt();

                train.addPassengerCar(carNumber, capacity);
            }

            train.displayTrainInfo();
        }

        scanner.close();
    }
}
