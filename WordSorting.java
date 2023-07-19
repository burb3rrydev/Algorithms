package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSorting {

    public static void main(String[] args) {
        File file = new File("text.txt.txt"); // Create a File object with the file name "text.txt.txt"
        Scanner scnr;

        try {
            scnr = new Scanner(file); // Create a Scanner object to read from the file
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getAbsolutePath()); // Print an error message if the file is not found
            return;
        }

        String[] words = new String[10000]; // Array to store words
        int wordCount = 0; // Counter for the number of words

        while (scnr.hasNext()) { // Loop until there are no more words in the file
            String word = scnr.next(); // Read the next word from the file
            words[wordCount] = word; // Store the word in the array
            wordCount++; // Increment the word count
        }

        for (int i = 0; i < wordCount; i++) { // Loop through the array of words
            System.out.println(words[i]); // Print each word
        }

        scnr.close(); // Close the Scanner

        // Sort the words array using Insertion Sort
        insertionSort(words, wordCount);

        // Print the sorted words
        System.out.println("Sorted words:");
        for (int i = 0; i < wordCount; i++) { // Loop through the sorted array of words
            System.out.println(words[i]); // Print each word
        }

        searchWords(words, wordCount); // Call the searchWords method with the array of words and word count as arguments
    }

    private static void insertionSort(String[] array, int size) {
        for (int i = 1; i < size; i++) { // Loop through the array starting from the second element
            String key = array[i]; // Store the current element as the key
            int j = i - 1;  // Initialize a variable 'j' to hold the index of the previous element to compare with 'key'

            while (j >= 0 && array[j].compareTo(key) > 0) {
                // while 'j' is greater than or equal to 0
                // and the element at index 'j' is greater than the 'key'

                array[j + 1] = array[j];  // Shift the element at index 'j' to the next position
                j--;  // Decrement 'j' to move to the previous element for comparison
            }

            array[j + 1] = key; // Insert the key into its correct position
        }
    }

    private static void searchWords(String[] words, int wordCount) {
        Scanner userInput = new Scanner(System.in); // Create a Scanner object to read user input
        String userWord;

        do {
            System.out.print("Enter a word to search (or 0 to quit): "); // Prompt the user to enter a word
            userWord = userInput.next(); // Read the user's input

            if (!userWord.equals("0")) { // Check if the user wants to quit
                boolean found = false;
                int index = -1;
                for (int i = 0; i < wordCount; i++) { // Loop through the array of words
                    if (userWord.equals(words[i])) { // Check if the user's word is found in the array
                        found = true;
                        index = i;
                        break;
                    }
                }
                if (found) {
                    System.out.println("Found at index " + index); // Print the index if the word is found
                } else {
                    System.out.println("-1"); // Print -1 if the word is not found
                }
            }
        } while (!userWord.equals("0")); // Repeat until the user enters 0 to quit

        userInput.close(); // Close the Scanner
    }
}


