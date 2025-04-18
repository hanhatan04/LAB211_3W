package l02_ce181017_hanhatan;

import java.util.Scanner;

/**
 * L02- Create a Java console program to manage students.
 *
 * @author Ha Nhat An - CE181017
 */
public class Validator {

    private Scanner scanner;  // Scanner object for user input.

    /**
     * Constructor to initialize the Validator with a Scanner.
     */
    public Validator() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Validate Student ID: ensures that the ID contains only letters and
     * numbers (no spaces or special characters).
     *
     * @return a valid Student ID
     */
    public String getValidatedId() {
        String id;
        while (true) {
            System.out.print("Enter Student ID (letters and numbers only, no spaces or special characters): ");
            id = scanner.nextLine().trim();
            if (id.matches("[a-zA-Z0-9]+")) {
                return id;
            }
            System.out.println("Invalid ID. Please try again.");
        }
    }

    /**
     * Validate Student Name: ensures that the name contains only letters and
     * spaces (no numbers or special characters).
     *
     * @return a valid Student Name
     */
    public String getValidatedName() {
        String name;
        while (true) {
            System.out.print("Enter Student Name (letters and spaces only): ");
            name = scanner.nextLine().trim();
            if (name.matches("[a-zA-Z ]+")) {
                return name;
            }
            System.out.println("Invalid name. Please try again.");
        }
    }

    /**
     * Validate Semester: ensures that the semester is a positive number.
     *
     * @return a valid Semester
     */
    public String getValidatedSemester() {
        String semester;
        while (true) {
            System.out.print("Enter Semester (positive number): ");
            semester = scanner.nextLine().trim();
            if (semester.matches("[0-9]+")) {
                return semester;
            }
            System.out.println("Invalid semester. Please enter a number.");
        }
    }

    /**
     * Validate Course: ensures that the input is one of the predefined courses:
     * Java, .Net, or C/C++.
     *
     * @return a valid Course Name
     */
    public String getValidatedCourse() {
        String course;
        while (true) {
            System.out.print("Enter Course Name (Java, .Net, C/C++): ");
            course = scanner.nextLine().trim();
            if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase(".Net") || course.equalsIgnoreCase("C/C++")) {
                return standardizeCourseName(course);
            }
            System.out.println("Invalid course. Please enter 'Java', '.Net', or 'C/C++'.");
        }
    }

    /**
     * Standardize the course name to the correct format (capitalization).
     *
     * @param course the input course name
     * @return the standardized course name
     */
    public String standardizeCourseName(String course) {
        if (course.equalsIgnoreCase("java")) {
            return "Java";
        }
        if (course.equalsIgnoreCase(".net")) {
            return ".Net";
        }
        if (course.equalsIgnoreCase("c/c++")) {
            return "C/C++";
        }
        return course;
    }

    public boolean inputYesNo(String prompt) {
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
