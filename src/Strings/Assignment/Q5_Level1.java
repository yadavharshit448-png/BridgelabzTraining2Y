package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 5 - Level 1: Demonstration of StringIndexOutOfBoundsException
 *
 * Description:
 * Demonstrates accessing an index beyond the bounds of a string, triggering
 * a StringIndexOutOfBoundsException, and properly catching it using a try-catch block.
 */
public class Q5_Level1 {

    /**
     * Method that attempts to access an index beyond string length.
     */
    public static void generateException(String text) {
        int invalidIndex = text.length() + 5;
        System.out.println("Attempting to access character at invalid index: " + invalidIndex);
        char ch = text.charAt(invalidIndex);
        System.out.println("Character: " + ch);
    }

    /**
     * Method that catches and handles the StringIndexOutOfBoundsException.
     */
    public static void handleException(String text) {
        try {
            int invalidIndex = text.length() + 5;
            System.out.println("Inside try block: attempting charAt(" + invalidIndex + ")...");
            char ch = text.charAt(invalidIndex);
            System.out.println("Character: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Handled Exception Successfully: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            System.out.println("Safely handled out-of-bounds access.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== StringIndexOutOfBoundsException Demonstration ===");
        System.out.print("Enter a text: ");
        String text = scanner.next();

        System.out.println("\n1. Calling handleException():");
        handleException(text);

        System.out.println("\n2. Calling generateException() wrapped in caller try-catch:");
        try {
            generateException(text);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught exception in main: " + e);
        }

        scanner.close();
    }
}
