/*
 * MSSV: CE181017
 * Full Name: Ha Nhat An
 * Purpose: ConvertDecimal class handles conversion of binary, octal, and hexadecimal numbers to decimal.
 */
package s03_ce181017_hanhatan;

/**
 * ConvertDecimal class for converting numbers to decimal
 *
 * @author hanha
 */
public class ConvertDecimal {

    private String inputNumber; // Input number as string
    private int decimalNumber;  // Converted decimal number

    /**
     * Converts a binary number to decimal Algorithm: Process each digit from
     * right to left, multiply by powers of 2, and sum
     */
    public void convertBinaryToDecimal() {
        String binary = MyLib.inputBinary("Enter binary number: ");
        this.inputNumber = binary;
        this.decimalNumber = 0;
        // Process each digit from right to left
        for (int i = 0; i < binary.length(); i++) {
            int digit = binary.charAt(binary.length() - 1 - i) - '0'; // Convert char to int
            this.decimalNumber += digit * Math.pow(2, i); // Multiply by 2^position and add
        }
    }

    /**
     * Converts an octal number to decimal Algorithm: Process each digit from
     * right to left, multiply by powers of 8, and sum
     *
     */
    public void convertOctalToDecimal() {
        String octal = MyLib.inputOctal("Enter octal number: ");
        this.inputNumber = octal;
        this.decimalNumber = 0;
        // Process each digit from right to left
        for (int i = 0; i < octal.length(); i++) {
            int digit = octal.charAt(octal.length() - 1 - i) - '0'; // Convert char to int
            this.decimalNumber += digit * Math.pow(8, i); // Multiply by 8^position and add
        }
    }

    /**
     * Converts a hexadecimal number to decimal Algorithm: Process each digit
     * from right to left, convert to decimal value, multiply by powers of 16,
     * and sum
     *
     */
    public void convertHexToDecimal() {
        String hex = MyLib.inputHexadecimal("Enter hexadecimal number: ");
        this.inputNumber = hex;
        this.decimalNumber = 0;
        // Process each digit from right to left
        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(hex.length() - 1 - i);
            int digit;
            if (c >= '0' && c <= '9') {
                digit = c - '0'; // Convert digit 0-9
            } else {
                digit = (Character.toUpperCase(c) - 'A') + 10; // Convert A-F to 10-15
            }
            this.decimalNumber += digit * Math.pow(16, i); // Multiply by 16^position and add
        }
    }

    /**
     * Prints the decimal number
     */
    public void printResult() {
        System.out.println("Decimal number is: " + decimalNumber);
        System.out.println("-------------------------------------");
    }
}
