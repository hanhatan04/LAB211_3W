/*
 * MSSV: CE181017
 * Full Name: Ha Nhat An
 * Purpose: Main class to run the letter counting program with user interaction.
 */
package s05_ce181017_hanhatan;

/**
 * Main class for letter counting program
 * @author hanha
 */
public class S05_CE181017_Hanhatan {

    /**
     * Main method to run the letter counting program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Function 1: Input string
        String input = MyLib.inputString("Enter a string: ");
        
        // Function 2: Count letters
        LetterCounter counter = new LetterCounter(input);
        
        // Function 3: Display results
        counter.displayResults();
    }
}