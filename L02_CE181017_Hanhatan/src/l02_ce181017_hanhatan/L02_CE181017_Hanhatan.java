package l02_ce181017_hanhatan;

import java.util.Scanner;

/**
 * L02- Create a Java console program to manage students.
 * @author Ha Nhat An - CE181017
 */
public class L02_CE181017_Hanhatan {

    /**
     * Main method used to run the main program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Instantiate the StudentManager to manage the student operations.
        StudentManagement studentManager = new StudentManagement();
        Scanner scanner = new Scanner(System.in);
        boolean hasData = false; // A flag to check if any data exists.

        // The main loop to handle user input and menu selection.
        while (true) {
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            System.out.print("Please choose: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim()); // Attempt to parse input as integer.
            } catch (NumberFormatException e) {
                // Handle non-integer input.
                System.out.println("Invalid input. Please enter a number.");
                continue;  // Ask the user again for a valid choice
            }

            // Switch-case structure to handle user's menu choice.
            switch (choice) {
                case 1:
                    // Call to create a new student.
                    studentManager.createStudent();
                    hasData = true;  // Mark that data exists.
                    break;
                case 2:
                    // Check if data exists before proceeding to find and sort.
                    if (!hasData) {
                        System.out.println("Please add data before using this feature.");
                    } else {
                        studentManager.findAndSort();
                    }
                    break;
                case 3:
                    // Check if data exists before proceeding to update or delete.
                    if (!hasData) {
                        System.out.println("Please add data before using this feature.");
                    } else {
                        studentManager.updateOrDelete();
                    }
                    break;
                case 4:
                    // Check if data exists before generating the report.
                    if (!hasData) {
                        System.out.println("Please add data before using this feature.");
                    } else {
                        studentManager.generateReport();
                    }
                    break;
                case 5:
                    // Exit the application.
                    System.out.println("Exiting...");
                    return;
                default:
                    // Handle invalid choice input.
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
