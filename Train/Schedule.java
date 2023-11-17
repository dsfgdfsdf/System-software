package main.java.transport.Train;



import java.util.Scanner;
import java.util.TreeMap;
import java.util.Comparator;

public class Schedule {
    private TreeMap<String, String[]> dailySchedule;
    private Scanner scanner;


    public Schedule() {
        // Ініціалізація розкладу
        dailySchedule = new TreeMap<>(Comparator.comparing(this::getDayOrder));
        dailySchedule.put("Понеділок", new String[]{"8:00", "11:00", "15:00"});
        dailySchedule.put("Вівторок", new String[]{"9:00", "13:00", "16:00"});
        dailySchedule.put("Середа", new String[]{"8:30", "12:30", "15:30"});
        dailySchedule.put("Четвер", new String[]{"9:30", "13:30", "16:30"});
        dailySchedule.put("П'ятниця", new String[]{"8:00", "10:00", "15:00"});

        scanner = new Scanner(System.in);


    }
    // Метод для отримання порядкового номера дня тижня
    private int getDayOrder(String day) {
        switch (day) {
            case "Понеділок":
                return 1;
            case "Вівторок":
                return 2;
            case "Середа":
                return 3;
            case "Четвер":
                return 4;
            case "П'ятниця":
                return 5;
            default:
                return 0; // Якщо введено невірний день, повертаємо 0

        }

    }



    public void displaySchedule() {
        System.out.println("Щоденний розклад:");
        for (var entry : dailySchedule.entrySet()) {
            System.out.println(entry.getKey() + ": " + String.join(", ", entry.getValue()));
        }
    }
    public String getDayByNumber(int dayNumber) {
        switch (dayNumber) {
            case 1:
                return "Понеділок";
            case 2:
                return "Вівторок";
            case 3:
                return "Середа";
            case 4:
                return "Четвер";
            case 5:
                return "П'ятниця";
            default:
                return "Invalid day";
        }
    }

    public String[] getDailySchedule(String day) {
        return dailySchedule.get(day);
    }

    public static void main(String[] args) {
        Schedule schedule = new Schedule();
        schedule.displaySchedule();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть день, який ви хочете вибрати:");
        String selectedDay = scanner.nextLine();

        String[] selectedDaySchedule = schedule.getDailySchedule(selectedDay);

        if (selectedDaySchedule != null) {
            System.out.println("Вибраний розклад для " + selectedDay + ": " + String.join(", ", selectedDaySchedule));
        } else {
            System.out.println("Вибраний недійсний день.");
        }

        scanner.close();
    }
}
