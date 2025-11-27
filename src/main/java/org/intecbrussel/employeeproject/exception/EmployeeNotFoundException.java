package org.intecbrussel.employeeproject.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(Long id) {
        super("Employee met id " + id + " niet gevonden");
    }
}
