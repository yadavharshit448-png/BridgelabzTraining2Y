package Array.assigment;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * StringBuilder Problem 2: Remove Duplicates from a String Using StringBuilder
 *
 * Problem Statement:
 * Write a program that uses StringBuilder to remove all duplicate characters from
 * a given string while maintaining the original order.
 *
 * Approach:
 * 1. Initialize an empty StringBuilder and a HashSet to keep track of seen characters.
 * 2. Iterate over each character in the string:
 *    - If character is not in HashSet, append to StringBuilder and add to HashSet.
 * 3. Return StringBuilder as string.
 */
public class StringBuilderRemoveDuplicates {

    /**
     * Removes duplicate characters from string while maintaining order.
     *
     * @param text Input string
     * @return String without duplicates
     */
    public static String removeDuplicates(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        // Initialize StringBuilder with capacity
        StringBuilder result = new StringBuilder(text.length());

        // Set to track unique characters
        Set<Character> seenCharacters = new HashSet<>();

        // Iterate through each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // If not seen before, append and record
            if (!seenCharacters.contains(ch)) {
                seenCharacters.add(ch);
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Remove Duplicates Using StringBuilder ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String uniqueString = removeDuplicates(input);

        System.out.println("Original String : " + input);
        System.out.println("Unique String   : " + uniqueString);

        scanner.close();
    }
}
