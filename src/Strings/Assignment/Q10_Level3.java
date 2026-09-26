package Strings.Assignment;

import java.util.Scanner;

/**
 * Question 10 - Level 3: Card Deck Simulation, Shuffling, & Distribution
 *
 * Description:
 * Creates a standard 52-card deck (4 suits x 13 ranks), shuffles it using
 * random swapping, distributes cards among X players into a 2D String array,
 * and prints each player's dealt cards.
 */
public class Q10_Level3 {

    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] RANKS = {
        "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"
    };

    /**
     * Initializes the standard 52-card deck.
     */
    public static String[] initializeDeck() {
        int numOfCards = SUITS.length * RANKS.length;
        String[] deck = new String[numOfCards];
        int index = 0;

        for (int i = 0; i < SUITS.length; i++) {
            for (int j = 0; j < RANKS.length; j++) {
                deck[index] = RANKS[j] + " of " + SUITS[i];
                index++;
            }
        }
        return deck;
    }

    /**
     * Shuffles the deck using Fisher-Yates style random swap.
     */
    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            // Generate random index between i and n - 1
            int randomCardNumber = i + (int) (Math.random() * (n - i));

            // Swap current card with random card
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    /**
     * Distributes cards evenly to x players.
     *
     * @param deck           Shuffled deck of cards
     * @param numPlayers     Number of players
     * @param cardsPerPlayer Number of cards each player receives
     * @return 2D String array [player][cards]
     */
    public static String[][] distributeCards(String[] deck, int numPlayers, int cardsPerPlayer) {
        int totalCardsToDistribute = numPlayers * cardsPerPlayer;
        if (totalCardsToDistribute > deck.length) {
            throw new IllegalArgumentException("Cannot distribute " + totalCardsToDistribute +
                    " cards from a deck of " + deck.length + " cards.");
        }

        String[][] playersCards = new String[numPlayers][cardsPerPlayer];
        int cardIndex = 0;

        for (int c = 0; c < cardsPerPlayer; c++) {
            for (int p = 0; p < numPlayers; p++) {
                playersCards[p][c] = deck[cardIndex++];
            }
        }

        return playersCards;
    }

    /**
     * Prints dealt cards for each player.
     */
    public static void printPlayersCards(String[][] playersCards) {
        System.out.println("\n================ Dealt Hands ================");
        for (int p = 0; p < playersCards.length; p++) {
            System.out.println("Player " + (p + 1) + "'s Hand (" + playersCards[p].length + " cards):");
            for (int c = 0; c < playersCards[p].length; c++) {
                System.out.println("  [" + (c + 1) + "] " + playersCards[p][c]);
            }
            System.out.println();
        }
        System.out.println("=============================================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Card Deck Shuffling & Distribution ===");
        System.out.print("Enter number of players: ");
        int numPlayers = scanner.nextInt();

        System.out.print("Enter number of cards per player: ");
        int cardsPerPlayer = scanner.nextInt();

        try {
            // Step 1: Initialize deck
            String[] deck = initializeDeck();
            System.out.println("\nDeck initialized with " + deck.length + " cards.");

            // Step 2: Shuffle deck
            deck = shuffleDeck(deck);
            System.out.println("Deck successfully shuffled.");

            // Step 3: Distribute cards
            String[][] hands = distributeCards(deck, numPlayers, cardsPerPlayer);

            // Step 4: Display players' cards
            printPlayersCards(hands);

        } catch (IllegalArgumentException e) {
            System.err.println("Distribution Error: " + e.getMessage());
        }

        scanner.close();
    }
}
