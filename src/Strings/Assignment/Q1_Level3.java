package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 1 - Level 3: Team BMI Management System (10 Members)
 *
 * Description:
 * Inputs weight (kg) and height (cm) for 10 team members into a 2D array,
 * calculates BMI (converting cm to meters), categorizes health status, stores
 * records in a 2D String array [Height, Weight, BMI, Status], and displays the table.
 */
public class Q1_Level3 {

    /**
     * Calculates BMI and status for every person given [weight, heightCm].
     *
     * @param personMeasurements 2D array [10][2] with weight (kg) and height (cm)
     * @return 2D String array [Height (cm), Weight (kg), BMI, Status]
     */
    public static String[][] computeBMITable(double[][] personMeasurements) {
        String[][] bmiTable = new String[personMeasurements.length][4];

        for (int i = 0; i < personMeasurements.length; i++) {
            double weightKg = personMeasurements[i][0];
            double heightCm = personMeasurements[i][1];

            // Convert height from cm to meters
            double heightMeters = heightCm / 100.0;
            double bmi = weightKg / (heightMeters * heightMeters);

            // Determine health status
            String status;
            if (bmi <= 18.4) {
                status = "Underweight";
            } else if (bmi <= 24.9) {
                status = "Normal";
            } else if (bmi <= 39.9) {
                status = "Overweight";
            } else {
                status = "Obese";
            }

            bmiTable[i][0] = String.format("%.1f cm", heightCm);
            bmiTable[i][1] = String.format("%.1f kg", weightKg);
            bmiTable[i][2] = String.format("%.2f", bmi);
            bmiTable[i][3] = status;
        }

        return bmiTable;
    }

    /**
     * Displays the 2D String array in a tabular format.
     */
    public static void displayBMITable(String[][] bmiTable) {
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-10s %-14s %-14s %-12s %-14s\n", "Person", "Height", "Weight", "BMI", "Status");
        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < bmiTable.length; i++) {
            System.out.printf("Person %-3d %-14s %-14s %-12s %-14s\n",
                    (i + 1), bmiTable[i][0], bmiTable[i][1], bmiTable[i][2], bmiTable[i][3]);
        }
        System.out.println("------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int TOTAL_PERSONS = 10;

        double[][] personMeasurements = new double[TOTAL_PERSONS][2];

        System.out.println("=== Team Body Mass Index (10 Persons) ===");
        System.out.println("Enter weight (kg) and height (cm) for 10 persons:\n");

        for (int i = 0; i < TOTAL_PERSONS; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.print("  Weight in kg: ");
            double weight = scanner.nextDouble();
            System.out.print("  Height in cm (e.g., 175): ");
            double height = scanner.nextDouble();

            while (weight <= 0.0 || height <= 0.0) {
                System.err.println("  Invalid input! Both weight and height must be positive.");
                System.out.print("  Weight in kg: ");
                weight = scanner.nextDouble();
                System.out.print("  Height in cm: ");
                height = scanner.nextDouble();
            }

            personMeasurements[i][0] = weight;
            personMeasurements[i][1] = height;
        }

        String[][] bmiTable = computeBMITable(personMeasurements);
        displayBMITable(bmiTable);

        scanner.close();
    }
}
