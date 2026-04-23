
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    public static List<Employee> filterEmployees(List<Employee> list, Filter<Employee> filter) {
        List<Employee> result = new ArrayList<>();

        for (Employee e : list) {
            if (filter.apply(e)) {
                result.add(e);
            }
        }
        return result;
    }
}