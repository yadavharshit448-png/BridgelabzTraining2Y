package Strings.Assignment;

/**
 * Question 8 - Level 2: Student Voting Eligibility (2D String Array)
 *
 * Description:
 * Generates random 2-digit ages for 10 students, evaluates their voting eligibility
 * (age >= 18), stores records in a 2D String array [age, canVote], and displays
 * them in a tabular format.
 */
public class Q8_Level2 {

    /**
     * Generates an array of random 2-digit ages (10 to 99).
     */
    public static int[] generateRandomAges(int count) {
        int[] ages = new int[count];
        for (int i = 0; i < count; i++) {
            // Random age between 10 and 99
            ages[i] = 10 + (int) (Math.random() * 90);
        }
        return ages;
    }

    /**
     * Creates 2D String array of [age, "true"/"false"].
     */
    public static String[][] evaluateVotingEligibility(int[] ages) {
        String[][] eligibilityTable = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            eligibilityTable[i][0] = String.valueOf(age);

            // Validate age and check voting rule (age >= 18)
            if (age < 0) {
                eligibilityTable[i][1] = "false";
            } else if (age >= 18) {
                eligibilityTable[i][1] = "true";
            } else {
                eligibilityTable[i][1] = "false";
            }
        }
        return eligibilityTable;
    }

    /**
     * Displays voting eligibility in a table.
     */
    public static void displayTable(String[][] table) {
        System.out.println("----------------------------------------------");
        System.out.printf("%-12s %-10s %-16s\n", "Student", "Age", "Can Vote?");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < table.length; i++) {
            System.out.printf("Student %-5d %-10s %-16s\n", (i + 1), table[i][0], table[i][1]);
        }
        System.out.println("----------------------------------------------");
    }

    public static void main(String[] args) {
        final int TOTAL_STUDENTS = 10;

        System.out.println("=== Student Voting Eligibility Checker (10 Students) ===\n");

        int[] studentAges = generateRandomAges(TOTAL_STUDENTS);
        String[][] eligibilityRecords = evaluateVotingEligibility(studentAges);
        displayTable(eligibilityRecords);
    }
}
