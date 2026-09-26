package Array.assigment;

import java.util.Scanner;

/**
 * Question 3 - Level 1: Multiplication Table Generator
 *
 * Description:
 * Takes an integer input from the user, computes its multiplication table from
 * 1 to 10, stores the products in an array, and displays them.
 *
 * Best Programming Practices Followed:
 * 1. Constant for table range (TABLE_LIMIT).
 * 2. Proper variable declarations and meaningful names.
 * 3. Array length property used in calculations and printing.
 * 4. Step-by-step comments.
 */
public class Q3_Level1 {

    public static void main(String[] args) {
        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Fixed constant for table range
        final int TABLE_LIMIT = 10;

        // User input for the base number
        System.out.print("Enter an integer number to generate its multiplication table: ");
        int number = scanner.nextInt();

        // Array to store the results of multiplication from 1 to 10
        int[] multiplicationTable = new int[TABLE_LIMIT];

        // Loop to compute and store multiplication results
        for (int i = 0; i < multiplicationTable.length; i++) {
            int multiplier = i + 1;
            multiplicationTable[i] = number * multiplier;
        }

        System.out.println("\n--- Multiplication Table of " + number + " ---");

        // Loop using array length to display results in standard format
        for (int i = 0; i < multiplicationTable.length; i++) {
            int multiplier = i + 1;
            System.out.println(number + " * " + multiplier + " = " + multiplicationTable[i]);
        }

        // Close scanner
        scanner.close();
    }
}
