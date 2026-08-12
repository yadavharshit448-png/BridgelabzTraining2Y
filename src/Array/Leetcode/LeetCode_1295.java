package Array.Leetcode;

import java.util.Scanner;

public class LeetCode_1295 {
    public static int findNumbers(int[] nums) {
        int count = 0;

        for(int i = 0; i<nums.length;i++){
            if(nums[i]>9 && nums[i]<99 || nums[i]>999 && nums[i]<10000 || nums[i]==100000){
                count++;
            }
        }
        return count;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i<n;i++){
             nums[i]=sc.nextInt();
        }
        System.out.println("the count is "+ findNumbers(nums));
    }


}
