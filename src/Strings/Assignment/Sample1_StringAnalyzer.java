package Strings.Assignment;

import java.util.Scanner;

/**
 * Sample Program 1: String Analyzer (Character Occurrences)
 *
 * Description:
 * Finds all index positions of a given character in a string using charAt().
 */
public class Sample1_StringAnalyzer {

    /**
     * Finds all occurrence indices of a character in the text.
     *
     * @param text Original string
     * @param ch   Character to locate
     * @return Array of indices
     */
    public static int[] findAllIndexes(String text, char ch) {
        if (text == null) {
            return new int[0];
        }

        // Count occurrences
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ch) {
                count++;
            }
        }

        // Store indices
        int[] indexes = new int[count];
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ch) {
                indexes[j] = i;
                j++;
            }
        }
        return indexes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        System.out.print("Enter a character to find the occurrences: ");
        char ch = sc.next().charAt(0);

        int[] indexes = findAllIndexes(text, ch);

        System.out.println("Indexes of the character '" + ch + "': ");
        for (int i = 0; i < indexes.length; i++) {
            System.out.print(indexes[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}
