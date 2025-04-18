/*
 * MSSV: CE181017
 * Full Name: Ha Nhat An
 * Purpose: Main class to run the string reversal program with user interaction.
 */
package s02_ce181017_hanhatan;

/**
 * Main class for string reversal program
 *
 * @author hanha
 */
public class S02_CE181017_HaNhatAn {

    /**
     * Main method to run the string reversal program Algorithm: Loop to input
     * string, reverse it, and display results until user exits
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyString reverser = new MyString(); // Create StringReverser instance

        while (true) {
            // Set and reverse the string
            reverser.setInputString();
            // Display results
            reverser.display();
            // Check if user wants to continue or exit
            if (reverser.Choice()) {
                break;
            }
        }
    }
}
