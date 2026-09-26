package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 8 - Level 1: Demonstration of ArrayIndexOutOfBoundsException
 *
 * Description:
 * Demonstrates accessing an array element beyond the valid index range, causing
 * an ArrayIndexOutOfBoundsException, and properly handling it with try-catch.
 */
public class Q8_Level1 {

    /**
     * Attempts to access an invalid index in an array.
     */
    public static void generateException(String[] names) {
        int invalidIndex = names.length + 2;
        System.out.println("Accessing names[" + invalidIndex + "]...");
        String name = names[invalidIndex];
        System.out.println("Name found: " + name);
    }

    /**
     * Accesses an invalid index within a try-catch block.
     */
    public static void handleException(String[] names) {
        int invalidIndex = names.length + 2;
        try {
            System.out.println("Inside try: accessing index " + invalidIndex + " of array size " + names.length + "...");
            String name = names[invalidIndex];
            System.out.println("Name found: " + name);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Handled ArrayIndexOutOfBoundsException: " + e.getMessage());
            System.out.println("Array bounds safely protected.");
        } catch (RuntimeException e) {
            System.out.println("Handled Generic RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ArrayIndexOutOfBoundsException Demonstration ===");
        System.out.print("Enter number of names: ");
        int count = scanner.nextInt();

        if (count <= 0) {
            System.err.println("Count must be positive.");
            scanner.close();
            return;
        }

        String[] names = new String[count];
        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.next();
        }

        System.out.println("\n1. Calling handleException():");
        handleException(names);

        System.out.println("\n2. Calling generateException() wrapped in caller try-catch:");
        try {
            generateException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught in main: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        scanner.close();
    }
}
