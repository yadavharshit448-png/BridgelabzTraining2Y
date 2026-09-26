package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 2 - Level 2: Custom Text Splitting into Words
 *
 * Description:
 * Splits a text into an array of words using charAt() and space tracking without
 * using Java's built-in split(), then compares the resulting array with built-in split().
 */
public class Q2_Level2 {

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
     * Splits text into words using charAt().
     */
    public static String[] splitWords(String text) {
        if (text == null || getLength(text) == 0) {
            return new String[0];
        }

        int len = getLength(text);

        // Count spaces to determine word boundaries
        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        // Space indices array
        int[] spaceIndexes = new int[spaceCount];
        int sIdx = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[sIdx++] = i;
            }
        }

        // Extract words based on space indices
        String[] words = new String[spaceCount + 1];
        int start = 0;
        for (int w = 0; w < spaceCount; w++) {
            int end = spaceIndexes[w];
            StringBuilder sb = new StringBuilder();
            for (int i = start; i < end; i++) {
                sb.append(text.charAt(i));
            }
            words[w] = sb.toString();
            start = end + 1;
        }

        // Last word
        StringBuilder lastWord = new StringBuilder();
        for (int i = start; i < len; i++) {
            lastWord.append(text.charAt(i));
        }
        words[spaceCount] = lastWord.toString();

        return words;
    }

    /**
     * Compares two string arrays.
     */
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1 == null || arr2 == null) return arr1 == arr2;
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Custom Word Split Program ===");
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();

        // Custom split
        String[] customWords = splitWords(text);

        // Built-in split
        String[] builtInWords = text.split(" ");

        // Compare
        boolean areEqual = compareStringArrays(customWords, builtInWords);

        System.out.println("\n--- Split Results ---");
        System.out.println("Custom Split Words (" + customWords.length + "):");
        for (String w : customWords) {
            System.out.println("  \"" + w + "\"");
        }

        System.out.println("Are both split results identical: " + areEqual);

        scanner.close();
    }
}
