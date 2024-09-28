package streamAPI;

import java.util.*;
import java.util.stream.*;

public class StreamApiExample {
    public static void main(String[] args) {

        // Sample Data: List of Employees
        List<Employee> employees = Arrays.asList(
                new Employee(101, "John", 5000),
                new Employee(102, "Jane", 6000),
                new Employee(103, "Jack", 7000),
                new Employee(104, "Jill", 8000),
                new Employee(105, "Joe", 5000)
        );

        // 1. Filtering: Get employees with salary > 6000
        List<Employee> highEarners = employees.stream()
                .filter(e -> e.getSalary() > 6000)
                .collect(Collectors.toList());

        System.out.println("High Earners (salary > 6000): " + highEarners);

        // 2. Mapping: Get list of employee names
        List<String> employeeNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("Employee Names: " + employeeNames);

        // 3. Sorting: Sort employees by salary
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary))
                .collect(Collectors.toList());

        System.out.println("Sorted Employees by Salary: " + sortedEmployees);


        // 4. Reducing: Get the total salary of all employees
        int totalSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce(0, Integer::sum);

        System.out.println("Total Salary of All Employees: " + totalSalary);

        // 5. Collecting: Group employees by salary
        Map<Integer, List<Employee>> employeesBySalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSalary));

        System.out.println("Employees Grouped by Salary: " + employeesBySalary);

        // 6. Primitive Stream: Calculate the average salary
        double averageSalary = employees.stream()
                .mapToInt(Employee::getSalary)
                .average()
                .orElse(0);

        System.out.println("Average Salary: " + averageSalary);

        // 7. Parallel Stream: Process the employee list in parallel
        List<Employee> parallelHighEarners = employees.parallelStream()
                .filter(e -> e.getSalary() > 6000)
                .collect(Collectors.toList());

        System.out.println("High Earners (Parallel Stream): " + parallelHighEarners);

        // 8. FlatMap: Flatten a list of lists (example with departments and employees)
        List<Department> departments = Arrays.asList(
                new Department("HR", Arrays.asList(new Employee(201, "Anna", 4000), new Employee(202, "Chris", 4500))),
                new Department("IT", Arrays.asList(new Employee(203, "Mike", 7000), new Employee(204, "Emma", 7500)))
        );

        List<Employee> allEmployeesFromDepartments = departments.stream()
                .flatMap(dept -> dept.getEmployees().stream())
                .collect(Collectors.toList());

        System.out.println("All Employees from Departments: " + allEmployeesFromDepartments);
    }
}

// Supporting Employee class
class Employee {
    private int id;
    private String name;
    private int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + ", Salary: " + salary + ")";
    }
}

// Supporting Department class
class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return name + ": " + employees;
    }
}
