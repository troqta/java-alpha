package telerik.jdbcdemo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import telerik.jdbcdemo.Data.EmployeeRepository;
import telerik.jdbcdemo.models.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }
}
