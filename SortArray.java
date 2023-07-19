package app;

import java.util.Random;

public class SortArray {
    int numbers[] = new int[100]; // Declare and initialize an array of integers called "numbers" with a size of 100
    int steps = 0; // Counter for computational steps
    
    public SortArray() {
        Random rand = new Random(); // Create a new instance of the Random class called "rand"
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000); // Generates a random number between 0 and 999 and assigns it to the current index of the "numbers" array
        }
    }
    
    public int findLargest() {
        int largest = numbers[0]; // Initialize a variable "largest" with the value at the first index of the "numbers" array
        steps++; // Increment step counter
        
        for (int i = 0; i < numbers.length; i++) {
            steps++; // Increment step counter
            if (numbers[i] > largest) {
                largest = numbers[i]; // Update the value of "largest" if the current number is greater than the previous largest number
                steps++; // Increment step counter
            }
        }
        return largest; // Return the largest number found in the "numbers" array
    }
    
    public static void main(String[] args) {
        SortArray sortArray = new SortArray(); // Create a new instance of the SortArray class called "sortArray"
        int largestNumber = sortArray.findLargest(); // Call the findLargest() method on the "sortArray" object and assign the result to "largestNumber"
        System.out.println("Largest number: " + largestNumber); // Print the largest number found
        System.out.println("Computational steps: " + sortArray.steps); // Print the total number of computational steps taken
    }
}

