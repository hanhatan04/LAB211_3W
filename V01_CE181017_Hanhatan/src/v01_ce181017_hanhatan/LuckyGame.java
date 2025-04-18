/*
 * MSSV: CE181017
 * Full Name: Ha Nhat An
 * Purpose: GuessNumberGame class handles the logic of a lucky number guessing game.
 */
package v01_ce181017_hanhatan;

/**
 * The LuckyGame class for managing a lucky number guessing game.
 *
 * @author hanha
 */
public class LuckyGame {

    private int Number;         // The random lucky number (0-100)
    private int Count;          // The number of guesses in the current game
    private int Games;          // The total number of games played
    private int Guess;          // The total number of guesses across all games
    private int bestGame;       // The best (lowest) number of guesses in a single game
    private final MyLib myLib;  // Instance of MyLib for input handling

    /**
     * Constructor to initialize the game with default values and MyLib
     * instance.
     */
    public LuckyGame() {
        this.myLib = new MyLib();
        this.Games = 0;          // Initialize total number of games
        this.Guess = 0;          // Initialize total number of guesses
        this.bestGame = Integer.MAX_VALUE; // Start with maximum value as the best game
    }

    /**
     * Generates a random lucky number between 0 and 100.
     */
    public void generateLuckyNumber() {
        this.Number = (int) (Math.random() * 101); // Generate a number from 0 to 100
    }

    /**
     * Manages a single game session, including guessing and updating stats.
     */
    public void playGame() {
        generateLuckyNumber();
        this.Count = 0;          // Reset guess count for the new game
        System.out.println("A new game starts! Guess the lucky number (0-100).");
        boolean guessedCorrectly = false;

        while (!guessedCorrectly) {
            int userGuess = myLib.inputValidInteger("Enter your guess: ");
            Count++;             // Increment the number of guesses
            if (userGuess == Number) {
                guessedCorrectly = true;
                System.out.println("Congratulations! You guessed the number " + Number + " in " + Count + " tries!");
            } else if (userGuess < Number) {
                System.out.println("Too low! Try a higher number.");
            } else {
                System.out.println("Too high! Try a lower number.");
            }
        }

        // Update game statistics
        Games++;                 // Increment total number of games
        Guess += Count;          // Add current game guesses to total
        if (Count < bestGame) {
            bestGame = Count;    // Update best game if current count is lower
        }
    }

    /**
     * Asks the user if they want to play again and returns the choice.
     *
     * @return true if Y, false if N
     */
    public boolean playAgain() {
        String choice = myLib.inputYesNo("Do you want to play again? (Y/N): ");
        return choice.equals("Y") || choice.equals("YES");
    }

    /**
     * Displays the game report including total games, guesses, average, and
     * best game.
     */
    public void displayReport() {
        double guessAvg = (Games > 0) ? (double) Guess / Games : 0; // Calculate average guesses
        System.out.println("\nGame Report:");
        System.out.println("Total games: " + Games);
        System.out.println("Total guesses: " + Guess);
        System.out.println("Guess average: " + String.format("%.2f", guessAvg));
        System.out.println("Best game: " + bestGame);
    }

    /**
     * Closes the MyLib Scanner to prevent resource leaks.
     */
    public void close() {
        myLib.closeScanner();
    }
}
