package telerik.jdbcdemo.Data;

import org.springframework.stereotype.Repository;
import telerik.jdbcdemo.models.Employee;

import java.util.List;


public interface EmployeeRepository {
    List<Employee> getAll();
    List<Employee> findByName(String name);
}
