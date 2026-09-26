package Array.assigment;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Challenge Problem: First Missing Positive & Binary Search Target Finder
 *
 * Requirements:
 * 1. Linear Search: Find the first missing positive integer (1, 2, 3, ...) in the list.
 * 2. Binary Search: After sorting, find the index of a user-specified target number.
 */
public class ChallengeSearchMissingAndTarget {

    /**
     * Finds the first missing positive integer using Linear Search & boolean marking.
     *
     * @param arr Input array of integers
     * @return Smallest positive integer not present in arr
     */
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;
        // The first missing positive integer must fall within the range [1, n + 1]
        boolean[] present = new boolean[n + 2];

        // Mark elements that fall in the valid positive range [1, n + 1]
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0 && arr[i] <= n + 1) {
                present[arr[i]] = true;
            }
        }

        // Linear search for the first unmarked positive integer starting from 1
        for (int i = 1; i <= n + 1; i++) {
            if (!present[i]) {
                return i;
            }
        }

        return n + 1;
    }

    /**
     * Standard iterative Binary Search on sorted array.
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = {3, 4, -1, 1, 7, 8, -5, 2, 9};

        System.out.println("=== Search Challenge: Missing Positive & Binary Search ===");
        System.out.println("Original Array: " + Arrays.toString(numbers));

        // Part 1: First Missing Positive via Linear Search
        int missingPositive = findFirstMissingPositive(numbers);
        System.out.println("\n--- Part 1: Linear Search ---");
        System.out.println("First Missing Positive Integer : " + missingPositive);

        // Part 2: Binary Search after sorting
        int[] sortedNumbers = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sortedNumbers);

        System.out.println("\n--- Part 2: Binary Search ---");
        System.out.println("Sorted Array : " + Arrays.toString(sortedNumbers));

        System.out.print("Enter target number to search: ");
        int target = scanner.nextInt();

        int targetIndex = binarySearch(sortedNumbers, target);
        if (targetIndex != -1) {
            System.out.println("Target " + target + " found in sorted array at index: " + targetIndex);
        } else {
            System.out.println("Target " + target + " is NOT present in the array (-1).");
        }

        scanner.close();
    }
}
