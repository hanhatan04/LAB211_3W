/*
 * MSSV: CE181017
 * Full Name: Ha Nhat An
 * Purpose: ConvertToBase class handles conversion of decimal numbers to binary, octal, and hexadecimal.
 */
package s03_ce181017_hanhatan_neworder;

/**
 * ConvertToBase class for converting decimal numbers to other bases
 * @author hanha
 */
public class ConvertToBase {

    private int decimalNumber; // Input decimal number
    private String result;     // Converted number in target base

    /**
     * Converts a decimal number to binary
     * Algorithm: Repeatedly divide by 2, collect remainders, and reverse
     * @param decimal the decimal number
     */
    public void convertToBinary(int decimal) {
        this.decimalNumber = decimal;
        if (decimal == 0) {
            this.result = "0";
            return;
        }
        StringBuilder binary = new StringBuilder();
        int num = decimal;
        // Divide by 2 and collect remainders
        while (num > 0) {
            binary.append(num % 2); // Add remainder (0 or 1)
            num /= 2;
        }
        this.result = binary.reverse().toString(); // Reverse to get correct binary
    }

    /**
     * Converts a decimal number to octal
     * Algorithm: Repeatedly divide by 8, collect remainders, and reverse
     * @param decimal the decimal number
     */
    public void convertToOctal(int decimal) {
        this.decimalNumber = decimal;
        if (decimal == 0) {
            this.result = "0";
            return;
        }
        StringBuilder octal = new StringBuilder();
        int num = decimal;
        // Divide by 8 and collect remainders
        while (num > 0) {
            octal.append(num % 8); // Add remainder (0 to 7)
            num /= 8;
        }
        this.result = octal.reverse().toString(); // Reverse to get correct octal
    }

    /**
     * Converts a decimal number to hexadecimal
     * Algorithm: Repeatedly divide by 16, collect remainders, convert to hex digits, and reverse
     * @param decimal the decimal number
     */
    public void convertToHex(int decimal) {
        this.decimalNumber = decimal;
        if (decimal == 0) {
            this.result = "0";
            return;
        }
        StringBuilder hex = new StringBuilder();
        int num = decimal;
        // Divide by 16 and collect remainders
        while (num > 0) {
            int remainder = num % 16;
            if (remainder < 10) {
                hex.append(remainder); // 0-9
            } else {
                hex.append((char) ('A' + (remainder - 10))); // 10-15 -> A-F
            }
            num /= 16;
        }
        this.result = hex.reverse().toString(); // Reverse to get correct hex
    }

    /**
     * Prints the result based on the conversion type
     * @param base the target base ("Binary", "Octal", or "Hexadecimal")
     */
    public void printResult(String base) {
        System.out.println(base + " number is: " + result);
    }
}