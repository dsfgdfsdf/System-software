package main.java.transport.Train;

public class TrainDeparture {
    private String day;
    private String time;
    private String trainRoute;
    private Train train; // Додайте поле для поїзда

    public TrainDeparture(String day, String time) {
        this.day = day;
        this.time = time;
        this.train = new Train(); // Ініціалізуємо поїзд при створенні відправлення
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public String getTrainRoute() {
        return trainRoute;
    }

    public void setTrainRoute(String trainRoute) {
        this.trainRoute = trainRoute;
    }

    public Train getTrain() {
        return train;
    }
}
