package Array.assigment;

import java.util.Scanner;

/**
 * Question 2 - Level 1: Number Classification and Extremity Comparison
 *
 * Description:
 * Takes user input for 5 numbers, checks whether each number is positive,
 * negative, or zero (and if positive, checks even or odd). Finally, compares the
 * first and last elements of the array.
 *
 * Best Programming Practices Followed:
 * 1. Constant variable for array size (ARRAY_SIZE).
 * 2. Proper camelCase variable naming.
 * 3. Array length property used in loops.
 * 4. Structured logic with clear comments.
 */
public class Q2_Level1 {

    public static void main(String[] args) {
        // Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Fixed size constant
        final int ARRAY_SIZE = 5;

        // Declare integer array
        int[] numbers = new int[ARRAY_SIZE];

        System.out.println("=== Number Classification and Comparison ===");
        System.out.println("Enter " + ARRAY_SIZE + " integer numbers:\n");

        // Input loop using array length property
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\n--- Number Analysis ---");

        // Processing loop using array length property
        for (int i = 0; i < numbers.length; i++) {
            int currentNum = numbers[i];

            // Conditional block to classify number
            if (currentNum > 0) {
                // Nested conditional check for even or odd
                if (currentNum % 2 == 0) {
                    System.out.println("Number " + currentNum + " is Positive and Even.");
                } else {
                    System.out.println("Number " + currentNum + " is Positive and Odd.");
                }
            } else if (currentNum < 0) {
                System.out.println("Number " + currentNum + " is Negative.");
            } else {
                System.out.println("Number " + currentNum + " is Zero.");
            }
        }

        System.out.println("\n--- First vs Last Element Comparison ---");

        // Variables storing first and last elements
        int firstElement = numbers[0];
        int lastElement = numbers[numbers.length - 1];

        // Comparison block
        if (firstElement == lastElement) {
            System.out.println("First element (" + firstElement + ") is EQUAL to the last element (" + lastElement + ").");
        } else if (firstElement > lastElement) {
            System.out.println("First element (" + firstElement + ") is GREATER than the last element (" + lastElement + ").");
        } else {
            System.out.println("First element (" + firstElement + ") is LESS than the last element (" + lastElement + ").");
        }

        // Close scanner
        scanner.close();
    }
}
