package Array.assigment;

import java.util.Scanner;

/**
 * Question 1 - Level 1: Voting Eligibility Checker
 *
 * Description:
 * Takes user input for the age of 10 students in a class and checks whether each
 * student is eligible to vote (age >= 18).
 *
 * Best Programming Practices Followed:
 * 1. Constant variables for fixed values (TOTAL_STUDENTS, MIN_VOTING_AGE).
 * 2. Proper variable naming conventions.
 * 3. Validation for negative or invalid age input.
 * 4. Array length property used in loops.
 * 5. Comprehensive comments for each logical section.
 */
public class Q1_Level1 {

    public static void main(String[] args) {
        // Scanner object for capturing user input
        Scanner scanner = new Scanner(System.in);

        // Fixed constants
        final int TOTAL_STUDENTS = 10;
        final int MIN_VOTING_AGE = 18;

        // Array declaration to store ages of 10 students
        int[] studentAges = new int[TOTAL_STUDENTS];

        System.out.println("=== Student Voting Eligibility Checker ===");
        System.out.println("Please enter the age for " + TOTAL_STUDENTS + " students:\n");

        // Loop to take input for each student
        for (int i = 0; i < studentAges.length; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            int inputAge = scanner.nextInt();

            // Validate user input: check for negative age
            if (inputAge < 0) {
                System.err.println("Invalid age entered! Age cannot be negative. Setting to -1.");
                studentAges[i] = -1; // Mark as invalid
            } else {
                studentAges[i] = inputAge;
            }
        }

        System.out.println("\n--- Voting Eligibility Results ---");

        // Loop through the array using length property to evaluate eligibility
        for (int i = 0; i < studentAges.length; i++) {
            int currentAge = studentAges[i];

            // Conditional check for eligibility and validity
            if (currentAge < 0) {
                System.out.println("Student " + (i + 1) + ": Invalid age entered.");
            } else if (currentAge >= MIN_VOTING_AGE) {
                System.out.println("The student with the age " + currentAge + " can vote.");
            } else {
                System.out.println("The student with the age " + currentAge + " cannot vote.");
            }
        }

        // Close scanner resource
        scanner.close();
    }
}
