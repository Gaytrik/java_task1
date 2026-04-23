
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Amit", 50000),
                new Employee(2, "Neha", 70000),
                new Employee(3, "Rahul", 40000),
                new Employee(4, "Priya", 90000));

        // Lambda with custom functional interface
        List<Employee> highSalary = EmployeeService.filterEmployees(
                employees,
                e -> e.getSalary() > 60000);

        System.out.println("High Salary Employees:");
        highSalary.forEach(System.out::println);

        // Stream API
        List<Employee> filtered = employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .collect(Collectors.toList());

        System.out.println("\nFiltered using Stream:");
        filtered.forEach(System.out::println);
    }
}