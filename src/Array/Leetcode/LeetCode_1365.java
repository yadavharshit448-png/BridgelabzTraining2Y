package Array.Leetcode;

import java.util.Scanner;
import java.util.Arrays;

public class LeetCode_1365 {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    result[i]++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));

        sc.close();
    }
}