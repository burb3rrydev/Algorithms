package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

class HashTable {
    private int size;
    private LinkedList<String>[] table;

    public HashTable(int size) {
        this.size = size; // Set the size of the hash table
        table = new LinkedList[size]; // Create an array to store LinkedLists for each index
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>(); // Initialize each index with an empty LinkedList
        }
    }

    private int hash(String word) {
        int hash = 0; // Initialize the hash value
        for (char c : word.toCharArray()) { // Iterates over each character in the word string and assigns each character to the variable c
            hash = (hash * 31 + c) % size; // Calculate the hash value for the word using a basic hashing technique
        }
        return hash; // Return the calculated hash value
    }


    public void insert(String word) {
        int index = hash(word); // Get index using hash function
        table[index].add(word); // Add the word to the linked list at the calculated index
    }

    public boolean search(String word, int[] count) {
        int index = hash(word); // Get index using hash function
        for (String w : table[index]) { // Loop through words at the index
            count[0]++; // Increment the count of inspected elements
            if (w.equals(word)) {
                return true; // If the word is found, return true
            }
        }
        return false; // If word not found, return false
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(100); // Create a hash table with size 100

        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt")); // Open the file for reading
            String line;
            while ((line = reader.readLine()) != null) {
                hashTable.insert(line); // Insert each line from the file into the hash table
            }
            reader.close(); // Close the file
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace if there's an IO exception
        }

        java.util.Scanner scanner = new java.util.Scanner(System.in); // Create a scanner to read from console
        System.out.println("Enter word to search (or 'exit' to quit):");
        String word = scanner.next(); // Read user input
        while (!word.equals("exit")) {
            int[] count = {0}; // Initialize count to keep track of inspected elements
            boolean found = hashTable.search(word, count); // Search for the word in hash table
            if (found) {
                System.out.println("Found " + word + " with " + count[0] + " elements inspected.");
            } else {
                System.out.println("Word not found. Inspected " + count[0] + " elements.");
            }
            System.out.println("Enter word to search (or 'exit' to quit):");
            word = scanner.next(); // Read next user input
        }
    }
}



