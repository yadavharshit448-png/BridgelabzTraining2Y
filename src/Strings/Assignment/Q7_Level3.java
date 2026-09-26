package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 7 - Level 3: Palindrome Checker Using Three Different Logics
 *
 * Description:
 * Verifies whether a string is a palindrome using:
 *   - Logic 1: Two-pointer iterative comparison (start and end indices).
 *   - Logic 2: Recursive comparison.
 *   - Logic 3: String reversal using charAt() and character array comparison.
 */
public class Q7_Level3 {

    /**
     * Logic 1: Iterative two-pointer comparison.
     */
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * Logic 2: Recursive comparison.
     */
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (text == null) return false;
        // Base case: if start index meets or exceeds end index
        if (start >= end) {
            return true;
        }
        // If characters mismatch
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        // Recurse inwards
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    /**
     * Logic 3: Reversal array comparison.
     */
    public static boolean isPalindromeArrayReverse(String text) {
        if (text == null) return false;

        // Create character array from original
        char[] original = text.toCharArray();

        // Create reversed character array using charAt()
        char[] reversed = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            reversed[i] = text.charAt(text.length() - 1 - i);
        }

        // Compare original and reversed arrays
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker (3 Distinct Logics) ===");
        System.out.print("Enter text to check: ");
        String text = scanner.nextLine();

        boolean resultLogic1 = isPalindromeIterative(text);
        boolean resultLogic2 = isPalindromeRecursive(text, 0, text.length() - 1);
        boolean resultLogic3 = isPalindromeArrayReverse(text);

        System.out.println("\n--- Palindrome Evaluation ---");
        System.out.println("Logic 1 (Iterative Two-Pointer) : " + (resultLogic1 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Logic 2 (Recursive)             : " + (resultLogic2 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Logic 3 (Array Reversal)        : " + (resultLogic3 ? "Palindrome" : "Not Palindrome"));

        if (resultLogic1 && resultLogic2 && resultLogic3) {
            System.out.println("\nConfirmation: All 3 methods consistently confirmed \"" + text + "\" is a Palindrome!");
        } else if (!resultLogic1 && !resultLogic2 && !resultLogic3) {
            System.out.println("\nConfirmation: All 3 methods consistently confirmed \"" + text + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }
}
