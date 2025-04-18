/*
 * MSSV: CE181017
 * Full Name: Ha Nhat An
 * Purpose: Student class represents a student with name, class, marks, average, and type.
 */
package s04_ce181017_hanhatan;

/**
 * Student class for storing and processing student information
 * @author hanha
 */
public class Student {

    private final String name;      // Student name
    private final String classes;   // Class name
    private final double math;      // Math mark
    private final double chemistry; // Chemistry mark
    private final double physics;   // Physics mark
    private double avg;       // Average mark
    private String type;      // Student type (A, B, C, D)

    /**
     * Creates a Student object
     * @param name student name
     * @param classes class name
     * @param math math mark
     * @param chemistry chemistry mark
     * @param physics physics mark
     */
    public Student(String name, String classes, double math, double chemistry, double physics) {
        this.name = name;
        this.classes = classes;
        this.math = math;
        this.chemistry = chemistry;
        this.physics = physics;
        calculateAverage();
        classifyStudent();
    }

    /**
     * Calculates the average mark
     */
    private void calculateAverage() {
        this.avg = (math + chemistry + physics) / 3;
    }

    /**
     * Classifies the student based on average mark
     */
    private void classifyStudent() {
        if (avg > 7.5) {
            this.type = "A";
        } else if (avg >= 6 && avg <= 7.5) {
            this.type = "B";
        } else if (avg >= 4 && avg < 6) {
            this.type = "C";
        } else {
            this.type = "D";
        }
    }

    /**
     * Gets the student name
     * @return student name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the average mark
     * @return average mark
     */
    public double getAverage() {
        return avg;
    }

    /**
     * Gets the student type
     * @return student type (A, B, C, D)
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the student information as a string
     * @return formatted student information
     */
    @Override
    public String toString() {
        return String.format("Name: %s\nClass: %s\nAVG: %.2f\nType: %s", name, classes, avg, type);
    }
}