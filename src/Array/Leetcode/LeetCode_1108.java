package Array.Leetcode;

import java.util.Scanner;

public class LeetCode_1108 {
    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter IP address (e.g. 1.1.1.1): ");
        String address = sc.next();

        String result = defangIPaddr(address);
        System.out.println("Result: " + result);

        sc.close();
    }
}
