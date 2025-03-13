import java.util.ArrayList;
import java.util.List;

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Department {
    private String name;
    private List<Faculty> facultyMembers;

    public Department(String name) {
        this.name = name;
        this.facultyMembers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    public void displayDepartment() {
        System.out.println("\nDepartment: " + name);
        for (Faculty faculty : facultyMembers) {
            System.out.println("Faculty: " + faculty.getName());
        }
    }
}

class University {
    private String name;
    private List<Department> departments;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addFacultyToDepartment(String departmentName, Faculty faculty) {
        for (Department dept : departments) {
            if (dept.getName().equals(departmentName)) {
                dept.addFaculty(faculty);
                return;
            }
        }
        System.out.println("Department " + departmentName + " not found.");
    }

    public void displayUniversity() {
        System.out.println("\nUniversity: " + name);
        for (Department dept : departments) {
            dept.displayDepartment();
        }
    }

    public void deleteUniversity() {
        departments.clear();
        System.out.println("\nUniversity " + name + " and all its departments have been deleted.");
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        University university = new University("CalTech University");

        university.addDepartment("Theoretical Physics");
        university.addDepartment("Astrophysics");
        university.addDepartment("Applied Physics");

        Faculty faculty1 = new Faculty("Dr. Sheldon");
        Faculty faculty2 = new Faculty("Dr. Leonard");
        Faculty faculty3 = new Faculty("Dr. Rajesh");
        Faculty faculty4 = new Faculty("Mr. Howard");

        university.addFacultyToDepartment("Theoretical Physics", faculty1);
        university.addFacultyToDepartment("Applied Physics", faculty2);
        university.addFacultyToDepartment("Astrophysics", faculty3);
        university.addFacultyToDepartment("Engineering", faculty4);

        university.displayUniversity();
        university.deleteUniversity();

//        Department Engineering not found.
//
//        University: CalTech University
//
//        Department: Theoretical Physics
//        Faculty: Dr. Sheldon
//
//        Department: Astrophysics
//        Faculty: Dr. Rajesh
//
//        Department: Applied Physics
//        Faculty: Dr. Leonard
//
//        University CalTech University and all its departments have been deleted.
    }
}
