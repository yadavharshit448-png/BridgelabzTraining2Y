package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 1 - Level 1: String Comparison Using charAt()
 *
 * Description:
 * Compares two user-entered strings character-by-character using the charAt() method,
 * and validates the outcome against the built-in equals() method.
 *
 * Best Programming Practices Followed:
 * 1. Modular methods instead of writing all logic in main().
 * 2. Proper variable and method naming conventions.
 * 3. Handles null checks and lengths safely.
 */
public class Q1_Level1 {

    /**
     * Compares two strings character by character using charAt().
     *
     * @param str1 First string to compare
     * @param str2 Second string to compare
     * @return true if both strings have identical characters, false otherwise
     */
    public static boolean compareStrings(String str1, String str2) {
        // Null checks
        if (str1 == null && str2 == null) {
            return true;
        }
        if (str1 == null || str2 == null) {
            return false;
        }

        // Length comparison
        if (str1.length() != str2.length()) {
            return false;
        }

        // Character-by-character comparison
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== String Comparison Program ===");
        System.out.print("Enter first string: ");
        String firstString = scanner.next();

        System.out.print("Enter second string: ");
        String secondString = scanner.next();

        // Compare using custom method
        boolean customResult = compareStrings(firstString, secondString);

        // Compare using built-in method
        boolean builtInResult = firstString.equals(secondString);

        // Display results
        System.out.println("\n--- Comparison Results ---");
        System.out.println("Custom charAt() comparison result : " + customResult);
        System.out.println("Built-in equals() comparison result: " + builtInResult);

        if (customResult == builtInResult) {
            System.out.println("Verification Passed: Both methods yield identical results.");
        } else {
            System.out.println("Verification Failed: Results differ.");
        }

        scanner.close();
    }
}
