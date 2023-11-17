package main.java.transport.Train;
public class PassengerCar {
    private int carNumber;
    private int capacity;

    public PassengerCar(int carNumber, int capacity) {
        this.carNumber = carNumber;
        this.capacity = capacity;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getCapacity() {
        return capacity;
    }
}