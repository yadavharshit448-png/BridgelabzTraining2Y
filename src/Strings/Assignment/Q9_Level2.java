package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 9 - Level 2: Rock-Paper-Scissors Simulation & Statistics
 *
 * Description:
 * Implements Rock-Paper-Scissors between User and Computer. Tracks outcomes
 * across multiple rounds in a 2D String array, calculates win statistics, and displays
 * reports in tabular format.
 */
public class Q9_Level2 {

    private static final String[] CHOICES = {"Rock", "Paper", "Scissors"};

    /**
     * Generates a random computer choice using Math.random().
     */
    public static String getComputerChoice() {
        int index = (int) (Math.random() * 3);
        return CHOICES[index];
    }

    /**
     * Determines winner between user and computer.
     * Rules: Rock beats Scissors, Scissors beats Paper, Paper beats Rock.
     *
     * @return "User", "Computer", or "Draw"
     */
    public static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equalsIgnoreCase(computerChoice)) {
            return "Draw";
        }
        if ((userChoice.equalsIgnoreCase("Rock") && computerChoice.equalsIgnoreCase("Scissors")) ||
            (userChoice.equalsIgnoreCase("Paper") && computerChoice.equalsIgnoreCase("Rock")) ||
            (userChoice.equalsIgnoreCase("Scissors") && computerChoice.equalsIgnoreCase("Paper"))) {
            return "User";
        }
        return "Computer";
    }

    /**
     * Calculates win counts and percentage stats in a 2D String array.
     */
    public static String[][] calculateStats(String[][] gameResults, int totalGames) {
        int userWins = 0;
        int computerWins = 0;
        int draws = 0;

        for (int i = 0; i < totalGames; i++) {
            String winner = gameResults[i][2];
            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) computerWins++;
            else draws++;
        }

        double userPercent = ((double) userWins / totalGames) * 100.0;
        double computerPercent = ((double) computerWins / totalGames) * 100.0;
        double drawPercent = ((double) draws / totalGames) * 100.0;

        return new String[][]{
            {"User", String.valueOf(userWins), String.format("%.2f%%", userPercent)},
            {"Computer", String.valueOf(computerWins), String.format("%.2f%%", computerPercent)},
            {"Draw", String.valueOf(draws), String.format("%.2f%%", drawPercent)}
        };
    }

    public static void displayResults(String[][] gameResults, String[][] stats) {
        System.out.println("\n-------------------- Match Log --------------------");
        System.out.printf("%-8s %-12s %-14s %-10s\n", "Game", "User Choice", "Computer Choice", "Winner");
        System.out.println("---------------------------------------------------");
        for (int i = 0; i < gameResults.length; i++) {
            System.out.printf("Round %-3d %-12s %-14s %-10s\n",
                    (i + 1), gameResults[i][0], gameResults[i][1], gameResults[i][2]);
        }
        System.out.println("---------------------------------------------------");

        System.out.println("\n----------------- Summary Stats -----------------");
        System.out.printf("%-12s %-10s %-14s\n", "Participant", "Wins", "Win Percentage");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < stats.length; i++) {
            System.out.printf("%-12s %-10s %-14s\n", stats[i][0], stats[i][1], stats[i][2]);
        }
        System.out.println("-------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Rock-Paper-Scissors Game ===");
        System.out.print("Enter number of rounds to play: ");
        int totalGames = scanner.nextInt();

        if (totalGames <= 0) {
            System.err.println("Number of games must be greater than 0.");
            scanner.close();
            return;
        }

        // 2D Array: [round][0]=userChoice, [1]=computerChoice, [2]=winner
        String[][] gameResults = new String[totalGames][3];

        for (int i = 0; i < totalGames; i++) {
            System.out.println("\nRound " + (i + 1) + ":");
            System.out.print("Enter choice (Rock, Paper, or Scissors): ");
            String userChoice = scanner.next();

            while (!userChoice.equalsIgnoreCase("Rock") &&
                   !userChoice.equalsIgnoreCase("Paper") &&
                   !userChoice.equalsIgnoreCase("Scissors")) {
                System.err.print("Invalid choice! Re-enter (Rock, Paper, or Scissors): ");
                userChoice = scanner.next();
            }

            String computerChoice = getComputerChoice();
            String winner = determineWinner(userChoice, computerChoice);

            gameResults[i][0] = userChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;

            System.out.println("  Computer chose : " + computerChoice);
            System.out.println("  Round Winner   : " + winner);
        }

        String[][] stats = calculateStats(gameResults, totalGames);
        displayResults(gameResults, stats);

        scanner.close();
    }
}
