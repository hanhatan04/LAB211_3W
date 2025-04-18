/*
 * MSSV: CE181017
 * Full Name: Ha Nhat An
 * Purpose: MyLib class provides utility methods for input validation.
 */
package s05_ce181017_hanhatan;

import java.util.Scanner;

/**
 * MyLib class for input validation utilities
 * @author hanha
 */
public class MyLib {

    private static final Scanner scanner = new Scanner(System.in); // Scanner for user input

    /**
     * Inputs and validates a string (non-empty)
     * @param prompt message to display
     * @return valid string
     */
    public static String inputString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Error: Input cannot be empty!");
            }
        }
    }
}