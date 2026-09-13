package Strings.LeetCode;

import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
import java.util.*;
public class LeetCode_567 {
    public static boolean checkInclusion(String s1, String s2) {
        
        if(s2.length()<s1.length())
        {
            return false;
        }
        int window = s1.length();
        int length = s2.length();

        int[] S1arr= new int[26];
        int[] S2arr= new int[26];

        for(int i =0;i<window;i++){
            S1arr[s1.charAt(i)-'a']++;
            S2arr[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(S1arr,S2arr)){
            return true;
        }
        for(int i = 1;i<=s2.length()-s1.length();i++){
            S2arr[s2.charAt(i-1)-'a']--;
            S2arr[s2.charAt(i+s1.length()-1)-'a']++;
            if(Arrays.equals(S1arr,S2arr)){
            return true;
        }
        }
        
        return false;
       

        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter s1: ");
        String s1 = sc.next();

        System.out.print("Enter s2: ");
        String s2 = sc.next();

        boolean result = checkInclusion(s1, s2);
        System.out.println("Result: " + result);

        sc.close();
    }
}