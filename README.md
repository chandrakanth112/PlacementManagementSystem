# Student Placement Management System

**Java-based placement system using JDBC and MySQL**

Manage students, companies, and placement applications through a menu-driven console interface.

## Tech Stack

- **Language**: Java
- **Database**: MySQL
- **JDBC Driver**: mysql-connector-java-8.0.33
- **Pattern**: DAO Design Pattern

## Features

- Add and manage students
- Track companies and job postings
- Monitor application status
- Search and filter records
- Update placements

## How to Use

1. Set up MySQL database
2. Update credentials in `DBConnection.java`
3. Run `Main.java` in your IDE
4. Follow the menu options

## Project Structure

```
src/
├── model/       (Student, Company, Application)
├── dao/         (StudentDAO, CompanyDAO)
├── util/        (DBConnection)
└── Main.java
```

## Key Concepts

- OOP principles
- JDBC database connectivity
- SQL operations
- Exception handling
- Collections framework
