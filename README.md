# Student Placement Management System

**Java-based Student Placement Management System using JDBC and MySQL**

Manage students, companies, and placement applications with a comprehensive menu-driven interface.

## Project Overview

A complete, production-ready placement management system demonstrating:
- OOP concepts (Encapsulation, Abstraction, Inheritance)
- JDBC for database connectivity
- MySQL database management
- DAO (Data Access Object) design pattern
- Collections Framework
- Exception handling
- Menu-driven console application

## Tech Stack

- **Language**: Java
- **Database**: MySQL
- **Database Driver**: JDBC (mysql-connector-java-8.0.33)
- **Pattern**: DAO Design Pattern
- **Collections**: ArrayList, HashMap

## Features

### Student Management
- Add new students with CGPA, branch, and contact info
- View all students
- Search students by ID
- Search students by minimum CGPA
- Update student information
- Delete student records

### Company Management
- Add new companies with positions and CTC
- View all companies
- Search companies by ID

### Application Management
- Apply students to companies
- Track application status (Applied, Shortlisted, Selected, Rejected)
- Update application status
- View placements

## Project Structure

```
PlacementManagementSystem/
├── src/
│   ├── model/
│   │   ├── Student.java
│   │   ├── Company.java
│   │   └── Application.java
│   ├── dao/
│   │   ├── StudentDAO.java
│   │   └── CompanyDAO.java
│   ├── service/
│   │   └── PlacementService.java
│   ├── util/
│   │   └── DBConnection.java
│   └── Main.java
├── lib/
│   └── mysql-connector-java-8.0.33.jar
└── README.md
```

## Quick Start Guide

### Prerequisites
- Java JDK 8 or higher
- MySQL Server
- MySQL JDBC Driver

### Step 1: Download MySQL JDBC Driver

```bash
# Download from:
https://dev.mysql.com/downloads/connector/j/
# Extract and place mysql-connector-java-8.0.33.jar in lib/ folder
```

### Step 2: Create MySQL Database

```sql
CREATE DATABASE placement_db;
USE placement_db;

CREATE TABLE students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    cgpa DECIMAL(3,2),
    branch VARCHAR(50),
    phone VARCHAR(10),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE companies (
    company_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    field VARCHAR(100),
    positions_open INT,
    ctc DECIMAL(10,2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE applications (
    application_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    company_id INT NOT NULL,
    status ENUM('Applied', 'Shortlisted', 'Selected', 'Rejected') DEFAULT 'Applied',
    applied_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (company_id) REFERENCES companies(company_id)
);
```

### Step 3: Compile and Run

```bash
# Navigate to project root
cd PlacementManagementSystem

# Compile
javac -cp lib/mysql-connector-java-8.0.33.jar -d bin src/util/*.java src/model/*.java src/dao/*.java src/service/*.java src/*.java

# Run
java -cp bin:lib/mysql-connector-java-8.0.33.jar Main
```

## How to Use

1. Run the application
2. Choose from main menu:
   - **1**: Student Management
   - **2**: Company Management
   - **3**: Application Management
   - **4**: Exit

3. Follow on-screen prompts for each operation

## Sample Data to Test

```
Student 1: Ram Kumar, ram@college.com, CGPA: 8.5, CSE, 9876543210
Student 2: Priya Singh, priya@college.com, CGPA: 7.8, ECE, 9123456789

Company 1: Google, IT, 50 positions, 15 LPA
Company 2: Microsoft, IT, 40 positions, 14 LPA
Company 3: Goldman Sachs, Finance, 25 positions, 20 LPA
```

## Resume Description (ATS-Optimized)

> Developed a Java-based Student Placement Management System using JDBC and MySQL to manage student records, company applications, and placement status. Implemented modular OOP-based design with efficient database operations, search functionality, and DAO pattern for data abstraction.

## Key Java Concepts Demonstrated

✅ **OOP**: Classes, Objects, Encapsulation, Abstraction  
✅ **JDBC**: PreparedStatement, ResultSet, Connection Pooling  
✅ **Database**: SQL Queries, Foreign Keys, Transactions  
✅ **Collections**: ArrayList for dynamic data storage  
✅ **Exception Handling**: Try-catch blocks, SQLException handling  
✅ **Design Pattern**: DAO for data access layer  
✅ **String Formatting**: Printf-style output  

## Placement Interview Talking Points

1. **Database Design**: Explain normalization and foreign key relationships
2. **JDBC Best Practices**: Connection management, prepared statements for SQL injection prevention
3. **DAO Pattern**: Why separate data access from business logic
4. **Error Handling**: How exceptions are managed
5. **Scalability**: How system can be extended (Spring Boot, REST API)

## Future Enhancements

- [ ] GUI using JavaFX or Swing
- [ ] Spring Boot backend
- [ ] REST API integration
- [ ] Authentication system
- [ ] Email notifications
- [ ] CSV export reports
- [ ] Web dashboard

## License

MIT License - feel free to use for learning and projects

## Support

For issues or questions, create an issue in the repository.

---

**Made for placement preparation at top tech companies** 🚀
