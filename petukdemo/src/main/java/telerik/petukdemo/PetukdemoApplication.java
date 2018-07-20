package telerik.petukdemo;

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import telerik.petukdemo.models.Employee;

@Configuration
@SpringBootApplication
public class PetukdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetukdemoApplication.class, args);
    }

    @Bean
    public SessionFactory createFactory(){
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
    }
}
