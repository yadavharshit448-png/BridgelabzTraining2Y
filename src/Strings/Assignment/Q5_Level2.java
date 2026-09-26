package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 5 - Level 2: Vowels and Consonants Counter
 *
 * Description:
 * Analyzes each character of a string to classify it as a Vowel, Consonant, or
 * Non-Letter using ASCII conversions, and returns counts of vowels and consonants in an array.
 */
public class Q5_Level2 {

    /**
     * Checks if character is Vowel, Consonant, or Not a Letter.
     */
    public static String checkCharType(char ch) {
        // Convert to lowercase if uppercase via ASCII arithmetic
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    /**
     * Counts vowels and consonants in string.
     *
     * @return int[] {vowelCount, consonantCount}
     */
    public static int[] countVowelsAndConsonants(String text) {
        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < text.length(); i++) {
            String type = checkCharType(text.charAt(i));
            if (type.equals("Vowel")) {
                vowelCount++;
            } else if (type.equals("Consonant")) {
                consonantCount++;
            }
        }

        return new int[]{vowelCount, consonantCount};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Vowels and Consonants Counter ===");
        System.out.print("Enter a line of text: ");
        String text = scanner.nextLine();

        int[] counts = countVowelsAndConsonants(text);

        System.out.println("\n--- Character Type Summary ---");
        System.out.println("Total Vowels     : " + counts[0]);
        System.out.println("Total Consonants : " + counts[1]);

        scanner.close();
    }
}
