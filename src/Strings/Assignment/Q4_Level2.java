package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 4 - Level 2: Shortest and Longest Words in Text
 *
 * Description:
 * Splits text into words, builds a 2D array of words and lengths, and identifies
 * the shortest and longest strings, returning their indices in a 1D int array.
 */
public class Q4_Level2 {

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

    public static String[][] getWordsWithLengths(String[] words) {
        String[][] wordData = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            wordData[i][0] = words[i];
            wordData[i][1] = String.valueOf(getLength(words[i]));
        }
        return wordData;
    }

    /**
     * Finds shortest and longest strings from 2D array.
     *
     * @return 1D int array [shortestIndex, longestIndex]
     */
    public static int[] findShortestAndLongest(String[][] wordData) {
        if (wordData == null || wordData.length == 0) {
            return new int[]{-1, -1};
        }

        int shortestIdx = 0;
        int longestIdx = 0;

        int shortestLen = Integer.parseInt(wordData[0][1]);
        int longestLen = Integer.parseInt(wordData[0][1]);

        for (int i = 1; i < wordData.length; i++) {
            int currentLen = Integer.parseInt(wordData[i][1]);
            if (currentLen < shortestLen) {
                shortestLen = currentLen;
                shortestIdx = i;
            }
            if (currentLen > longestLen) {
                longestLen = currentLen;
                longestIdx = i;
            }
        }

        return new int[]{shortestIdx, longestIdx};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Shortest and Longest Words Finder ===");
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] words = splitWords(text);
        String[][] wordData = getWordsWithLengths(words);
        int[] resultIndexes = findShortestAndLongest(wordData);

        if (resultIndexes[0] != -1) {
            String shortestWord = wordData[resultIndexes[0]][0];
            int shortestLength = Integer.parseInt(wordData[resultIndexes[0]][1]);

            String longestWord = wordData[resultIndexes[1]][0];
            int longestLength = Integer.parseInt(wordData[resultIndexes[1]][1]);

            System.out.println("\n--- Extremities Summary ---");
            System.out.println("Shortest Word : \"" + shortestWord + "\" (Length: " + shortestLength + ")");
            System.out.println("Longest Word  : \"" + longestWord + "\" (Length: " + longestLength + ")");
        } else {
            System.out.println("No words found.");
        }

        scanner.close();
    }
}
