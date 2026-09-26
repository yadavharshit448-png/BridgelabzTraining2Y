package Array.assigment;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Binary Search Problem 4: Find First and Last Occurrence of an Element
 *
 * Problem Statement:
 * Given a sorted array and a target element, write a program that uses Binary Search
 * to find the first and last occurrence of the target element. If the element is
 * not found, return -1 for both.
 *
 * Algorithm Strategy:
 * 1. Find First Occurrence:
 *    - Binary search for target. When arr[mid] == target, record mid and search left (right = mid - 1).
 * 2. Find Last Occurrence:
 *    - Binary search for target. When arr[mid] == target, record mid and search right (left = mid + 1).
 *
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
public class BinarySearchFirstAndLastOccurrence {

    /**
     * Finds the first (leftmost) occurrence index of target.
     */
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int firstIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                firstIndex = mid;
                right = mid - 1; // Keep searching towards the left
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return firstIndex;
    }

    /**
     * Finds the last (rightmost) occurrence index of target.
     */
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int lastIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                lastIndex = mid;
                left = mid + 1; // Keep searching towards the right
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return lastIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = {2, 4, 4, 4, 6, 7, 7, 8, 9, 9, 9, 9, 12};

        System.out.println("=== Binary Search: First & Last Occurrence ===");
        System.out.println("Sorted Array: " + Arrays.toString(arr));

        System.out.print("\nEnter target element to locate: ");
        int target = scanner.nextInt();

        int firstIdx = findFirstOccurrence(arr, target);
        int lastIdx = findLastOccurrence(arr, target);

        System.out.println("\n--- Search Results ---");
        System.out.println("Target Element   : " + target);
        System.out.println("First Occurrence : " + firstIdx);
        System.out.println("Last Occurrence  : " + lastIdx);

        if (firstIdx != -1) {
            int totalCount = (lastIdx - firstIdx) + 1;
            System.out.println("Total Count      : " + totalCount);
        }

        scanner.close();
    }
}
