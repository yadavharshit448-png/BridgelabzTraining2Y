package Array.assigment;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Linear Search Problem 1: Search for the First Negative Number
 *
 * Problem Statement:
 * You are given an integer array. Write a program that performs Linear Search to
 * find the first negative number in the array. If a negative number is found,
 * return its index. If no negative number is found, return -1.
 *
 * Best Practices:
 * - Early return upon finding the first occurrence to avoid unnecessary checks.
 * - Time Complexity: O(N) worst case, O(1) best case.
 * - Auxiliary Space Complexity: O(1).
 */
public class LinearSearchFirstNegative {

    /**
     * Performs linear search to find index of the first negative number.
     *
     * @param arr Array of integers
     * @return Index of first negative number, or -1 if none found
     */
    public static int findFirstNegativeIndex(int[] arr) {
        if (arr == null) {
            return -1;
        }

        // Iterate through array from start
        for (int i = 0; i < arr.length; i++) {
            // Check if current element is negative
            if (arr[i] < 0) {
                return i; // Early return as soon as first negative is found
            }
        }

        return -1; // No negative number found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Linear Search: First Negative Number ===");
        System.out.print("Do you want to enter a custom array? (yes/no): ");
        String choice = scanner.next();

        int[] numbers;
        if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
            System.out.print("Enter size of array: ");
            int size = scanner.nextInt();
            numbers = new int[size];
            System.out.println("Enter " + size + " integer values:");
            for (int i = 0; i < size; i++) {
                numbers[i] = scanner.nextInt();
            }
        } else {
            // Default sample dataset
            numbers = new int[]{15, 23, 0, 42, -7, 18, -3, 90};
            System.out.println("Using default sample array.");
        }

        System.out.println("\nArray: " + Arrays.toString(numbers));
        int resultIndex = findFirstNegativeIndex(numbers);

        if (resultIndex != -1) {
            System.out.println("First negative number (" + numbers[resultIndex] + ") found at index: " + resultIndex);
        } else {
            System.out.println("No negative number exists in the array (-1).");
        }

        scanner.close();
    }
}
