package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 9 - Level 3: Gregorian Calendar Display
 *
 * Description:
 * Takes month (1-12) and year from the user and prints the calendar for that month
 * using the Gregorian calendar algorithm to find the first day of the week.
 */
public class Q9_Level3 {

    private static final String[] MONTH_NAMES = {
        "", "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };

    private static final int[] DAYS_IN_MONTH = {
        0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    /**
     * Checks if a year is a Leap Year.
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * Returns name of the month.
     */
    public static String getMonthName(int month) {
        if (month >= 1 && month <= 12) {
            return MONTH_NAMES[month];
        }
        return "Invalid";
    }

    /**
     * Returns total days in a given month and year.
     */
    public static int getNumberOfDays(int month, int year) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return DAYS_IN_MONTH[month];
    }

    /**
     * Calculates the starting day of the week (0=Sun, 1=Mon, ..., 6=Sat)
     * using the Gregorian Calendar Algorithm for day d = 1.
     */
    public static int getStartDay(int d, int m, int y) {
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
        return d0;
    }

    /**
     * Displays formatted calendar grid.
     */
    public static void displayCalendar(int month, int year) {
        String monthName = getMonthName(month);
        int totalDays = getNumberOfDays(month, year);
        int startDay = getStartDay(1, month, year); // 0 = Sun, 1 = Mon, ..., 6 = Sat

        System.out.println("\n  " + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // Loop 1: Print leading spaces for offset before day 1
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        // Loop 2: Display days of the month
        for (int day = 1; day <= totalDays; day++) {
            System.out.printf("%3d ", day);

            // Move to next line after Saturday
            if ((day + startDay) % 7 == 0 || day == totalDays) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Gregorian Calendar Generator ===");
        System.out.print("Enter month (1 - 12): ");
        int month = scanner.nextInt();

        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        if (month < 1 || month > 12 || year < 1) {
            System.err.println("Invalid month or year entered.");
            scanner.close();
            return;
        }

        displayCalendar(month, year);

        scanner.close();
    }
}
