package string;

public class Q6_RemoveCharacter {
    /**
     * 6. Removes all occurrences of a character from a string using recursion.
     */
    public static String removeChar(String str, char target) {
        // Base case: empty or null string
        if (str == null || str.isEmpty()) {
            return str;
        }
        char current = str.charAt(0);
        String remaining = removeChar(str.substring(1), target);

        // If current matches target, exclude it
        if (current == target) {
            return remaining;
        }
        // Otherwise, include it
        return current + remaining;
    }

    public static void main(String[] args) {
        String s = "banana";
        System.out.println("Remove 'a' from \"" + s + "\": " + removeChar(s, 'a'));
        System.out.println("Remove 'n' from \"" + s + "\": " + removeChar(s, 'n'));
        System.out.println("Remove 'b' from \"" + s + "\": " + removeChar(s, 'b'));
        System.out.println("Remove 'z' from \"" + s + "\": " + removeChar(s, 'z'));
    }
}
