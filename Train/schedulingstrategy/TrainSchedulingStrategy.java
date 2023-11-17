// TrainSchedulingStrategy.java
package main.java.transport.Train.schedulingstrategy;

import main.java.transport.Train.ScheduleQueue;

import java.util.Scanner;

public interface TrainSchedulingStrategy {
    void scheduleTrain(ScheduleQueue scheduleQueue, Scanner scanner);
}
