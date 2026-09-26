package Array.assigment;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Binary Search Problem 2: Find the Peak Element in an Array
 *
 * Problem Statement:
 * A peak element is an element that is strictly greater than its neighbors.
 * Write a program that performs Binary Search to find a peak element in an array.
 * If multiple peaks exist, return any one of them.
 *
 * Algorithm Strategy:
 * 1. Initialize left = 0, right = n - 1.
 * 2. Calculate mid = left + (right - left) / 2.
 * 3. Compare arr[mid] with arr[mid + 1]:
 *    - If arr[mid] > arr[mid + 1]: A peak exists in the left half (including mid) -> right = mid.
 *    - If arr[mid] < arr[mid + 1]: A peak exists in the right half -> left = mid + 1.
 * 4. When left == right, left points to a valid peak element.
 *
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
public class BinarySearchPeakElement {

    /**
     * Finds a peak element index using Binary Search.
     *
     * @param arr Input array
     * @return Index of a peak element
     */
    public static int findPeakElementIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If slope is decreasing, peak is at mid or to the left
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                // If slope is increasing, peak is to the right
                left = mid + 1;
            }
        }

        return left; // left == right is a peak index
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Binary Search: Find Peak Element ===");
        System.out.print("Do you want to enter a custom array? (yes/no): ");
        String choice = scanner.next();

        int[] arr;
        if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
            System.out.print("Enter size of array: ");
            int size = scanner.nextInt();
            arr = new int[size];
            System.out.println("Enter " + size + " integers:");
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }
        } else {
            // Default sample dataset
            arr = new int[]{1, 3, 20, 4, 1, 0};
            System.out.println("Using default sample array.");
        }

        System.out.println("\nArray: " + Arrays.toString(arr));

        int peakIndex = findPeakElementIndex(arr);
        if (peakIndex != -1) {
            System.out.println("Peak Element Index : " + peakIndex);
            System.out.println("Peak Element Value : " + arr[peakIndex]);
        }

        scanner.close();
    }
}
