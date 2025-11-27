# Employee Management System

Een eenvoudige **Spring Boot applicatie** met **MySQL** database om werknemers te beheren (CRUD: Create, Read, Update, Delete).

## Wat heb ik gedaan?
- **Model**: `Employee` entity met JPA-annotaties en unieke e-mail.
- **Repository**: `EmployeeRepository` (extends `JpaRepository`).
- **Service**:
    - Interface `EmployeeService` met CRUD-methodes.
    - Implementatie `EmployeeServiceImpl` met businesslogica en exception handling.
- **Controller**: REST API endpoints (`GET`, `POST`, `PUT`, `DELETE`) met **DTO** voor input/output en validatie.
- **Config**: `EmployeeConfig` met `CommandLineRunner` om testdata toe te voegen.
- **Extra**:
    - Custom exceptions (`EmployeeNotFoundException`, `DuplicateEmailException`).
    - `GlobalExceptionHandler` voor nette foutmeldingen.
    - MySQL configuratie in `application.properties`.

## 📂 Projectstructuur
```
org.intecbrussel.employeeproject
│
├── model        → Entity-klassen (Employee)
├── repository   → Database-operaties
├── service      → Business logic
├── controller   → REST API endpoints
├── config       → Configuratie en testdata
├── dto          → Data Transfer Objects
├── exception    → Custom exceptions
└── EmployeeProjectApplication.java → Hoofdklasse Spring Boot
```

## ⚙️ Technologieën
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Jakarta Validation

## 🌐 Endpoints
| Methode | Endpoint     | Beschrijving                  |
|---------|--------------|--------------------------------|
| GET     | `/employees` | Alle werknemers ophalen       |
| GET     | `/employees/{id}`| Werknemer op ID ophalen       |
| POST    | `/employees` | Nieuwe werknemer toevoegen    |
| PUT     | `/employees/{id}`| Werknemer updaten             |
| DELETE  | `/employees/{id}`| Werknemer verwijderen         |
