package Array.Leetcode;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class LeetCode_1832 {
    public static boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for (char c : sentence.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                set.add(c);
            }
        }
        return set.size() == 26;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String sentence = sc.nextLine();

        boolean result = checkIfPangram(sentence);
        System.out.println("Result: " + result);

        sc.close();
    }
}
