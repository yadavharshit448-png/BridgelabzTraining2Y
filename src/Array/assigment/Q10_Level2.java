package Array.assigment;

import java.util.Scanner;

/**
 * Question 10 - Level 2: Digit Frequency Counter
 *
 * Description:
 * Takes a number as input, extracts its digits into an array, computes the
 * occurrence frequency of each decimal digit (0 through 9) using a frequency
 * array of size 10, and displays the frequency of each digit that appears in the number.
 *
 * Best Programming Practices Followed:
 * 1. Constant for decimal base size (DIGIT_BASE = 10).
 * 2. Proper variable declarations and dynamic digit extraction.
 * 3. Array length properties used in all counting and display loops.
 * 4. Clear comments explaining frequency mapping.
 */
public class Q10_Level2 {

    public static void main(String[] args) {
        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Constant for decimal digits (0 to 9)
        final int DIGIT_BASE = 10;

        System.out.print("Enter an integer number: ");
        long number = scanner.nextLong();

        // Preserve original input for reporting and handle negative sign
        long originalNumber = number;
        long tempNum = (number < 0) ? -number : number;

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

        // Step 2: Extract digits and save them in an array
        int[] digits = new int[count];
        long tempExtractor = tempNum;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (int) (tempExtractor % 10);
            tempExtractor /= 10;
        }

        // Step 3: Define frequency array of size 10 (indices 0 to 9)
        int[] frequency = new int[DIGIT_BASE];

        // Step 4: Loop through digits array and increment frequency
        for (int i = 0; i < digits.length; i++) {
            int currentDigit = digits[i];
            frequency[currentDigit]++;
        }

        // Step 5: Display the frequency of each digit
        System.out.println("\n--- Digit Frequency Analysis for " + originalNumber + " ---");
        System.out.printf("%-10s %-12s\n", "Digit", "Frequency");
        System.out.println("----------------------");

        for (int digit = 0; digit < frequency.length; digit++) {
            if (frequency[digit] > 0) {
                System.out.printf("  %-8d %-10d\n", digit, frequency[digit]);
            }
        }
        System.out.println("----------------------");

        // Close scanner
        scanner.close();
    }
}
