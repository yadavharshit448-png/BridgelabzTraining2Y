package Array.assigment;

import java.util.Scanner;

/**
 * Question 8 - Level 1: Factor Finder with Dynamic Array Resizing
 *
 * Description:
 * Finds all factors of a user-entered integer, dynamically storing them in an
 * array that automatically doubles its size whenever capacity is exceeded.
 *
 * Best Programming Practices Followed:
 * 1. Initial size and growth factor declared as variables.
 * 2. Proper validation for positive integer inputs.
 * 3. Array length property used during manual array copy operations.
 * 4. Clear comments explaining the dynamic array doubling technique.
 */
public class Q8_Level1 {

    public static void main(String[] args) {
        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive number to find its factors: ");
        int number = scanner.nextInt();

        // Validate user input: must be positive
        if (number <= 0) {
            System.err.println("Invalid input! Please enter a number greater than 0.");
            System.exit(0);
        }

        // Initial capacity variable
        int maxFactor = 10;

        // Array to store factors
        int[] factors = new int[maxFactor];

        // Index pointer to track number of stored factors
        int index = 0;

        // Loop to find all factors from 1 to number
        for (int i = 1; i <= number; i++) {
            // Check if i is a divisor / factor of number
            if (number % i == 0) {
                // If capacity is reached, double the array size dynamically
                if (index == maxFactor) {
                    maxFactor = maxFactor * 2; // Double the maximum capacity
                    int[] tempArray = new int[maxFactor];

                    // Copy existing elements from factors array to tempArray using array length
                    for (int j = 0; j < factors.length; j++) {
                        tempArray[j] = factors[j];
                    }

                    // Reassign factors reference to newly resized array
                    factors = tempArray;
                }

                // Store factor and advance index
                factors[index] = i;
                index++;
            }
        }

        System.out.println("\n--- Factors of " + number + " ---");
        System.out.println("Total Factors Found: " + index);
        System.out.print("Factors: [ ");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + (i < index - 1 ? ", " : " "));
        }
        System.out.println("]");

        // Close scanner
        scanner.close();
    }
}
