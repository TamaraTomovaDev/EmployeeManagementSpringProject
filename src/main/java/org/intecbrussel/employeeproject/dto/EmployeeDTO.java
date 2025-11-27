package org.intecbrussel.employeeproject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "Voornaam is verplicht")
    private String firstName;
    @NotBlank(message = "Achternaam is verplicht")
    private String lastName;
    @NotBlank(message = "E-mailadres is verplicht")
    @Email(message = "Ongeldig e-mailadres")
    private String email;
}
