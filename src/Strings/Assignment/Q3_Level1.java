package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 3 - Level 1: String to Character Array Conversion
 *
 * Description:
 * Converts a string into a character array without using toCharArray(), and
 * compares the result against Java's built-in toCharArray() method.
 */
public class Q3_Level1 {

    /**
     * Converts a string to a character array using charAt().
     *
     * @param text Original string
     * @return Character array
     */
    public static char[] getCharacters(String text) {
        if (text == null) {
            return new char[0];
        }
        char[] charArray = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            charArray[i] = text.charAt(i);
        }
        return charArray;
    }

    /**
     * Compares two character arrays element by element.
     */
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1 == null || arr2 == null) {
            return arr1 == arr2;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Custom toCharArray Program ===");
        System.out.print("Enter a text: ");
        String text = scanner.next();

        // Custom method call
        char[] customChars = getCharacters(text);

        // Built-in method call
        char[] builtInChars = text.toCharArray();

        // Compare both arrays
        boolean areEqual = compareCharArrays(customChars, builtInChars);

        System.out.println("\n--- Results ---");
        System.out.print("Custom char array   : ");
        for (int i = 0; i < customChars.length; i++) {
            System.out.print("'" + customChars[i] + "' ");
        }
        System.out.println();

        System.out.print("Built-in char array : ");
        for (int i = 0; i < builtInChars.length; i++) {
            System.out.print("'" + builtInChars[i] + "' ");
        }
        System.out.println();

        System.out.println("Are both arrays identical: " + areEqual);

        scanner.close();
    }
}
