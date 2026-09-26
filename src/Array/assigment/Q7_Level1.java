package Array.assigment;

import java.util.Scanner;

/**
 * Question 7 - Level 1: Segregate Odd and Even Numbers into Arrays
 *
 * Description:
 * Takes a natural number input N, segregates all numbers from 1 to N into separate
 * even and odd integer arrays, and displays both arrays.
 *
 * Best Programming Practices Followed:
 * 1. Natural number validation (must be > 0), exits gracefully if invalid.
 * 2. Proper variable declarations and calculated array sizes.
 * 3. Array length boundaries maintained with separate tracking indices.
 * 4. Comprehensive comments explaining each logical block.
 */
public class Q7_Level1 {

    public static void main(String[] args) {
        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Input prompt
        System.out.print("Enter a positive natural number: ");
        int number = scanner.nextInt();

        // Validate user input: must be a natural number (greater than 0)
        if (number <= 0) {
            System.err.println("Error: " + number + " is not a natural number! A natural number must be greater than 0.");
            System.exit(0);
        }

        // Calculate dynamic maximum possible size for each array
        int arrayCapacity = (number / 2) + 1;

        // Arrays to store even and odd numbers
        int[] evenNumbers = new int[arrayCapacity];
        int[] oddNumbers = new int[arrayCapacity];

        // Trackers for current number of elements in each array
        int evenIndex = 0;
        int oddIndex = 0;

        // Loop from 1 up to the input number
        for (int currentVal = 1; currentVal <= number; currentVal++) {
            // Conditional check for even or odd
            if (currentVal % 2 == 0) {
                evenNumbers[evenIndex] = currentVal;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = currentVal;
                oddIndex++;
            }
        }

        // Display Even Numbers Array
        System.out.println("\n--- Even Numbers Array (1 to " + number + ") ---");
        System.out.print("[ ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + (i < evenIndex - 1 ? ", " : " "));
        }
        System.out.println("] (Total: " + evenIndex + ")");

        // Display Odd Numbers Array
        System.out.println("\n--- Odd Numbers Array (1 to " + number + ") ---");
        System.out.print("[ ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + (i < oddIndex - 1 ? ", " : " "));
        }
        System.out.println("] (Total: " + oddIndex + ")");

        // Close scanner
        scanner.close();
    }
}
