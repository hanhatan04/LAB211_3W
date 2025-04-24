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
    private Scanner scanner;  // Scanner object for capturing user inputs.

    /**
     * Constructor to initialize StudentManagement with an empty student list.
     * The Scanner is initialized to read inputs from the console.
     */
    public StudentManagement() {
        this.students = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void inputDatatoTest() {
        students.add(new Student("SE001", "Nguyen Van A", "Java", "1"));
        students.add(new Student("SE002", "Tran Thi B", ".Net", "2"));
        students.add(new Student("SE003", "Le Van C", "C/C++", "3"));
        students.add(new Student("SE004", "Pham Thi D", "Java", "1"));
        students.add(new Student("SE005", "Hoang Van E", ".Net", "2"));
        students.add(new Student("SE006", "Nguyen Thi F", "C/C++", "3"));
        students.add(new Student("SE007", "Tran Van G", "Java", "4"));
        students.add(new Student("SE008", "Le Thi H", ".Net", "1"));
        students.add(new Student("SE009", "Pham Van I", "C/C++", "2"));
        students.add(new Student("SE010", "Hoang Thi K", "Java", "3"));
    }

    public void addStudent() {
        createStudent();
        while (students.size() < 10) {
            System.out.println("Do you want to order now (Y/N)");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("Y")) {
                createStudent();
            } else if (input.equals("N")) {
                break;
            } else {
                System.out.println("Error: Please enter Y or N!");
            }
        }

    }

    /**
     * Function to create a new student and add them to the list. Ensures that
     * the Student ID, course, and semester are valid. Avoids duplicate student
     * entries for the same course and semester.
     */
public void createStudent() {
    Student newStudent = new Student("", "", "", "");
    newStudent.input();

    boolean checkId = false;
    boolean checkSemester = false;
    String existingName = null;

    // Kiểm tra ID trùng và trùng khóa học-kỳ học
    for (Student student : students) {
        if (student.getId().equalsIgnoreCase(newStudent.getId())) {
            checkId = true;
            existingName = student.getName(); // Lưu tên hiện tại để đảm bảo nhất quán
        }
        if (student.getId().equalsIgnoreCase(newStudent.getId()) && 
            student.getName().equalsIgnoreCase(newStudent.getName()) && 
            student.getCourse().equalsIgnoreCase(newStudent.getCourse()) && 
            student.getSemester().equalsIgnoreCase(newStudent.getSemester())) {
            checkSemester = true;
        }
    }

    // Nếu dữ liệu hoàn toàn trùng (ID, tên, khóa học, kỳ học)
    if (checkSemester) {
        System.out.println("This data already exists in the system.");
        return; // Thoát ra, không thêm sinh viên
    }

    // Nếu ID trùng nhưng không trùng khóa học-kỳ học
    if (checkId) {
        // Đảm bảo tên nhất quán
        if (existingName != null && !newStudent.getName().equalsIgnoreCase(existingName)) {
            System.out.println("Name changed to match existing student: " + existingName);
            newStudent.setName(existingName);
        }

        // Hỏi người dùng có muốn lưu không
        while (true) {
            System.out.println("Id has been used, do you want to save the information you just entered for: " + newStudent.getName() + "? (Y/N)");
            String choice = scanner.nextLine().trim().toUpperCase();
            if (choice.equals("Y")) {
                students.add(newStudent);
                System.out.println("Student added successfully!");
                return; // Thoát ra sau khi thêm
            } else if (choice.equals("N")) {
                System.out.println("Student information discarded.");
                return; // Thoát ra, không thêm sinh viên
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }
    }

    // Nếu ID không trùng, thêm sinh viên bình thường
    students.add(newStudent);
    System.out.println("Student added successfully!");
}
    /**
     * Function to find students by name (or partial name) and sort them by
     * name. Outputs the result in a formatted table showing the list of
     * students and their semesters.
     */
    public void findAndSort() {
        if (students.isEmpty()) {
            System.out.println("No students available in the system.");
            return;
        }
        System.out.print("Enter the student name or part of the name to search: ");
        String name = scanner.nextLine().trim();  // Get the name or part of the name for searching.

        // HashMap to group semesters by a key: "Student ID + Name + Course".
        HashMap<String, ArrayList<String>> checkname = new HashMap<>();

        // Search for students whose name contains the given input (case-insensitive).
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                String key = student.getId().toUpperCase() + " | " + student.getName() + " | " + student.getCourse();
                // Group the semesters by the key.
                checkname.putIfAbsent(key, new ArrayList<>());
                checkname.get(key).add(student.getSemester());
            }
        }

        // Sort the students by name.
        ArrayList<String> sorted = new ArrayList<>(checkname.keySet());
        sorted.sort((k1, k2) -> k1.split(" \\| ")[1].compareToIgnoreCase(k2.split(" \\| ")[1]));  // Sort by name part of the key.

        // Display the results in a formatted table.
        if (sorted.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("+-----+--------------+--------------+--------+------------+");
            System.out.println("| No. | ID Student   | Name         | Course | Semesters  |");
            System.out.println("+-----+--------------+--------------+--------+------------+");

            int index = 1;
            for (String key : sorted) {
                String[] parts = key.split(" \\| ");
                String semesters = String.join(",", checkname.get(key));  // Join semesters into a comma-separated string.
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
        ArrayList<String> sorted = new ArrayList<>(reportData.keySet());
        sorted.sort((k1, k2) -> k1.split(" \\| ")[0].compareToIgnoreCase(k2.split(" \\| ")[0]));  // Sort by student ID.

        // Print the report in a formatted table.
        System.out.println("+-----+--------------+--------------+--------+-----------------+");
        System.out.println("| No. | ID Student   | Student Name | Course | Total of course |");
        System.out.println("+-----+--------------+--------------+--------+-----------------+");

        int index = 1;
        for (String key : sorted) {
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
        if (students.isEmpty()) {
            System.out.println("No students available in the system.");
            return;
        }
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
                    // Inline name validation
                    if (!newName.matches("[a-zA-Z ]+")) {
                        System.out.println("Invalid name. Please use letters and spaces only.");
                        continue;
                    }
                    boolean isNameDuplicate = false;

                    for (Student student : students) {
                        if (!student.getId().equalsIgnoreCase(studentToUpdate.getId()) && student.getName().equalsIgnoreCase(newName)) {
                            System.out.println("Warning: The name " + newName + " is already used by another student with ID " + student.getId() + ".");
                            isNameDuplicate = true;
                            break;
                        }
                    }

                    if (isNameDuplicate) {
                        // Inline inputYesNo()
                        boolean keepName;
                        while (true) {
                            System.out.print("This name is already taken. Do you want to keep this name? (Y/N): ");
                            String input = scanner.nextLine().trim().toUpperCase();
                            if (input.equals("Y")) {
                                keepName = true;
                                break;
                            } else if (input.equals("N")) {
                                keepName = false;
                                break;
                            } else {
                                System.out.println("Error: Please enter Y or N!");
                            }
                        }
                        if (keepName) {
                            // If the user chooses "Y", keep the current name and stop asking for a new one.
                            System.out.println("Name unchanged.");
                            break;  // Exit loop.
                        } else {
                            // Prompt for a new name until a valid one is provided.
                            System.out.println("Please enter a new name that is not duplicated!");

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
                // Inline course validation
                if (newCourse.equalsIgnoreCase("Java") || newCourse.equalsIgnoreCase(".Net") || newCourse.equalsIgnoreCase("C/C++")) {
                    // Inline standardizeCourseName()
                    if (newCourse.equalsIgnoreCase("java")) {
                        newCourse = "Java";
                    } else if (newCourse.equalsIgnoreCase(".net")) {
                        newCourse = ".Net";
                    } else if (newCourse.equalsIgnoreCase("c/c++")) {
                        newCourse = "C/C++";
                    }
                    studentToUpdate.setCourse(newCourse);
                } else {
                    System.out.println("Invalid course. Course unchanged.");
                }
            }

            // 3. Update Semester: Validate and change semester if entered, ensuring no duplicates.
            while (true) {
                System.out.printf("Current semester: %s. Enter new semester (or press Enter to keep it): ", studentToUpdate.getSemester());
                String newSemester = scanner.nextLine().trim();
                if (newSemester.isEmpty()) {
                    break;  // Keep the current semester if input is blank.
                }

                // Allow any non-empty string for semester updates, per original behavior
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
                if (!isDuplicate && newSemester.matches("[0-9]+")) {
                    studentToUpdate.setSemester(newSemester);
                    break;
                } else {
                    System.out.println("Semester must be Interger");
                }
            }

            System.out.println("Student updated successfully!");

        } else if (choice.equals("D")) {
            // Delete the selected student.
            while (true) {
                System.out.print("Enter '1' to remove all students with this ID, '2' to remove this specific line or '3' to cancel: ");
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
                } else if (deleteChoice.equals("3")) {
                    System.out.println("Cancel remove.");
                    break;
                } else {
                    // Handle invalid input for deletion choice.
                    System.out.println("Invalid input. Please enter '1' to remove all or '2' to remove this line or '3' to cancel remove.");
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
