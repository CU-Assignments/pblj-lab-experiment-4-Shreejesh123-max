import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

public class EmployeeManagementSystem {
    private ArrayList<Employee> employees;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
    }

   
    public void addEmployee(int id, String name, double salary) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                System.out.println("Error: Employee with ID " + id + " already exists.");
                return;
            }
        }
        Employee newEmployee = new Employee(id, name, salary);
        employees.add(newEmployee);
        System.out.println("Employee Added: ID=" + id + ", Name=" + name + ", Salary=" + salary);
    }

    public void updateEmployeeSalary(int id, double newSalary) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                emp.salary = newSalary;
                System.out.println("Employee ID " + id + " updated successfully.");
                return;
            }
        }
        System.out.println("Error: Employee with ID " + id + " not found.");
    }

    // Remove Employee
    public void removeEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                employees.remove(emp);
                System.out.println("Employee ID " + id + " removed successfully.");
                return;
            }
        }
        System.out.println("Error: Employee with ID " + id + " not found.");
    }

    public void searchEmployee(String searchTerm) {
        for (Employee emp : employees) {
            if (String.valueOf(emp.id).equals(searchTerm) || emp.name.equalsIgnoreCase(searchTerm)) {
                System.out.println("Employee Found: ID=" + emp.id + ", Name=" + emp.name + ", Salary=" + emp.salary);
                return;
            }
        }
        System.out.println("Error: Employee not found.");
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        for (Employee emp : employees) {
            System.out.println("ID: " + emp.id + ", Name: " + emp.name + ", Salary: " + emp.salary);
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        Scanner sc = new Scanner(System.in);
        
       
        system.displayEmployees(); 

        system.addEmployee(101, "shreejesh", 50000);  
        system.addEmployee(102, "sumantra", 60000);  

        system.updateEmployeeSalary(101, 55000);  

        system.searchEmployee("102"); 

        system.removeEmployee(101);  
      
        system.displayEmployees();  

        system.addEmployee(101, "dipendra", 70000);  
    }
}






//Output

Employee Added: ID=101, Name=shreejesh, Salary=50000.0
Employee Added: ID=102, Name=sumantra, Salary=60000.0
Employee ID 101 updated successfully.
Employee Found: ID=102, Name=sumantra, Salary=60000.0
Employee ID 101 removed successfully.
ID: 102, Name: sumantra, Salary: 60000.0
Employee Added: ID=101, Name=dipendra, Salary=70000.0
