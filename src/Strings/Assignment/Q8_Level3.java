package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 8 - Level 3: Anagram Checker
 *
 * Description:
 * Checks whether two user-entered texts are anagrams by verifying string lengths,
 * counting character frequencies using a 256 ASCII array, and comparing frequencies.
 */
public class Q8_Level3 {

    /**
     * Verifies if str1 and str2 are anagrams.
     *
     * @param str1 First string
     * @param str2 Second string
     * @return true if anagrams, false otherwise
     */
    public static boolean areAnagrams(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        // Step 1: Check if lengths of the two texts are equal
        if (str1.length() != str2.length()) {
            return false;
        }

        // Step 2 & 3: Frequency arrays for 256 ASCII characters
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        for (int i = 0; i < str1.length(); i++) {
            freq1[str1.charAt(i)]++;
            freq2[str2.charAt(i)]++;
        }

        // Step 4: Compare character frequencies
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Anagram Checker ===");
        System.out.print("Enter first text: ");
        String text1 = scanner.nextLine();

        System.out.print("Enter second text: ");
        String text2 = scanner.nextLine();

        boolean result = areAnagrams(text1, text2);

        System.out.println("\n--- Anagram Verdict ---");
        if (result) {
            System.out.println("\"" + text1 + "\" and \"" + text2 + "\" ARE Anagrams!");
        } else {
            System.out.println("\"" + text1 + "\" and \"" + text2 + "\" are NOT Anagrams.");
        }

        scanner.close();
    }
}
