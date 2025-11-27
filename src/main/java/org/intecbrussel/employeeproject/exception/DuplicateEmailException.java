package org.intecbrussel.employeeproject.exception;

public class DuplicateEmailException extends RuntimeException{
    public DuplicateEmailException(String email) {
        super("E-mailadres bestaat al: " + email);
    }
}
