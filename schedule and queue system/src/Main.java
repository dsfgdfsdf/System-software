// Main class
public class Main {
    public static void main(String[] args) {
        Administrator admin1 = new Administrator("Admin1 Ольга");
        Administrator admin2 = new Administrator("Admin2 Олексій");

        Employee employee = new Employee(" головний адмінітратор Володимир Володимирович Осада");

        employee.addAdministrator(admin1);
        employee.addAdministrator(admin2);


        employee.listAdministrators();


        Car car1 = new Car("Nisan Maxima 2004");
//        Car car2 = new Car("BMW X5 2019");
//        Car car3 = new Car("Toyota Camry 2020");
//        Car car4 = new Car("Chevrolet Camaro 2022");
//        Car car5 = new Car("Honda Civic 2000");

        ServiceQueue serviceQueue = new ServiceQueue();

        serviceQueue.addToQueue(car1);
//        serviceQueue.addToQueue(car2);
//        serviceQueue.addToQueue(car3);
//        serviceQueue.addToQueue(car4);
//        serviceQueue.addToQueue(car5);

        Technician technician1 = new Technician("Микола Олексійович Кондрашов", "Електрик");
        Technician technician2 = new Technician("Віталій Олександрович Каучуг","Механік");

        ScheduleManager scheduleManager = new ScheduleManager();

        scheduleManager.assignSchedule((Schedulable) technician1, "Понеділок, 9:00");
        scheduleManager.assignSchedule((Schedulable) technician2, "Вівторок, 10:30");

        while (!serviceQueue.isQueueEmpty()) {
            Schedulable schedulable = serviceQueue.removeFromQueue();
            String schedule = schedulable.getSchedule();
            System.out.println("Машина" + ((Car) schedulable).getModel() + "Запланована на обслуговування в " + schedule);
        }

        System.out.println("Розклад роботи для техніка 1:" + technician1.getSpecialization() + "" + technician1.getName() + "-" + technician1.getSchedule());
        System.out.println("Розклад роботи для техніка 2:" + technician2.getSpecialization() + "" + technician2.getName() + "-" + technician2.getSchedule());

    }
}

