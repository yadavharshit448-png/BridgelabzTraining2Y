package Strings.LeetCode;

import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
public class LeetCode_1876 {
    public static int countGoodSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length() - 2; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);

            if (a != b && b != c && a != c) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter s: ");
        String s = sc.next();

        int result = countGoodSubstrings(s);
        System.out.println("Result: " + result);

        sc.close();
    }
}