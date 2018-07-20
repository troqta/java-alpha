package telerik.petukdemo.services;

import telerik.petukdemo.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    Employee findById(int id);

    void updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);
}
