package Array.assigment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * InputStreamReader Problem 2: Read User Input and Write to File Using InputStreamReader
 *
 * Problem Statement:
 * Write a program that uses InputStreamReader to read user input from the console
 * and write the input to a file. Each input should be written as a new line in the file.
 * Repeat until user enters "exit".
 *
 * Best Practices Followed:
 * - Reads System.in through InputStreamReader wrapped with BufferedReader.
 * - Writes to file via FileWriter with try-with-resources.
 * - Graceful exit condition without abrupt termination.
 */
public class InputStreamReaderConsoleToFile {

    /**
     * Reads console lines and writes them to the specified output file.
     *
     * @param targetFilePath File path where inputs will be saved
     * @throws IOException On I/O error
     */
    public static void recordConsoleInputToFile(String targetFilePath) throws IOException {
        System.out.println("Enter lines of text to write to \"" + targetFilePath + "\".");
        System.out.println("Type 'exit' on a new line to finish:\n");

        // Try-with-resources manages both the console reader and file writer
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
             FileWriter fileWriter = new FileWriter(targetFilePath)) {

            String inputLine;
            int lineCount = 0;

            while ((inputLine = consoleReader.readLine()) != null) {
                // Exit condition
                if (inputLine.trim().equalsIgnoreCase("exit")) {
                    break;
                }

                // Write line to file followed by newline separator
                fileWriter.write(inputLine + System.lineSeparator());
                lineCount++;
            }

            System.out.println("\nSuccessfully saved " + lineCount + " line(s) to " + targetFilePath);
        }
    }

    public static void main(String[] args) {
        String outputFilePath = "user_input_log.txt";

        System.out.println("=== Console Input to File via InputStreamReader ===");
        try {
            recordConsoleInputToFile(outputFilePath);

            // Display file contents to verify
            File file = new File(outputFilePath);
            if (file.exists()) {
                System.out.println("Verification: File exists, size = " + file.length() + " bytes.");
                // Clean up created file
                file.delete();
            }
        } catch (IOException e) {
            System.err.println("I/O Error: " + e.getMessage());
        }
    }
}
