package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 7 - Level 1: Demonstration of NumberFormatException
 *
 * Description:
 * Demonstrates parsing non-numeric strings with Integer.parseInt(), which triggers
 * a NumberFormatException, and how to safely catch and handle it.
 */
public class Q7_Level1 {

    /**
     * Directly parses input text without exception handling.
     */
    public static void generateException(String text) {
        System.out.println("Calling Integer.parseInt(\"" + text + "\")...");
        int parsedNumber = Integer.parseInt(text);
        System.out.println("Parsed successfully: " + parsedNumber);
    }

    /**
     * Parses input text with try-catch block for NumberFormatException and RuntimeException.
     */
    public static void handleException(String text) {
        try {
            System.out.println("Attempting to parse \"" + text + "\" in try block...");
            int parsedNumber = Integer.parseInt(text);
            System.out.println("Parsed successfully: " + parsedNumber);
        } catch (NumberFormatException e) {
            System.out.println("Handled NumberFormatException Successfully: " + e.getMessage());
            System.out.println("Input \"" + text + "\" is not a valid integer format.");
        } catch (RuntimeException e) {
            System.out.println("Handled Generic RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== NumberFormatException Demonstration ===");
        System.out.print("Enter text to parse as integer (e.g. 'abc' or '123'): ");
        String text = scanner.next();

        System.out.println("\n1. Calling handleException():");
        handleException(text);

        System.out.println("\n2. Calling generateException() wrapped in caller try-catch:");
        try {
            generateException(text);
        } catch (NumberFormatException e) {
            System.out.println("Caught in main caller: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        scanner.close();
    }
}
