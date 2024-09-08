package codsoft1;

import java.util.ArrayList;
import java.util.List;
public class Course {
	private String courseCode;
    private String title;
    private int capacity;
    private List<Student> registeredStudents;

    public Course(String courseCode, String title, int capacity) {
        this.courseCode = courseCode;
        this.title = title;
        this.capacity = capacity;
        this.registeredStudents = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableSlots() {
        return capacity - registeredStudents.size();
    }

    public boolean addStudent(Student student) {
        if (registeredStudents.size() < capacity) {
            registeredStudents.add(student);
            return true;
        }
        return false;
    }

    public boolean removeStudent(Student student) {
        return registeredStudents.remove(student);
    }

    public void displayCourseDetails() {
        System.out.println("Course Code: " + courseCode + ", Title: " + title + ", Capacity: " + capacity + ", Available Slots: " + getAvailableSlots());
    }
}
