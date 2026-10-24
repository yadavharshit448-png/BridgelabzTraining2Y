package string;

public class Q8_StringLength {
    /**
     * 8. Finds the length of a string without using length().
     * Uses recursion by attempting to access the first character with charAt(0)
     * and catching IndexOutOfBoundsException when the string is empty.
     */
    public static int findLength(String str) {
        if (str == null) {
            return 0;
        }
        try {
            str.charAt(0);
            return 1 + findLength(str.substring(1));
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        String s1 = "hello world";
        String s2 = "";
        String s3 = "Recursion";
        String s4 = "Bridgelabz Training";

        System.out.println("Length of \"" + s1 + "\": " + findLength(s1));
        System.out.println("Length of empty string: " + findLength(s2));
        System.out.println("Length of \"" + s3 + "\": " + findLength(s3));
        System.out.println("Length of \"" + s4 + "\": " + findLength(s4));
    }
}
