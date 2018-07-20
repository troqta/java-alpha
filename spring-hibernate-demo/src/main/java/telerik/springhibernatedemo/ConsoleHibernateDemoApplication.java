package telerik.springhibernatedemo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import telerik.hibernatedemo.models.Employee;
import telerik.springhibernatedemo.models.Employee;

public class ConsoleHibernateDemoApplication {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        Employee e = session.get(Employee.class, 1);
        System.out.println(e.getId() + " " + e.getFirstName() + " " + e.getLastName() + " " + e.getJobTitle());

        session.getTransaction().commit();
        session.close();
    }

}
