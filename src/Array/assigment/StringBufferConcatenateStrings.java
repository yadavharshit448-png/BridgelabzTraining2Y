package Array.assigment;

import java.util.Scanner;

/**
 * StringBuffer Problem 1: Concatenate Strings Efficiently Using StringBuffer
 *
 * Problem Statement:
 * You are given an array of strings. Write a program that uses StringBuffer to
 * concatenate all the strings in the array efficiently.
 *
 * Best Practices Followed:
 * - StringBuffer provides thread-safe string mutation for multi-threaded contexts.
 * - append() method is used instead of + operator to avoid intermediate string objects.
 */
public class StringBufferConcatenateStrings {

    /**
     * Concatenates an array of strings using StringBuffer.
     *
     * @param words Array of strings
     * @return Concatenated single string
     */
    public static String concatenateStrings(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        // Estimate total capacity required
        int estimatedCapacity = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                estimatedCapacity += words[i].length();
            }
        }

        // Initialize StringBuffer with calculated capacity
        StringBuffer stringBuffer = new StringBuffer(estimatedCapacity);

        // Append each string
        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                stringBuffer.append(words[i]);
            }
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== StringBuffer String Concatenation ===");
        System.out.print("Enter number of strings to concatenate: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] words = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            words[i] = scanner.nextLine();
        }

        String result = concatenateStrings(words);

        System.out.println("\nConcatenated String : \"" + result + "\"");

        scanner.close();
    }
}
