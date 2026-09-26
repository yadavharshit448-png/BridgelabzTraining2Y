package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 5 - Level 3: Character Frequency via Unique Characters Method
 *
 * Description:
 * Extracts unique characters from a text using charAt() and nested loops,
 * calculates the frequency of each unique character using an ASCII frequency array,
 * and compiles the output into a 2D String array.
 */
public class Q5_Level3 {

    /**
     * Extracts unique characters in order of appearance using nested loops.
     */
    public static char[] uniqueCharacters(String text) {
        if (text == null || text.isEmpty()) {
            return new char[0];
        }

        char[] temp = new char[text.length()];
        int uniqueCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

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

        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    /**
     * Builds 2D String array of unique characters and their frequencies.
     */
    public static String[][] getFrequenciesUsingUnique(String text) {
        if (text == null || text.isEmpty()) {
            return new String[0][0];
        }

        // Calculate frequencies using 256 ASCII array
        int[] frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        // Find unique characters
        char[] uniqueChars = uniqueCharacters(text);

        // Build 2D array
        String[][] table = new String[uniqueChars.length][2];
        for (int i = 0; i < uniqueChars.length; i++) {
            char ch = uniqueChars[i];
            table[i][0] = String.valueOf(ch);
            table[i][1] = String.valueOf(frequency[ch]);
        }

        return table;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Character Frequency via Unique Characters ===");
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[][] table = getFrequenciesUsingUnique(text);

        System.out.println("\n----------------------------");
        System.out.printf("%-12s %-12s\n", "Character", "Frequency");
        System.out.println("----------------------------");

        for (int i = 0; i < table.length; i++) {
            String ch = table[i][0].equals(" ") ? "<space>" : table[i][0];
            System.out.printf("%-12s %-12s\n", ch, table[i][1]);
        }
        System.out.println("----------------------------");

        scanner.close();
    }
}
