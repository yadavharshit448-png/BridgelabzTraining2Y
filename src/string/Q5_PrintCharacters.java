package string;

public class Q5_PrintCharacters {
    /**
     * 5. Prints each character of a string on a new line using recursion.
     */
    public static void printCharacters(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        printHelper(str, 0);
    }

    private static void printHelper(String str, int index) {
        // Base case: end of string
        if (index >= str.length()) {
            return;
        }
        System.out.println(str.charAt(index));
        printHelper(str, index + 1);
    }

    public static void main(String[] args) {
        String s = "Hello";
        System.out.println("Characters of \"" + s + "\" on new lines:");
        printCharacters(s);
    }
}
