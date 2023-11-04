// Schedule management
class ScheduleManager {
    public void assignSchedule(Schedulable schedulable, String schedule) {
        schedulable.setSchedule(schedule);
        System.out.println("Розклад призначено: " + schedule);
    }
}



