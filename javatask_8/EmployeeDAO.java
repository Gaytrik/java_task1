package javatask_8;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // 🔸 Insert Employee (PreparedStatement)
    public void addEmployee(Employee emp) {
        String sql = "INSERT INTO employee(name, salary) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, emp.getName());
            ps.setDouble(2, emp.getSalary());

            ps.executeUpdate();
            System.out.println("Employee added!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔸 Fetch All Employees
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee";

        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary"));
                list.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // 🔸 Transaction Example (Transfer Salary)
    public void transferSalary(int fromId, int toId, double amount) {

        String deduct = "UPDATE employee SET salary = salary - ? WHERE id = ?";
        String add = "UPDATE employee SET salary = salary + ? WHERE id = ?";

        try (Connection con = DBConnection.getConnection()) {

            con.setAutoCommit(false); // 🔥 start transaction

            PreparedStatement ps1 = con.prepareStatement(deduct);
            ps1.setDouble(1, amount);
            ps1.setInt(2, fromId);
            ps1.executeUpdate();

            // 🔥 simulate error (test rollback)
            if (true) {
                throw new RuntimeException("Something went wrong!");
            }

            PreparedStatement ps2 = con.prepareStatement(add);
            ps2.setDouble(1, amount);
            ps2.setInt(2, toId);
            ps2.executeUpdate();

            con.commit(); // ✅ success

        } catch (Exception e) {
            try {
                System.out.println("Transaction Failed! Rolling back...");
                DBConnection.getConnection().rollback(); // ❌ WRONG WAY (common mistake)
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}