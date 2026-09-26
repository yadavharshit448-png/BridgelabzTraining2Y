package Array.assigment;

import java.util.Scanner;

/**
 * Sample Program 2: 2D Array Matrix Elements and Sum
 *
 * Best Programming Practices Followed:
 * 1. Constant variables for dimensions (ROWS, COLUMNS).
 * 2. Proper valid identifier class name (Sample2_2DArray).
 * 3. Array length properties (arr.length, arr[i].length) used in loops.
 * 4. Step-by-step commentary and structured output.
 */
public class Sample2_2DArray {

    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Fixed dimension constants
        final int ROWS = 3;
        final int COLUMNS = 3;

        // Declare the 2D Array
        int[][] arr = new int[ROWS][COLUMNS];

        // Input the elements of the 2D Array
        System.out.println("Enter the elements of the " + ROWS + "x" + COLUMNS + " 2D Array: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("Enter element at [" + i + "][" + j + "]: ");
                arr[i][j] = input.nextInt();
            }
        }

        // Display the elements of the 2D Array and calculate sum
        int sum = 0;
        System.out.println("\nThe elements of the 2D Array are: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
                sum += arr[i][j];
            }
            System.out.println();
        }

        // Display the sum of the elements of the 2D Array
        System.out.println("\nThe sum of the elements of the 2D Array is: " + sum);

        // Close the Scanner Object
        input.close();
    }
}
