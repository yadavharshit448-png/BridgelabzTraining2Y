package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 2 - Level 1: Substring Extraction Using charAt()
 *
 * Description:
 * Extracts a substring from a string using charAt() and compares it with Java's
 * built-in substring() method.
 */
public class Q2_Level1 {

    /**
     * Extracts substring from start (inclusive) to end (exclusive) using charAt().
     *
     * @param text  Original text
     * @param start Starting index (inclusive)
     * @param end   Ending index (exclusive)
     * @return Substring
     */
    public static String createSubstring(String text, int start, int end) {
        if (text == null) {
            throw new IllegalArgumentException("Input string cannot be null.");
        }
        if (start < 0 || end > text.length() || start > end) {
            throw new StringIndexOutOfBoundsException("Invalid indices: start=" + start + ", end=" + end);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
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

        System.out.println("=== Custom Substring Program ===");
        System.out.print("Enter a string: ");
        String text = scanner.next();

        System.out.print("Enter start index (0 to " + text.length() + "): ");
        int start = scanner.nextInt();

        System.out.print("Enter end index (0 to " + text.length() + "): ");
        int end = scanner.nextInt();

        try {
            // Custom substring
            String customSub = createSubstring(text, start, end);

            // Built-in substring
            String builtInSub = text.substring(start, end);

            // Compare
            boolean isIdentical = compareStrings(customSub, builtInSub);

            System.out.println("\n--- Substring Results ---");
            System.out.println("Custom Substring   : \"" + customSub + "\"");
            System.out.println("Built-in Substring : \"" + builtInSub + "\"");
            System.out.println("Are both identical : " + isIdentical);

        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            System.err.println("Exception caught: " + e.getMessage());
        }

        scanner.close();
    }
}
