import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class EmployeeManager {
    private final List<Employee> employees = new ArrayList<>();
    private int nextId = 1;
    public int addEmployee(Employee employee) {
        employee.setId(nextId);
        employees.add(employee);
        return nextId++;
    }

   
    public List<Employee> getAllEmployees() {
        return employees;
    }
    public Optional<Employee> findById(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }
    public boolean updateEmployee(int id, String name, String department, double salary) {
        Optional<Employee> match = findById(id);
        if (match.isPresent()) {
            Employee e = match.get();
            if (name != null && !name.isBlank()) e.setName(name);
            if (department != null && !department.isBlank()) e.setDepartment(department);
            if (salary >= 0) e.setSalary(salary);
            return true;
        }
        return false;
    }
    public boolean removeEmployee(int id) {
        return employees.removeIf(e -> e.getId() == id);
    }

    public int count() {
        return employees.size();
    }
}