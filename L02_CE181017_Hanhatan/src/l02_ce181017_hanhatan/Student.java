package l02_ce181017_hanhatan;

/**
 * L02- Create a Java console program to manage students.
 * @author Ha Nhat An - CE181017
 */
public class Student {

    // Private fields to store the student's ID, name, course, and semester.
    private String id;       // Unique identifier for the student.
    private String name;     // Name of the student.
    private String course;   // Course the student is enrolled in.
    private String semester; // The semester during which the student is taking the course.

    /**
     * Constructs a Student object with the specified ID, name, course, and semester.
     * 
     * @param id The student's unique ID.
     * @param name The name of the student.
     * @param course The course the student is enrolled in.
     * @param semester The semester in which the student is enrolled in the course.
     */
    public Student(String id, String name, String course, String semester) {
        this.id = id;              // Assign the provided ID to the student.
        this.name = name;          // Assign the provided name to the student.
        this.course = course;      // Assign the provided course to the student.
        this.semester = semester;  // Assign the provided semester to the student.
    }

    /**
     * Returns the student's ID.
     * 
     * @return A string representing the student's ID.
     */
    public String getId() {
        return id;  // Return the student's ID.
    }

    /**
     * Sets the student's ID to the specified value.
     * 
     * @param id A string representing the new ID for the student.
     */
    public void setId(String id) {
        this.id = id;  // Set the student's ID to the given value.
    }

    /**
     * Returns the student's name.
     * 
     * @return A string representing the student's name.
     */
    public String getName() {
        return name;  // Return the student's name.
    }

    /**
     * Sets the student's name to the specified value.
     * 
     * @param name A string representing the new name for the student.
     */
    public void setName(String name) {
        this.name = name;  // Set the student's name to the given value.
    }

    /**
     * Returns the course the student is enrolled in.
     * 
     * @return A string representing the student's course.
     */
    public String getCourse() {
        return course;  // Return the student's course.
    }

    /**
     * Sets the student's course to the specified value.
     * 
     * @param course A string representing the new course for the student.
     */
    public void setCourse(String course) {
        this.course = course;  // Set the student's course to the given value.
    }

    /**
     * Returns the semester the student is enrolled in.
     * 
     * @return A string representing the student's semester.
     */
    public String getSemester() {
        return semester;  // Return the student's semester.
    }

    /**
     * Sets the student's semester to the specified value.
     * 
     * @param semester A string representing the new semester for the student.
     */
    public void setSemester(String semester) {
        this.semester = semester;  // Set the student's semester to the given value.
    }

    /**
     * Returns a string representation of the student's information, including ID, name, course, and semester.
     * 
     * @return A formatted string containing the student's details.
     */
    @Override
    public String toString() {
        // Return a formatted string with the student's ID, name, course, and semester.
        return "ID: " + id + ", Name: " + name + ", Course: " + course + ", Semester: " + semester;
    }
}
