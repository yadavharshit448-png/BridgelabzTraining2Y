package string;

public class Q10_RemoveDuplicates {
    /**
     * 10. Removes duplicate characters from a string using recursion.
     * Preserves the first occurrence of each character.
     */
    public static String removeDuplicates(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        boolean[] seen = new boolean[256];
        return removeDuplicatesHelper(str, 0, seen);
    }

    private static String removeDuplicatesHelper(String str, int index, boolean[] seen) {
        // Base case: processed all characters
        if (index >= str.length()) {
            return "";
        }
        char ch = str.charAt(index);
        if (seen[ch]) {
            // Skip duplicate character
            return removeDuplicatesHelper(str, index + 1, seen);
        }
        // Mark as seen and include current character
        seen[ch] = true;
        return ch + removeDuplicatesHelper(str, index + 1, seen);
    }

    public static void main(String[] args) {
        String s1 = "banana";
        String s2 = "programming";
        String s3 = "hello";
        String s4 = "aaaaa";

        System.out.println("removeDuplicates(\"" + s1 + "\") -> \"" + removeDuplicates(s1) + "\"");
        System.out.println("removeDuplicates(\"" + s2 + "\") -> \"" + removeDuplicates(s2) + "\"");
        System.out.println("removeDuplicates(\"" + s3 + "\") -> \"" + removeDuplicates(s3) + "\"");
        System.out.println("removeDuplicates(\"" + s4 + "\") -> \"" + removeDuplicates(s4) + "\"");
    }
}
