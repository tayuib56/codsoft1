package codsoft1;

import java.util.ArrayList;
import java.util.List;
public class Student {
	private String studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public void registerCourse(Course course) {
        if (course.addStudent(this)) {
            registeredCourses.add(course);
            System.out.println("Registered for course: " + course.getTitle());
        } else {
            System.out.println("Registration failed. Course is full.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.remove(course)) {
            course.removeStudent(this);
            System.out.println("Dropped course: " + course.getTitle());
        } else {
            System.out.println("You are not registered in this course.");
        }
    }

    public void displayRegisteredCourses() {
        System.out.println("Student ID: " + studentID + ", Name: " + name);
        System.out.println("Registered Courses:");
        for (Course course : registeredCourses) {
            System.out.println("- " + course.getTitle());
        }
    }
}
