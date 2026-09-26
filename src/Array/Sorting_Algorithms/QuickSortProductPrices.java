package Array.Sorting_Algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem 4: Quick Sort - Sort Product Prices
 *
 * Problem Statement:
 * An e-commerce company wants to display product prices in ascending order.
 * Implement Quick Sort to sort the product prices.
 *
 * Algorithm Strategy (Divide and Conquer):
 * 1. Pivot Selection: Pick a pivot (e.g. last element).
 * 2. Partition: Rearrange the array such that all elements smaller than the pivot
 *    are placed to its left, and all elements greater are placed to its right.
 * 3. Recursion: Recursively sort the sub-arrays to the left and right of the pivot.
 *
 * Time Complexity:
 * - Best Case    : O(N log N)
 * - Average Case : O(N log N)
 * - Worst Case   : O(N^2) (e.g., when array is already sorted and extreme pivot chosen)
 *
 * Space Complexity:
 * - Auxiliary Space: O(log N) (call stack depth for recursive partitioning)
 */
public class QuickSortProductPrices {

    /**
     * Recursively applies Quick Sort to partitions.
     *
     * @param prices Array of product prices
     * @param low    Starting index
     * @param high   Ending index
     */
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            // Partition index
            int pi = partition(prices, low, high);

            // Recursively sort elements before and after partition
            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }

    /**
     * Lomuto Partition Scheme: Places pivot at its correct sorted position
     * with all smaller elements to the left and larger to the right.
     */
    private static int partition(double[] prices, int low, int high) {
        double pivot = prices[high]; // Choosing the last element as pivot
        int i = low - 1;             // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (prices[j] <= pivot) {
                i++;
                // Swap prices[i] and prices[j]
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap prices[i + 1] and prices[high] (pivot)
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 4. Quick Sort: Product Prices ===");
        System.out.print("Do you want to enter custom product prices? (yes/no): ");
        String choice = scanner.next();

        double[] productPrices;
        if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
            System.out.print("Enter number of products: ");
            int count = scanner.nextInt();
            while (count <= 0) {
                System.err.print("Count must be positive. Re-enter: ");
                count = scanner.nextInt();
            }

            productPrices = new double[count];
            System.out.println("Enter price for " + count + " products:");
            for (int i = 0; i < productPrices.length; i++) {
                System.out.print("Product " + (i + 1) + " Price ($): ");
                productPrices[i] = scanner.nextDouble();
            }
        } else {
            // Default sample dataset
            productPrices = new double[]{1299.99, 450.50, 899.00, 299.95, 1599.00, 649.50, 99.99, 749.00};
            System.out.println("Using sample product prices dataset.");
        }

        System.out.println("\nOriginal Product Prices : " + Arrays.toString(productPrices));

        // Perform Quick Sort
        quickSort(productPrices, 0, productPrices.length - 1);

        System.out.println("Sorted Product Prices   : " + Arrays.toString(productPrices));

        scanner.close();
    }
}
