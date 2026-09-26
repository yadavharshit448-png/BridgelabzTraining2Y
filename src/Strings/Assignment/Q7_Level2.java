package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 7 - Level 2: Custom String Trim Using charAt()
 *
 * Description:
 * Implements custom trimming of leading and trailing spaces using charAt() by
 * finding the start and end boundary indices, extracts the substring, and verifies
 * against Java's built-in trim() method.
 */
public class Q7_Level2 {

    /**
     * Determines the start and end indices of non-space characters.
     *
     * @return int[] {start, end} where start is inclusive and end is inclusive
     */
    public static int[] findTrimBoundaries(String text) {
        if (text == null || text.isEmpty()) {
            return new int[]{-1, -1};
        }

        int start = 0;
        int end = text.length() - 1;

        // Skip leading spaces
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        // Skip trailing spaces
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    /**
     * Custom substring using charAt().
     */
    public static String createSubstring(String text, int start, int end) {
        if (start > end || start < 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }

    /**
     * Custom trim method.
     */
    public static String customTrim(String text) {
        int[] bounds = findTrimBoundaries(text);
        if (bounds[0] == -1 || bounds[0] > bounds[1]) {
            return "";
        }
        return createSubstring(text, bounds[0], bounds[1]);
    }

    /**
     * Compares two strings using charAt().
     */
    public static boolean compareStrings(String s1, String s2) {
        if (s1 == null || s2 == null) return s1 == s2;
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Custom Trim Program ===");
        System.out.println("Enter a text with leading/trailing spaces:");
        String text = scanner.nextLine();

        String customResult = customTrim(text);
        String builtInResult = text.trim();

        boolean areEqual = compareStrings(customResult, builtInResult);

        System.out.println("\n--- Results ---");
        System.out.println("Custom Trimmed   : \"" + customResult + "\"");
        System.out.println("Built-in Trimmed : \"" + builtInResult + "\"");
        System.out.println("Both match       : " + areEqual);

        scanner.close();
    }
}
