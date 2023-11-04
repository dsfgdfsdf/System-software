import java.util.Queue;
import java.util.LinkedList;

// Representation of the queue
class ServiceQueue {
    private Queue<Schedulable> queue;
    private String schedule;

    public ServiceQueue()  {
        queue = new LinkedList<>();
    }

    public void addToQueue(Schedulable schedulable) {
        if (queue.size() < 4){
            queue.offer(schedulable);
        } else {
            System.out.println("Черга заповнена.");

        }
    }
    public Schedulable removeFromQueue() {
        return queue.poll();
    }
    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }
}





