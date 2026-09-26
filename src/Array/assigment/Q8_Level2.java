package Array.assigment;

import java.util.Scanner;

/**
 * Question 8 - Level 2: Student Examination Grade Evaluation (1D Arrays)
 *
 * Description:
 * Evaluates student performance across 3 subjects (Physics, Chemistry, Maths),
 * calculates aggregate percentage, and assigns grades based on academic standards:
 *   >= 80%    : Grade A (Level 4, above standards)
 *   70% - 79% : Grade B (Level 3, at standards)
 *   60% - 69% : Grade C (Level 2, below standards)
 *   50% - 59% : Grade D (Level 1, well below standards)
 *   40% - 49% : Grade E (Level 1-, too below standards)
 *   <= 39%    : Grade R (Remedial standards)
 *
 * Best Programming Practices Followed:
 * 1. Fixed subject count and maximum possible marks as constants.
 * 2. Input validation for marks (0 to 100) with index decrement (i--).
 * 3. Array length property used in loops.
 * 4. Tabular formatted output.
 */
public class Q8_Level2 {

    public static void main(String[] args) {
        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Subject constants
        final int TOTAL_SUBJECTS = 3;
        final double MAX_MARKS_PER_SUBJECT = 100.0;
        final double MAX_TOTAL_MARKS = TOTAL_SUBJECTS * MAX_MARKS_PER_SUBJECT;

        System.out.print("Enter the number of students: ");
        int totalStudents = scanner.nextInt();

        // Validate number of students
        if (totalStudents <= 0) {
            System.err.println("Invalid input! Number of students must be positive.");
            scanner.close();
            return;
        }

        // 1D Arrays for each subject
        int[] physicsMarks = new int[totalStudents];
        int[] chemistryMarks = new int[totalStudents];
        int[] mathsMarks = new int[totalStudents];

        // Arrays for results
        double[] percentages = new double[totalStudents];
        char[] grades = new char[totalStudents];

        System.out.println("\nEnter marks (0 - 100) for each student:\n");

        // Input loop with validation
        for (int i = 0; i < totalStudents; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.print("  Physics marks: ");
            int phy = scanner.nextInt();
            System.out.print("  Chemistry marks: ");
            int chem = scanner.nextInt();
            System.out.print("  Maths marks: ");
            int math = scanner.nextInt();

            // Validate marks range [0, 100]
            if (phy < 0 || phy > 100 || chem < 0 || chem > 100 || math < 0 || math > 100) {
                System.err.println("  Invalid marks! All marks must be between 0 and 100. Please re-enter.");
                i--; // Decrement index counter to re-enter
                continue;
            }

            physicsMarks[i] = phy;
            chemistryMarks[i] = chem;
            mathsMarks[i] = math;

            // Compute total and percentage
            double totalObtained = phy + chem + math;
            double percentage = (totalObtained / MAX_TOTAL_MARKS) * 100.0;
            percentages[i] = percentage;

            // Determine grade based on percentage criteria
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

        // Display results
        System.out.println("\n---------------------------- Student Report Card ----------------------------");
        System.out.printf("%-10s %-10s %-12s %-10s %-14s %-8s\n",
                "Student", "Physics", "Chemistry", "Maths", "Percentage", "Grade");
        System.out.println("-----------------------------------------------------------------------------");

        for (int i = 0; i < totalStudents; i++) {
            System.out.printf("Student %-2d %-10d %-12d %-10d %-13.2f%% %-8c\n",
                    (i + 1), physicsMarks[i], chemistryMarks[i], mathsMarks[i],
                    percentages[i], grades[i]);
        }
        System.out.println("-----------------------------------------------------------------------------");

        // Close scanner
        scanner.close();
    }
}
