/*
 * MSSV: CE181017
 * Full Name: Ha Nhat An
 * Purpose: MyLib class handles input validation utilities for the game.
 */
package v01_ce181017_hanhatan;

import java.util.Scanner;

/**
 * MyLib class for input validation utilities
 * @author hanha
 */
public class MyLib {
    private final Scanner scanner; // Scanner for user input

    /**
     * Constructor to initialize the Scanner for input operations.
     */
    public MyLib() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Inputs and validates an integer within the range 0 to 100.
     * @param prompt message to display
     * @return valid integer between 0 and 100
     */
    public int inputValidInteger(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine());
                if (value >= 0 && value <= 100) {
                    return value;
                } else {
                    System.out.println("Number must be between 0 and 100! Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }

    /**
     * Inputs and validates a yes/no choice (Y/N).
     * @param prompt message to display
     * @return true if Y, false if N
     */
    public String inputYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String choice = scanner.nextLine().trim().toUpperCase();
            if (choice.equals("Y") || choice.equals("N") || choice.equals("YES") || choice.equals("NO")) {
                return choice;
            } else {
                System.out.println("Please enter Yes(Y) or No(N)!");
            }
        }
    }

    /**
     * Closes the Scanner to prevent resource leaks.
     */
    public void closeScanner() {
        scanner.close();
    }
}