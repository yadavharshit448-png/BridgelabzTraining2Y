package Strings.Assignment;

/**
 * Question 4 - Level 1: Demonstration of NullPointerException
 *
 * Description:
 * Demonstrates how attempting to invoke methods on a null String reference triggers
 * a NullPointerException, and shows how to handle it gracefully using try-catch.
 */
public class Q4_Level1 {

    /**
     * Method that deliberately induces a NullPointerException.
     */
    public static void generateException() {
        String text = null;
        // Calling length() on null reference throws NullPointerException
        System.out.println("Text length: " + text.length());
    }

    /**
     * Method that catches and handles the NullPointerException.
     */
    public static void handleException() {
        String text = null;
        try {
            System.out.println("Attempting to access length of null string...");
            int len = text.length();
            System.out.println("Length is: " + len);
        } catch (NullPointerException e) {
            System.out.println("Handled Exception Successfully: " + e.getClass().getName() + " - " + e.getMessage());
            System.out.println("Safely recovered from null reference.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== NullPointerException Demonstration ===");

        System.out.println("\n1. Demonstrating handled NullPointerException:");
        handleException();

        System.out.println("\n2. Demonstrating unhandled NullPointerException inside try-catch in main:");
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Caught generated exception in caller: " + e);
        }
    }
}
