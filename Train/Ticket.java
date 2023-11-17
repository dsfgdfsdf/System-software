package main.java.transport.Train;

public class Ticket {
    private static int lastTicketCode = 1000; // Початковий номер для квитків
    private int ticketCode;
    private TrainDeparture trainDeparture;

    public Ticket(TrainDeparture trainDeparture) {
        this.ticketCode = generateTicketCode();
        this.trainDeparture = trainDeparture;
    }

    private int generateTicketCode() {
        return ++lastTicketCode;
    }

    public int getTicketCode() {
        return ticketCode;
    }

    public TrainDeparture getTrainDeparture() {
        return trainDeparture;
    }
}
