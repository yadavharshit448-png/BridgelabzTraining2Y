package Array.assigment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * FileReader Problem 2: Count the Occurrence of a Word in a File Using FileReader
 *
 * Problem Statement:
 * Write a program that uses FileReader and BufferedReader to read a file and count
 * how many times a specific word appears in the file.
 *
 * Approach:
 * 1. Create a FileReader wrapped in a BufferedReader.
 * 2. Initialize a counter variable to track word occurrences.
 * 3. Split each line on whitespace (\\s+) and compare against target word.
 * 4. Increment counter and output total count.
 */
public class FileReaderCountWordOccurrence {

    /**
     * Counts occurrences of a target word in a file.
     *
     * @param filePath   Path to text file
     * @param targetWord Word to search for
     * @return Occurrence count
     * @throws IOException On file read error
     */
    public static int countWordOccurrences(String filePath, String targetWord) throws IOException {
        int count = 0;
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("File not found at: " + filePath);
        }

        // Try-with-resources wraps FileReader in BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split line on whitespace characters
                String[] words = line.split("\\s+");
                for (String word : words) {
                    // Strip common punctuation for accurate comparison
                    String cleanWord = word.replaceAll("[^a-zA-Z0-9]", "");
                    if (cleanWord.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String demoFilePath = "sample_word_count_demo.txt";

        // Create sample file for demonstration
        try (FileWriter writer = new FileWriter(demoFilePath)) {
            writer.write("Java is a popular programming language.\n");
            writer.write("Many developers love Java because Java is robust and portable.\n");
            writer.write("Learn Java and master data structures in Java.\n");
        } catch (IOException e) {
            System.err.println("Could not create demo file: " + e.getMessage());
            scanner.close();
            return;
        }

        System.out.println("=== Count Word Occurrence in File ===");
        System.out.print("Enter target word to search (e.g. 'Java'): ");
        String searchWord = scanner.next();

        try {
            int totalOccurrences = countWordOccurrences(demoFilePath, searchWord);
            System.out.println("\nResult: The word \"" + searchWord + "\" appears " + totalOccurrences + " time(s) in the file.");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            new File(demoFilePath).delete();
        }

        scanner.close();
    }
}
