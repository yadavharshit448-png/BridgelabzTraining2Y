package Array.assigment;

import java.util.Scanner;

/**
 * Question 5 - Level 1: Multiplication Table Range (6 to 9)
 *
 * Description:
 * Takes an integer input from the user, computes its multiplication table for
 * multipliers from 6 to 9, saves results in an array, and displays them.
 *
 * Best Programming Practices Followed:
 * 1. Fixed range boundaries defined as constants (START_MULTIPLIER, END_MULTIPLIER).
 * 2. Array size computed dynamically from constants to avoid magic numbers.
 * 3. Array length property used in loops.
 * 4. User input validated.
 */
public class Q5_Level1 {

    public static void main(String[] args) {
        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Constants defining the multiplication range
        final int START_MULTIPLIER = 6;
        final int END_MULTIPLIER = 9;
        final int TOTAL_ELEMENTS = (END_MULTIPLIER - START_MULTIPLIER) + 1;

        // User input for base number
        System.out.print("Enter an integer number: ");
        int number = scanner.nextInt();

        // Integer array to store the multiplication results
        int[] multiplicationResult = new int[TOTAL_ELEMENTS];

        // Loop using array length to calculate and save results
        for (int i = 0; i < multiplicationResult.length; i++) {
            int currentMultiplier = START_MULTIPLIER + i;
            multiplicationResult[i] = number * currentMultiplier;
        }

        System.out.println("\n--- Multiplication Table of " + number + " (from 6 to 9) ---");

        // Loop using array length to display results
        for (int i = 0; i < multiplicationResult.length; i++) {
            int currentMultiplier = START_MULTIPLIER + i;
            System.out.println(number + " * " + currentMultiplier + " = " + multiplicationResult[i]);
        }

        // Close scanner
        scanner.close();
    }
}
