package Array.assigment;

import java.util.Scanner;

/**
 * Question 2 - Level 2: Youngest and Tallest Friend Among Three Friends
 *
 * Description:
 * Takes user inputs for age and height of 3 friends (Amar, Akbar, Anthony) and
 * determines the youngest friend based on age and the tallest friend based on
 * height.
 *
 * Best Programming Practices Followed:
 * 1. String array for friend names to avoid hardcoding inside loops.
 * 2. Input validation for age and height.
 * 3. Array length property used in search loops.
 * 4. Step-by-step comments.
 */
public class Q2_Level2 {

    public static void main(String[] args) {
        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Fixed friends array
        final String[] FRIENDS = {"Amar", "Akbar", "Anthony"};
        final int TOTAL_FRIENDS = FRIENDS.length;

        // Arrays to store ages and heights
        int[] ages = new int[TOTAL_FRIENDS];
        double[] heights = new double[TOTAL_FRIENDS];

        System.out.println("=== Comparison of Three Friends (Amar, Akbar, Anthony) ===");

        // Input loop with validation
        for (int i = 0; i < FRIENDS.length; i++) {
            System.out.println("Details for " + FRIENDS[i] + ":");
            System.out.print("  Enter age (years): ");
            int inputAge = scanner.nextInt();

            // Validate age
            while (inputAge <= 0) {
                System.err.print("  Age must be positive! Re-enter age: ");
                inputAge = scanner.nextInt();
            }

            System.out.print("  Enter height (in cm): ");
            double inputHeight = scanner.nextDouble();

            // Validate height
            while (inputHeight <= 0.0) {
                System.err.print("  Height must be positive! Re-enter height: ");
                inputHeight = scanner.nextDouble();
            }

            ages[i] = inputAge;
            heights[i] = inputHeight;
        }

        // Variables to track min age (youngest) and max height (tallest)
        int youngestIndex = 0;
        int tallestIndex = 0;

        // Loop to find the youngest and tallest friend using array length
        for (int i = 1; i < FRIENDS.length; i++) {
            // Find youngest
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }

            // Find tallest
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        // Display summary
        System.out.println("\n-------------------- Results --------------------");
        System.out.println("Youngest Friend : " + FRIENDS[youngestIndex] +
                " (Age: " + ages[youngestIndex] + " years)");
        System.out.println("Tallest Friend  : " + FRIENDS[tallestIndex] +
                " (Height: " + heights[tallestIndex] + " cm)");
        System.out.println("-------------------------------------------------");

        // Close scanner
        scanner.close();
    }
}
