package Array.assigment;

import java.util.Scanner;

/**
 * Question 3 - Level 2: Largest and Second Largest Digit (Fixed Array Limit)
 *
 * Description:
 * Extracts digits from a user-provided number into an array capped at maxDigit (10).
 * Then identifies and displays the largest and second largest digits.
 *
 * Best Programming Practices Followed:
 * 1. Initial size defined as variable (maxDigit = 10).
 * 2. Proper validation for non-negative numbers.
 * 3. Array bounds guarded with conditional break.
 * 4. Distinct handling for largest and second largest values.
 */
public class Q3_Level2 {

    public static void main(String[] args) {
        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer number: ");
        long number = scanner.nextLong();

        // Convert negative to positive for digit analysis
        long originalNumber = number;
        if (number < 0) {
            number = -number;
        }

        // Variable for maximum digits capacity
        int maxDigit = 10;

        // Array to store digits
        int[] digits = new int[maxDigit];

        // Index tracker
        int index = 0;

        // Special handling for 0
        if (number == 0) {
            digits[index] = 0;
            index++;
        } else {
            // Loop until number becomes 0
            while (number > 0) {
                // Remove last digit and add to array
                int lastDigit = (int) (number % 10);
                digits[index] = lastDigit;
                index++;
                number /= 10;

                // Break out of loop if maximum capacity is reached
                if (index == maxDigit) {
                    System.out.println("Maximum digit limit of " + maxDigit + " reached. Extra digits omitted.");
                    break;
                }
            }
        }

        // Variables for largest and second largest digits
        int largest = -1;
        int secondLargest = -1;

        // Loop through array up to populated index
        for (int i = 0; i < index; i++) {
            int currentDigit = digits[i];

            if (currentDigit > largest) {
                secondLargest = largest;
                largest = currentDigit;
            } else if (currentDigit > secondLargest && currentDigit != largest) {
                secondLargest = currentDigit;
            }
        }

        System.out.println("\n--- Digit Analysis for " + originalNumber + " ---");
        System.out.print("Extracted Digits: [ ");
        for (int i = 0; i < index; i++) {
            System.out.print(digits[i] + (i < index - 1 ? ", " : " "));
        }
        System.out.println("]");

        System.out.println("Largest Digit        : " + largest);
        if (secondLargest != -1) {
            System.out.println("Second Largest Digit : " + secondLargest);
        } else {
            System.out.println("Second Largest Digit : Not present (all digits are identical).");
        }

        // Close scanner
        scanner.close();
    }
}
