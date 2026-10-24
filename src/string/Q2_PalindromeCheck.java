package string;

public class Q2_PalindromeCheck {
    /**
     * 2. Checks whether a string is a palindrome using recursion.
     * Compares characters from both ends moving inward.
     */
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        return isPalindromeHelper(str, 0, str.length() - 1);
    }

    private static boolean isPalindromeHelper(String str, int start, int end) {
        // Base case: converged or passed middle
        if (start >= end) {
            return true;
        }
        // If characters at boundary mismatch
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        // Recursive check for inner substring
        return isPalindromeHelper(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String[] testCases = {"radar", "madam", "racecar", "hello", "Java", "a", ""};
        for (String s : testCases) {
            System.out.println("\"" + s + "\" is palindrome? " + isPalindrome(s));
        }
    }
}
