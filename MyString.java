package app;

public class MyString {
    private char[] charArray; // Declare a private char array to store the characters of the string
    private int curr_length; // Declare a private integer to store the current length of the string

    public MyString() {
        charArray = new char[0]; // Initialize the charArray with an empty char array
        curr_length = 0; // Set the current length to 0
    }

    public MyString(String str) {
        charArray = str.toCharArray(); // Convert the input string to a char array and assign it to charArray
        curr_length = charArray.length; // Set the current length to the length of charArray
    }

    public MyString(MyString other) {
        charArray = other.charArray.clone(); // Create a copy of the char array in the other MyString object
        curr_length = other.curr_length; // Set the current length to the length of the copied char array
    }

    public int length() {
        return curr_length; // Return the current length of the string
    }

    private void ensureCapacity(int capacity) {
        if (charArray.length < capacity) { // Check if the current capacity is less than the required capacity
            char[] newArray = new char[capacity]; // Create a new char array with the required capacity
            System.arraycopy(charArray, 0, newArray, 0, curr_length); // Copy the existing characters to the new array
            charArray = newArray; // Replace the existing char array with the new array
        }
    }

    @Override
    public String toString() {
        return new String(charArray, 0, curr_length); // Convert the char array to a string and return it
    }

    public MyString concat(MyString other) {
        MyString result = new MyString(); // Create a new MyString object to store the concatenated string
        result.ensureCapacity(curr_length + other.curr_length); // Ensure capacity for the concatenated string
        System.arraycopy(charArray, 0, result.charArray, 0, curr_length); // Copy the characters of the first string
        System.arraycopy(other.charArray, 0, result.charArray, curr_length, other.curr_length); // Copy the characters of the second string
        result.curr_length = curr_length + other.curr_length; // Update the length of the concatenated string
        return result; // Return the concatenated string
    }

    public boolean equals(MyString other) {
        if (curr_length != other.curr_length) {
            return false; // If the lengths are different, the strings are not equal
        }
        for (int i = 0; i < curr_length; i++) {
            if (charArray[i] != other.charArray[i]) {
                return false; // If any characters are different, the strings are not equal
            }
        }
        return true; // All characters are equal, so the strings are equal
    }

    public int compareTo(MyString other) {
        int minLength = Math.min(curr_length, other.curr_length); // Find the minimum length between the two strings
        for (int i = 0; i < minLength; i++) {
            if (charArray[i] != other.charArray[i]) {
                return charArray[i] - other.charArray[i]; // Compare the characters and return the difference
            }
        }
        return curr_length - other.curr_length; // All characters are equal, so compare the lengths
    }

    public char get(int index) {
        if (index < 0 || index >= curr_length) {
            throw new IndexOutOfBoundsException(); // Check if the index is valid and throw an exception if not
        }
        return charArray[index]; // Return the character at the specified index
    }

    public MyString toUpper() {
        MyString result = new MyString(this); // Create a copy of the current string
        for (int i = 0; i < curr_length; i++) {
            result.charArray[i] = Character.toUpperCase(result.charArray[i]); // Convert each character to uppercase
        }
        return result; // Return the uppercase string
    }

    public MyString toLower() {
        MyString result = new MyString(this); // Create a copy of the current string
        for (int i = 0; i < curr_length; i++) {
            result.charArray[i] = Character.toLowerCase(result.charArray[i]); // Convert each character to lowercase
        }
        return result; // Return the lowercase string
    }

    public MyString substring(int startIndex) {
        if (startIndex < 0 || startIndex >= curr_length) {
            throw new IndexOutOfBoundsException(); // Check if the start index is valid and throw an exception if not
        }
        MyString result = new MyString(); // Create a new MyString object to store the substring
        result.ensureCapacity(curr_length - startIndex); // Ensure capacity for the substring
        System.arraycopy(charArray, startIndex, result.charArray, 0, curr_length - startIndex); // Copy the characters of the substring
        result.curr_length = curr_length - startIndex; // Update the length of the substring
        return result; // Return the substring
    }

    public MyString substring(int startIndex, int endIndex) {
        if (startIndex < 0 || startIndex >= curr_length || endIndex < startIndex || endIndex > curr_length) {
            throw new IndexOutOfBoundsException(); // Check if the start and end indices are valid and throw an exception if not
        }
        MyString result = new MyString(); // Create a new MyString object to store the substring
        result.ensureCapacity(endIndex - startIndex); // Ensure capacity for the substring
        System.arraycopy(charArray, startIndex, result.charArray, 0, endIndex - startIndex); // Copy the characters of the substring
        result.curr_length = endIndex - startIndex; // Update the length of the substring
        return result; // Return the substring
    }

    public int indexOf(MyString pattern) {
        int patternLength = pattern.length(); // Get the length of the pattern string
        if (patternLength > curr_length) {
            return -1; // If the pattern is longer than the current string, it cannot be found
        }
        for (int i = 0; i <= curr_length - patternLength; i++) {
            boolean found = true; // Assume the pattern is found
            for (int j = 0; j < patternLength; j++) {
                if (charArray[i + j] != pattern.charArray[j]) {
                    found = false; // If any characters do not match, the pattern is not found
                    break;
                }
            }
            if (found) {
                return i; // Pattern found at index i
            }
        }
        return -1; // Pattern not found
    }

    public int lastIndexOf(MyString pattern) {
        int patternLength = pattern.length(); // Store the length of the pattern string
        if (patternLength > curr_length) { // Check if the pattern is longer than the current string
            return -1; // Return -1 if the pattern is longer
        }
        for (int i = curr_length - patternLength; i >= 0; i--) {
            // Loop through the current string starting from a position that allows
            // the pattern to fit within the remaining characters of the string
            boolean found = true; // Assume the pattern is found
            for (int j = 0; j < patternLength; j++) {
                // Loop through each character of the pattern
                if (charArray[i + j] != pattern.charArray[j]) {
                    // Compare the characters of the current string and the pattern
                    found = false; // Set found to false if characters don't match
                    break; // Exit the loop if characters don't match
                }
            }
            if (found) {
                // If the pattern is found, return the starting index of the pattern
                return i;
            }
        }
        // Return -1 if the pattern is not found in the current string
        return -1;
    }


    public static void main(String[] args) {
        MyString str1 = new MyString("Hello"); // Create a new MyString object with the value "Hello"
        MyString str2 = new MyString("World"); // Create a new MyString object with the value "World"
        MyString str3 = new MyString(str1); // Create a new MyString object as a copy of str1

        System.out.println("str1: " + str1); // Print the value of str1
        System.out.println("str2: " + str2); // Print the value of str2
        System.out.println("str3: " + str3); // Print the value of str3

        MyString concatenated = str1.concat(str2); // Concatenate str1 and str2
        System.out.println("Concatenated: " + concatenated); // Print the concatenated string

        boolean isEqual = str1.equals(str2); // Check if str1 is equal to str2
        System.out.println("str1 equals str2: " + isEqual); // Print the result of the equality check

        int comparison = str1.compareTo(str2); // Compare str1 and str2 based on their dictionary or alphabetical order
        System.out.println("Comparison result: " + comparison); // Print the result of the comparison

        char ch = str1.get(2); // Get the character at index 2 in str1
        System.out.println("Character at index 2 in str1: " + ch); // Print the character

        MyString upperCase = str1.toUpper(); // Convert str1 to uppercase
        System.out.println("Uppercase of str1: " + upperCase); // Print the uppercase string

        MyString lowerCase = str1.toLower(); // Convert str1 to lowercase
        System.out.println("Lowercase of str1: " + lowerCase); // Print the lowercase string

        MyString substring1 = str1.substring(1); // Get the substring of str1 starting from index 1
        System.out.println("Substring of str1 (starting at index 1): " + substring1); // Print the substring

        MyString substring2 = str1.substring(1, 4); // Get the substring of str1 from index 1 to 4
        System.out.println("Substring of str1 (from index 1 to 4): " + substring2); // Print the substring

        int index1 = str1.indexOf(new MyString("lo")); // Find the index of "lo" in str1
        int index2 = str1.lastIndexOf(new MyString("l")); // Find the last index of "l" in str1
        System.out.println("Index of 'lo' in str1: " + index1); // Print the index of "lo"
        System.out.println("Last index of 'l' in str1: " + index2); // Print the last index of "l"
    }

}

