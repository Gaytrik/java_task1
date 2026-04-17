package javatask_8;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAO();

        // Add
        dao.addEmployee(new Employee("Amit", 50000));
        dao.addEmployee(new Employee("Riya", 60000));

        // Fetch
        List<Employee> list = dao.getAllEmployees();
        list.forEach(System.out::println);

        // Transaction Test
        dao.transferSalary(1, 2, 5000);
    }
}