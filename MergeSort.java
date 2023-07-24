package app;

import java.util.Arrays;

public class MergeSort {
    // Function to perform Merge Sort on the array 'arr'
    public static void mergeSort(int[] arr, int left, int right) {
        // Base case: If left is less than right, then the array has more than one element
        if (left < right) {
            // Calculate the middle index
            int mid = (left + right) / 2;
            // Recursively sort the left half of the array
            mergeSort(arr, left, mid);
            // Recursively sort the right half of the array
            mergeSort(arr, mid + 1, right);
            // Merge the two sorted halves into a single sorted array
            merge(arr, left, mid, right);
        }
    }

    // Function to merge two sorted arrays into a single sorted array
    public static void merge(int[] arr, int left, int mid, int right) {
        // Create a temporary array to store the merged result
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        // Compare elements from the left and right halves, and merge them in sorted order
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy any remaining elements from the left half
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy any remaining elements from the right half
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy the merged elements from the temporary array back to the original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i - left];
        }
    }

    public static void main(String[] args) {
        // Input array to be sorted
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original Array: " + Arrays.toString(arr));

        // Call mergeSort function to sort the array
        mergeSort(arr, 0, arr.length - 1);

        // Print the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
