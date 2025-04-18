/*
 * MSSV: CE181017
 * Full Name: Ha Nhat An
 * Purpose: Main class to demonstrate array operations including input, sorting, and inserting a new value.
 */

 /*
 * Click nbproject://SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbproject://SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s01_ce181017_hanhatan;

/**
 * Main class for array operation demonstration
 *
 * @author hanha
 */
public class S01_CE181017_HaNhatAn {

    /**
     * Main method to run array operations Algorithm: Create array, input
     * elements, sort, insert new value and sort
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create Array instance
        Array array = new Array();
        // Input array elements
        array.inputArray();
        // Sort array
        array.sapxep();
        // Get new value into array and sort
        array.newArray();
    }
}
