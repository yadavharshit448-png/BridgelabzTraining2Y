package Array.assigment;

import java.util.Scanner;

/**
 * Linear Search Problem 2: Search for a Specific Word in a List of Sentences
 *
 * Problem Statement:
 * You are given an array of sentences. Write a program that performs Linear Search
 * to find the first sentence containing a specific word. If found, return the sentence;
 * otherwise return "Not Found".
 *
 * Best Practices:
 * - Return early as soon as the target word is identified in a sentence.
 * - Handles case-insensitive word matching safely with word boundaries.
 */
public class LinearSearchWordInSentences {

    /**
     * Searches for the first sentence containing the target word.
     *
     * @param sentences Array of sentence strings
     * @param word      Word to look for
     * @return Matching sentence or "Not Found"
     */
    public static String findSentenceWithWord(String[] sentences, String word) {
        if (sentences == null || word == null) {
            return "Not Found";
        }

        String searchPattern = "\\b" + word.trim().toLowerCase() + "\\b";

        for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i];
            if (sentence != null) {
                // Check if sentence contains the whole word
                if (sentence.toLowerCase().matches(".*" + searchPattern + ".*")) {
                    return sentence; // Early return on first match
                }
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sentences = {
            "The quick brown fox jumps over the lazy dog.",
            "Java is a high-level, class-based, object-oriented programming language.",
            "Linear search examines each element sequentially until a match is found.",
            "Data structures and algorithms form the foundation of computer science.",
            "Practice problem solving daily to sharpen analytical thinking."
        };

        System.out.println("=== Linear Search: Find Word in Sentences ===");
        System.out.println("Available Sentences:");
        for (int i = 0; i < sentences.length; i++) {
            System.out.println(" [" + (i + 1) + "] " + sentences[i]);
        }

        System.out.print("\nEnter a word to search: ");
        String searchWord = scanner.next();

        String matchingSentence = findSentenceWithWord(sentences, searchWord);

        System.out.println("\n--- Search Result ---");
        System.out.println("Target Word : \"" + searchWord + "\"");
        System.out.println("Result      : " + matchingSentence);

        scanner.close();
    }
}
