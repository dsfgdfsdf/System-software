package main.java.transport.Train;


import java.time.LocalTime;
import java.util.*;

public class ScheduleQueue {
    private static final int MAX_DEPARTURES_PER_DAY = 3;
    private static final List<String> DAYS_OF_WEEK = Arrays.asList("Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця");

    private List<TrainDeparture> queue;
    private Map<String, List<LocalTime>> freeTimes;

    public ScheduleQueue() {
        queue = new ArrayList<>();
        freeTimes = new HashMap<>();
        initializeFreeTimes();
    }

    private void initializeFreeTimes() {
        // Ініціалізація вільних часів для всіх днів тижня
        // При потребі можна розширити часові проміжки для кожного дня
        for (String day : DAYS_OF_WEEK) {
            List<LocalTime> times = Arrays.asList(LocalTime.of(8, 0), LocalTime.of(10, 0), LocalTime.of(12, 0));
            freeTimes.put(day, times);
        }
    }
    public void displayUpdatedSchedule() {
        System.out.println("Оновлений розклад:");
        for (TrainDeparture departure : queue) {
            System.out.println("День: " + departure.getDay() + ", Час: " + departure.getTime());
        }
        System.out.println();
    }

    public boolean canEnqueue(TrainDeparture departure) {
        // Перевірка чи можна додати відправлення на обраний день та час
        List<LocalTime> dayFreeTimes = freeTimes.get(departure.getDay());
        return dayFreeTimes != null && dayFreeTimes.contains(LocalTime.parse(departure.getTime())) &&
                queue.stream().filter(d -> d.getDay().equals(departure.getDay())).count() < MAX_DEPARTURES_PER_DAY;
    }

    public boolean enqueue(TrainDeparture departure) {
        if (canEnqueue(departure)) {
            queue.add(departure);
            removeTimeFromFreeTimes(departure.getDay(), departure.getTime());
            return true;
        } else {
            System.out.println("Неможливо поставити в чергу відправлення для " + departure.getDay() +
                    ". Досягнуто максимальної кількості відправлень за день.");
            return false;
        }
    }

    private void removeTimeFromFreeTimes(String day, String selectedTime) {
        List<LocalTime> dayFreeTimes = new ArrayList<>(freeTimes.get(day)); // Створюємо копію списку для можливості зміни
        dayFreeTimes.remove(LocalTime.parse(selectedTime));
        freeTimes.put(day, dayFreeTimes);
    }


    public List<LocalTime> getFreeTimesForDay(String day) {
        return freeTimes.getOrDefault(day, Collections.emptyList());
    }

    public void displayFreeTimes() {
        System.out.println("Вільний час:");
        for (Map.Entry<String, List<LocalTime>> entry : freeTimes.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append("День: ").append(entry.getKey()).append(", Вільний час: ");
            entry.getValue().forEach(time -> sb.append(time).append(" "));
            System.out.println(sb.toString());
        }
        System.out.println();
    }

    public void displayFreeTimesWithoutSelectedTime(String selectedDay, String selectedTime) {
        System.out.println("Вільний час після додавання потяга:");
        for (Map.Entry<String, List<LocalTime>> entry : freeTimes.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append("День: ").append(entry.getKey()).append(", Вільний час: ");

            if (!entry.getKey().equals(selectedDay)) {
                // Додати усі часи, оскільки це не обраний день
                entry.getValue().forEach(time -> sb.append(time).append(" "));
            } else {
                // Виключити обраний час
                entry.getValue().stream()
                        .filter(time -> !time.equals(LocalTime.parse(selectedTime)))
                        .forEach(time -> sb.append(time).append(" "));
            }

            System.out.println(sb.toString());
        }
        System.out.println();
    }

    public List<TrainDeparture> getQueue() {
        return queue;
    }

    // ... інші методи
}
