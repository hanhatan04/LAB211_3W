/*
 * MSSV: CE181017
 * Full Name: Ha Nhat An
 * Purpose: MyLib class provides utility methods for input validation.
 */
package s02_ce181017_hanhatan;

import java.util.Scanner;

/**
 * MyLib class for input validation utilities
 *
 * @author hanha
 */
public class MyLib {

    private static final Scanner scanner = new Scanner(System.in); // Scanner for user input

    /**
     * Inputs and validates a string Algorithm: Prompt until a non-empty string
     * is entered
     *
     * @return valid string
     */
  public static String inputString() {
        while (true) {
            // Display prompt and get input
            System.out.print("Please enter string: ");
            String input = scanner.nextLine().trim(); // Remove extra whitespace at start and end

            // Check if input is empty
            if (input.isEmpty()) {
                System.out.println("Error: Input cannot be empty!");
                continue;
            }

            // Check for invalid characters (special characters other than space and underscore)
            if (!input.matches("[a-zA-Z0-9 _]+")) {
                System.out.println("Error: Only letters, numbers, spaces, and underscores are allowed!");
                continue;
            }

            // Check for consecutive delimiters (space or underscore)
            boolean hasConsecutiveDelimiters = false;
            for (int i = 0; i < input.length() - 1; i++) {
                char current = input.charAt(i);
                char next = input.charAt(i + 1);
                if ((current == ' ' || current == '_') && (next == ' ' || next == '_')) {
                    hasConsecutiveDelimiters = true;
                    break;
                }
            }
            if (hasConsecutiveDelimiters) {
                System.out.println("Error: Consecutive spaces or underscores are not allowed!");
                continue;
            }

            // If all checks pass, return the input
            return input;
        }
    }

    public static String EnterOrExit(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("ESC") || input.equals("") || input.equals("ENTER") ) {
                return input;
            } else {
                System.out.println("Unclear requirements, please choose again (Enter to continue/ESC to exit)");
            }
        }
    }
}
