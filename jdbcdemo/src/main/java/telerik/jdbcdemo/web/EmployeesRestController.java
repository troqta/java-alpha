package telerik.jdbcdemo.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import telerik.jdbcdemo.Data.EmployeeRepository;
import telerik.jdbcdemo.Data.EmployeeSqlRepository;
import telerik.jdbcdemo.Services.EmployeeService;
import telerik.jdbcdemo.models.Employee;

import java.io.*;
import java.sql.*;
import java.util.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeesRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeesRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping("/")
    List<Employee> getAll() {
       return employeeService.getAll();
    }

    @GetMapping("/find/{name}")
    List<Employee> findByName(@PathVariable("name") String name){
        return employeeService.findByName(name);
    }
}
