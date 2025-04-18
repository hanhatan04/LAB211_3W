/*
 * MSSV: CE181017
 * Full Name: Ha Nhat An
 * Purpose: Main class to run the number conversion program with user interaction.
 */
package s03_ce181017_hanhatan_neworder;

/**
 * Main class for number conversion program
 * @author hanha
 */
public class S03_CE181017_Hanhatan_Neworder {

    /**
     * Main method to run the number conversion program
     * Algorithm: Loop to prompt user to choose conversion type, input decimal number, convert to target base, and display result until user exits
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConvertToBase converter = new ConvertToBase(); // Create ConvertToBase instance

        while (true) {
            // Display menu and get user choice
            System.out.println("1. Convert decimal number to binary number");
            System.out.println("2. Convert decimal number to octal number");
            System.out.println("3. Convert decimal number to hexadecimal number");
            System.out.println("4. Exit");
            int choice = MyLib.getChoice("Please choose number (1-4): ");

            // Process based on user choice
            switch (choice) {
                case 1:
                    // Decimal to binary
                    int decimalForBinary = MyLib.inputDecimal("Enter decimal number: ");
                    converter.convertToBinary(decimalForBinary);
                    converter.printResult("Binary");
                    break;
                case 2:
                    // Decimal to octal
                    int decimalForOctal = MyLib.inputDecimal("Enter decimal number: ");
                    converter.convertToOctal(decimalForOctal);
                    converter.printResult("Octal");
                    break;
                case 3:
                    // Decimal to hexadecimal
                    int decimalForHex = MyLib.inputDecimal("Enter decimal number: ");
                    converter.convertToHex(decimalForHex);
                    converter.printResult("Hexadecimal");
                    break;
                case 4:
                    // Exit
                    System.out.println("Exiting program...");
                    return; // Exit the program
            }
            // Add a separator for clarity between iterations
            System.out.println("\n-----------------------------------\n");
        }
    }
}