package Array.assigment;

/**
 * StringBuffer Problem 2: Compare StringBuffer with StringBuilder for String Concatenation
 *
 * Problem Statement:
 * Write a program that compares the performance of StringBuffer and StringBuilder
 * for concatenating strings across a large dataset (e.g. 1,000,000 appends).
 * Measure execution time using System.nanoTime() and output the comparison.
 *
 * Key Takeaway:
 * - StringBuilder is unsynchronized and faster for single-threaded tasks.
 * - StringBuffer uses synchronized methods for thread safety, introducing locking overhead.
 */
public class CompareStringBufferAndBuilder {

    public static void main(String[] args) {
        final int ITERATIONS = 1_000_000;
        final String APPEND_TEXT = "hello";

        System.out.println("=== Performance Comparison: StringBuffer vs StringBuilder ===");
        System.out.println("Testing " + String.format("%,d", ITERATIONS) + " string appends...\n");

        // 1. Benchmark StringBuilder
        long builderStartTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ITERATIONS; i++) {
            stringBuilder.append(APPEND_TEXT);
        }
        long builderEndTime = System.nanoTime();
        long builderDurationNs = builderEndTime - builderStartTime;
        double builderDurationMs = builderDurationNs / 1_000_000.0;

        // 2. Benchmark StringBuffer
        long bufferStartTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < ITERATIONS; i++) {
            stringBuffer.append(APPEND_TEXT);
        }
        long bufferEndTime = System.nanoTime();
        long bufferDurationNs = bufferEndTime - bufferStartTime;
        double bufferDurationMs = bufferDurationNs / 1_000_000.0;

        // Display results
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-18s %-20s %-20s\n", "Class", "Time (Nanoseconds)", "Time (Milliseconds)");
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-18s %-20d %-20.2f\n", "StringBuilder", builderDurationNs, builderDurationMs);
        System.out.printf("%-18s %-20d %-20.2f\n", "StringBuffer", bufferDurationNs, bufferDurationMs);
        System.out.println("-----------------------------------------------------------------");

        if (builderDurationNs < bufferDurationNs) {
            double speedup = (double) bufferDurationNs / builderDurationNs;
            System.out.printf("Conclusion: StringBuilder was %.2fx FASTER due to absence of synchronization locks.\n", speedup);
        } else {
            System.out.println("Conclusion: Performance was comparable on this runtime run.");
        }
    }
}
