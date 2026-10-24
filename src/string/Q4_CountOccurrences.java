package string;

public class Q4_CountOccurrences {
    /**
     * 4. Counts the occurrences of a given character in a string using recursion.
     */
    public static int countOccurrences(String str, char target) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        return countOccurrencesHelper(str, target, 0);
    }

    private static int countOccurrencesHelper(String str, char target, int index) {
        // Base case: end of string reached
        if (index >= str.length()) {
            return 0;
        }
        int match = (str.charAt(index) == target) ? 1 : 0;
        return match + countOccurrencesHelper(str, target, index + 1);
    }

    public static void main(String[] args) {
        String s = "banana";
        char target1 = 'a';
        char target2 = 'n';
        char target3 = 'z';

        System.out.println("Occurrences of '" + target1 + "' in \"" + s + "\": " + countOccurrences(s, target1));
        System.out.println("Occurrences of '" + target2 + "' in \"" + s + "\": " + countOccurrences(s, target2));
        System.out.println("Occurrences of '" + target3 + "' in \"" + s + "\": " + countOccurrences(s, target3));
    }
}
