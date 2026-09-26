package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 3 - Level 2: Words and Lengths in 2D Array
 *
 * Description:
 * Splits a sentence into words, measures their lengths without using length(),
 * generates a 2D String array [word, lengthStr], and displays them in a tabular format.
 */
public class Q3_Level2 {

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

    public static String[] splitWords(String text) {
        int len = getLength(text);
        if (len == 0) return new String[0];

        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') spaceCount++;
        }

        String[] words = new String[spaceCount + 1];
        int start = 0, wordIdx = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                StringBuilder sb = new StringBuilder();
                for (int j = start; j < i; j++) sb.append(text.charAt(j));
                words[wordIdx++] = sb.toString();
                start = i + 1;
            }
        }
        StringBuilder last = new StringBuilder();
        for (int j = start; j < len; j++) last.append(text.charAt(j));
        words[wordIdx] = last.toString();

        return words;
    }

    /**
     * Builds 2D String array with word and its length.
     */
    public static String[][] getWordsWithLengths(String[] words) {
        String[][] wordData = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            wordData[i][0] = words[i];
            wordData[i][1] = String.valueOf(getLength(words[i]));
        }
        return wordData;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Words and Lengths Table ===");
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] words = splitWords(text);
        String[][] tableData = getWordsWithLengths(words);

        System.out.println("\n-----------------------------");
        System.out.printf("%-20s %-8s\n", "Word", "Length");
        System.out.println("-----------------------------");

        for (int i = 0; i < tableData.length; i++) {
            String word = tableData[i][0];
            int length = Integer.parseInt(tableData[i][1]); // Converted to Integer for display
            System.out.printf("%-20s %-8d\n", word, length);
        }
        System.out.println("-----------------------------");

        scanner.close();
    }
}
