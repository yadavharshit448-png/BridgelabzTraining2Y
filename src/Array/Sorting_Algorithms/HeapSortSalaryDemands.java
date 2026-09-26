package Array.Sorting_Algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem 6: Heap Sort - Sort Job Applicants by Salary
 *
 * Problem Statement:
 * A company receives job applications with different expected salary demands.
 * Implement Heap Sort to sort these salary demands in ascending order.
 *
 * Algorithm Strategy (Comparison-based Binary Heap):
 * 1. Build Max Heap: Rearrange the array into a complete binary tree satisfying
 *    the Max Heap property (parent node >= child nodes).
 * 2. Extraction & Reheapify: Repeatedly extract the maximum element (located at root index 0),
 *    swap it with the last element of the unsorted heap, reduce heap size, and call
 *    heapify on the root to restore heap property.
 *
 * Time Complexity:
 * - Best Case    : O(N log N)
 * - Average Case : O(N log N)
 * - Worst Case   : O(N log N)
 *
 * Space Complexity:
 * - Auxiliary Space: O(1) (In-place sort)
 */
public class HeapSortSalaryDemands {

    /**
     * Sorts salary demands in ascending order using Heap Sort.
     *
     * @param salaries Array of applicant expected salaries
     */
    public static void heapSort(double[] salaries) {
        int n = salaries.length;

        // Step 1: Build max heap (rearrange array)
        // Start from last non-leaf node and heapify down to root
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Step 2: One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root (maximum) to end
            double temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Call max heapify on the reduced heap
            heapify(salaries, i, 0);
        }
    }

    /**
     * To heapify a subtree rooted with node i which is an index in arr[].
     * n is the size of the heap.
     */
    private static void heapify(double[] arr, int n, int i) {
        int largest = i;       // Initialize largest as root
        int left = 2 * i + 1;  // Left child = 2*i + 1
        int right = 2 * i + 2; // Right child = 2*i + 2

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            double swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 6. Heap Sort: Job Applicant Salary Demands ===");
        System.out.print("Do you want to enter custom salary demands? (yes/no): ");
        String choice = scanner.next();

        double[] salaries;
        if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
            System.out.print("Enter number of applicants: ");
            int count = scanner.nextInt();
            while (count <= 0) {
                System.err.print("Count must be positive. Re-enter: ");
                count = scanner.nextInt();
            }

            salaries = new double[count];
            System.out.println("Enter salary demands for " + count + " applicants ($):");
            for (int i = 0; i < salaries.length; i++) {
                System.out.print("Applicant " + (i + 1) + " Expected Salary: $");
                salaries[i] = scanner.nextDouble();
            }
        } else {
            // Default sample dataset
            salaries = new double[]{65000.0, 48000.0, 92000.0, 35000.0, 120000.0, 78000.0, 55000.0, 84000.0};
            System.out.println("Using sample salary demands dataset.");
        }

        System.out.println("\nOriginal Salaries : " + Arrays.toString(salaries));

        // Perform Heap Sort
        heapSort(salaries);

        System.out.println("Sorted Salaries   : " + Arrays.toString(salaries));

        scanner.close();
    }
}
