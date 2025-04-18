/*
 * MSSV: CE181017
 * Full Name: Ha Nhat An
 * Purpose: MarkCalculation class handles student data processing, classification, and type statistics.
 */
package s04_ce181017_hanhatan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MarkCalculation class for processing student data, classifying students, and calculating type statistics
 * @author hanha
 */
public class MarkCalculation {
    // Thuộc tính để lưu danh sách sinh viên
    private final List<Student> students;

    // Constructor khởi tạo danh sách sinh viên
    public MarkCalculation() {
        this.students = new ArrayList<>();
    }

    /**
     * Creates a Student object by prompting user for input
     * @return Student object
     */
    private Student createStudent() {
        String name;
        while (true) {
            name = MyLib.inputString("Name: ");
            // Check for duplicate name
            boolean isDuplicate = false;
            for (Student student : students) {
                if (student.getName().equalsIgnoreCase(name)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                System.out.println("Error: This name already exists! Please enter a different name.");
            } else {
                break;
            }
        }
        String classes = MyLib.inputString("Classes: ");
        double math = MyLib.inputMark("Maths: ");
        double chemistry = MyLib.inputMark("Chemistry: ");
        double physics = MyLib.inputMark("Physics: ");
        return new Student(name, classes, math, chemistry, physics);
    }

    /**
     * Inputs student data and stores in the internal list
     */
    public void inputStudentData() {
        while (true) {
            Student student = createStudent();
            students.add(student);
            boolean continueInput = MyLib.inputYesNo("Do you want to enter more student information?(Y/N): ");
            if (!continueInput) {
                break;
            }
        }
    }
    /**
     * Displays student information
     */
    public void displayStudentInfo() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println("------Student" + (i + 1) + " Info------");
            System.out.println(students.get(i));
        }
    }

    /**
     * Calculates the percentage of each student type
     * @return map of type percentages
     */
    private Map<String, Double> getPercentTypeStudent() {
        Map<String, Double> typePercentages = new HashMap<>();
        // Initialize counts for each type
        typePercentages.put("A", 0.0);
        typePercentages.put("B", 0.0);
        typePercentages.put("C", 0.0);
        typePercentages.put("D", 0.0);

        if (students.isEmpty()) {
            return typePercentages; // Return 0% for all types if list is empty
        }

        // Count students for each type
        int totalStudents = students.size();
        for (Student student : students) {
            String type = student.getType();
            typePercentages.put(type, typePercentages.get(type) + 1);
        }

        // Calculate percentages
        for (Map.Entry<String, Double> entry : typePercentages.entrySet()) {
            double count = entry.getValue();
            double percentage = (count / totalStudents) * 100;
            entry.setValue(percentage);
        }

        return typePercentages;
    }

    /**
     * Displays classification statistics
     */
    public void displayClassificationInfo() {
        Map<String, Double> typePercentages = getPercentTypeStudent();
        System.out.println("\n=========Classification Info=========");
        System.out.printf("A: %.2f%%\n", typePercentages.get("A"));
        System.out.printf("B: %.2f%%\n", typePercentages.get("B"));
        System.out.printf("C: %.2f%%\n", typePercentages.get("C"));
        System.out.printf("D: %.2f%%\n", typePercentages.get("D"));
    }
}