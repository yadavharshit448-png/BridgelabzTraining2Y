package Array.assigment;

import java.util.Scanner;

/**
 * Question 4 - Level 1: Dynamic User Entry with Upper Bound
 *
 * Description:
 * Stores multiple values in an array up to a maximum of 10 elements or until the
 * user enters 0 or a negative number. Displays all stored numbers and their sum.
 *
 * Best Programming Practices Followed:
 * 1. Constant for maximum capacity (MAX_CAPACITY).
 * 2. All inputs, counters, and accumulators declared as variables.
 * 3. Array length property adhered to.
 * 4. Loop break conditions properly handled and validated.
 */
public class Q4_Level1 {

    public static void main(String[] args) {
        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Maximum array capacity constant
        final int MAX_CAPACITY = 10;

        // Array declaration to store up to 10 elements of type double
        double[] numbers = new double[MAX_CAPACITY];

        // Total accumulator variable
        double total = 0.0;

        // Index pointer initialized to 0
        int index = 0;

        System.out.println("=== Storing Numbers (Max 10 or until 0/negative) ===");
        System.out.println("Enter positive numbers (enter 0 or a negative number to stop):");

        // Infinite while loop to collect numbers
        while (true) {
            // Check if array has reached maximum capacity
            if (index == MAX_CAPACITY) {
                System.out.println("\nMaximum limit of " + MAX_CAPACITY + " elements reached.");
                break;
            }

            System.out.print("Enter number [" + (index + 1) + "]: ");
            double userInput = scanner.nextDouble();

            // Validate user input: stop if 0 or negative
            if (userInput <= 0.0) {
                System.out.println("Terminating input collection (0 or negative number entered).");
                break;
            }

            // Assign value to array element and increment index
            numbers[index] = userInput;
            index++;
        }

        System.out.println("\n--- Stored Numbers ---");

        // Loop through populated elements to display them and accumulate sum
        for (int i = 0; i < index; i++) {
            System.out.println("Element at index " + i + ": " + numbers[i]);
            total += numbers[i];
        }

        // Display the total sum of all stored numbers
        System.out.println("\nTotal Sum of " + index + " number(s): " + total);

        // Close scanner
        scanner.close();
    }
}
