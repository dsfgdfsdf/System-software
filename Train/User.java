package main.java.transport.Train;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class User {
    private String name;
    private int age;
    private List<Ticket> tickets;
    private static Scanner scanner = new Scanner(System.in);

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.tickets = new ArrayList<>();
    }

    public void viewSchedule(ScheduleQueue scheduleQueue) {
        scheduleQueue.displayFreeTimes();
    }

    public void viewTickets() {
        if (tickets.isEmpty()) {
            System.out.println("У вас немає квитків.");
        } else {
            System.out.println("Ваші квитки:");
            for (Ticket ticket : tickets) {
                System.out.println("Код квитка: " + ticket.getTicketCode());
            }
        }
    }

    public void viewTicketDetails() {
        System.out.println("Введіть код квитка:");
        int ticketCode = Integer.parseInt(scanner.nextLine());

        Ticket ticket = findTicketByCode(ticketCode);
        if (ticket != null) {
            TrainDeparture trainDeparture = ticket.getTrainDeparture();
            displayTripDetails(trainDeparture, ticketCode);
        } else {
            System.out.println("Квиток з номером " + ticketCode + " не знайдено.");
        }
    }

    private Ticket findTicketByCode(int ticketCode) {
        return tickets.stream()
                .filter(ticket -> ticket.getTicketCode() == ticketCode)
                .findFirst()
                .orElse(null);
    }

    private void displayTripDetails(TrainDeparture trainDeparture, int ticketCode) {
        System.out.println("Деталі маршруту для квитка №" + ticketCode + ":");
        System.out.println("Призначений день: " + trainDeparture.getDay());
        System.out.println("Призначений час: " + trainDeparture.getTime());
        System.out.println("Маршрут: " + trainDeparture.getTrain().getRoute());
        System.out.println("Номер потягу: " + trainDeparture.getTrain().getTrainNumber());
        System.out.println("Кількість вагонів: " + trainDeparture.getTrain().getPassengerCars().size());
        System.out.println("Пасажирські місця:");

        for (PassengerCar car : trainDeparture.getTrain().getPassengerCars()) {
            System.out.println("Вагон " + car.getCarNumber() + ": " + car.getCapacity() + " місць");
        }
    }

    public static void main(String[] args) {
        System.out.println("Введіть ім'я користувача:");
        String userName = scanner.nextLine();

        System.out.println("Введіть вік користувача:");
        int userAge = Integer.parseInt(scanner.nextLine());

        User user = new User(userName, userAge);

        ScheduleQueue scheduleQueue = new ScheduleQueue();

        // Додати приклади потягів у розклад
        TrainDeparture exampleDeparture1 = new TrainDeparture("Понеділок", "08:00");
        TrainDeparture exampleDeparture2 = new TrainDeparture("Вівторок", "10:00");
        scheduleQueue.enqueue(exampleDeparture1);
        scheduleQueue.enqueue(exampleDeparture2);

        // Приклад створення квитка для користувача
        Ticket exampleTicket = new Ticket(exampleDeparture1);
        user.tickets.add(exampleTicket);

        // Приклад виклику методів користувача
        user.viewSchedule(scheduleQueue);
        user.viewTickets();
        user.viewTicketDetails();
    }
}
