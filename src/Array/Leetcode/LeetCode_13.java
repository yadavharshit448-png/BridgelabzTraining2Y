package Array.Leetcode;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_13 {
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = map.getOrDefault(s.charAt(i), 0);
            if (curr < prev) {
                total -= curr;
            } else {
                total += curr;
            }
            prev = curr;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Roman numeral (e.g. III, LVIII, MCMXCIV): ");
        String s = sc.next();

        int result = romanToInt(s);
        System.out.println("Result: " + result);

        sc.close();
    }
}
