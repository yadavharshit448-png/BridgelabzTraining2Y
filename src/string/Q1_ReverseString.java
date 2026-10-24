package string;

public class Q1_ReverseString {
    /**
     * 1. Reverses a string using recursion.
     * Base case: If string is null or has length <= 1, return the string.
     * Recursive step: reverse(remaining string) + first character.
     */
    public static String reverse(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "Recursion";
        String s3 = "a";
        String s4 = "";

        System.out.println("Original: \"" + s1 + "\" -> Reversed: \"" + reverse(s1) + "\"");
        System.out.println("Original: \"" + s2 + "\" -> Reversed: \"" + reverse(s2) + "\"");
        System.out.println("Original: \"" + s3 + "\" -> Reversed: \"" + reverse(s3) + "\"");
        System.out.println("Original: \"\" -> Reversed: \"" + reverse(s4) + "\"");
    }
}
