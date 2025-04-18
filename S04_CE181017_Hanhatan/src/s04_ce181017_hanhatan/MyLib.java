/*
 * MSSV: CE181017
 * Full Name: Ha Nhat An
 * Purpose: MyLib class provides utility methods for input validation.
 */
package s04_ce181017_hanhatan;

import java.util.Scanner;

/**
 * MyLib class for input validation utilities
 * @author hanha
 */
public class MyLib {

    private static final Scanner scanner = new Scanner(System.in); // Scanner for user input

    /**
     * Inputs and validates a string (non-empty)
     * For names: only letters and spaces are allowed
     * For other inputs: non-empty check only
     * @param prompt message to display
     * @return valid string
     */
    public static String inputString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Error: Input cannot be empty!");
                continue;
            }
            // Check if the prompt is for Name (to apply name validation)
            if (prompt.trim().equalsIgnoreCase("Name:")) {
                if (input.matches("[a-zA-Z ]+")) {
                    return input;
                } else {
                    System.out.println("Error: Name must contain only letters and spaces!");
                }
            } else {
                return input; // For other inputs (like Classes), only check non-empty
            }
        }
    }

    /**
     * Inputs and validates a mark (between 1 and 10)
     * @param prompt message to display
     * @return valid mark
     */
    public static double inputMark(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double mark = Double.parseDouble(scanner.nextLine());
                if (mark >= 1 && mark <= 10) {
                    return mark;
                } else if (mark < 1) {
                    System.out.println("Error: " + prompt.trim() + " is less than equal zero");
                } else {
                    System.out.println("Error: " + prompt.trim() + " is greater than equal ten");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: " + prompt.trim() + " is digit");
            }
        }
    }

    /**
     * Inputs and validates yes/no choice (Y/N)
     * @param prompt message to display
     * @return true if Y, false if N
     */
    public static boolean inputYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("Y")) {
                return true;
            } else if (input.equals("N")) {
                return false;
            } else {
                System.out.println("Error: Please enter Y or N!");
            }
        }
    }
}