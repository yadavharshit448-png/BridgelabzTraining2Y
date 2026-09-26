package Array.assigment;

import java.util.Scanner;

/**
 * Question 4 - Level 2: Largest and Second Largest Digit with Dynamic Array Expansion
 *
 * Description:
 * Reworks Q3 to dynamically expand the digits array by +10 elements whenever
 * index reaches maxDigit, ensuring all digits of large numbers are captured.
 * Then finds and displays the largest and second largest digits.
 *
 * Best Programming Practices Followed:
 * 1. Initial size and expansion increment declared as variables.
 * 2. Dynamic resizing using a temporary helper array.
 * 3. Array length property used in copy operations.
 * 4. Clear comments explaining the memory reallocation.
 */
public class Q4_Level2 {

    public static void main(String[] args) {
        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a large integer number: ");
        String inputStr = scanner.next();

        // Validate numeric input
        if (!inputStr.matches("-?\\d+")) {
            System.err.println("Invalid numeric input!");
            scanner.close();
            return;
        }

        // Remove negative sign for digit processing
        if (inputStr.startsWith("-")) {
            inputStr = inputStr.substring(1);
        }

        // Initial capacity variable and expansion increment
        int maxDigit = 10;
        final int EXPANSION_INCREMENT = 10;

        // Array to store digits
        int[] digits = new int[maxDigit];

        // Index pointer
        int index = 0;

        // Process each digit character from input string (supports arbitrarily long numbers)
        for (int i = 0; i < inputStr.length(); i++) {
            // Check if current array capacity is reached
            if (index == maxDigit) {
                // Expand capacity by 10
                maxDigit += EXPANSION_INCREMENT;
                int[] tempArray = new int[maxDigit];

                // Copy elements from current digits array using length property
                for (int j = 0; j < digits.length; j++) {
                    tempArray[j] = digits[j];
                }

                // Point digits to new larger array
                digits = tempArray;
            }

            // Extract numeric value from character
            digits[index] = Character.getNumericValue(inputStr.charAt(i));
            index++;
        }

        // Variables for largest and second largest digits
        int largest = -1;
        int secondLargest = -1;

        // Loop through array up to populated index to find largest and second largest
        for (int i = 0; i < index; i++) {
            int currentDigit = digits[i];

            if (currentDigit > largest) {
                secondLargest = largest;
                largest = currentDigit;
            } else if (currentDigit > secondLargest && currentDigit != largest) {
                secondLargest = currentDigit;
            }
        }

        System.out.println("\n--- Dynamic Array Digit Analysis ---");
        System.out.println("Total Digits Processed: " + index);
        System.out.println("Final Array Capacity   : " + maxDigit);
        System.out.print("All Digits: [ ");
        for (int i = 0; i < index; i++) {
            System.out.print(digits[i] + (i < index - 1 ? ", " : " "));
        }
        System.out.println("]");

        System.out.println("Largest Digit          : " + largest);
        if (secondLargest != -1) {
            System.out.println("Second Largest Digit   : " + secondLargest);
        } else {
            System.out.println("Second Largest Digit   : Not present (all digits are identical).");
        }

        // Close scanner
        scanner.close();
    }
}
