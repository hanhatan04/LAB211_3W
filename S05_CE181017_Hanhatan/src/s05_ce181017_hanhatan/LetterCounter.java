/*
 * MSSV: CE181017
 * Full Name: Ha Nhat An
 * Purpose: LetterCounter class handles counting the appearances of letters in a string.
 */
package s05_ce181017_hanhatan;

/**
 * LetterCounter class for counting letter appearances
 * @author hanha
 */

public class LetterCounter {

    private String inputString; // Input string
    private int[] letterCounts; // Array to store counts of 26 letters

    /**
     * Constructor to initialize the input string and count letters
     * @param inputString the string to process
     */
    public LetterCounter(String inputString) {
        this.inputString = inputString;
        this.letterCounts = new int[26]; // Array for 26 letters (a-z)
        countLetters();
    }

    /**
     * Counts the appearances of each letter in the input string
     */
    private void countLetters() {
        // Initialize array with zeros
        for (int i = 0; i < 26; i++) {
            letterCounts[i] = 0;
        }

        // Count letters in the string
        for (char c : inputString.toCharArray()) {
            if (Character.isLetter(c)) { // Check if character is a letter
                c = Character.toLowerCase(c); // Convert to lowercase
                int index = c - 'a'; // Map to array index (a=0, b=1, ..., z=25)
                letterCounts[index]++;
            }
        }
    }

    /**
     * Displays the letters and their counts
     */
    public void displayResults() {
        for (int i = 0; i < 26; i++) {
            if (letterCounts[i] > 0) { // Only display letters with count > 0
                char letter = (char) ('a' + i);
                System.out.println(letter + ": " + letterCounts[i]);
            }
        }
    }
}