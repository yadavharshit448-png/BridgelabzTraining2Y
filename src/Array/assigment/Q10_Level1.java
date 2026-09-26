package Array.assigment;

import java.util.Scanner;

/**
 * Question 10 - Level 1: FizzBuzz String Array
 *
 * Description:
 * Takes a positive integer N from the user, populates a String array from 0 to N
 * with "Fizz" for multiples of 3, "Buzz" for multiples of 5, "FizzBuzz" for
 * multiples of both 3 and 5, and the number itself otherwise. Finally prints
 * each position.
 *
 * Best Programming Practices Followed:
 * 1. Positive number validation (exits if invalid).
 * 2. Proper variable naming.
 * 3. Array length property used in loops.
 * 4. Two-pass design: first pass calculates & stores, second pass displays.
 */
public class Q10_Level1 {

    public static void main(String[] args) {
        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Validate user input: must be positive
        if (number < 0) {
            System.err.println("Invalid input! Please enter a non-negative integer.");
            System.exit(0);
        }

        // Total elements from 0 up to number inclusive
        int totalElements = number + 1;

        // String array to save results
        String[] results = new String[totalElements];

        // Pass 1: Loop from 0 to number and evaluate FizzBuzz conditions
        for (int i = 0; i < results.length; i++) {
            // Handle 0 separately as it is not a positive multiple
            if (i == 0) {
                results[i] = "0";
            } else if (i % 3 == 0 && i % 5 == 0) {
                results[i] = "FizzBuzz";
            } else if (i % 3 == 0) {
                results[i] = "Fizz";
            } else if (i % 5 == 0) {
                results[i] = "Buzz";
            } else {
                results[i] = String.valueOf(i);
            }
        }

        System.out.println("\n--- FizzBuzz Array Results ---");

        // Pass 2: Loop using array length to display results in requested format
        for (int i = 0; i < results.length; i++) {
            System.out.println("Position " + i + " = " + results[i]);
        }

        // Close scanner
        scanner.close();
    }
}
