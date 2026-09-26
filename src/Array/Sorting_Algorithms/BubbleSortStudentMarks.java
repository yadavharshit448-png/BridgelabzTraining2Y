package Array.Sorting_Algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem 1: Bubble Sort - Sort Student Marks
 *
 * Problem Statement:
 * A school maintains student marks in an array. Implement Bubble Sort to sort
 * the student marks in ascending order.
 *
 * Algorithm Strategy:
 * 1. Traverse through the array multiple times.
 * 2. Compare adjacent elements and swap if marks[j] > marks[j + 1].
 * 3. Optimize by tracking whether any swap occurred in a pass. If no swaps
 *    occurred, the array is already sorted and we can terminate early.
 *
 * Time Complexity:
 * - Best Case    : O(N) (when already sorted)
 * - Average Case : O(N^2)
 * - Worst Case   : O(N^2)
 *
 * Space Complexity:
 * - Auxiliary Space: O(1) (In-place sort)
 */
public class BubbleSortStudentMarks {

    /**
     * Sorts student marks array in ascending order using optimized Bubble Sort.
     *
     * @param marks Array of student marks
     */
    public static void bubbleSort(int[] marks) {
        int n = marks.length;

        // Traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            // Last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements
                if (marks[j] > marks[j + 1]) {
                    // Swap adjacent elements
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped by inner loop, array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 1. Bubble Sort: Student Marks ===");
        System.out.print("Do you want to enter custom marks? (yes/no): ");
        String choice = scanner.next();

        int[] marks;
        if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
            System.out.print("Enter number of students: ");
            int count = scanner.nextInt();
            while (count <= 0) {
                System.err.print("Count must be positive. Re-enter: ");
                count = scanner.nextInt();
            }

            marks = new int[count];
            System.out.println("Enter marks for " + count + " students (0 - 100):");
            for (int i = 0; i < marks.length; i++) {
                System.out.print("Student " + (i + 1) + ": ");
                marks[i] = scanner.nextInt();
            }
        } else {
            // Default sample dataset
            marks = new int[]{85, 42, 96, 73, 60, 88, 51, 99, 45, 68};
            System.out.println("Using sample student marks dataset.");
        }

        System.out.println("\nOriginal Marks : " + Arrays.toString(marks));

        // Perform Bubble Sort
        bubbleSort(marks);

        System.out.println("Sorted Marks   : " + Arrays.toString(marks));

        scanner.close();
    }
}
