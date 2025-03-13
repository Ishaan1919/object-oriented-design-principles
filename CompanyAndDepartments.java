import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void displayInfo() {
        System.out.println("Employee: " + name + ", Position: " + position);
    }
}

class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, String position) {
        employees.add(new Employee(name, position));
    }

    public String getName(){
        return this.name;
    }

    public void displayDepartment() {
        System.out.println("\nDepartment: " + name);
        for (Employee emp : employees) {
            emp.displayInfo();
        }
    }
}

class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addEmployeeToDepartment(String departmentName, String employeeName, String position) {
        for (Department dept : departments) {
            if (dept.getName().equals(departmentName)) {
                dept.addEmployee(employeeName, position);
                return;
            }
        }
        System.out.println("Department " + departmentName + " not found.");
    }

    public void displayCompany() {
        System.out.println("\nCompany: " + name);
        for (Department dept : departments) {
            dept.displayDepartment();
        }
    }

    public void deleteCompany() {
        departments.clear();
        System.out.println("\nCompany " + name + " and all departments/employees have been deleted.");
    }
}

public class  CompanyAndDepartments {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");

        company.addDepartment("Engineering");
        company.addDepartment("HR");

        company.addEmployeeToDepartment("Engineering", "Ishaan", "Software Engineer");
        company.addEmployeeToDepartment("Engineering", "Hitesh", "DevOps Engineer");
        company.addEmployeeToDepartment("HR", "Jain", "HR Manager");

        company.displayCompany();

        company.deleteCompany();

//        Company: TechCorp
//
//        Department: Engineering
//        Employee: Ishaan, Position: Software Engineer
//        Employee: Hitesh, Position: DevOps Engineer
//
//        Department: HR
//        Employee: Jain, Position: HR Manager
//
//        Company TechCorp and all departments/employees have been deleted.
    }
}
