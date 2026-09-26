package Array.assigment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileReader Problem 1: Read a File Line by Line Using FileReader
 *
 * Problem Statement:
 * Write a program that uses FileReader wrapped in BufferedReader to read a text
 * file line by line and print each line to the console.
 *
 * Best Practices Followed:
 * - Wrap FileReader with BufferedReader for efficient bulk character buffering.
 * - Always use try-with-resources to automatically close readers and prevent leaks.
 * - Proper handling of IOException.
 */
public class FileReaderReadLineByLine {

    /**
     * Reads and prints a text file line by line using FileReader and BufferedReader.
     *
     * @param filePath Path of file to read
     * @throws IOException On file read error
     */
    public static void readFileLineByLine(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("File not found at path: " + filePath);
        }

        // Try-with-resources wraps FileReader in BufferedReader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 1;

            System.out.println("\n--- Reading File Contents (" + file.getName() + ") ---");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.printf("[%02d] %s\n", lineNumber++, line);
            }
            System.out.println("--- End of File ---\n");
        }
    }

    public static void main(String[] args) {
        String sampleFilePath = "sample_filereader_demo.txt";

        // Create a small sample file to guarantee runnable demo
        try (FileWriter writer = new FileWriter(sampleFilePath)) {
            writer.write("Java Data Structures & Algorithms\n");
            writer.write("Topic: FileReader and BufferedReader\n");
            writer.write("Reading text line by line efficiently.\n");
            writer.write("Always remember to close file streams.\n");
        } catch (IOException e) {
            System.err.println("Could not create sample file: " + e.getMessage());
            return;
        }

        // Demonstrate reading the file
        try {
            readFileLineByLine(sampleFilePath);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            // Clean up demo file
            new File(sampleFilePath).delete();
        }
    }
}
