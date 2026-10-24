package string;

public class Q9_CheckStringsEqual {
    /**
     * 9. Checks whether two strings are equal without using equals().
     * Recursively compares characters from left to right.
     */
    public static boolean areEqual(String s1, String s2) {
        // If both point to the same reference or both are null
        if (s1 == s2) {
            return true;
        }
        // If only one is null
        if (s1 == null || s2 == null) {
            return false;
        }
        // If both are empty strings
        if (s1.isEmpty() && s2.isEmpty()) {
            return true;
        }
        // If one is empty while the other is not
        if (s1.isEmpty() || s2.isEmpty()) {
            return false;
        }
        // If current characters differ
        if (s1.charAt(0) != s2.charAt(0)) {
            return false;
        }
        // Recurse on remaining substrings
        return areEqual(s1.substring(1), s2.substring(1));
    }

    public static void main(String[] args) {
        System.out.println("areEqual(\"hello\", \"hello\"): " + areEqual("hello", "hello"));
        System.out.println("areEqual(\"hello\", \"world\"): " + areEqual("hello", "world"));
        System.out.println("areEqual(\"java\", \"jav\"): " + areEqual("java", "jav"));
        System.out.println("areEqual(\"\", \"\"): " + areEqual("", ""));
        System.out.println("areEqual(null, null): " + areEqual(null, null));
        System.out.println("areEqual(\"abc\", null): " + areEqual("abc", null));
    }
}
