package app;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {
    public static void main(String[] args) {
        // Create a Deque using ArrayDeque implementation
        Deque<String> deque = new ArrayDeque<>();

        // Add elements to the deque
        deque.addFirst("First");
        deque.addLast("Last");
        deque.offerFirst("OfferFirst");
        deque.offerLast("OfferLast");

        // Display the contents of the deque
        System.out.println("Contents of the deque: " + deque);

        // Remove elements from the deque
        String firstElement = deque.removeFirst();
        String lastElement = deque.removeLast();

        // Display the removed elements
        System.out.println("Removed first element: " + firstElement);
        System.out.println("Removed last element: " + lastElement);

        // Display the updated contents of the deque
        System.out.println("Updated contents of the deque: " + deque);

        // Peek elements from the deque (without removing)
        String firstPeek = deque.peekFirst();
        String lastPeek = deque.peekLast();

        // Display the peeked elements
        System.out.println("Peeked first element: " + firstPeek);
        System.out.println("Peeked last element: " + lastPeek);
    }
}

