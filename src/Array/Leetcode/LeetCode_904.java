package Array.Leetcode;

import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
public class LeetCode_904 {
    public static int totalFruit(int[] fruits) {
        int start = 0;
        int max = 0;
        int count = 0;

        int[] freq = new int[fruits.length + 1];

        for (int end = 0; end < fruits.length; end++) {

            // New fruit type enters the window
            if (freq[fruits[end]] == 0) {
                count++;
            }

            freq[fruits[end]]++;

            // More than 2 fruit types
            while (count > 2) {
                freq[fruits[start]]--;

                if (freq[fruits[start]] == 0) {
                    count--;
                }

                start++;
            }

            // Current window size
            max = Math.max(max, end - start + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array fruits: ");
        int n_fruits = sc.nextInt();
        int[] fruits = new int[n_fruits];
        System.out.println("Enter " + n_fruits + " integers for fruits: ");
        for (int i = 0; i < n_fruits; i++) {
            fruits[i] = sc.nextInt();
        }

        int result = totalFruit(fruits);
        System.out.println("Result: " + result);

        sc.close();
    }
}