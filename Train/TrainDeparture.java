// TrainDeparture.java
package main.java.transport.Train;

import java.util.UUID;

public class TrainDeparture {
    private String day;
    private String time;
    private Train train;
    private String ticketCode;

    public TrainDeparture(String day, String time) {
        this.day = day;
        this.time = time;
        this.train = new Train();
        this.ticketCode = generateTicketCode();
    }

    private String generateTicketCode() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public Train getTrain() {
        return train;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    // Додано методи для отримання та встановлення номера потяга
    public int getTrainNumber() {
        return train.getTrainNumber();
    }

    public void setTrainNumber(int trainNumber) {
        train.setTrainNumber(trainNumber);
    }
}
