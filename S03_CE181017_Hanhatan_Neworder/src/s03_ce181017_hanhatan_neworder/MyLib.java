/*
 * MSSV: CE181017
 * Full Name: Ha Nhat An
 * Purpose: MyLib class provides utility methods for input validation and user choice.
 */
package s03_ce181017_hanhatan_neworder;

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
     * Inputs and validates a decimal number
     * Algorithm: Prompt until a valid non-negative integer is entered
     * @param prompt message to display
     * @return valid decimal number
     */
    public static int inputDecimal(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int decimal = Integer.parseInt(scanner.nextLine());
                if (decimal >= 0) {
                    return decimal; // Return valid decimal number
                } else {
                    System.out.println("Error: Number must be non-negative!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer!");
            }
        }
    }
}