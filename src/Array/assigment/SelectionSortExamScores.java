package Array.assigment;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem 5: Selection Sort - Sort Exam Scores
 *
 * Problem Statement:
 * A university needs to sort students' exam scores in ascending order.
 * Implement Selection Sort to achieve this.
 *
 * Algorithm Strategy:
 * 1. Maintain two subarrays: sorted (left) and unsorted (right).
 * 2. In each iteration, scan the unsorted portion to find the index of the minimum element.
 * 3. Swap the discovered minimum element with the first element of the unsorted subarray.
 * 4. Increment the boundary of the sorted subarray and repeat until the array is fully sorted.
 *
 * Time Complexity:
 * - Best Case    : O(N^2)
 * - Average Case : O(N^2)
 * - Worst Case   : O(N^2)
 *
 * Space Complexity:
 * - Auxiliary Space: O(1) (In-place sort)
 */
public class SelectionSortExamScores {

    /**
     * Sorts exam scores in ascending order using Selection Sort.
     *
     * @param scores Array of student exam scores
     */
    public static void selectionSort(int[] scores) {
        int n = scores.length;

        // Move the boundary of unsorted subarray one by one
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap found minimum element with the first element of unsorted part
            if (minIndex != i) {
                int temp = scores[minIndex];
                scores[minIndex] = scores[i];
                scores[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 5. Selection Sort: Exam Scores ===");
        System.out.print("Do you want to enter custom exam scores? (yes/no): ");
        String choice = scanner.next();

        int[] scores;
        if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
            System.out.print("Enter number of students: ");
            int count = scanner.nextInt();
            while (count <= 0) {
                System.err.print("Count must be positive. Re-enter: ");
                count = scanner.nextInt();
            }

            scores = new int[count];
            System.out.println("Enter exam scores for " + count + " students (0 - 100):");
            for (int i = 0; i < scores.length; i++) {
                System.out.print("Student " + (i + 1) + " Score: ");
                scores[i] = scanner.nextInt();
            }
        } else {
            // Default sample dataset
            scores = new int[]{72, 88, 55, 94, 61, 83, 49, 90, 77, 65};
            System.out.println("Using sample exam scores dataset.");
        }

        System.out.println("\nOriginal Scores : " + Arrays.toString(scores));

        // Perform Selection Sort
        selectionSort(scores);

        System.out.println("Sorted Scores   : " + Arrays.toString(scores));

        scanner.close();
    }
}
