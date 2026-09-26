package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 4 - Level 3: Character Frequency in 2D Array
 *
 * Description:
 * Computes frequency of all characters in a string using a 256 ASCII frequency array,
 * stores results in a 2D String array [character, frequency], and displays them.
 */
public class Q4_Level3 {

    /**
     * Determines frequency of all distinct characters using 256 ASCII array.
     *
     * @return 2D String array [character, frequency]
     */
    public static String[][] getCharacterFrequencies(String text) {
        if (text == null || text.isEmpty()) {
            return new String[0][0];
        }

        int[] frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        // Count unique characters
        int uniqueCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // If first occurrence
            if (frequency[ch] > 0) {
                uniqueCount++;
                frequency[ch] = -frequency[ch]; // Mark as counted
            }
        }

        // Restore positive frequencies
        for (int i = 0; i < 256; i++) {
            if (frequency[i] < 0) {
                frequency[i] = -frequency[i];
            }
        }

        // Populate 2D array in order of appearance
        String[][] result = new String[uniqueCount][2];
        boolean[] visited = new boolean[256];
        int idx = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!visited[ch]) {
                visited[ch] = true;
                result[idx][0] = String.valueOf(ch);
                result[idx][1] = String.valueOf(frequency[ch]);
                idx++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Character Frequency in 2D Array ===");
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[][] freqData = getCharacterFrequencies(text);

        System.out.println("\n----------------------------");
        System.out.printf("%-12s %-12s\n", "Character", "Frequency");
        System.out.println("----------------------------");

        for (int i = 0; i < freqData.length; i++) {
            String ch = freqData[i][0].equals(" ") ? "<space>" : freqData[i][0];
            System.out.printf("%-12s %-12s\n", ch, freqData[i][1]);
        }
        System.out.println("----------------------------");

        scanner.close();
    }
}
