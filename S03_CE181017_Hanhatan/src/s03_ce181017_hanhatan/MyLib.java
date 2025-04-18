/*
 * MSSV: CE181017
 * Full Name: Ha Nhat An
 * Purpose: MyLib class provides utility methods for input validation and user choice.
 */
package s03_ce181017_hanhatan;

import java.util.Scanner;

/**
 * MyLib class for input validation and user choice utilities
 * @author hanha
 */
public class MyLib {

    private static final Scanner scanner = new Scanner(System.in); // Scanner for user input

    /**
     * Inputs and validates user's choice (1 to 4)
     * Algorithm: Prompt until a valid integer between 1 and 4 is entered
     * @param prompt message to display
     * @return valid choice (1 to 4)
     */
    public static int getChoice(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 4) {
                    return choice; // Return valid choice
                } else {
                    System.out.println("Error: Choice must be between 1 and 4!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer!");
            }
        }
    }

    /**
     * Inputs and validates a binary number
     * Algorithm: Prompt until a valid binary number (only 0s and 1s) is entered
     * @param prompt message to display
     * @return valid binary number as string
     */
    public static String inputBinary(String prompt) {
        while (true) {
            System.out.print(prompt);
            String binary = scanner.nextLine().trim();
            if (binary.isEmpty()) {
                System.out.println("Error: Input cannot be empty!");
                continue;
            }
            if (binary.matches("[01]+")) {
                return binary; // Return valid binary number
            } else {
                System.out.println("Error: Binary number must contain only 0s and 1s!");
            }
        }
    }

    /**
     * Inputs and validates an octal number
     * Algorithm: Prompt until a valid octal number (digits 0 to 7) is entered
     * @param prompt message to display
     * @return valid octal number as string
     */
    public static String inputOctal(String prompt) {
        while (true) {
            System.out.print(prompt);
            String octal = scanner.nextLine().trim();
            if (octal.isEmpty()) {
                System.out.println("Error: Input cannot be empty!");
                continue;
            }
            if (octal.matches("[0-7]+")) {
                return octal; // Return valid octal number
            } else {
                System.out.println("Error: Octal number must contain only digits 0 to 7!");
            }
        }
    }

    /**
     * Inputs and validates a hexadecimal number
     * Algorithm: Prompt until a valid hexadecimal number (digits 0-9, A-F, a-f) is entered
     * @param prompt message to display
     * @return valid hexadecimal number as string
     */
    public static String inputHexadecimal(String prompt) {
        while (true) {
            System.out.print(prompt);
            String hex = scanner.nextLine().trim();
            if (hex.isEmpty()) {
                System.out.println("Error: Input cannot be empty!");
                continue;
            }
            if (hex.matches("[0-9A-Fa-f]+")) {
                return hex; // Return valid hexadecimal number
            } else {
                System.out.println("Error: Hexadecimal number must contain only digits 0-9, A-F, or a-f!");
            }
        }
    }
}