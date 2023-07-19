package app;

public class SinglyLinkedList<T extends Comparable<T>> {
    private Node<T> head;  // Declare a private instance variable "head" of type Node<T>
    private Node<T> tail;  // Declare a private instance variable "tail" of type Node<T>

    public SinglyLinkedList() {
        head = null;  // Set the "head" to null
        tail = null;  // Set the "tail" to null
    }

    public SinglyLinkedList(SinglyLinkedList<T> otherList) {
        if (otherList.head != null) {  // Check if "otherList" has a non-null "head"
            Node<T> current = otherList.head;  // Set "current" to the "head" of "otherList"
            while (current != null) {  // Iterate through "otherList" until "current" becomes null
                insert(current.getData());  // Insert the data of "current" node into the current list
                current = current.getNext();  // Move to the next node in "otherList"
            }
        }
    }

    public T front() {
        if (head != null) {  // Check if the list has a non-null "head"
            return head.getData();  // Return the data of the "head" node
        }
        return null;  // Return null if the list is empty
    }

    public T back() {
        if (tail != null) {  // Check if the list has a non-null "tail"
            return tail.getData();  // Return the data of the "tail" node
        }
        return null;  // Return null if the list is empty
    }

    public void insert(T value) {
        Node<T> newNode = new Node<>(value);  // Create a new node with the given value
        if (head == null) {  // Check if the list is empty
            head = newNode;  // Set the "head" and "tail" to the new node
            tail = newNode;
        } else if (value.compareTo(head.getData()) < 0) {  // Check if the value is less than the data in the "head" node
            newNode.setNext(head);  // Set the new node's next pointer to the current "head"
            head = newNode;  // Update the "head" to the new node
        } else if (value.compareTo(tail.getData()) >= 0) {  // Check if the value is greater than or equal to the data in the "tail" node
            tail.setNext(newNode);  // Set the current "tail" node's next pointer to the new node
            tail = newNode;  // Update the "tail" to the new node
        } else {
            Node<T> current = head;  // Set "current" to the "head" node
            while (current.getNext() != null && value.compareTo(current.getNext().getData()) > 0) {  // Find the appropriate position to insert the new node
                current = current.getNext();  // Move to the next node
            }
            newNode.setNext(current.getNext());  // Set the new node's next pointer to the current node's next pointer
            current.setNext(newNode);  // Set the current node's next pointer to the new node
        }
    }

    public void pop_front() {
        if (head != null) {  // Check if the list has a non-null "head"
            head = head.getNext();  // Update the "head" to the next node
            if (head == null) {  // Check if the list became empty
                tail = null;  // Set the "tail" to null as well
            }
        }
    }

    public void pop_back() {
        if (head != null) {  // Check if the list has a non-null "head"
            if (head == tail) {  // Check if there is only one node in the list
                head = null;  // Set both "head" and "tail" to null
                tail = null;
            } else {
                Node<T> current = head;  // Set "current" to the "head" node
                while (current.getNext() != tail) {  // Find the node preceding the "tail" node
                    current = current.getNext();  // Move to the next node
                }
                current.setNext(null);  // Set the current node's next pointer to null
                tail = current;  // Update the "tail" to the current node
            }
        }
    }

    public boolean empty() {
        return head == null;  // Return true if the list is empty (head is null), false otherwise
    }

    public int size() {
        int count = 0;  // Initialize a counter variable
        Node<T> current = head;  // Set "current" to the "head" node
        while (current != null) {  // Iterate through the list until "current" becomes null
            count++;  // Increment the counter
            current = current.getNext();  // Move to the next node
        }
        return count;  // Return the count
    }

    public void reverse() {
        if (head != null) {  // Check if the list has a non-null "head"
            Node<T> previous = null;  // Initialize a variable to hold the previous node
            Node<T> current = head;  // Set "current" to the "head" node
            Node<T> next;  // Declare a variable to hold the next node
            while (current != null) {  // Iterate through the list until "current" becomes null
                next = current.getNext();  // Store the next node
                current.setNext(previous);  // Reverse the next pointer of the current node
                previous = current;  // Move "previous" to the current node
                current = next;  // Move "current" to the next node
            }
            tail = head;  // Swap "head" and "tail" since the list is reversed
            head = previous;
        }
    }

    public void merge(SinglyLinkedList<T> otherList) {
        if (otherList.head != null) {  // Check if "otherList" has a non-null "head"
            Node<T> current = otherList.head;  // Set "current" to the "head" of "otherList"
            while (current != null) {  // Iterate through "otherList" until "current" becomes null
                insert(current.getData());  // Insert the data of "current" node into the current list
                current = current.getNext();  // Move to the next node in "otherList"
            }
        }
    }

    private static class Node<T> {
        private T data;  // Declare a private instance variable "data" of type T
        private Node<T> next;  // Declare a private instance variable "next" of type Node<T>

        public Node(T data) {
            this.data = data;  // Initialize "data" with the given value
            this.next = null;  // Set "next" to null
        }

        public T getData() {
            return data;  // Return the data of the node
        }

        public void setData(T data) {
            this.data = data;  // Set the data of the node to the given value
        }

        public Node<T> getNext() {
            return next;  // Return the next node
        }

        public void setNext(Node<T> next) {
            this.next = next;  // Set the next node to the given value
        }
    }

    // Test program
    public static void main(String[] args) {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<>();  // Create a new instance of SinglyLinkedList

        myList.insert(5);  // Insert 5 into the list
        myList.insert(2);  // Insert 2 into the list
        myList.insert(8);  // Insert 8 into the list
        myList.insert(1);  // Insert 1 into the list

        System.out.println("Size: " + myList.size());  // Output: Size: 4
        System.out.println("Front: " + myList.front());  // Output: Front: 1
        System.out.println("Back: " + myList.back());  // Output: Back: 8

        myList.pop_front();  // Remove the first element from the list
        myList.pop_back();  // Remove the last element from the list

        System.out.println("Size: " + myList.size());  // Output: Size: 2
        System.out.println("Front: " + myList.front());  // Output: Front: 2
        System.out.println("Back: " + myList.back());  // Output: Back: 5

        myList.reverse();  // Reverse the list

        System.out.println("Front: " + myList.front());  // Output: Front: 5
        System.out.println("Back: " + myList.back());  // Output: Back: 2

        SinglyLinkedList<Integer> otherList = new SinglyLinkedList<>();  // Create another instance of SinglyLinkedList
        otherList.insert(3);  // Insert 3 into the other list
        otherList.insert(7);  // Insert 7 into the other list

        myList.merge(otherList);  // Merge the other list into the main list

        System.out.println("Size: " + myList.size());  // Output: Size: 4
        System.out.println("Front: " + myList.front());  // Output: Front: 2
        System.out.println("Back: " + myList.back());  // Output: Back: 7
    }
}

