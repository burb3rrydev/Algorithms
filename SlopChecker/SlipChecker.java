package app; // Declaring a package named 'app'

public class SlipChecker { // Declaring a public class named 'SlipChecker'

    public static boolean isSlip(String str) { // Declaring a public static method 'isSlip' that takes a String argument 'str' and returns a boolean

        if (str.isEmpty() || (str.charAt(0) != 'D' && str.charAt(0) != 'E')) {
            // Checking if the input string is empty or if the first character of the string is not 'D' and not 'E'
            // If either condition is true, it means the string doesn't start with 'D' or 'E', so return false.
            return false;
        }

        int fCount = 0; // Initializing a variable 'fCount' to keep track of the number of consecutive 'F's
        int i = 1; // Initializing a variable 'i' to start iterating the string from the second character (index 1)

        while (i < str.length() && str.charAt(i) == 'F') {
            // While 'i' is within the string length and the character at index 'i' is 'F', do the following:
            fCount++; // Increment the count of consecutive 'F's
            i++; // Move to the next character in the string
        }

        // After the loop ends, we check the following conditions to determine if the input string is a valid 'slip':
        // 1. There should be at least one 'F' (fCount > 0)
        // 2. The loop should have reached the last character of the string (i == str.length() - 1)
        // 3. The last character of the string should be 'G' (str.charAt(i) == 'G')

        return fCount > 0 && i == str.length() - 1 && str.charAt(i) == 'G';
        // If all the conditions are met, return true (it's a valid 'slip'), otherwise, return false.
    }
}
