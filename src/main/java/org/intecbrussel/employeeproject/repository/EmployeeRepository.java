package org.intecbrussel.employeeproject.repository;

import org.intecbrussel.employeeproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Zoek een werknemer op e-mailadres
    Optional<Employee> findByEmail(String email);

    // Controleer of een e-mailadres al bestaat
    boolean existsByEmail(String email);
}
