package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 10 - Level 1: Lowercase Conversion Using ASCII Arithmetic
 *
 * Description:
 * Converts uppercase characters to lowercase using the ASCII difference of 32
 * ('A' = 65, 'a' = 97 -> 'A' + 32 = 'a'), and verifies the result against
 * Java's built-in toLowerCase() method.
 */
public class Q10_Level1 {

    /**
     * Converts text to lowercase without using toLowerCase().
     *
     * @param text Original string
     * @return Lowercase converted string
     */
    public static String toCustomLowerCase(String text) {
        if (text == null) {
            return null;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // If uppercase ('A' through 'Z'), convert to lowercase by adding 32
            if (ch >= 'A' && ch <= 'Z') {
                result.append((char) (ch + 32));
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

        System.out.println("=== Custom Lowercase Converter ===");
        System.out.print("Enter a line of text: ");
        String inputText = scanner.nextLine();

        // Custom conversion
        String customLower = toCustomLowerCase(inputText);

        // Built-in conversion
        String builtInLower = inputText.toLowerCase();

        // Compare using custom comparator
        boolean areEqual = compareStrings(customLower, builtInLower);

        System.out.println("\n--- Conversion Results ---");
        System.out.println("Custom LowerCase   : " + customLower);
        System.out.println("Built-in LowerCase : " + builtInLower);
        System.out.println("Both methods match : " + areEqual);

        scanner.close();
    }
}
