/*
 * MSSV: CE181017
 * Full Name: Ha Nhat An
 * Purpose: Main class to start and control the GuessNumberGame.
 */
package v01_ce181017_hanhatan;
/**
 * Main Class for run game
 * @author hanha
 */
public class V01_CE181017_Hanhatan {
    /**
     * Main method to initialize and run the guessing game.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        LuckyGame game = new LuckyGame();
        boolean playAgain = true;

        while (playAgain) {
            game.playGame();
            playAgain = game.playAgain();
        }

        game.displayReport();
        game.close();
    }
}