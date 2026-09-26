package Array.assigment;

import java.util.Scanner;

/**
 * Question 9 - Level 1: Multi-Dimensional Matrix Flattening (2D to 1D Array)
 *
 * Description:
 * Creates a 2D integer array (matrix) based on user-defined rows and columns,
 * populates it with user values, and copies all elements row-by-row into a
 * single-dimensional (1D) array.
 *
 * Best Programming Practices Followed:
 * 1. Variables for rows, columns, and total elements.
 * 2. Input validation for positive dimension entries.
 * 3. Matrix lengths (matrix.length, matrix[i].length) used in nested loops.
 * 4. Clear step-by-step comments and output formatting.
 */
public class Q9_Level1 {

    public static void main(String[] args) {
        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Input dimensions
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = scanner.nextInt();

        // Validate dimensions
        if (rows <= 0 || columns <= 0) {
            System.err.println("Invalid matrix dimensions! Rows and columns must be greater than 0.");
            System.exit(0);
        }

        // Declare and allocate 2D array (Matrix)
        int[][] matrix = new int[rows][columns];

        // Input matrix elements
        System.out.println("\nEnter elements of the " + rows + "x" + columns + " Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Element at [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Declare 1D array with capacity rows * columns
        int totalElements = rows * columns;
        int[] flatArray = new int[totalElements];

        // Index pointer to track position in 1D array
        int flatIndex = 0;

        // Nested loops to copy elements from 2D array to 1D array
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                flatArray[flatIndex] = matrix[i][j];
                flatIndex++;
            }
        }

        // Display 2D Matrix
        System.out.println("\n--- Original 2D Matrix ---");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        // Display Flattened 1D Array using array length property
        System.out.println("\n--- Flattened 1D Array ---");
        System.out.print("[ ");
        for (int i = 0; i < flatArray.length; i++) {
            System.out.print(flatArray[i] + (i < flatArray.length - 1 ? ", " : " "));
        }
        System.out.println("]");

        // Close scanner
        scanner.close();
    }
}
