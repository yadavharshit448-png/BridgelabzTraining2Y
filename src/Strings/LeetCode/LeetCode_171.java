package Strings.LeetCode;

import java.util.Scanner;

public class LeetCode_171 {
    public static int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            result = result * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Excel column title (e.g. A, AB, ZY): ");
        String columnTitle = sc.next();

        int result = titleToNumber(columnTitle);
        System.out.println("Result: " + result);

        sc.close();
    }
}
