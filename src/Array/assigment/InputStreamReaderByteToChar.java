package Array.assigment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * InputStreamReader Problem 1: Convert Byte Stream to Character Stream Using InputStreamReader
 *
 * Problem Statement:
 * Write a program that uses InputStreamReader to read binary data from a file and
 * print it as characters. The file contains data encoded in a specific charset (UTF-8).
 *
 * Best Practices Followed:
 * - Bridges byte streams (FileInputStream) to character streams with explicit charset.
 * - Wraps InputStreamReader in BufferedReader for optimal read performance.
 * - Uses try-with-resources to guarantee safe release of system resources.
 */
public class InputStreamReaderByteToChar {

    /**
     * Reads a byte stream from a file, decodes it with UTF-8 charset, and prints lines.
     *
     * @param filePath Path of the file to decode and read
     * @throws IOException On file read or decoding error
     */
    public static void readByteStreamAsCharacters(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("File not found at: " + filePath);
        }

        // FileInputStream (byte stream) -> InputStreamReader (bridge with UTF-8) -> BufferedReader
        try (FileInputStream fileInputStream = new FileInputStream(file);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            System.out.println("Reading file via InputStreamReader using Charset: " + inputStreamReader.getEncoding());
            String line;
            int lineNumber = 1;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.printf("[%02d] %s\n", lineNumber++, line);
            }
        }
    }

    public static void main(String[] args) {
        String demoBinaryFile = "sample_byte_stream_demo.bin";

        // Create a sample binary-encoded file with UTF-8 bytes
        try (FileOutputStream fos = new FileOutputStream(demoBinaryFile)) {
            String sampleText = "Byte stream to character stream demonstration.\n" +
                                "Unicode support: Hello, World! - Bonjour - 你好 - नमस्ते\n" +
                                "Charset: UTF-8 decoded successfully.\n";
            fos.write(sampleText.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.err.println("Could not create demo byte file: " + e.getMessage());
            return;
        }

        System.out.println("=== InputStreamReader: Byte Stream to Character Stream ===");
        try {
            readByteStreamAsCharacters(demoBinaryFile);
        } catch (IOException e) {
            System.err.println("Error processing byte stream: " + e.getMessage());
        } finally {
            new File(demoBinaryFile).delete();
        }
    }
}
