package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 3 - Level 3: First Non-Repeating Character
 *
 * Description:
 * Finds the first character that occurs only once in the string using a 256-element
 * ASCII frequency array.
 */
public class Q3_Level3 {

    /**
     * Finds first non-repeating character using 256 ASCII array.
     *
     * @param text Input string
     * @return First non-repeating character, or 0 if none exists
     */
    public static char findFirstNonRepeatingCharacter(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        // Frequency array for 256 ASCII characters
        int[] frequency = new int[256];

        // Pass 1: Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        // Pass 2: Find first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] == 1) {
                return ch;
            }
        }

        return 0; // No non-repeating character found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== First Non-Repeating Character Finder ===");
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        char nonRepeatingChar = findFirstNonRepeatingCharacter(text);

        System.out.println("\n--- Result ---");
        if (nonRepeatingChar != 0) {
            System.out.println("First non-repeating character is: '" + nonRepeatingChar + "'");
        } else {
            System.out.println("No non-repeating character exists in the text.");
        }

        scanner.close();
    }
}
