// Define the package for this class
package app;

// Import the SlipChecker class from the app package
import app.SlapChecker.SlipChecker;

// Define the SlapChecker class
public class SlapChecker {

    // Method to check if a given string is a "slap"
    public static boolean isSlap(String str) {
        // If the input string is empty, return false
        if (str.isEmpty()) {
            return false;
        }

        // If the first character of the string is not 'A', return false
        if (str.charAt(0) != 'A') {
            return false;
        }

        // If the length of the string is 2, check if the second character is 'H', and return the result
        if (str.length() == 2) {
            return str.charAt(1) == 'H';
        }

        // If the second character is 'B' and the last character is 'C', recursively call isSlap on the substring
        // between the second and the last character (excluding the last character), and return the result.
        if (str.charAt(1) == 'B' && str.charAt(str.length() - 1) == 'C') {
            return isSlap(str.substring(2, str.length() - 1));
        }

        // If the second character is 'D' and SlipChecker.isSlip() returns true for the substring between the second
        // and last character (excluding the last character), and the last character is 'C', return true.
        if (str.charAt(1) == 'D' && SlipChecker.isSlip(str.substring(1, str.length() - 1))) {
            return str.charAt(str.length() - 1) == 'C';
        }

        // If none of the above conditions are met, return false.
        return false;
    }

    // Define the nested SlipChecker class
    public static class SlipChecker {

        // Method to check if a given string is a "slip"
        public static boolean isSlip(String str) {
            // If the input string is empty, return false
            if (str.isEmpty()) {
                return false;
            }

            // If the first character of the string is not 'D' and not 'E', return false
            if (str.charAt(0) != 'D' && str.charAt(0) != 'E') {
                return false;
            }

            // Count the number of consecutive 'F' characters starting from the second character
            int fCount = 0;
            int i = 1;
            while (i < str.length() && str.charAt(i) == 'F') {
                fCount++;
                i++;
            }

            // If there are no 'F' characters or the string ends after the 'F' characters, return false
            if (fCount == 0 || i == str.length()) {
                return false;
            }

            // If the character after the 'F' characters is 'G', return true, otherwise recursively call isSlip
            // on the substring after the 'F' characters and return the result.
            if (str.charAt(i) == 'G') {
                return true;
            } else {
                return isSlip(str.substring(i));
            }
        }
    }
}
