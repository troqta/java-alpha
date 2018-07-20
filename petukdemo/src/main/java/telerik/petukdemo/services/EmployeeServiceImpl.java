package telerik.petukdemo.services;

import org.springframework.stereotype.Service;
import telerik.petukdemo.data.EmployeeRepository;
import telerik.petukdemo.data.EmployeeRepositoryDb;
import telerik.petukdemo.models.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepositoryDb employeeRepository){
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        employeeRepository.updateEmployee(id, employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }
}
