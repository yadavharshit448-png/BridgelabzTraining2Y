package Array.assigment;

import java.util.Scanner;

/**
 * Sample Program 1: Sum of Digits of a Number Using an Array
 *
 * Best Programming Practices Followed:
 * 1. Proper class and variable naming conventions.
 * 2. Input validation for non-negative number.
 * 3. Count of digits dynamically determined.
 * 4. Digits stored in an array and summed using array length property.
 */
public class Sample1_SumOfDigits {

    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take input for a number
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Validate the user input number, if negative state invalid and exit
        if (number < 0) {
            System.err.println("Invalid Number.");
            input.close();
            System.exit(0);
        }

        // Special case for 0
        if (number == 0) {
            System.out.println("\nSum of Digits: 0");
            input.close();
            return;
        }

        // Find the count of digits in the number
        int count = 0;
        int temp = number;
        while (temp > 0) {
            count++;
            temp /= 10;
        }

        // Find the digits in the number and save them in an array
        int[] digits = new int[count];
        int originalNumber = number;
        for (int i = 0; i < digits.length; i++) {
            digits[i] = originalNumber % 10;
            originalNumber /= 10;
        }

        // Find the sum of the digits of the number
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
        }

        // Display the sum of the digits of the number
        System.out.println("\nSum of Digits: " + sum);

        // Close the Scanner Object
        input.close();
    }
}
