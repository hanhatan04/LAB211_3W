/*
 * MSSV: CE181017
 * Full Name: Ha Nhat An
 * Purpose: Main class to run the number conversion program with user interaction.
 */
package s03_ce181017_hanhatan;

/**
 * Main class for number conversion program
 * @author hanha
 */
public class S03_CE181017_Hanhatan {

    /**
     * Main method to run the number conversion program
     * Algorithm: Prompt user to choose conversion type, input number, convert to decimal, and display result
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConvertDecimal converter = new ConvertDecimal(); // Create ConvertDecimal instance

        while(true){
        // Display menu and get user choice
        System.out.println("1. Convert binary number to decimal number");
        System.out.println("2. Convert octal number to decimal number");
        System.out.println("3. Convert hexadecimal number to decimal number");
        System.out.println("4. Exit");
        int choice = MyLib.getChoice("Please choose number (1-4): ");

        // Process based on user choice
        switch (choice) {
            case 1 -> {
                // Binary to decimal
                converter.convertBinaryToDecimal();
                converter.printResult();
            }
            case 2 -> {
                // Octal to decimal
                converter.convertOctalToDecimal();
                converter.printResult();
            }
            case 3 -> {
                // Hexadecimal to decimal
                converter.convertHexToDecimal();
                converter.printResult();
            }
            case 4 ->
            {// Exit 
                System.out.println("Exiting program...");
                return;}
        }
    }
    }
}