package Array.Leetcode;

import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
public class LeetCode_26 {
    public static int removeDuplicates(int[] nums) {
// Brute Force Approach 
        Set<Integer> set = new LinkedHashSet<>();
        for(int i : nums)
        {
            set.add(i);
        }
        int k = 0;
        for(int i : set)
        {
            nums[k] = i;
            k++;
        }

        return k;


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array nums: ");
        int n_nums = sc.nextInt();
        int[] nums = new int[n_nums];
        System.out.println("Enter " + n_nums + " integers for nums: ");
        for (int i = 0; i < n_nums; i++) {
            nums[i] = sc.nextInt();
        }

        int result = removeDuplicates(nums);
        System.out.println("Result: " + result);

        sc.close();
    }
}