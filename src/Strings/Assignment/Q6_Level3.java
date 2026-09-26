package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 6 - Level 3: Character Frequency via Nested Loops & '0' Sentinel
 *
 * Description:
 * Computes frequency of characters in a string by converting it to a char array,
 * using nested loops to count duplicates, and marking duplicate positions with '0'
 * to avoid recounting. Stores output in a 1D String array.
 */
public class Q6_Level3 {

    /**
     * Determines frequency using nested loops and '0' sentinel.
     *
     * @param text Input string
     * @return 1D String array where each element is "character : frequency"
     */
    public static String[] getFrequenciesWithNestedLoops(String text) {
        if (text == null || text.isEmpty()) {
            return new String[0];
        }

        char[] chars = text.toCharArray();
        int[] freq = new int[chars.length];

        // Outer loop sets frequency to 1, inner loop finds duplicates
        for (int i = 0; i < chars.length; i++) {
            freq[i] = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j] && chars[i] != '0' && chars[i] != ' ') {
                    freq[i]++;
                    chars[j] = '0'; // Set duplicate character to '0' to avoid recount
                }
            }
        }

        // Count non-'0' entries
        int validCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                validCount++;
            }
        }

        // Create 1D String array
        String[] result = new String[validCount];
        int idx = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                String label = (chars[i] == ' ') ? "<space>" : String.valueOf(chars[i]);
                result[idx++] = label + " : " + freq[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Character Frequency via Nested Loops ===");
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] frequencyStrings = getFrequenciesWithNestedLoops(text);

        System.out.println("\n--- Frequencies ---");
        for (String entry : frequencyStrings) {
            System.out.println("  " + entry);
        }

        scanner.close();
    }
}
