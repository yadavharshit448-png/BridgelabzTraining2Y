package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 10 - Level 2: Student Scorecard Generator (PCM)
 *
 * Description:
 * Generates random 2-digit PCM (Physics, Chemistry, Maths) scores for N students,
 * computes total, average, and percentages rounded to 2 decimal places using Math.round(),
 * assigns grades based on academic tiers, and outputs a formatted scorecard.
 */
public class Q10_Level2 {

    /**
     * Generates random 2-digit scores (10 to 99) for Physics, Chemistry, and Maths.
     */
    public static int[][] generatePCMScores(int students) {
        int[][] scores = new int[students][3];
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 10 + (int) (Math.random() * 90);
            }
        }
        return scores;
    }

    /**
     * Calculates total, average, and percentage for each student.
     * Values rounded to 2 decimal places using Math.round().
     *
     * @return 2D double array: [i][0]=Total, [i][1]=Average, [i][2]=Percentage
     */
    public static double[][] calculateMetrics(int[][] scores) {
        double[][] metrics = new double[scores.length][3];

        for (int i = 0; i < scores.length; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100.0;

            // Round to 2 decimal places using Math.round()
            double roundedAverage = Math.round(average * 100.0) / 100.0;
            double roundedPercentage = Math.round(percentage * 100.0) / 100.0;

            metrics[i][0] = total;
            metrics[i][1] = roundedAverage;
            metrics[i][2] = roundedPercentage;
        }

        return metrics;
    }

    /**
     * Calculates grades based on percentage.
     */
    public static String[] calculateGrades(double[][] metrics) {
        String[] grades = new String[metrics.length];

        for (int i = 0; i < metrics.length; i++) {
            double pct = metrics[i][2];
            if (pct >= 80.0) {
                grades[i] = "A";
            } else if (pct >= 70.0) {
                grades[i] = "B";
            } else if (pct >= 60.0) {
                grades[i] = "C";
            } else if (pct >= 50.0) {
                grades[i] = "D";
            } else if (pct >= 40.0) {
                grades[i] = "E";
            } else {
                grades[i] = "R";
            }
        }
        return grades;
    }

    /**
     * Displays scorecard in tabular format.
     */
    public static void displayScorecard(int[][] scores, double[][] metrics, String[] grades) {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%-10s %-8s %-10s %-8s %-8s %-10s %-12s %-6s\n",
                "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Percentage", "Grade");
        System.out.println("-----------------------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("Student %-2d %-8d %-10d %-8d %-8.0f %-10.2f %-11.2f%% %-6s\n",
                    (i + 1), scores[i][0], scores[i][1], scores[i][2],
                    metrics[i][0], metrics[i][1], metrics[i][2], grades[i]);
        }
        System.out.println("-----------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Student Scorecard Generator ===");
        System.out.print("Enter number of students: ");
        int students = scanner.nextInt();

        if (students <= 0) {
            System.err.println("Student count must be positive.");
            scanner.close();
            return;
        }

        int[][] scores = generatePCMScores(students);
        double[][] metrics = calculateMetrics(scores);
        String[] grades = calculateGrades(metrics);

        displayScorecard(scores, metrics, grades);

        scanner.close();
    }
}
