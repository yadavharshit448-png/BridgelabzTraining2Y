package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 6 - Level 1: Demonstration of IllegalArgumentException
 *
 * Description:
 * Demonstrates generating and handling exceptions when illegal arguments are
 * provided to substring extraction (e.g. start index greater than end index).
 */
public class Q6_Level1 {

    /**
     * Method that validates arguments and throws IllegalArgumentException if start > end.
     */
    public static String extractSub(String text, int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException("Start index (" + start + ") cannot be greater than end index (" + end + ").");
        }
        return text.substring(start, end);
    }

    /**
     * Method that demonstrates generating the exception.
     */
    public static void generateException(String text) {
        int startIndex = 4;
        int endIndex = 2; // start > end
        System.out.println("Calling extractSub with start=" + startIndex + " and end=" + endIndex);
        extractSub(text, startIndex, endIndex);
    }

    /**
     * Method that demonstrates handling the IllegalArgumentException.
     */
    public static void handleException(String text) {
        int startIndex = 4;
        int endIndex = 2;
        try {
            System.out.println("Inside try: extracting substring from " + startIndex + " to " + endIndex + "...");
            String result = extractSub(text, startIndex, endIndex);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Handled Exception Successfully: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Handled Generic RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== IllegalArgumentException Demonstration ===");
        System.out.print("Enter a text: ");
        String text = scanner.next();

        System.out.println("\n1. Calling handleException():");
        handleException(text);

        System.out.println("\n2. Calling generateException() wrapped in caller try-catch:");
        try {
            generateException(text);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught in main: " + e.getMessage());
        }

        scanner.close();
    }
}
