package Array.assigment;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem 7: Counting Sort - Sort Student Ages
 *
 * Problem Statement:
 * A school collects students' ages (ranging from 10 to 18) and wants them sorted.
 * Implement Counting Sort for this task.
 *
 * Algorithm Strategy (Non-comparison Integer Sorting):
 * 1. Range Offset: Map ages in range [minAge, maxAge] to count array indices [0, range - 1].
 * 2. Frequency Array: Count occurrences of each age value.
 * 3. Cumulative Sum: Compute cumulative frequencies (count[i] += count[i - 1]) to determine
 *    the exact starting/ending index for each element.
 * 4. Output Placement: Iterate backwards through the original array to maintain stable
 *    placement into the sorted output array, decrementing the count table.
 *
 * Time Complexity:
 * - O(N + K) where N is the number of students and K is the range of ages (K = 18 - 10 + 1 = 9).
 * - Linear time since K << N.
 *
 * Space Complexity:
 * - Auxiliary Space: O(N + K) (count array of size K, output array of size N).
 */
public class CountingSortStudentAges {

    /**
     * Sorts student ages using stable Counting Sort.
     *
     * @param ages   Array of student ages
     * @param minAge Minimum age boundary (e.g. 10)
     * @param maxAge Maximum age boundary (e.g. 18)
     * @return Sorted array of student ages
     */
    public static int[] countingSort(int[] ages, int minAge, int maxAge) {
        int n = ages.length;
        int range = maxAge - minAge + 1;

        // Step 1: Create count array of size equal to age range
        int[] count = new int[range];
        int[] output = new int[n];

        // Step 2: Store frequency of each age
        for (int i = 0; i < n; i++) {
            int age = ages[i];
            if (age < minAge || age > maxAge) {
                throw new IllegalArgumentException("Age " + age + " is outside the expected range [" +
                        minAge + ", " + maxAge + "].");
            }
            count[age - minAge]++;
        }

        // Step 3: Compute cumulative frequencies to determine output positions
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 4: Build the output array (traverse backwards for stable sort)
        for (int i = n - 1; i >= 0; i--) {
            int age = ages[i];
            int position = count[age - minAge] - 1;
            output[position] = age;
            count[age - minAge]--;
        }

        return output;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int MIN_AGE = 10;
        final int MAX_AGE = 18;

        System.out.println("=== 7. Counting Sort: Student Ages (Range 10 - 18) ===");
        System.out.print("Do you want to enter custom student ages? (yes/no): ");
        String choice = scanner.next();

        int[] ages;
        if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
            System.out.print("Enter number of students: ");
            int count = scanner.nextInt();
            while (count <= 0) {
                System.err.print("Count must be positive. Re-enter: ");
                count = scanner.nextInt();
            }

            ages = new int[count];
            System.out.println("Enter ages for " + count + " students (between " + MIN_AGE + " and " + MAX_AGE + "):");
            for (int i = 0; i < ages.length; i++) {
                System.out.print("Student " + (i + 1) + " Age: ");
                int enteredAge = scanner.nextInt();

                while (enteredAge < MIN_AGE || enteredAge > MAX_AGE) {
                    System.err.print("Invalid age! Must be between " + MIN_AGE + " and " + MAX_AGE + ". Re-enter: ");
                    enteredAge = scanner.nextInt();
                }
                ages[i] = enteredAge;
            }
        } else {
            // Default sample dataset
            ages = new int[]{14, 12, 16, 11, 18, 15, 10, 13, 17, 12, 14, 16, 10, 15};
            System.out.println("Using sample student ages dataset.");
        }

        System.out.println("\nOriginal Ages : " + Arrays.toString(ages));

        // Perform Counting Sort
        int[] sortedAges = countingSort(ages, MIN_AGE, MAX_AGE);

        System.out.println("Sorted Ages   : " + Arrays.toString(sortedAges));

        scanner.close();
    }
}
