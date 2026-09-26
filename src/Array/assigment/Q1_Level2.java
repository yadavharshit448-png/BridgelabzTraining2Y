package Array.assigment;

import java.util.Scanner;

/**
 * Question 1 - Level 2: Zara Employee Bonus and Salary Calculator
 *
 * Description:
 * Calculates the bonus (5% for > 5 years, 2% otherwise) and updated salary for 10
 * employees at Zara based on their years of service. Computes total old salary,
 * total bonus payout, and total new salary.
 *
 * Best Programming Practices Followed:
 * 1. Fixed values as constants (TOTAL_EMPLOYEES, HIGH_BONUS_RATE, etc.).
 * 2. Proper variable declarations and naming conventions.
 * 3. Input validation with loop index decrement (i--) on invalid entries.
 * 4. Array length property used in loops.
 * 5. Comprehensive step-by-step comments.
 */
public class Q1_Level2 {

    public static void main(String[] args) {
        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Fixed constants
        final int TOTAL_EMPLOYEES = 10;
        final double SERVICE_THRESHOLD_YEARS = 5.0;
        final double HIGH_BONUS_PERCENTAGE = 0.05; // 5% for > 5 years
        final double LOW_BONUS_PERCENTAGE = 0.02;  // 2% for <= 5 years

        // Double arrays to store old salary and years of service
        double[] oldSalaries = new double[TOTAL_EMPLOYEES];
        double[] yearsOfService = new double[TOTAL_EMPLOYEES];

        // Double arrays to store calculated bonus and new salary
        double[] bonusAmounts = new double[TOTAL_EMPLOYEES];
        double[] newSalaries = new double[TOTAL_EMPLOYEES];

        // Accumulator variables
        double totalOldSalary = 0.0;
        double totalBonus = 0.0;
        double totalNewSalary = 0.0;

        System.out.println("=== Zara Employee Bonus & Salary Management ===");
        System.out.println("Enter salary and years of service for " + TOTAL_EMPLOYEES + " employees:\n");

        // Loop 1: Input collection with validation
        for (int i = 0; i < oldSalaries.length; i++) {
            System.out.println("Employee " + (i + 1) + ":");
            System.out.print("  Enter salary: ");
            double salaryInput = scanner.nextDouble();
            System.out.print("  Enter years of service: ");
            double serviceInput = scanner.nextDouble();

            // Validate: salary must be positive, years of service must be non-negative
            if (salaryInput <= 0.0 || serviceInput < 0.0) {
                System.err.println("  Invalid input! Salary must be > 0 and service years >= 0. Please re-enter.");
                i--; // Decrement index counter to re-enter for this employee
                continue;
            }

            oldSalaries[i] = salaryInput;
            yearsOfService[i] = serviceInput;
        }

        // Loop 2: Calculation of bonus, new salary, and totals
        for (int i = 0; i < oldSalaries.length; i++) {
            double currentSalary = oldSalaries[i];
            double currentService = yearsOfService[i];
            double bonusRate;

            // Conditional check for bonus rate based on service years
            if (currentService > SERVICE_THRESHOLD_YEARS) {
                bonusRate = HIGH_BONUS_PERCENTAGE;
            } else {
                bonusRate = LOW_BONUS_PERCENTAGE;
            }

            double currentBonus = currentSalary * bonusRate;
            double currentNewSalary = currentSalary + currentBonus;

            // Store in arrays
            bonusAmounts[i] = currentBonus;
            newSalaries[i] = currentNewSalary;

            // Accumulate totals
            totalOldSalary += currentSalary;
            totalBonus += currentBonus;
            totalNewSalary += currentNewSalary;
        }

        // Display results
        System.out.println("\n----------------- Employee Summary Report -----------------");
        System.out.printf("%-12s %-14s %-10s %-12s %-14s\n", "Employee", "Old Salary", "Service", "Bonus", "New Salary");
        for (int i = 0; i < oldSalaries.length; i++) {
            System.out.printf("Emp %-8d $%-13.2f %-10.1f $%-11.2f $%-13.2f\n",
                    (i + 1), oldSalaries[i], yearsOfService[i], bonusAmounts[i], newSalaries[i]);
        }

        System.out.println("-----------------------------------------------------------");
        System.out.printf("Total Old Salary   : $%.2f\n", totalOldSalary);
        System.out.printf("Total Bonus Payout : $%.2f\n", totalBonus);
        System.out.printf("Total New Salary   : $%.2f\n", totalNewSalary);
        System.out.println("-----------------------------------------------------------");

        // Close scanner
        scanner.close();
    }
}
