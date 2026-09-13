package Strings.LeetCode;

import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
public class LeetCode_438 {
    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (s.length() < p.length()) {
            return ans;
        }

        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
            windowFreq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= s.length() - p.length(); i++) {

            if (Arrays.equals(pFreq, windowFreq)) {
                ans.add(i);
            }

            
            if (i + p.length() < s.length()) {
                windowFreq[s.charAt(i) - 'a']--;
                windowFreq[s.charAt(i + p.length()) - 'a']++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter s: ");
        String s = sc.next();

        System.out.print("Enter p: ");
        String p = sc.next();

        List<Integer> result = findAnagrams(s, p);
        System.out.println("Result: " + result);

        sc.close();
    }
}