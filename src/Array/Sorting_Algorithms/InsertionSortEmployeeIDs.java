package Array.Sorting_Algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem 2: Insertion Sort - Sort Employee IDs
 *
 * Problem Statement:
 * A company stores employee IDs in an unsorted array. Implement Insertion Sort
 * to sort the employee IDs in ascending order.
 *
 * Algorithm Strategy:
 * 1. Divide array into sorted (initially just the first element) and unsorted parts.
 * 2. Iterate from index 1 to N - 1.
 * 3. Store the current element in a variable `key`.
 * 4. Shift all elements in the sorted portion that are greater than `key` one position ahead.
 * 5. Insert `key` into its correct sorted position.
 *
 * Time Complexity:
 * - Best Case    : O(N) (when already sorted)
 * - Average Case : O(N^2)
 * - Worst Case   : O(N^2) (reverse sorted)
 *
 * Space Complexity:
 * - Auxiliary Space: O(1) (In-place sort)
 */
public class InsertionSortEmployeeIDs {

    /**
     * Sorts employee IDs in ascending order using Insertion Sort.
     *
     * @param employeeIds Array of employee IDs
     */
    public static void insertionSort(int[] employeeIds) {
        int n = employeeIds.length;

        // Iterate through unsorted elements starting from index 1
        for (int i = 1; i < n; i++) {
            int key = employeeIds[i];
            int j = i - 1;

            // Move elements of employeeIds[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && employeeIds[j] > key) {
                employeeIds[j + 1] = employeeIds[j];
                j--;
            }

            // Insert key at its correct position
            employeeIds[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 2. Insertion Sort: Employee IDs ===");
        System.out.print("Do you want to enter custom employee IDs? (yes/no): ");
        String choice = scanner.next();

        int[] employeeIds;
        if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
            System.out.print("Enter number of employees: ");
            int count = scanner.nextInt();
            while (count <= 0) {
                System.err.print("Count must be positive. Re-enter: ");
                count = scanner.nextInt();
            }

            employeeIds = new int[count];
            System.out.println("Enter " + count + " Employee IDs:");
            for (int i = 0; i < employeeIds.length; i++) {
                System.out.print("Employee ID " + (i + 1) + ": ");
                employeeIds[i] = scanner.nextInt();
            }
        } else {
            // Default sample dataset
            employeeIds = new int[]{1045, 1012, 1099, 1001, 1056, 1023, 1080, 1010};
            System.out.println("Using sample employee IDs dataset.");
        }

        System.out.println("\nOriginal Employee IDs : " + Arrays.toString(employeeIds));

        // Perform Insertion Sort
        insertionSort(employeeIds);

        System.out.println("Sorted Employee IDs   : " + Arrays.toString(employeeIds));

        scanner.close();
    }
}
