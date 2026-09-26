package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 6 - Level 2: Character Classification in 2D Array
 *
 * Description:
 * Classifies each character of a string into [Character, Type] where Type is
 * Vowel, Consonant, or Not a Letter, storing the output in a 2D array and displaying in tabular format.
 */
public class Q6_Level2 {

    public static String checkCharType(char ch) {
        char lower = ch;
        if (ch >= 'A' && ch <= 'Z') {
            lower = (char) (ch + 32);
        }

        if (lower >= 'a' && lower <= 'z') {
            if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    /**
     * Builds 2D array [Character, Type] for every character.
     */
    public static String[][] classifyCharacters(String text) {
        if (text == null) return new String[0][0];

        String[][] table = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            table[i][0] = String.valueOf(ch);
            table[i][1] = checkCharType(ch);
        }
        return table;
    }

    /**
     * Displays 2D array in tabular format.
     */
    public static void displayTable(String[][] table) {
        System.out.println("\n----------------------------");
        System.out.printf("%-12s %-15s\n", "Character", "Type");
        System.out.println("----------------------------");

        for (int i = 0; i < table.length; i++) {
            String displayChar = table[i][0].equals(" ") ? "<space>" : table[i][0];
            System.out.printf("%-12s %-15s\n", displayChar, table[i][1]);
        }
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Character Classification Table ===");
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[][] table = classifyCharacters(text);
        displayTable(table);

        scanner.close();
    }
}
