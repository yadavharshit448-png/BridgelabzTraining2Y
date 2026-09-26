package Array.assigment;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem 3: Merge Sort - Sort an Array of Book Prices
 *
 * Problem Statement:
 * A bookstore maintains a list of book prices in an array. Implement Merge Sort
 * to sort the prices in ascending order.
 *
 * Algorithm Strategy (Divide and Conquer):
 * 1. Divide: Find the midpoint of the array and divide into two subarrays.
 * 2. Conquer: Recursively sort both subarrays using mergeSort.
 * 3. Combine: Merge the two sorted subarrays into a single sorted array.
 *
 * Time Complexity:
 * - Best Case    : O(N log N)
 * - Average Case : O(N log N)
 * - Worst Case   : O(N log N)
 *
 * Space Complexity:
 * - Auxiliary Space: O(N) (temporary arrays for merging)
 */
public class MergeSortBookPrices {

    /**
     * Recursively divides array and sorts both halves.
     *
     * @param prices Array of book prices
     * @param left   Starting index
     * @param right  Ending index
     */
    public static void mergeSort(double[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Divide and sort left half
            mergeSort(prices, left, mid);

            // Divide and sort right half
            mergeSort(prices, mid + 1, right);

            // Merge both sorted halves
            merge(prices, left, mid, right);
        }
    }

    /**
     * Merges two sorted subarrays prices[left..mid] and prices[mid+1..right].
     */
    private static void merge(double[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary auxiliary arrays
        double[] leftArr = new double[n1];
        double[] rightArr = new double[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            leftArr[i] = prices[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = prices[mid + 1 + j];
        }

        // Merge temp arrays back into prices[left..right]
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                prices[k] = leftArr[i];
                i++;
            } else {
                prices[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArr[], if any
        while (i < n1) {
            prices[k++] = leftArr[i++];
        }

        // Copy remaining elements of rightArr[], if any
        while (j < n2) {
            prices[k++] = rightArr[j++];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 3. Merge Sort: Book Prices ===");
        System.out.print("Do you want to enter custom book prices? (yes/no): ");
        String choice = scanner.next();

        double[] bookPrices;
        if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
            System.out.print("Enter number of books: ");
            int count = scanner.nextInt();
            while (count <= 0) {
                System.err.print("Count must be positive. Re-enter: ");
                count = scanner.nextInt();
            }

            bookPrices = new double[count];
            System.out.println("Enter price for " + count + " books:");
            for (int i = 0; i < bookPrices.length; i++) {
                System.out.print("Book " + (i + 1) + " Price ($): ");
                bookPrices[i] = scanner.nextDouble();
            }
        } else {
            // Default sample dataset
            bookPrices = new double[]{450.50, 199.99, 850.00, 320.75, 150.00, 620.25, 275.50};
            System.out.println("Using sample book prices dataset.");
        }

        System.out.println("\nOriginal Prices : " + Arrays.toString(bookPrices));

        // Perform Merge Sort
        mergeSort(bookPrices, 0, bookPrices.length - 1);

        System.out.println("Sorted Prices   : " + Arrays.toString(bookPrices));

        scanner.close();
    }
}
