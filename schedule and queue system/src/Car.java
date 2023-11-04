
import java.util.Scanner;
public class Car implements Schedulable {
    private String model;
    private int year;
    private String vinCode;
    private String schedule;

    public Car(String model) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть марку автомобіля: ");
        this.model = scanner.nextLine();
        System.out.print("Введіть рік випуску вашого автомобіля: ");
        this.year = scanner.nextInt();
        String s = scanner.nextLine();
        System.out.print("Введіть VIN-код вашого автомобіля: ");
        this.vinCode = scanner.nextLine();


    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getSchedule() {
        return schedule;
    }

    public String getModel() {
        return model;
    }
}




