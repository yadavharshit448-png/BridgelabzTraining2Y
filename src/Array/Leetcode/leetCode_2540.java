package Array.Leetcode;

import java.util.Scanner;

public class leetCode_2540 {
    public static int getCommon(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of nums1: ");
        int n1 = sc.nextInt();
        int[] nums1 = new int[n1];
        System.out.println("Enter sorted elements for nums1: ");
        for (int i = 0; i < n1; i++) {
            nums1[i] = sc.nextInt();
        }

        System.out.print("Enter size of nums2: ");
        int n2 = sc.nextInt();
        int[] nums2 = new int[n2];
        System.out.println("Enter sorted elements for nums2: ");
        for (int i = 0; i < n2; i++) {
            nums2[i] = sc.nextInt();
        }

        int result = getCommon(nums1, nums2);
        System.out.println("Result (minimum common value): " + result);

        sc.close();
    }
}
