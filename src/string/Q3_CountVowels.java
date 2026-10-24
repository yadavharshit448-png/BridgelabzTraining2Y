package string;

public class Q3_CountVowels {
    /**
     * 3. Counts the vowels in a string using recursion.
     */
    public static int countVowels(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        return countVowelsHelper(str, 0);
    }

    private static int countVowelsHelper(String str, int index) {
        // Base case: reached end of string
        if (index >= str.length()) {
            return 0;
        }
        char ch = Character.toLowerCase(str.charAt(index));
        int isVowel = (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') ? 1 : 0;
        return isVowel + countVowelsHelper(str, index + 1);
    }

    public static void main(String[] args) {
        String s1 = "Recursion";
        String s2 = "Bridgelabz";
        String s3 = "xyz";
        String s4 = "AEIOUaeiou";

        System.out.println("Vowels in \"" + s1 + "\": " + countVowels(s1));
        System.out.println("Vowels in \"" + s2 + "\": " + countVowels(s2));
        System.out.println("Vowels in \"" + s3 + "\": " + countVowels(s3));
        System.out.println("Vowels in \"" + s4 + "\": " + countVowels(s4));
    }
}
