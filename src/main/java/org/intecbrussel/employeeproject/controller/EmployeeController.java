
package org.intecbrussel.employeeproject.controller;

import jakarta.validation.Valid;
import org.intecbrussel.employeeproject.dto.EmployeeDTO;
import org.intecbrussel.employeeproject.model.Employee;
import org.intecbrussel.employeeproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    // Haal alle employees op
//    @GetMapping
//    public List<Employee> getAllEmployees() {
//        return employeeService.getAllEmployees();
//    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }


    // Haal één employee op via ID
//    @GetMapping("/{id}")
//    public Employee getEmployeeById(@PathVariable Long id) {
//        return employeeService.getEmployeeById(id);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(mapToDTO(employee));
    }

    // Maak een nieuwe employee
//    @PostMapping
//    public Employee createEmployee(@RequestBody Employee employee) {
//        return employeeService.saveEmployee(employee);
//    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO dto) {
        Employee employee = mapToEntity(dto);
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapToDTO(savedEmployee));
    }


    // Update een bestaande employee
//    @PutMapping("/{id}")
//    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
//        return employeeService.updateEmployee(id, employee);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id,
                                                      @Valid @RequestBody EmployeeDTO dto) {
        Employee employee = mapToEntity(dto);
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(mapToDTO(updatedEmployee));
    }


    // Verwijder een employee
//    @DeleteMapping("/{id}")
//    public void deleteEmployee(@PathVariable Long id) {
//        employeeService.deleteEmployee(id);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    // Mapping helpers
    // Entity -> DTO
    private EmployeeDTO mapToDTO(Employee employee) {
        return new EmployeeDTO(employee.getId(), employee.getFirstName(),
                employee.getLastName(), employee.getEmail());
    }

    // DTO-> Entity
    private Employee mapToEntity(EmployeeDTO dto) {
        return new Employee(dto.getId(), dto.getFirstName(),
                dto.getLastName(), dto.getEmail());
    }
}