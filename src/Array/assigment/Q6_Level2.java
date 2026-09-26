package Array.assigment;

import java.util.Scanner;

/**
 * Question 6 - Level 2: Team Body Mass Index (BMI) Calculator (1D Arrays)
 *
 * Description:
 * Evaluates the Body Mass Index (BMI) and health status for all members in a team
 * using 1D arrays for weight, height, BMI, and status strings.
 *
 * Classification:
 *   BMI <= 18.4    : Underweight
 *   18.5 - 24.9    : Normal
 *   25.0 - 39.9    : Overweight
 *   >= 40.0        : Obese
 *
 * Best Programming Practices Followed:
 * 1. Team size dynamically inputted and validated (> 0).
 * 2. Proper variable declarations and status thresholds.
 * 3. Array length property used in loops.
 * 4. Structured tabular output.
 */
public class Q6_Level2 {

    public static void main(String[] args) {
        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of persons in the team: ");
        int numberOfPersons = scanner.nextInt();

        // Validate number of persons
        if (numberOfPersons <= 0) {
            System.err.println("Invalid input! Number of persons must be greater than 0.");
            scanner.close();
            return;
        }

        // 1D Arrays to store person details
        double[] weights = new double[numberOfPersons];
        double[] heights = new double[numberOfPersons];
        double[] bmis = new double[numberOfPersons];
        String[] weightStatuses = new String[numberOfPersons];

        System.out.println("\nEnter weight (kg) and height (meters) for each person:\n");

        // Input loop with validation
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.print("  Weight in kg: ");
            double weight = scanner.nextDouble();

            System.out.print("  Height in meters (e.g., 1.75): ");
            double height = scanner.nextDouble();

            // Validate positive values
            while (weight <= 0.0 || height <= 0.0) {
                System.err.println("  Invalid input! Both weight and height must be positive numbers. Please re-enter.");
                System.out.print("  Weight in kg: ");
                weight = scanner.nextDouble();
                System.out.print("  Height in meters: ");
                height = scanner.nextDouble();
            }

            weights[i] = weight;
            heights[i] = height;

            // Calculate BMI: weight / (height * height)
            double bmi = weight / (height * height);
            bmis[i] = bmi;

            // Determine weight status based on reference table
            if (bmi <= 18.4) {
                weightStatuses[i] = "Underweight";
            } else if (bmi <= 24.9) {
                weightStatuses[i] = "Normal";
            } else if (bmi <= 39.9) {
                weightStatuses[i] = "Overweight";
            } else {
                weightStatuses[i] = "Obese";
            }
        }

        // Display results in tabular format
        System.out.println("\n------------------------- Team BMI Report -------------------------");
        System.out.printf("%-10s %-14s %-14s %-12s %-14s\n", "Person", "Weight (kg)", "Height (m)", "BMI", "Status");
        System.out.println("-------------------------------------------------------------------");

        for (int i = 0; i < numberOfPersons; i++) {
            System.out.printf("Person %-3d %-14.2f %-14.2f %-12.2f %-14s\n",
                    (i + 1), weights[i], heights[i], bmis[i], weightStatuses[i]);
        }
        System.out.println("-------------------------------------------------------------------");

        // Close scanner
        scanner.close();
    }
}
