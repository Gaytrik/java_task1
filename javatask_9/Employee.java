import java.util.*;
import java.util.stream.Collectors;

// Functional Interface
@FunctionalInterface
interface Filter<T> {
    boolean apply(T t);
}

class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + salary;
    }
}

public class Main {

    // Method using functional interface
    public static List<Employee> filterEmployees(List<Employee> list, Filter<Employee> filter) {
        List<Employee> result = new ArrayList<>();

        for (Employee e : list) {
            if (filter.apply(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Amit", 50000),
                new Employee(2, "Neha", 70000),
                new Employee(3, "Rahul", 40000),
                new Employee(4, "Priya", 90000)
        );

        // ✅ Using Lambda Expression
        List<Employee> highSalary = filterEmployees(employees, e -> e.getSalary() > 60000);

        System.out.println("High Salary Employees:");
        highSalary.forEach(System.out::println);  // Method Reference

        // ✅ Using Stream API (Modern Approach)
        List<Employee> filtered = employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .collect(Collectors.toList());

        System.out.println("\nFiltered using Stream:");
        filtered.forEach(System.out::println);
    }
}