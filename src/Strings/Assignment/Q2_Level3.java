package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 2 - Level 3: Unique Characters Extraction
 *
 * Description:
 * Determines the length of a string without using length(), and extracts all
 * unique characters in the order of their first appearance using nested loops.
 */
public class Q2_Level3 {

    /**
     * Determines string length without length().
     */
    public static int getLength(String text) {
        if (text == null) return 0;
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    /**
     * Finds unique characters in a string using charAt() and nested loops.
     */
    public static char[] findUniqueCharacters(String text) {
        int len = getLength(text);
        if (len == 0) return new char[0];

        char[] temp = new char[len];
        int uniqueCount = 0;

        for (int i = 0; i < len; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            // Inner loop compares with all preceding characters
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[uniqueCount++] = current;
            }
        }

        // Create exact-sized array
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Unique Characters Finder ===");
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        char[] uniqueChars = findUniqueCharacters(text);

        System.out.println("\n--- Unique Characters Result ---");
        System.out.println("Total Unique Characters: " + uniqueChars.length);
        System.out.print("Unique Characters: [ ");
        for (int i = 0; i < uniqueChars.length; i++) {
            System.out.print("'" + uniqueChars[i] + "'" + (i < uniqueChars.length - 1 ? ", " : " "));
        }
        System.out.println("]");

        scanner.close();
    }
}
