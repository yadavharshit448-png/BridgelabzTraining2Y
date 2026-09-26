package Array.assigment;

import java.util.Scanner;

/**
 * Question 6 - Level 1: Football Team Mean Height Calculator
 *
 * Description:
 * Calculates the mean (average) height of 11 players in a football team using a
 * double array.
 *
 * Best Programming Practices Followed:
 * 1. Constant for team size (TEAM_SIZE).
 * 2. Proper variable declarations (heights array, sum, meanHeight).
 * 3. Validation for positive, realistic height inputs.
 * 4. Array length property used in all loops and average calculation.
 */
public class Q6_Level1 {

    public static void main(String[] args) {
        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Fixed constant for football team squad size
        final int TEAM_SIZE = 11;

        // Double array to store player heights (in cm or meters)
        double[] heights = new double[TEAM_SIZE];

        System.out.println("=== Football Team Mean Height Calculator ===");
        System.out.println("Enter the height for " + heights.length + " players:\n");

        // Input loop with user input validation
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height for player " + (i + 1) + ": ");
            double inputHeight = scanner.nextDouble();

            // Validate that height is a positive real value
            while (inputHeight <= 0.0) {
                System.err.print("Invalid height! Please enter a positive value: ");
                inputHeight = scanner.nextDouble();
            }

            heights[i] = inputHeight;
        }

        // Variable to accumulate total sum of heights
        double totalSum = 0.0;

        // Summation loop using array length property
        for (int i = 0; i < heights.length; i++) {
            totalSum += heights[i];
        }

        // Compute mean height using array length
        double meanHeight = totalSum / heights.length;

        // Display individual heights and calculated mean
        System.out.println("\n--- Player Heights ---");
        for (int i = 0; i < heights.length; i++) {
            System.out.println("Player " + (i + 1) + " Height: " + heights[i]);
        }

        System.out.println("\nTotal Sum of Heights: " + totalSum);
        System.out.println("Mean Height of Football Team: " + meanHeight);

        // Close scanner
        scanner.close();
    }
}
