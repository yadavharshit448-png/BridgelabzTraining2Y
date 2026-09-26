package Java_dsa;

import java.util.Arrays;

/**
 * ============================================================================
 * DATA STRUCTURES AND ALGORITHMS (DSA) PRACTICE SHEET
 * Topics: Time Complexity & Space Complexity Analysis with Java Solutions
 * Target Arrays:
 *   - Sample Array for Linear Search & Merge Sort: {8, 61, 2, 3, 4, 0}
 *   - Sample Sorted Array for Binary Search:       {0, 2, 3, 4, 8, 61}
 * ============================================================================
 */
public class ComplexityAnalysis {

    /*
     * ========================================================================
     * ⏱ SECTION 3: TIME COMPLEXITY & 💾 SECTION 4: SPACE COMPLEXITY
     * ------------------------------------------------------------------------
     * ALGORITHM 1: LINEAR SEARCH
     * Sample Input Array: {8, 61, 2, 3, 4, 0} (Size N = 6)
     * ========================================================================
     *
     * PROBLEM TC-1: LINEAR SEARCH TIME COMPLEXITY
     * ------------------------------------------------------------------------
     * Task 1: Best Case Time Complexity (Target = 8)
     *   - Definition: The best case occurs when the target element is located
     *     at the very first position of the array (index 0).
     *   - Observation: In {8, 61, 2, 3, 4, 0}, target 8 is at arr[0].
     *   - Comparisons required: Exactly 1 comparison.
     *   - Big-O Notation: O(1) [Constant Time].
     *
     * Task 2: Worst Case Time Complexity (Target = 0 or Target not present, e.g., 5)
     *   - Definition: The worst case occurs when the algorithm must examine every
     *     single element in the array. This happens when the target is at the
     *     very last position (arr[N - 1]) or does not exist in the array at all.
     *   - Observation: Target 0 is at arr[5] (index 5) -> Requires 6 comparisons.
     *     Target 5 (not present) -> Scans all 6 elements before returning -1.
     *   - Comparisons required: N comparisons for an array of size N.
     *   - Big-O Notation: O(N) [Linear Time].
     *
     * Task 3: Average Case Time Complexity (Random target position)
     *   - Definition: Assuming uniform probability (1/N) for the target being at
     *     any index i in [0, N - 1], the expected number of comparisons is:
     *         Expected Comparisons = (1/N) * (1 + 2 + 3 + ... + N)
     *                              = (1/N) * [N * (N + 1) / 2]
     *                              = (N + 1) / 2
     *   - Big-O Notation: As N -> infinity, (N + 1) / 2 scales linearly with N.
     *     Hence, Average Case Time Complexity = O(N) [Linear Time].
     *
     * ------------------------------------------------------------------------
     * PROBLEM SC-1: LINEAR SEARCH SPACE COMPLEXITY
     * ------------------------------------------------------------------------
     * Task 1: Auxiliary Space Complexity Analysis
     *   - Auxiliary space refers to the temporary or extra memory used by an
     *     algorithm beyond the input data.
     *   - Memory Allocation Breakdown:
     *       * Loop counter `i`       : 4 bytes (integer primitive)
     *       * Target parameter `key` : 4 bytes (passed by value)
     *       * Array reference `arr`  : reference pointer (no array copy created)
     *   - The number and size of these extra variables remain constant, regardless
     *     of whether N = 6 or N = 10,000,000.
     *   - Auxiliary Space: O(1) [Constant Space].
     *   - Total Space (including input): O(N) to store the input array.
     * ========================================================================
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Target found at index i
            }
        }
        return -1; // Target not found
    }

    /*
     * ========================================================================
     * ALGORITHM 2: ITERATIVE BINARY SEARCH
     * Sample Sorted Array: {0, 2, 3, 4, 8, 61} (Size N = 6)
     * ========================================================================
     *
     * PROBLEM TC-2: ITERATIVE BINARY SEARCH COMPLEXITY
     * ------------------------------------------------------------------------
     * Task 1: Step-by-Step Search Range Narrowing for Target = 4
     *   Initial Array: index 0: 0, index 1: 2, index 2: 3, index 3: 4, index 4: 8, index 5: 61
     *   Target = 4
     *
     *   +-----------+-----+------+-----+----------+---------------------------------+
     *   | Iteration | low | high | mid | arr[mid] | Action / Decision               |
     *   +-----------+-----+------+-----+----------+---------------------------------+
     *   | Step 1    |  0  |  5   |  2  |    3     | arr[2] = 3 < 4 -> low = mid + 1 |
     *   | Step 2    |  3  |  5   |  4  |    8     | arr[4] = 8 > 4 -> high = mid - 1|
     *   | Step 3    |  3  |  3   |  3  |    4     | arr[3] = 4 == 4 -> MATCH FOUND! |
     *   +-----------+-----+------+-----+----------+---------------------------------+
     *   Result: Target 4 found at index 3 in 3 comparisons.
     *
     * Task 2: Mathematical Derivation of Worst-Case Time Complexity
     *   - Let N be the number of elements in the sorted array.
     *   - In each iteration, Binary Search compares the target with arr[mid].
     *     If unequal, it halves the search space.
     *   - Search space size progression:
     *       After 0 iterations : N
     *       After 1 iteration  : N / 2
     *       After 2 iterations : N / 4 = N / (2^2)
     *       After 3 iterations : N / 8 = N / (2^3)
     *       ...
     *       After k iterations : N / (2^k)
     *   - In the worst case (element found at last possible step or absent),
     *     search terminates when remaining search space is reduced to size 1:
     *         N / (2^k) = 1
     *         2^k = N
     *         k = log2(N)
     *   - For arbitrary integer N: Number of comparisons = floor(log2(N)) + 1.
     *   - Big-O Notation: O(log N) [Logarithmic Time].
     *
     * ------------------------------------------------------------------------
     * PROBLEM SC-2: BINARY SEARCH SPACE COMPLEXITY
     * ------------------------------------------------------------------------
     * Task 1: Auxiliary Space Complexity in Big-O Notation
     *   - In the iterative implementation of Binary Search, only three pointer
     *     variables are allocated: `low`, `high`, and `mid`.
     *   - No auxiliary arrays, slices, or recursive stack frames are generated.
     *   - Therefore, Auxiliary Space Complexity: O(1) [Constant Space].
     *   - [Contrast with Recursive Binary Search, which requires O(log N)
     *     auxiliary space for call stack frames].
     * ========================================================================
     */
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Prevents integer overflow

            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                low = mid + 1; // Narrow search to right half
            } else {
                high = mid - 1; // Narrow search to left half
            }
        }
        return -1; // Target not found
    }

    /*
     * ========================================================================
     * ALGORITHM 3: MERGE SORT
     * Sample Input Array: {8, 61, 2, 3, 4, 0} (Size N = 6)
     * ========================================================================
     *
     * PROBLEM TC-3: MERGE SORT TIME COMPLEXITY
     * ------------------------------------------------------------------------
     * Task 1: Division / Split Tree for Sample Array {8, 61, 2, 3, 4, 0}
     *
     *                       [8, 61, 2, 3, 4, 0]                Level 0 (N = 6)
     *                              /     \
     *                             /       \
     *                    [8, 61, 2]       [3, 4, 0]            Level 1 (N/2)
     *                      /    \           /    \
     *                    [8]   [61, 2]    [3]   [4, 0]         Level 2
     *                          /    \           /    \
     *                        [61]   [2]       [4]    [0]       Level 3 (Leaves)
     *
     *   Merge Progression (Bottom-Up):
     *     1. Merge [61] & [2]    -> [2, 61]
     *     2. Merge [8] & [2, 61] -> [2, 8, 61]
     *     3. Merge [4] & [0]     -> [0, 4]
     *     4. Merge [3] & [0, 4]  -> [0, 3, 4]
     *     5. Merge [2, 8, 61] & [0, 3, 4] -> [0, 2, 3, 4, 8, 61]
     *
     * Task 2: Recurrence Relation Solution via Recursion Tree Method
     *   - Recurrence relation for Merge Sort:
     *         T(N) = 2 * T(N / 2) + c * N    for N > 1
     *         T(1) = O(1)
     *     where:
     *       * 2 * T(N/2) is the time to recursively sort both halves.
     *       * c * N is the time required to merge the two sorted halves.
     *
     *   - Recursion Tree Level-by-Level Work Breakdown:
     *     +-------+--------------------+----------------------+--------------------+
     *     | Level | Number of Subprobs | Size of Each Subprob | Work at this Level |
     *     +-------+--------------------+----------------------+--------------------+
     *     |   0   |       2^0 = 1      |          N           | 1 * cN     = cN    |
     *     |   1   |       2^1 = 2      |         N/2          | 2 * c(N/2) = cN    |
     *     |   2   |       2^2 = 4      |         N/4          | 4 * c(N/4) = cN    |
     *     |  ...  |        ...         |         ...          |        ...         |
     *     |   i   |        2^i         |        N/(2^i)       | 2^i*c(N/2^i) = cN  |
     *     |  ...  |        ...         |         ...          |        ...         |
     *     | log2N |    2^(log2N) = N   |          1           | N * O(1)   = cN    |
     *     +-------+--------------------+----------------------+--------------------+
     *
     *   - Total Levels: log2(N) + 1 levels (from level 0 to log2(N)).
     *   - Total Work:
     *         Total Work = Sum from level 0 to log2(N) of (cN)
     *                    = cN * (log2(N) + 1)
     *                    = cN * log2(N) + cN
     *   - Asymptotically: O(N log N).
     *   - Final Time Complexity: O(N log N) in all cases (Best, Average, and Worst).
     *
     * ------------------------------------------------------------------------
     * PROBLEM SC-3: MERGE SORT SPACE COMPLEXITY
     * ------------------------------------------------------------------------
     * Task 1: Why Merging Requires Extra Memory Allocation & Big-O Notation
     *   - During the merge step, elements from two sorted subarrays must be
     *     compared and assembled into a combined sorted sequence.
     *   - In-place merging without extra memory would require shifting elements
     *     forward upon each insertion, leading to an O(N^2) time complexity for
     *     merging and eliminating the O(N log N) performance guarantee.
     *   - To preserve linear O(N) merge time, Merge Sort allocates temporary
     *     arrays (e.g. leftArray and rightArray) of total size N to store
     *     copied elements while writing the smallest element back into the main array.
     *   - Auxiliary Space Complexity: O(N) [Linear Auxiliary Space].
     *
     * Task 2: Comparison with In-Place Sorting Algorithms
     *   +----------------+-----------------+-------------------+-------------------+
     *   | Algorithm      | Auxiliary Space | Time Complexity   | In-Place / Stable |
     *   +----------------+-----------------+-------------------+-------------------+
     *   | Merge Sort     | O(N)            | O(N log N)        | Not In-Place / Yes|
     *   | Quick Sort     | O(log N) stack  | O(N log N) avg    | In-Place     / No |
     *   | Insertion Sort | O(1)            | O(N^2) worst      | In-Place     / Yes|
     *   +----------------+-----------------+-------------------+-------------------+
     *   - Merge Sort requires O(N) auxiliary heap/buffer space, giving it a much
     *     higher memory footprint than Quick Sort (which requires only O(log N)
     *     stack frames for partitioning) and Insertion Sort (which requires O(1)
     *     constant space).
     *   - However, Merge Sort provides stability and a guaranteed O(N log N) worst
     *     case, making it ideal for linked lists and external sorting (e.g. disk data).
     * ========================================================================
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Divide step
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Conquer / Merge step
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary auxiliary arrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }

    // ========================================================================
    // MAIN METHOD: DEMONSTRATING SOLUTIONS ON PRACTICE SHEET SAMPLE INPUTS
    // ========================================================================
    public static void main(String[] args) {
        System.out.println("=================================================================");
        System.out.println("DSA PRACTICE SHEET: TIME & SPACE COMPLEXITY DEMONSTRATION");
        System.out.println("=================================================================\n");

        // 1. Linear Search Demonstration
        int[] linearSample = {8, 61, 2, 3, 4, 0};
        System.out.println("--- 1. LINEAR SEARCH ---");
        System.out.println("Array: " + Arrays.toString(linearSample));
        
        int targetBest = 8;
        int indexBest = linearSearch(linearSample, targetBest);
        System.out.println("Best Case Search (Target " + targetBest + "): Found at index " + indexBest + " [O(1) time]");

        int targetWorst = 0;
        int indexWorst = linearSearch(linearSample, targetWorst);
        System.out.println("Worst Case Search (Target " + targetWorst + "): Found at index " + indexWorst + " [O(N) time]");

        int targetAbsent = 5;
        int indexAbsent = linearSearch(linearSample, targetAbsent);
        System.out.println("Worst Case Search (Target " + targetAbsent + " not found): Index " + indexAbsent + " [O(N) time]\n");

        // 2. Binary Search Demonstration
        int[] binarySample = {0, 2, 3, 4, 8, 61};
        int binaryTarget = 4;
        System.out.println("--- 2. ITERATIVE BINARY SEARCH ---");
        System.out.println("Sorted Array: " + Arrays.toString(binarySample));
        int binaryIndex = binarySearch(binarySample, binaryTarget);
        System.out.println("Searching for Target " + binaryTarget + ": Found at index " + binaryIndex + " [O(log N) time]\n");

        // 3. Merge Sort Demonstration
        int[] mergeSample = {8, 61, 2, 3, 4, 0};
        System.out.println("--- 3. MERGE SORT ---");
        System.out.println("Original Array: " + Arrays.toString(mergeSample));
        mergeSort(mergeSample, 0, mergeSample.length - 1);
        System.out.println("Sorted Array:   " + Arrays.toString(mergeSample) + " [O(N log N) time, O(N) auxiliary space]\n");

        System.out.println("=================================================================");
        System.out.println("All algorithms executed successfully.");
        System.out.println("See detailed Big-O commentary and mathematical proofs in the code.");
        System.out.println("=================================================================");
    }
}
