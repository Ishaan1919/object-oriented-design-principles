import java.util.ArrayList;
import java.util.List;

class Course {
    private String name;
    private List<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public void displayEnrolledStudents() {
        System.out.println("\nCourse: " + name + " - Enrolled Students:");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this);
    }

    public void displayEnrolledCourses() {
        System.out.println("\nStudent: " + name + " - Enrolled Courses:");
        for (Course course : courses) {
            System.out.println(course.getName());
        }
    }
}

class School {
    private String name;
    private List<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("\nSchool: " + name + " - Students:");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}

public class SchoolStudents {
    public static void main(String[] args) {
        School school = new School("Chitkara School");

        Student student1 = new Student("Ishaan");
        Student student2 = new Student("Jain");

        school.addStudent(student1);
        school.addStudent(student2);

        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Physics");

        student1.enrollInCourse(course1);
        student1.enrollInCourse(course2);
        student2.enrollInCourse(course1);

        school.displayStudents();
        student1.displayEnrolledCourses();
        student2.displayEnrolledCourses();
        course1.displayEnrolledStudents();
        course2.displayEnrolledStudents();

//        School: Chitkara School - Students:
//        Ishaan
//                Jain
//
//        Student: Ishaan - Enrolled Courses:
//        Mathematics
//                Physics
//
//        Student: Jain - Enrolled Courses:
//        Mathematics
//
//        Course: Mathematics - Enrolled Students:
//        Ishaan
//                Jain
//
//        Course: Physics - Enrolled Students:
//        Ishaan
    }
}
