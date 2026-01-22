# Student Placement Management System

**Java-based Student Placement Management System using JDBC and MySQL**

A comprehensive console application for managing student placements. Track students, companies, and applications all in one place.

## What is this project?

I built this system to handle the placement process efficiently. It's a complete, working solution that manages students, tracks which companies are recruiting, and monitors the status of each application.

Key features:
- **OOP concepts** - Uses proper encapsulation, abstraction, and inheritance
- **Database-driven** - Built with JDBC to connect to MySQL
- **DAO Pattern** - Clean separation between data access and business logic
- **Collections** - Uses ArrayList and HashMap for dynamic data storage
- **Exception handling** - Proper try-catch blocks and SQL error handling
- **Menu-driven interface** - Easy to navigate console UI

## Tech Stack

- **Language**: Java
- **Database**: MySQL
- **JDBC Driver**: mysql-connector-java-8.0.33
- **Architecture**: DAO Design Pattern
- **Collections**: ArrayList, HashMap

## What can you do with it?

### Manage Students
- Add new students (with CGPA, branch, phone number)
- Search for students by ID
- Filter students by minimum CGPA
- Update student details
- Delete student records
- View complete student list

### Manage Companies
- Add recruiting companies
- Set positions available and CTC offered
- Search companies by ID
- View all companies

### Track Applications
- Apply students to companies
- Track application status (Applied → Shortlisted → Selected/Rejected)
- Update application status as students progress
- View final placements

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
│   ├── util/
│   │   └── DBConnection.java
│   └── Main.java
```

## How to use it

1. Set up MySQL database
2. Update database credentials in `DBConnection.java`
3. Run `Main.java` in your IDE
4. Follow the console menu options

## Learning Concepts

This project demonstrates:
- Core OOP principles (classes, objects, inheritance)
- JDBC basics (connecting to databases, executing queries)
- SQL operations (INSERT, UPDATE, DELETE, SELECT)
- Data structure concepts
- Exception handling patterns
- Design patterns (DAO)

---

**Built for**: Campus placements, learning Java fundamentals
**Perfect for**: Portfolio, interviews, understanding real-world Java applications
