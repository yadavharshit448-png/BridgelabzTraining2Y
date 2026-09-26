package Array.assigment;

import java.util.Scanner;

/**
 * Binary Search Problem 3: Search for a Target Value in a 2D Sorted Matrix
 *
 * Problem Statement:
 * You are given a 2D matrix where each row is sorted in ascending order, and
 * the first element of each row is greater than the last element of the previous row.
 * Write a program that performs Binary Search to find a target value in the matrix.
 *
 * Algorithm Strategy (Virtual Flattening):
 * 1. Dimensions: rows = matrix.length, cols = matrix[0].length.
 * 2. Total elements: total = rows * cols.
 * 3. Range: left = 0, right = total - 1.
 * 4. Coordinate Mapping:
 *    - row = mid / cols
 *    - col = mid % cols
 * 5. Compare matrix[row][col] with target:
 *    - If match: return true.
 *    - If matrix[row][col] < target: search right (left = mid + 1).
 *    - If matrix[row][col] > target: search left (right = mid - 1).
 *
 * Time Complexity: O(log(M * N))
 * Space Complexity: O(1)
 */
public class BinarySearch2DMatrix {

    /**
     * Searches for a target value in a 2D sorted matrix.
     *
     * @param matrix 2D sorted integer matrix
     * @param target Value to search for
     * @return true if target exists in matrix, false otherwise
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = (rows * cols) - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;
            int midValue = matrix[row][col];

            if (midValue == target) {
                return true; // Target found
            } else if (midValue < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }

        return false; // Target not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = {
            { 1,  3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        System.out.println("=== Binary Search: 2D Sorted Matrix ===");
        System.out.println("Matrix Contents:");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("  [ ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%2d ", matrix[i][j]);
            }
            System.out.println("]");
        }

        System.out.print("\nEnter target value to search: ");
        int target = scanner.nextInt();

        boolean found = searchMatrix(matrix, target);

        System.out.println("\nSearch Result: Target " + target + " " + (found ? "EXISTS" : "DOES NOT EXIST") + " in the matrix.");

        scanner.close();
    }
}
