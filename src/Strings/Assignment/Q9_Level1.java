package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 9 - Level 1: Uppercase Conversion Using ASCII Arithmetic
 *
 * Description:
 * Converts lowercase characters to uppercase using the ASCII difference of 32
 * ('a' = 97, 'A' = 65 -> 'a' - 32 = 'A'), and verifies the result against
 * Java's built-in toUpperCase() method.
 */
public class Q9_Level1 {

    /**
     * Converts text to uppercase without using toUpperCase().
     *
     * @param text Original string
     * @return Uppercase converted string
     */
    public static String toCustomUpperCase(String text) {
        if (text == null) {
            return null;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // If lowercase ('a' through 'z'), convert to uppercase by subtracting 32
            if (ch >= 'a' && ch <= 'z') {
                result.append((char) (ch - 32));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    /**
     * Compares two strings using charAt().
     */
    public static boolean compareStrings(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return str1 == str2;
        }
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Custom Uppercase Converter ===");
        System.out.print("Enter a line of text: ");
        String inputText = scanner.nextLine();

        // Custom conversion
        String customUpper = toCustomUpperCase(inputText);

        // Built-in conversion
        String builtInUpper = inputText.toUpperCase();

        // Compare using custom comparator
        boolean areEqual = compareStrings(customUpper, builtInUpper);

        System.out.println("\n--- Conversion Results ---");
        System.out.println("Custom UpperCase   : " + customUpper);
        System.out.println("Built-in UpperCase : " + builtInUpper);
        System.out.println("Both methods match : " + areEqual);

        scanner.close();
    }
}
