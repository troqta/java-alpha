package telerik.petukdemo.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import telerik.petukdemo.models.Employee;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryDb implements EmployeeRepository {
    private SessionFactory factory;

    @Autowired
    public EmployeeRepositoryDb(SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public Employee findById(int id) {
        Employee e = null;

        try (Session session = factory.openSession()) {
            session.beginTransaction();

            e = session.get(Employee.class, id);

            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return e;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> result = new ArrayList<>();
        try (Session session = factory.openSession()) {

            session.beginTransaction();


            result = session.createQuery("FROM Employee").list();

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    @Override
    public void updateEmployee(int id, Employee newEmployee) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            session.createQuery("update Employee set firstName = " + newEmployee.getFirstName() + "where id = " + id);
            session.createQuery("update Employee set lastName = " + newEmployee.getLastName() + "where id = " + id);
            session.createQuery("update Employee set jobTitle = " + newEmployee.getJobTitle() + "where id = " + id);
        } catch (Exception exception1) {
            System.out.println(exception1.getMessage());
        }
    }

    @Override
    public void deleteEmployee(int id) {
        Employee e = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            session.createQuery("delete Employee where id = " + id);

            session.getTransaction().commit();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }
}
