package Array.assigment;

import java.util.Scanner;

/**
 * Question 9 - Level 2: Student Marks and Grades Evaluation (2D Array)
 *
 * Description:
 * Rewrites the student grade evaluation system using a 2D array (marks[N][3]) where:
 *   - Column 0: Physics
 *   - Column 1: Chemistry
 *   - Column 2: Maths
 * Computes individual percentages and assigns academic grades (A, B, C, D, E, R).
 *
 * Best Programming Practices Followed:
 * 1. Column indices declared as constants (PHYSICS_COL, CHEMISTRY_COL, MATHS_COL).
 * 2. Multi-dimensional array length properties used in loops.
 * 3. Input validation with index decrement.
 * 4. Structured tabular output.
 */
public class Q9_Level2 {

    public static void main(String[] args) {
        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Constants
        final int TOTAL_SUBJECTS = 3;
        final int PHYSICS_COL = 0;
        final int CHEMISTRY_COL = 1;
        final int MATHS_COL = 2;
        final double MAX_MARKS_PER_SUBJECT = 100.0;
        final double MAX_TOTAL_MARKS = TOTAL_SUBJECTS * MAX_MARKS_PER_SUBJECT;

        System.out.print("Enter the number of students: ");
        int totalStudents = scanner.nextInt();

        // Validate student count
        if (totalStudents <= 0) {
            System.err.println("Invalid input! Number of students must be positive.");
            scanner.close();
            return;
        }

        // 2D Array: rows = students, columns = subjects (Physics, Chemistry, Maths)
        int[][] marks = new int[totalStudents][TOTAL_SUBJECTS];

        // 1D Arrays for percentage and grade results
        double[] percentages = new double[totalStudents];
        char[] grades = new char[totalStudents];

        System.out.println("\nEnter marks (0 - 100) for each student:\n");

        // Input loop with nested column access
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.print("  Physics marks: ");
            int phy = scanner.nextInt();
            System.out.print("  Chemistry marks: ");
            int chem = scanner.nextInt();
            System.out.print("  Maths marks: ");
            int math = scanner.nextInt();

            // Validate range
            if (phy < 0 || phy > 100 || chem < 0 || chem > 100 || math < 0 || math > 100) {
                System.err.println("  Invalid marks! All marks must be between 0 and 100. Please re-enter.");
                i--; // Decrement index to re-enter
                continue;
            }

            marks[i][PHYSICS_COL] = phy;
            marks[i][CHEMISTRY_COL] = chem;
            marks[i][MATHS_COL] = math;

            // Compute total obtained and percentage
            double studentTotal = 0;
            for (int j = 0; j < marks[i].length; j++) {
                studentTotal += marks[i][j];
            }

            double percentage = (studentTotal / MAX_TOTAL_MARKS) * 100.0;
            percentages[i] = percentage;

            // Grade assignment
            if (percentage >= 80.0) {
                grades[i] = 'A';
            } else if (percentage >= 70.0) {
                grades[i] = 'B';
            } else if (percentage >= 60.0) {
                grades[i] = 'C';
            } else if (percentage >= 50.0) {
                grades[i] = 'D';
            } else if (percentage >= 40.0) {
                grades[i] = 'E';
            } else {
                grades[i] = 'R';
            }
        }

        // Display results table
        System.out.println("\n---------------------------- Student Report Card ----------------------------");
        System.out.printf("%-10s %-10s %-12s %-10s %-14s %-8s\n",
                "Student", "Physics", "Chemistry", "Maths", "Percentage", "Grade");
        System.out.println("-----------------------------------------------------------------------------");

        for (int i = 0; i < marks.length; i++) {
            System.out.printf("Student %-2d %-10d %-12d %-10d %-13.2f%% %-8c\n",
                    (i + 1), marks[i][PHYSICS_COL], marks[i][CHEMISTRY_COL], marks[i][MATHS_COL],
                    percentages[i], grades[i]);
        }
        System.out.println("-----------------------------------------------------------------------------");

        // Close scanner
        scanner.close();
    }
}
