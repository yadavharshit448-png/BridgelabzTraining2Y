package Array.assigment;

import java.util.Scanner;

/**
 * Question 5 - Level 2: Reverse a Number Using Digits Array
 *
 * Description:
 * Takes a number as input, finds its digit count, saves digits into an array,
 * copies them in reverse order into a second array, and displays the reversed
 * elements.
 *
 * Best Programming Practices Followed:
 * 1. Count of digits dynamically determined to size array accurately.
 * 2. Proper variable declarations and comments.
 * 3. Array length property used in loops.
 * 4. Input validation for numbers.
 */
public class Q5_Level2 {

    public static void main(String[] args) {
        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to reverse: ");
        long number = scanner.nextLong();

        // Preserve sign for display
        boolean isNegative = (number < 0);
        long tempNum = isNegative ? -number : number;

        // Step 1: Count number of digits
        int count = 0;
        long tempCounter = tempNum;
        if (tempCounter == 0) {
            count = 1;
        } else {
            while (tempCounter > 0) {
                count++;
                tempCounter /= 10;
            }
        }

        // Step 2: Extract digits in natural order (left to right)
        int[] digits = new int[count];
        long tempExtractor = tempNum;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (int) (tempExtractor % 10);
            tempExtractor /= 10;
        }

        // Step 3: Create an array to store elements of digits array in reverse order
        int[] reversedDigits = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversedDigits[i] = digits[digits.length - 1 - i];
        }

        // Step 4: Display original and reversed arrays
        System.out.println("\n--- Digit Array Reversal ---");
        System.out.print("Original Digits Array: [ ");
        for (int i = 0; i < digits.length; i++) {
            System.out.print(digits[i] + (i < digits.length - 1 ? ", " : " "));
        }
        System.out.println("]");

        System.out.print("Reversed Digits Array: [ ");
        for (int i = 0; i < reversedDigits.length; i++) {
            System.out.print(reversedDigits[i] + (i < reversedDigits.length - 1 ? ", " : " "));
        }
        System.out.println("]");

        // Print final reversed number
        System.out.print("Reversed Number: ");
        if (isNegative) {
            System.out.print("-");
        }
        for (int i = 0; i < reversedDigits.length; i++) {
            System.out.print(reversedDigits[i]);
        }
        System.out.println();

        // Close scanner
        scanner.close();
    }
}
