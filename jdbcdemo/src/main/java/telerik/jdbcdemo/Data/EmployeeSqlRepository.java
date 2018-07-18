package telerik.jdbcdemo.Data;

import org.springframework.stereotype.Repository;
import telerik.jdbcdemo.models.Employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Repository
public class EmployeeSqlRepository implements EmployeeRepository {

    @Override
    public List<Employee> getAll() {
        String configFile = "src\\main\\resources\\application.properties";
        Properties dbConfig = new Properties();
        try (FileInputStream fis = new FileInputStream(configFile)) {
            dbConfig.load(fis);
        } catch (FileNotFoundException e) {
            System.out.println("prop file not found");
        } catch (IOException e) {
            System.out.println("unable to read prop file");
        }

        String dbUrl = dbConfig.getProperty("dbUrl");
        String dbUserName = dbConfig.getProperty("dbUserName");
        String dbPassword = dbConfig.getProperty("dbPassword");

        List<Employee> resultEmployees = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
             Statement statement = connection.createStatement()) {
            String query = "select firstname, lastname, jobtitle from employees";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                Employee employee = new Employee(
                        result.getString("firstname"),
                        result.getString("lastname"),
                        result.getString("jobtitle")
                );
                resultEmployees.add(employee);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultEmployees;
    }

    @Override
    public List<Employee> findByName(String name) {
        String configFile = "src\\main\\resources\\application.properties";
        Properties dbConfig = new Properties();
        try (FileInputStream fis = new FileInputStream(configFile)) {
            dbConfig.load(fis);
        } catch (FileNotFoundException e) {
            System.out.println("prop file not found");
        } catch (IOException e) {
            System.out.println("unable to read prop file");
        }

        String dbUrl = dbConfig.getProperty("dbUrl");
        String dbUserName = dbConfig.getProperty("dbUserName");
        String dbPassword = dbConfig.getProperty("dbPassword");

        String query = "select firstname, lastname, jobtitle from employees where firstname = ?";

        List<Employee> resultEmployees = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Employee employee = new Employee(
                        result.getString("firstname"),
                        result.getString("lastname"),
                        result.getString("jobtitle")
                );
                resultEmployees.add(employee);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultEmployees;
    }
}
