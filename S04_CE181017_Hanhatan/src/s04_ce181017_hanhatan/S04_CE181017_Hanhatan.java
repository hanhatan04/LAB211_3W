/*
 * MSSV: CE181017
 * Full Name: Ha Nhat An
 * Purpose: Main class to run the student data management program with user interaction.
 */
package s04_ce181017_hanhatan;

/**
 * Main class for student data management program
 *
 * @author hanha
 */
public class S04_CE181017_Hanhatan {

    /**
     * Main method to run the student data management program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MarkCalculation mark = new MarkCalculation();
        System.out.println("\n=========MANAGE STUDENT PROGRAM=========");
        // Input student data and Classify students
        mark.inputStudentData();
        // Display student information
        mark.displayStudentInfo();
        // Calculate and display type statistics
        mark.displayClassificationInfo();
    }
}
