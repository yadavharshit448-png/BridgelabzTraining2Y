package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 1 - Level 2: String Length Without Using length()
 *
 * Description:
 * Calculates string length by iterating in an infinite loop until charAt() throws
 * a StringIndexOutOfBoundsException, then returns the accumulated count.
 * Compares result with built-in length().
 */
public class Q1_Level2 {

    /**
     * Determines length of string without calling length().
     *
     * @param text Input string
     * @return Number of characters
     */
    public static int findLength(String text) {
        if (text == null) {
            return 0;
        }

        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // Exception signifies end of string reached
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== String Length Without length() ===");
        System.out.print("Enter a string: ");
        String text = scanner.next();

        int customLength = findLength(text);
        int builtInLength = text.length();

        System.out.println("\n--- Length Results ---");
        System.out.println("Custom calculated length : " + customLength);
        System.out.println("Built-in length()        : " + builtInLength);
        System.out.println("Both lengths match       : " + (customLength == builtInLength));

        scanner.close();
    }
}
