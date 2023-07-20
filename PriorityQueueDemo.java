package app;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        // Create a priority queue of integers
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add elements to the priority queue
        pq.add(10);
        pq.add(5);
        pq.add(20);
        pq.add(15);

        // Remove elements from the priority queue (in priority order)
        while (!pq.isEmpty()) {
            int highestPriorityElement = pq.poll();
            System.out.println("Dequeued element with priority: " + highestPriorityElement);
        }
    }
}

