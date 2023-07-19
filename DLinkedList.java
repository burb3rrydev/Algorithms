package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DLinkedList<T extends Comparable<T>> {
    private class DNode {
        private DNode next, prev;
        private T data;

        private DNode(T val) {
            this.data = val;
            next = prev = this;
        }
    }

    private DNode header;

    public DLinkedList() {
        header = new DNode(null); // Create a header node with null data
    }

    public DNode add(T item) {
        DNode newNode = new DNode(item); // Create a new node with the given item
        newNode.prev = header; // Set the new node's previous node as the header
        newNode.next = header.next; // Set the new node's next node as the current first node
        header.next.prev = newNode; // Update the previous node of the current first node to be the new node
        header.next = newNode; // Update the header's next node to be the new node
        return newNode; // Return the new node
    }

    public String toString() {
        String str = "["; // Initialize a string with an opening bracket
        DNode curr = header.next; // Start from the first node after the header
        while (curr != header) { // Iterate until the header is reached again
            str += curr.data + " "; // Append the data of the current node to the string
            curr = curr.next; // Move to the next node
        }
        if (str.length() > 1)
            str = str.substring(0, str.length() - 1); // Remove the extra space at the end
        return str + "]"; // Append a closing bracket and return the string representation
    }

    public boolean remove(T val) {
        DNode curr = header.next; // Start from the first node after the header
        while (curr != header) { // Iterate until the header is reached again
            if (curr.data.equals(val)) { // Check if the current node's data matches the given value
                curr.prev.next = curr.next; // Update the previous node's next pointer to skip the current node
                curr.next.prev = curr.prev; // Update the next node's previous pointer to skip the current node
                return true; // Node found and removed, return true
            }
            curr = curr.next; // Move to the next node
        }
        return false; // Node not found, return false
    }

    public void insertOrder(T item) {
        DNode newNode = new DNode(item); // Create a new node with the given item
        DNode curr = header.next; // Start from the first node after the header
        while (curr != header && curr.data.compareTo(item) < 0) {
            // Iterate until the header is reached or the current node's data is greater than the given item
            curr = curr.next; // Move to the next node
        }
        newNode.prev = curr.prev; // Set the new node's previous node as the current node's previous node
        newNode.next = curr; // Set the new node's next node as the current node
        curr.prev.next = newNode; // Update the next node of the new node's previous node to be the new node
        curr.prev = newNode; // Update the previous node of the current node to be the new node
    }

    public boolean insertOrderUnique(T item) {
        DNode curr = header.next; // Start from the first node after the header
        while (curr != header) { // Iterate until the header is reached again
            if (curr.data.equals(item))
                return false; // If the current node's data matches the given item, return false (not unique)
            if (curr.data.compareTo(item) > 0)
                break; // If the current node's data is greater than the given item, stop iterating
            curr = curr.next; // Move to the next node
        }
        DNode newNode = new DNode(item); // Create a new node with the given item
        newNode.prev = curr.prev; // Set the new node's previous node as the current node's previous node
        newNode.next = curr; // Set the new node's next node as the current node
        curr.prev.next = newNode; // Update the next node of the new node's previous node to be the new node
        curr.prev = newNode; // Update the previous node of the current node to be the new node
        return true; // Node inserted successfully and is unique, return true
    }

    public DLinkedList<T> merge(DLinkedList<T> rhs) {
        DLinkedList<T> result = new DLinkedList<>(); // Create a new empty linked list
        DNode curr1 = this.header.next; // Start from the first node of the current linked list
        DNode curr2 = rhs.header.next; // Start from the first node of the other linked list

        while (curr1 != this.header && curr2 != rhs.header) {
            // Iterate until either linked list reaches its header
            if (curr1.data.compareTo(curr2.data) <= 0) {
                result.add(curr1.data); // Add the data from the current node of the current linked list to the result
                curr1 = curr1.next; // Move to the next node in the current linked list
            } else {
                result.add(curr2.data); // Add the data from the current node of the other linked list to the result
                curr2 = curr2.next; // Move to the next node in the other linked list
            }
        }

        while (curr1 != this.header) {
            // If there are remaining nodes in the current linked list
            result.add(curr1.data); // Add the data from the current node to the result
            curr1 = curr1.next; // Move to the next node
        }

        while (curr2 != rhs.header) {
            // If there are remaining nodes in the other linked list
            result.add(curr2.data); // Add the data from the current node to the result
            curr2 = curr2.next; // Move to the next node
        }

        this.header.next = this.header.prev = this.header; // Reset the current linked list by setting its header as the only node
        rhs.header.next = rhs.header.prev = rhs.header; // Reset the other linked list by setting its header as the only node

        return result; // Return the merged linked list
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();

        DLinkedList<String> lst1 = new DLinkedList<>(); // Create a new instance of DLinkedList for the first list
        DLinkedList<String> lst2 = new DLinkedList<>(); // Create a new instance of DLinkedList for the second list
        Scanner fin = new Scanner(new File("text1.txt")); // Open the file "text1.txt" for reading
        String str;
        while (fin.hasNext()) {
            str = fin.next(); // Read the next string from the file
            str = cleanUp(str); // Clean up the string by removing non-letter characters and converting to lowercase
            lst1.insertOrderUnique(str); // Insert the cleaned-up string into the first list in an ordered and unique manner
        }
        fin.close(); // Close the file
        fin = new Scanner(new File("text2.txt")); // Open the file "text2.txt" for reading
        while (fin.hasNext()) {
            str = fin.next(); // Read the next string from the file
            str = cleanUp(str); // Clean up the string by removing non-letter characters and converting to lowercase
            lst2.insertOrderUnique(str); // Insert the cleaned-up string into the second list in an ordered and unique manner
        }
        fin.close(); // Close the file

        System.out.println("List 1:  " + lst1); // Print the first list
        System.out.println("List 2:  " + lst2); // Print the second list

        DLinkedList<String> combined = lst1.merge(lst2); // Merge the two lists into a new list

        System.out.println("\nAFTER MERGE");
        System.out.println("List 1:  " + lst1); // Print the first list after merge (should be empty)
        System.out.println("List 2:  " + lst2); // Print the second list after merge (should be empty)
        System.out.println("\n" + combined); // Print the merged list

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("\nBUILD SUCCESSFUL (total time: " + totalTime + " milliseconds)");
    }

    public static String cleanUp(String str) {
        StringBuilder cleaned = new StringBuilder(); // Create a StringBuilder object to store the cleaned string
        for (char c : str.toCharArray()) { // Iterate over each character in the input string
            if (Character.isLetter(c)) // Check if the character is a letter
                cleaned.append(Character.toLowerCase(c)); // If it is a letter, append its lowercase version to the StringBuilder
        }
        return cleaned.toString(); // Convert the StringBuilder to a string and return the cleaned-up string
    }

}




