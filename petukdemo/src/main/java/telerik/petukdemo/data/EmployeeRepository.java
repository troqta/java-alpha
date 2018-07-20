package telerik.petukdemo.data;

import telerik.petukdemo.models.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee findById(int id);
    List<Employee> getAll();
    void updateEmployee(int id, Employee newEmployee);
    void deleteEmployee(int id);
}
