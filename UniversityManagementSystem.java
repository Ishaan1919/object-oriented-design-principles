import java.util.ArrayList;
import java.util.List;

class UniversityCourse {
    private String name;
    private UniversityProfessor professor;
    private List<UniversityStudent> students;

    public UniversityCourse(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void assignProfessor(UniversityProfessor professor) {
        this.professor = professor;
        System.out.println("Professor " + professor.getName() + " is assigned to " + name);
    }

    public void enrollStudent(UniversityStudent student) {
        students.add(student);
        System.out.println("Student " + student.getName() + " enrolled in " + name);
    }

    public void displayCourseDetails() {
        System.out.println("\nCourse: " + name);
        if (professor != null) {
            System.out.println("Professor: " + professor.getName());
        }
        System.out.println("Enrolled Students:");
        for (UniversityStudent student : students) {
            System.out.println(student.getName());
        }
    }
}

class UniversityStudent {
    private String name;
    private List<UniversityCourse> courses;

    public UniversityStudent(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(UniversityCourse course) {
        courses.add(course);
        course.enrollStudent(this);
    }
}

class UniversityProfessor {
    private String name;

    public UniversityProfessor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        UniversityCourse course1 = new UniversityCourse("Physics");
        UniversityCourse course2 = new UniversityCourse("Astrophysics");

        UniversityProfessor professor1 = new UniversityProfessor("Dr. Koothrapali");
        UniversityProfessor professor2 = new UniversityProfessor("Dr. Hofstader");

        course1.assignProfessor(professor1);
        course2.assignProfessor(professor2);

        UniversityStudent student1 = new UniversityStudent("Sheldon Cooper");
        UniversityStudent student2 = new UniversityStudent("Howard Wolowitts");

        student1.enrollCourse(course1);
        student2.enrollCourse(course1);
        student2.enrollCourse(course2);

        course1.displayCourseDetails();
        course2.displayCourseDetails();

//        Professor Dr. Koothrapali is assigned to Physics
//        Professor Dr. Hofstader is assigned to Astrophysics
//        Student Sheldon Cooper enrolled in Physics
//        Student Howard Wolowitts enrolled in Physics
//        Student Howard Wolowitts enrolled in Astrophysics
//
//        Course: Physics
//        Professor: Dr. Koothrapali
//        Enrolled Students:
//        Sheldon Cooper
//        Howard Wolowitts
//
//        Course: Astrophysics
//        Professor: Dr. Hofstader
//        Enrolled Students:
//        Howard Wolowitts
    }
}
