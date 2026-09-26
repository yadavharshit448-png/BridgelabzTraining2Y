package Array.assigment;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Binary Search Problem 1: Find the Rotation Point in a Rotated Sorted Array
 *
 * Problem Statement:
 * You are given a rotated sorted array. Write a program that performs Binary Search
 * to find the index and value of the smallest element in the array (the rotation point).
 *
 * Algorithm Strategy:
 * 1. Initialize left = 0, right = n - 1.
 * 2. While left < right:
 *    - Calculate mid = left + (right - left) / 2 (avoids integer overflow).
 *    - If arr[mid] > arr[right]: rotation point lies strictly in right half -> left = mid + 1.
 *    - If arr[mid] <= arr[right]: rotation point lies in left half (including mid) -> right = mid.
 * 3. At termination, left == right points to the minimum element.
 *
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
public class BinarySearchRotationPoint {

    /**
     * Finds the index of the rotation point (smallest element).
     *
     * @param arr Rotated sorted array
     * @return Index of the minimum element
     */
    public static int findRotationPointIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Avoid integer overflow
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                // Minimum element must be in right half
                left = mid + 1;
            } else {
                // Minimum element is at mid or in left half
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Binary Search: Rotation Point in Rotated Sorted Array ===");
        System.out.print("Do you want to enter a custom array? (yes/no): ");
        String choice = scanner.next();

        int[] arr;
        if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
            System.out.print("Enter size of rotated sorted array: ");
            int size = scanner.nextInt();
            arr = new int[size];
            System.out.println("Enter " + size + " integers (rotated sorted order, e.g. 4 5 6 7 0 1 2):");
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }
        } else {
            // Default sample dataset
            arr = new int[]{45, 61, 78, 89, 99, 12, 23, 34};
            System.out.println("Using default rotated sorted array.");
        }

        System.out.println("\nRotated Sorted Array: " + Arrays.toString(arr));

        int rotationIndex = findRotationPointIndex(arr);
        if (rotationIndex != -1) {
            System.out.println("Rotation Point Index : " + rotationIndex);
            System.out.println("Smallest Element     : " + arr[rotationIndex]);
        }

        scanner.close();
    }
}
