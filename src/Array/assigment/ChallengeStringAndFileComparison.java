package Array.assigment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Challenge Problem: Comprehensive Comparison of String Builders & File Readers
 *
 * Requirements:
 * 1. String Concatenation: Compare StringBuilder vs StringBuffer appending 1,000,000 times.
 * 2. File Reading: Compare FileReader vs InputStreamReader counting words in a generated text dataset.
 */
public class ChallengeStringAndFileComparison {

    public static void benchmarkStringConcatenation(int iterations) {
        System.out.println("------------------------------------------------------------------");
        System.out.println("PART 1: StringBuilder vs StringBuffer (" + String.format("%,d", iterations) + " appends)");
        System.out.println("------------------------------------------------------------------");

        String text = "test";

        // StringBuilder
        long builderStart = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long builderEnd = System.nanoTime();
        double builderMs = (builderEnd - builderStart) / 1_000_000.0;

        // StringBuffer
        long bufferStart = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        long bufferEnd = System.nanoTime();
        double bufferMs = (bufferEnd - bufferStart) / 1_000_000.0;

        System.out.printf("StringBuilder Elapsed Time : %.2f ms\n", builderMs);
        System.out.printf("StringBuffer Elapsed Time  : %.2f ms\n", bufferMs);
        System.out.printf("Speedup Ratio              : %.2fx\n\n", (bufferMs / builderMs));
    }

    public static void benchmarkFileReaders(String filePath) throws IOException {
        System.out.println("------------------------------------------------------------------");
        System.out.println("PART 2: FileReader vs InputStreamReader (Word Count & Performance)");
        System.out.println("------------------------------------------------------------------");

        // 1. FileReader + BufferedReader
        long fileReaderStart = System.nanoTime();
        int wordsFileReader = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordsFileReader += words.length;
                }
            }
        }
        long fileReaderEnd = System.nanoTime();
        double fileReaderMs = (fileReaderEnd - fileReaderStart) / 1_000_000.0;

        // 2. FileInputStream + InputStreamReader + BufferedReader
        long isrStart = System.nanoTime();
        int wordsISR = 0;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordsISR += words.length;
                }
            }
        }
        long isrEnd = System.nanoTime();
        double isrMs = (isrEnd - isrStart) / 1_000_000.0;

        System.out.printf("FileReader:        Words = %,d | Time = %.2f ms\n", wordsFileReader, fileReaderMs);
        System.out.printf("InputStreamReader: Words = %,d | Time = %.2f ms\n", wordsISR, isrMs);
        System.out.println("------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println("CHALLENGE: STRING BUILDERS & FILE READERS BENCHMARK");
        System.out.println("==================================================================\n");

        // Part 1: String Benchmarks
        benchmarkStringConcatenation(1_000_000);

        // Part 2: Generate sample file for file benchmarks
        String testFile = "benchmark_test_dataset.txt";
        try {
            System.out.println("Generating test dataset file...");
            try (FileWriter writer = new FileWriter(testFile)) {
                for (int i = 0; i < 50_000; i++) {
                    writer.write("Java DataStructures Algorithms Performance Benchmark Test Line " + i + "\n");
                }
            }

            benchmarkFileReaders(testFile);
        } catch (IOException e) {
            System.err.println("File benchmark error: " + e.getMessage());
        } finally {
            new File(testFile).delete();
        }
    }
}
