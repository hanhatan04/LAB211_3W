package l02_ce181017_hanhatan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * L02- Create a Java console program to manage students.
 *
 * @author Ha Nhat An - CE181017
 */
public class StudentManagement {

    private ArrayList<Student> students;  // List to store student objects.
    private Validator validator;  // Validator object for validating user inputs.
    private Scanner scanner;  // Scanner object for capturing user inputs.

    /**
     * Constructor to initialize StudentManagement with an empty student list
     * and a Validator object. The Scanner is also initialized to read inputs
     * from the console.
     */
    public StudentManagement() {
        this.students = new ArrayList<>();
        this.validator = new Validator();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Function to create a new student and add them to the list. Ensures that
     * the Student ID, course, and semester are valid. Avoids duplicate student
     * entries for the same course and semester.
     */
    public void createStudent() {
        String id = validator.getValidatedId().toUpperCase();  // Normalize the student ID to uppercase.
        String name = null;
        String course;
        String semester;

        // Check if the student ID already exists in the system.
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)) {  // Case-insensitive comparison.
                System.out.println("This ID already exists. Student name: " + student.getName());
                name = student.getName();  // Reuse the existing student name.
                break;
            }
        }

        // If the student is new, prompt the user for the student's name.
        if (name == null) {
            name = validator.getValidatedName();  // Validate and retrieve the student's name.
        }

        // Validate and retrieve the course name.
        course = validator.getValidatedCourse();

        // Ensure the student isn't already registered in the same course and semester.
        while (true) {
            semester = validator.getValidatedSemester();  // Validate and retrieve the semester.

            boolean isDuplicate = false;
            // Check for duplicate entries with the same student ID, course, and semester.
            for (Student student : students) {
                if (student.getId().equalsIgnoreCase(id) && student.getCourse().equals(course) && student.getSemester().equals(semester)) {
                    System.out.println("This student has already registered for " + course + " in semester " + semester + ". Please enter a different semester.");
                    isDuplicate = true;
                    break;
                }
            }

            // Break the loop if no duplicate entry is found.
            if (!isDuplicate) {
                break;
            }
        }

        // Add the new student to the list after validation.
        students.add(new Student(id, name, course, semester));
        System.out.println("Student added successfully!");
    }

    /**
     * Function to find students by name (or partial name) and sort them by
     * name. Outputs the result in a formatted table showing the list of
     * students and their semesters.
     */
    public void findAndSort() {
        System.out.print("Enter the student name or part of the name to search: ");
        String name = scanner.nextLine().trim();  // Get the name or part of the name for searching.

        // HashMap to group semesters by a key: "Student ID + Name + Course".
        HashMap<String, ArrayList<String>> groupedData = new HashMap<>();

        // Search for students whose name contains the given input (case-insensitive).
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                String key = student.getId().toUpperCase() + " | " + student.getName() + " | " + student.getCourse();
                // Group the semesters by the key.
                groupedData.putIfAbsent(key, new ArrayList<>());
                groupedData.get(key).add(student.getSemester());
            }
        }

        // Sort the students by name.
        ArrayList<String> sortedKeys = new ArrayList<>(groupedData.keySet());
        sortedKeys.sort((k1, k2) -> k1.split(" \\| ")[1].compareToIgnoreCase(k2.split(" \\| ")[1]));  // Sort by name part of the key.

        // Display the results in a formatted table.
        if (sortedKeys.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("+-----+--------------+--------------+--------+------------+");
            System.out.println("| No. | ID Student   | Name         | Course | Semesters  |");
            System.out.println("+-----+--------------+--------------+--------+------------+");

            int index = 1;
            for (String key : sortedKeys) {
                String[] parts = key.split(" \\| ");
                String semesters = String.join(",", groupedData.get(key));  // Join semesters into a comma-separated string.
                System.out.printf("| %-3d | %-12s | %-12s | %-6s | %-10s |\n", index++, parts[0], parts[1], parts[2], semesters);
            }
            System.out.println("+-----+--------------+--------------+--------+------------+");
        }
    }

    /**
     * Function to generate a report that shows the number of times each student
     * has registered for a particular course. The report is presented in a
     * formatted table, sorted by student ID.
     */
    public void generateReport() {
        if (students.isEmpty()) {
            System.out.println("No data to report.");
            return;
        }

        // HashMap to store the number of course registrations by each student.
        HashMap<String, Integer> reportData = new HashMap<>();

        // Populate the report by counting occurrences of each student-course pair.
        for (Student student : students) {
            String key = student.getId().toUpperCase() + " | " + student.getName() + " | " + student.getCourse();
            reportData.put(key, reportData.getOrDefault(key, 0) + 1);
        }

        // Sort the student data by ID.
        ArrayList<String> sortedKeys = new ArrayList<>(reportData.keySet());
        sortedKeys.sort((k1, k2) -> k1.split(" \\| ")[0].compareToIgnoreCase(k2.split(" \\| ")[0]));  // Sort by student ID.

        // Print the report in a formatted table.
        System.out.println("+-----+--------------+--------------+--------+-----------------+");
        System.out.println("| No. | ID Student   | Student Name | Course | Total of course |");
        System.out.println("+-----+--------------+--------------+--------+-----------------+");

        int index = 1;
        for (String key : sortedKeys) {
            String[] parts = key.split(" \\| ");
            System.out.printf("| %-3d | %-12s | %-12s | %-6s | %-15d |\n", index++, parts[0], parts[1], parts[2], reportData.get(key));
        }

        System.out.println("+-----+--------------+--------------+--------+-----------------+");
    }

    /**
     * Function to update or delete a student entry. The function first displays
     * all records and then asks the user to select an action: update the
     * student's information or delete the record.
     */
    public void updateOrDelete() {
        // Display all student records before updating or deleting.
        displayStudents();

        String id;
        ArrayList<Student> studentsWithId = new ArrayList<>();

        // Loop to ensure valid ID input.
        while (true) {
            System.out.print("Enter the student ID to find (or 0 to cancel): ");
            id = scanner.nextLine().trim().toUpperCase();  // Normalize input ID to uppercase.

            // Check if the user wants to cancel the operation.
            if (id.equals("0")) {
                System.out.println("Operation cancelled.");
                return;
            }

            // Find all students with the given ID.
            studentsWithId.clear();  // Clear previous results.
            for (Student student : students) {
                if (student.getId().equalsIgnoreCase(id)) {  // Case-insensitive comparison.
                    studentsWithId.add(student);
                }
            }

            // If no students are found, inform the user and prompt for re-entry.
            if (studentsWithId.isEmpty()) {
                System.out.println("No student found with this ID. Please try again.");
            } else {
                break;  // Exit loop if a valid ID is found.
            }
        }

        // Display all records with the given student ID.
        System.out.println("+-----+--------------+--------------+--------+------------+");
        System.out.println("| No. | ID Student   | Name         | Course | Semester   |");
        System.out.println("+-----+--------------+--------------+--------+------------+");

        for (int i = 0; i < studentsWithId.size(); i++) {
            Student student = studentsWithId.get(i);
            System.out.printf("| %-3d | %-12s | %-12s | %-6s | %-10s |\n", i + 1, student.getId(), student.getName(), student.getCourse(), student.getSemester());
        }

        System.out.println("+-----+--------------+--------------+--------+------------+");

        int line = -1;
        // Loop to prompt user for valid line number input.
        while (true) {
            System.out.print("Enter the line number to update (or 0 to cancel): ");
            String lineInput = scanner.nextLine().trim();

            try {
                line = Integer.parseInt(lineInput);  // Attempt to parse the input as an integer.
                if (line < 0 || line > studentsWithId.size()) {
                    System.out.println("Invalid line number. Please enter a number between 1 and " + studentsWithId.size() + ", or 0 to cancel.");
                } else {
                    break;  // Exit loop if a valid line number is entered.
                }
            } catch (NumberFormatException e) {
                // Handle if the input is not a valid integer.
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        if (line == 0) {
            System.out.println("Operation cancelled.");
            return;
        }

        // Get the selected student for update.
        Student studentToUpdate = studentsWithId.get(line - 1);

        // Ask the user whether they want to update or delete the student.
        System.out.print("Do you want to update (U) or delete (D) the student? ");
        String choice = scanner.nextLine().toUpperCase();

        if (choice.equals("U")) {
            // Update the student's details.
            // 1. Update Name: If the name is changed, update it for all students with the same ID.
            while (true) {
                System.out.printf("Current name: %s. Enter new name (or press Enter to keep it): ", studentToUpdate.getName());
                String newName = scanner.nextLine().trim();

                // Check if the new name is already taken by another student with a different ID.
                if (!newName.isEmpty()) {
                    boolean isNameDuplicate = false;

                    for (Student student : students) {
                        if (!student.getId().equalsIgnoreCase(studentToUpdate.getId()) && student.getName().equalsIgnoreCase(newName)) {
                            System.out.println("Warning: The name " + newName + " is already used by another student with ID " + student.getId() + ".");
                            isNameDuplicate = true;
                            break;
                        }
                    }

                    if (isNameDuplicate) {
                        // Ask the user whether they want to keep the duplicated name.
                        String keepNameChoice;
                        while (true) {
                            System.out.print("This name is already taken. Do you want to keep this name? (Y/N): ");
                            keepNameChoice = scanner.nextLine().trim().toUpperCase();

                            if (keepNameChoice.equals("Y")) {
                                // If the user chooses "Y", keep the current name and stop asking for a new one.
                                System.out.println("Name unchanged.");
                                break;  // Exit inner loop.
                            } else if (keepNameChoice.equals("N")) {
                                // Prompt for a new name until a valid one is provided.
                                System.out.println("Please enter a new name that is not duplicated!");
                                break;  // Break out of the inner loop to prompt for a new name.
                            } else {
                                // Handle invalid input for Y/N.
                                System.out.println("Invalid choice. Please enter 'Y' to keep the name or 'N' to enter a new one.");
                            }
                        }
                        if (keepNameChoice.equals("Y")) {
                            break;  // Exit outer loop if user chooses to keep the current name.
                        }
                    } else {
                        // If the new name is not a duplicate, update the name for all records with the same ID.
                        for (Student student : studentsWithId) {
                            student.setName(newName);  // Update the name for all records with the same ID.
                        }
                        break;  // Exit loop after successful update.
                    }
                } else {
                    break; // Keep the current name if input is empty.
                }
            }

            // 2. Update Course: Validate and change course if entered.
            System.out.printf("Current course: %s. Enter new course (or press Enter to keep it): ", studentToUpdate.getCourse());
            String newCourse = scanner.nextLine().trim();
            if (!newCourse.isEmpty()) {
                studentToUpdate.setCourse(validator.standardizeCourseName(newCourse));
            }

            // 3. Update Semester: Validate and change semester if entered, ensuring no duplicates.
            while (true) {
                System.out.printf("Current semester: %s. Enter new semester (or press Enter to keep it): ", studentToUpdate.getSemester());
                String newSemester = scanner.nextLine().trim();
                if (newSemester.isEmpty()) {
                    break;  // Keep the current semester if input is blank.
                }

                // Check if the student is already registered for the same course and semester.
                boolean isDuplicate = false;
                for (Student student : students) {
                    if (student.getId().equalsIgnoreCase(studentToUpdate.getId()) && student.getCourse().equals(studentToUpdate.getCourse()) && student.getSemester().equals(newSemester)) {
                        System.out.println("This student has already registered for " + studentToUpdate.getCourse() + " in semester " + newSemester + ". Please enter a different semester.");
                        isDuplicate = true;
                        break;
                    }
                }

                // Update the semester if no duplicate is found.
                if (!isDuplicate) {
                    studentToUpdate.setSemester(newSemester);
                    break;
                } else {
                    System.out.println("Please enter a different semester.");
                }
            }

            System.out.println("Student updated successfully!");

        } else if (choice.equals("D")) {
            // Delete the selected student.
            while (true) {
                System.out.print("Enter '1' to remove all students with this ID, or '2' to remove this specific line: ");
                String deleteChoice = scanner.nextLine().trim();

                if (deleteChoice.equals("1")) {
                    // Remove all students with the same ID.
                    students.removeIf(student -> student.getId().equalsIgnoreCase(studentToUpdate.getId()));
                    System.out.println("All students with ID " + studentToUpdate.getId() + " have been removed.");
                    break;  // Exit loop.
                } else if (deleteChoice.equals("2")) {
                    // Remove only the selected student entry.
                    students.remove(studentToUpdate);  // Remove the specific student entry.
                    System.out.println("Selected student line has been removed.");
                    break;  // Exit loop.
                } else {
                    // Handle invalid input for deletion choice.
                    System.out.println("Invalid input. Please enter '1' to remove all or '2' to remove this line.");
                }
            }
        } else {
            // Handle invalid input for update or delete choice.
            System.out.println("Invalid choice. Operation cancelled.");
        }
    }

    /**
     * Function to display the list of all students in a table format. The
     * students are sorted by their Student ID (MSSV).
     */
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available in the system.");
            return;
        }

        // Sort students by their Student ID (MSSV).
        students.sort((s1, s2) -> s1.getId().compareToIgnoreCase(s2.getId()));

        System.out.println("+-----+--------------+--------------+--------+------------+");
        System.out.println("| No. | ID Student   | Name         | Course | Semester   |");
        System.out.println("+-----+--------------+--------------+--------+------------+");

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.printf("| %-3d | %-12s | %-12s | %-6s | %-10s |\n", i + 1, student.getId(), student.getName(), student.getCourse(), student.getSemester());
        }

        System.out.println("+-----+--------------+--------------+--------+------------+");
    }
}
