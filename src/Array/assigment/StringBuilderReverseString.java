package Array.assigment;

import java.util.Scanner;

/**
 * StringBuilder Problem 1: Reverse a String Using StringBuilder
 *
 * Problem Statement:
 * Write a program that uses StringBuilder to reverse a given string.
 * Example: Input: "hello" -> Output: "olleh"
 *
 * Best Practices Followed:
 * - Preferred over String for mutable operations.
 * - Uses StringBuilder.reverse() for optimal in-place character inversion.
 * - Initialized with capacity equal to the input string length.
 */
public class StringBuilderReverseString {

    /**
     * Reverses a given string using StringBuilder.
     *
     * @param input String to reverse
     * @return Reversed string
     */
    public static String reverseString(String input) {
        if (input == null) {
            return null;
        }

        // Initialize StringBuilder with capacity equal to input length to avoid resizing
        StringBuilder sb = new StringBuilder(input.length());

        // Append the input string
        sb.append(input);

        // Reverse the characters
        sb.reverse();

        // Convert back to string and return
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Reverse String Using StringBuilder ===");
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        String reversedText = reverseString(text);

        System.out.println("Original String : " + text);
        System.out.println("Reversed String : " + reversedText);

        scanner.close();
    }
}
