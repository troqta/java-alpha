package telerik.jdbcdemo.Data;

import telerik.jdbcdemo.models.Employee;

import java.util.List;

public class EmployeeFileRepository implements EmployeeRepository {
    @Override
    public List<Employee> getAll() {

        //read from file
        return null;
    }

    @Override
    public List<Employee> findByName(String name) {
        return null;
    }
}
