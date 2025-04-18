/*
 * MSSV: CE181017
 * Full Name: Ha Nhat An
 * Purpose: MyLib class provides utility methods for input validation, including valid integer and Gmail address input.
 */

 /*
 * Click nbproject://SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbproject://SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s01_ce181017_hanhatan;

import java.util.Scanner;

/**
 * MyLib class for input validation utilities
 *
 * @author hanha
 */
public class MyLib {

    private static final Scanner scanner = new Scanner(System.in); // Scanner for user input

    /**
     * Inputs and validates an integer Algorithm: Repeatedly prompt until a
     * valid integer is entered
     *
     * @param prompt message to display
     * @return valid integer
     */
    public static int inputValidInteger(String prompt) {
        while (true) {
            try {
                // Display prompt and get input
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine()); // Convert input to integer
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer!");
            }
        }
    }
}
