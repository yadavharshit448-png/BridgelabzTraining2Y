package Array.assigment;

import java.util.Scanner;

/**
 * Question 7 - Level 2: Team BMI Calculator (2D Multi-Dimensional Array)
 *
 * Description:
 * Rewrites the BMI problem utilizing a 2D array (personData[N][3]) where:
 *   - Column 0: Weight (kg)
 *   - Column 1: Height (m)
 *   - Column 2: Calculated BMI
 * And a 1D String array (weightStatus[N]) for health categorization.
 *
 * Best Programming Practices Followed:
 * 1. Column indices declared as constants (COL_WEIGHT, COL_HEIGHT, COL_BMI).
 * 2. Proper validation against negative or zero entries.
 * 3. Array length properties used in loops.
 * 4. Structured tabular output.
 */
public class Q7_Level2 {

    public static void main(String[] args) {
        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Column constants for readability
        final int COL_WEIGHT = 0;
        final int COL_HEIGHT = 1;
        final int COL_BMI = 2;
        final int TOTAL_COLUMNS = 3;

        System.out.print("Enter the number of persons in the team: ");
        int numberOfPersons = scanner.nextInt();

        // Validate number of persons
        if (numberOfPersons <= 0) {
            System.err.println("Invalid input! Number of persons must be positive.");
            scanner.close();
            return;
        }

        // Multi-dimensional array: rows = persons, columns = [weight, height, BMI]
        double[][] personData = new double[numberOfPersons][TOTAL_COLUMNS];

        // 1D String array for weight status
        String[] weightStatus = new String[numberOfPersons];

        System.out.println("\nEnter weight (kg) and height (meters) for each person:\n");

        // Input and computation loop
        for (int i = 0; i < personData.length; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.print("  Weight in kg: ");
            double weight = scanner.nextDouble();

            System.out.print("  Height in meters: ");
            double height = scanner.nextDouble();

            // Validate positive values
            while (weight <= 0.0 || height <= 0.0) {
                System.err.println("  Invalid input! Both weight and height must be positive numbers. Please re-enter.");
                System.out.print("  Weight in kg: ");
                weight = scanner.nextDouble();
                System.out.print("  Height in meters: ");
                height = scanner.nextDouble();
            }

            // Store weight and height
            personData[i][COL_WEIGHT] = weight;
            personData[i][COL_HEIGHT] = height;

            // Calculate and store BMI in 2D array
            double bmi = weight / (height * height);
            personData[i][COL_BMI] = bmi;

            // Determine status
            if (bmi <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmi <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmi <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display results from 2D array
        System.out.println("\n---------------------- 2D Matrix BMI Report ----------------------");
        System.out.printf("%-10s %-14s %-14s %-12s %-14s\n", "Person", "Weight (kg)", "Height (m)", "BMI", "Status");
        System.out.println("-------------------------------------------------------------------");

        for (int i = 0; i < personData.length; i++) {
            System.out.printf("Person %-3d %-14.2f %-14.2f %-12.2f %-14s\n",
                    (i + 1), personData[i][COL_WEIGHT], personData[i][COL_HEIGHT],
                    personData[i][COL_BMI], weightStatus[i]);
        }
        System.out.println("-------------------------------------------------------------------");

        // Close scanner
        scanner.close();
    }
}
