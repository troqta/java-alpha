package telerik.petukdemo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import telerik.petukdemo.models.Employee;
import telerik.petukdemo.services.EmployeeService;
import telerik.petukdemo.services.EmployeeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService){
        this.employeeService = employeeService;
    }

    @RequestMapping("/{id}")
    public Employee findById(@PathVariable("id") String textId){
        int id = Integer.parseInt(textId);
        return employeeService.findById(id);
    }
    @RequestMapping("/")
    public List<Employee> getAll(){
        return employeeService.getAll();
    }
    @RequestMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") String textId){
        int id = Integer.parseInt(textId);
        employeeService.deleteEmployee(id);
    }

    @RequestMapping("/update/{id}?{firstName}?{lastName}?{jobTitle}")
    public void updateEmployee(@PathVariable("id") String idText,
                               @PathVariable("firstName") String firstName,
                               @PathVariable("lastName") String lastName,
                               @PathVariable("jobTitle") String jobTitle){

        int id = Integer.parseInt(idText);
        Employee newEmployee = new Employee(firstName, lastName, jobTitle);

        employeeService.updateEmployee(id, newEmployee);
    }
}
