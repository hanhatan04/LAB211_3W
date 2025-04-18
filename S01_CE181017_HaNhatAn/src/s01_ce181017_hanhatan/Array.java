/*
 * MSSV: CE181017
 * Full Name: Ha Nhat An
 * Purpose: Array class to handle operations like inputting an integer array, sorting it in ascending order, and inserting a new value while maintaining sorted order.
 */

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s01_ce181017_hanhatan;

/**
 * Array class for managing integer array operations
 *
 * @author hanha
 */
public class Array {

    private int[] mang; // Array to store integers
    private int size;   // Size of the array

    /**
     * Default constructor
     */
    /**
     * Inputs array size and elements from user
     */
    public void inputArray() {
        // Get valid array size
        size = MyLib.inputValidInteger("Please enter size of array: ");
        while (size <= 0) {
            System.out.println("Error: Size must be greater than 0!");
            size = MyLib.inputValidInteger("Please enter size of array: ");
        }

        mang = new int[size];
        // Input array elements
        for (int i = 0; i < size; i++) {
            mang[i] = MyLib.inputValidInteger("Enter element[" + i + "]: ");
        }
    }

    /**
     * Sorts array in ascending order using bubble sort Algorithm: Repeatedly
     * compare adjacent elements and swap if out of order
     */
    public void sapxep() {
        // Perform bubble sort
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (mang[j] > mang[j + 1]) {
                    // Swap elements
                    int d = mang[j];
                    mang[j] = mang[j + 1];
                    mang[j + 1] = d;
                }
            }
        }
        // Display sorted array
        System.out.println("The array after sorting: ");
        for (int i = 0; i < size; i++) {
            System.out.print(mang[i] + "    ");
        }
        System.out.println();
    }

    /**
     * Gets new value from user
     *
     * @return new value
     */
    public int newValue() {
        // Input new value
        return MyLib.inputValidInteger("Please enter new value: ");
    }

    /**
     * Inserts new value into sorted array Algorithm: Find position, shift
     * elements, insert value
     *
     */
    public void newArray() {
        int sole = 0;
        // Input New Value to sort
        int newValue = MyLib.inputValidInteger("Please enter new value: ");
        // Create new array
        int[] mangnew = new int[size + 1];
        int vitri = 0;
        // Find insertion position
        for (int i = 0; i < size; i++) {
            if (mang[i] < newValue) {
                vitri = i + 1;
            } else {
                break;
            }
        }
        // Insert value and copy elements
        for (int i = 0, j = 0; i < size + 1; i++) {
            if (i == vitri) {
                mangnew[i] = newValue;
            } else {
                mangnew[i] = mang[j++];
            }
        }
        // Update array and size
        mang = mangnew;
        size++;
        // Display new array
        System.out.println("New Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(mang[i] + "    ");
            if (mang[i]%2==1){
                sole += mang[i];
            } 
        }
        System.out.println();
        System.out.println("SUM = " + sole);

    }
    //Tinh tong cac so le va in ra
}
