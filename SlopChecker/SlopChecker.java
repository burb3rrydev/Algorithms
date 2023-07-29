// Define the package for this Java class
package app;

// Import necessary Java classes for file reading and IOException handling
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Define the main class called SlopChecker
public class SlopChecker {

    // Check if a given string is a slop (contains 'Slap' followed by 'Slip')
    public static boolean isSlop(String str) {
        // Find the index where 'Slap' ends in the string
        int slapEndIndex = findSlapEndIndex(str);

        // If 'Slap' is not found in the string, return false
        if (slapEndIndex == -1) {
            return false;
        }

        // Extract 'Slap' part and 'Slip' part from the string
        String slapPart = str.substring(0, slapEndIndex);
        String slipPart = str.substring(slapEndIndex);

        // Check if both 'Slap' and 'Slip' parts are valid using helper methods
        return SlapChecker.isSlap(slapPart) && SlipChecker.isSlip(slipPart);
    }

    // Helper method to find the index where 'Slap' ends in the string
    private static int findSlapEndIndex(String str) {
        // Initialize the index to 0
        int i = 0;
        // Iterate through the characters of the string
        while (i < str.length()) {
            // If the current character is 'H' or 'C', return the index + 1
            if (str.charAt(i) == 'H' || str.charAt(i) == 'C') {
                return i + 1;
            }
            // Move to the next character in the string
            i++;
        }
        // If 'Slap' is not found, return -1
        return -1;
    }

    // Main method to read input from a file and process each line to check for slop
    public static void main(String[] args) {
        try {
            // Create a BufferedReader to read input from the "input.txt" file
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            // Read the first line from the file, which is the number of test cases (N)
            int N = Integer.parseInt(br.readLine().trim());

            // Process each test case one by one
            for (int i = 0; i < N; i++) {
                // Read the next line from the file and remove leading/trailing whitespaces
                String inputString = br.readLine().trim();
                // Check if the inputString is a slop and store the result in a boolean variable
                boolean isSlop = isSlop(inputString);
                // Print "Slop" if it's a slop, otherwise print "Not Slop"
                System.out.println(isSlop ? "Slop" : "Not Slop");
            }

            // Close the BufferedReader after processing all test cases
            br.close();
        } catch (IOException e) {
            // If an IOException occurs during file reading, print the stack trace
            e.printStackTrace();
        }
    }
}


