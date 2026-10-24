package string;

public class Q7_ReplaceCharacter {
    /**
     * 7. Replaces every occurrence of 'a' with 'b' using recursion.
     */
    public static String replaceAWithB(String str) {
        // Base case: empty or null string
        if (str == null || str.isEmpty()) {
            return str;
        }
        char current = str.charAt(0);
        char replacement = current;

        if (current == 'a') {
            replacement = 'b';
        } else if (current == 'A') {
            replacement = 'B';
        }

        return replacement + replaceAWithB(str.substring(1));
    }

    public static void main(String[] args) {
        String s1 = "banana";
        String s2 = "Apple and avocado";
        String s3 = "cat bat rat";

        System.out.println("Original: \"" + s1 + "\" -> Result: \"" + replaceAWithB(s1) + "\"");
        System.out.println("Original: \"" + s2 + "\" -> Result: \"" + replaceAWithB(s2) + "\"");
        System.out.println("Original: \"" + s3 + "\" -> Result: \"" + replaceAWithB(s3) + "\"");
    }
}
