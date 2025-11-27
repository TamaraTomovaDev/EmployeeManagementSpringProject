
package org.intecbrussel.employeeproject.config;

import org.intecbrussel.employeeproject.model.Employee;
import org.intecbrussel.employeeproject.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository) {
        return args -> {
            Employee e1 = new Employee();
            e1.setFirstName("Tamara");
            e1.setLastName("Tomova");
            e1.setEmail("tamara@example.com");

            Employee e2 = new Employee();
            e2.setFirstName("Hilal");
            e2.setLastName("Demir");
            e2.setEmail("hilal@example.com");

            repository.save(e1);
            repository.save(e2);
        };
    }
}
