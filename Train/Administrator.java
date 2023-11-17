
package main.java.transport.Train;

import main.java.transport.Train.schedulingstrategy.TrainSchedulingStrategy;
import main.java.transport.Train.schedulingstrategy.DefaultTrainSchedulingStrategy;
import main.java.transport.Train.schedulingstrategy.TrainSchedulingStrategy;
import java.util.Scanner;

public class Administrator {
    private static final String COMMAND_SCHEDULE = "Розклад";
    private static final String COMMAND_EXIT = "Вихід";
    private static TrainSchedulingStrategy schedulingStrategy;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ScheduleQueue scheduleQueue = new ScheduleQueue();

            // Встановлення стратегії за умовчанням
            schedulingStrategy = new DefaultTrainSchedulingStrategy();

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
        // Виклик методу стратегії для розкладу
        schedulingStrategy.scheduleTrain(scheduleQueue, scanner);
        // Решта коду методу, як в попередніх відповідях
    }
}
