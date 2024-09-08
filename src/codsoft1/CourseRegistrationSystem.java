package codsoft1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CourseRegistrationSystem {
	private List<Course> courses;
    private List<Student> students;

    public CourseRegistrationSystem() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Course findCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }
        return null;
    }

    public Student findStudentByID(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equalsIgnoreCase(studentID)) {
                return student;
            }
        }
        return null;
    }

    public void displayAvailableCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            course.displayCourseDetails();
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. List Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    displayAvailableCourses();
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    String studentID = scanner.nextLine();
                    Student student = findStudentByID(studentID);
                    if (student == null) {
                        System.out.print("Student not found. Enter student name to register: ");
                        String studentName = scanner.nextLine();
                        student = new Student(studentID, studentName);
                        addStudent(student);
                    }
                    System.out.print("Enter Course Code to Register: ");
                    String courseCode = scanner.nextLine();
                    Course course = findCourseByCode(courseCode);
                    if (course != null) {
                        student.registerCourse(course);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextLine();
                    student = findStudentByID(studentID);
                    if (student == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    System.out.print("Enter Course Code to Drop: ");
                    courseCode = scanner.nextLine();
                    course = findCourseByCode(courseCode);
                    if (course != null) {
                        student.dropCourse(course);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        CourseRegistrationSystem system = new CourseRegistrationSystem();

        // Adding some courses
        system.addCourse(new Course("CS101", "Introduction to Computer Science", 30));
        system.addCourse(new Course("MA101", "Calculus I", 25));
        system.addCourse(new Course("PH101", "Physics I", 20));

        // Running the system
        system.run();
    }
}
