import util.DBConnection;
import model.Student;
import model.Company;
import dao.StudentDAO;
import dao.CompanyDAO;
import java.util.List;
import java.util.Scanner;

public class Main {
    static StudentDAO studentDAO = new StudentDAO();
    static CompanyDAO companyDAO = new CompanyDAO();
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║ STUDENT PLACEMENT MANAGEMENT SYSTEM    ║");
        System.out.println("╚════════════════════════════════════════╝\n");
        
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getInput();
            
            switch (choice) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    companyMenu();
                    break;
                case 3:
                    System.out.println("\n✓ Thank you for using the system!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
        sc.close();
    }
    
    static void displayMainMenu() {
        System.out.println("\n┌─ MAIN MENU ──────────────────────────┐");
        System.out.println("│ 1. Student Management                │");
        System.out.println("│ 2. Company Management                │");
        System.out.println("│ 3. Exit                              │");
        System.out.println("└──────────────────────────────────────┘");
        System.out.print("Enter your choice: ");
    }
    
    static void studentMenu() {
        boolean inStudentMenu = true;
        while (inStudentMenu) {
            System.out.println("\n┌─ STUDENT MANAGEMENT ──────────────────┐");
            System.out.println("│ 1. Add Student                       │");
            System.out.println("│ 2. View All Students                 │");
            System.out.println("│ 3. Search Student by ID              │");
            System.out.println("│ 4. Search by CGPA                    │");
            System.out.println("│ 5. Update Student                    │");
            System.out.println("│ 6. Delete Student                    │");
            System.out.println("│ 7. Back to Main Menu                 │");
            System.out.println("└──────────────────────────────────────┘");
            System.out.print("Enter your choice: ");
            
            int choice = getInput();
            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewAllStudents(); break;
                case 3: searchStudentById(); break;
                case 4: searchByMinCGPA(); break;
                case 5: updateStudent(); break;
                case 6: deleteStudent(); break;
                case 7: inStudentMenu = false; break;
                default: System.out.println("Invalid choice!");
            }
        }
    }
    
    static void addStudent() {
        System.out.println("\n--- Add New Student ---");
        System.out.print("Enter Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter Email: ");
        String email = sc.nextLine().trim();
        System.out.print("Enter CGPA: ");
        double cgpa = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Branch: ");
        String branch = sc.nextLine().trim();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine().trim();
        
        Student student = new Student(name, email, cgpa, branch, phone);
        if (studentDAO.addStudent(student)) {
            System.out.println("✓ Student added successfully!");
        } else {
            System.out.println("✗ Failed to add student.");
        }
    }
    
    static void viewAllStudents() {
        System.out.println("\n--- All Students ---");
        List<Student> students = studentDAO.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }
    
    static void searchStudentById() {
        System.out.println("\n--- Search Student by ID ---");
        System.out.print("Enter Student ID: ");
        int id = getInput();
        Student student = studentDAO.getStudentById(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("✗ Student not found.");
        }
    }
    
    static void searchByMinCGPA() {
        System.out.println("\n--- Search by CGPA ---");
        System.out.print("Enter minimum CGPA: ");
        double minCGPA = sc.nextDouble();
        sc.nextLine();
        List<Student> students = studentDAO.searchByMinCGPA(minCGPA);
        if (students.isEmpty()) {
            System.out.println("No students with CGPA >= " + minCGPA);
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }
    
    static void updateStudent() {
        System.out.println("\n--- Update Student ---");
        System.out.print("Enter Student ID: ");
        int id = getInput();
        Student existing = studentDAO.getStudentById(id);
        if (existing == null) {
            System.out.println("✗ Student not found.");
            return;
        }
        System.out.print("Enter new Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter new CGPA: ");
        double cgpa = sc.nextDouble();
        sc.nextLine();
        Student updated = new Student(id, name, existing.getEmail(), cgpa, existing.getBranch(), existing.getPhone());
        if (studentDAO.updateStudent(updated)) {
            System.out.println("✓ Student updated successfully!");
        } else {
            System.out.println("✗ Failed to update student.");
        }
    }
    
    static void deleteStudent() {
        System.out.println("\n--- Delete Student ---");
        System.out.print("Enter Student ID: ");
        int id = getInput();
        System.out.print("Are you sure? (yes/no): ");
        String confirm = sc.nextLine().trim().toLowerCase();
        if (confirm.equals("yes")) {
            if (studentDAO.deleteStudent(id)) {
                System.out.println("✓ Student deleted successfully!");
            } else {
                System.out.println("✗ Failed to delete student.");
            }
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
    
    static void companyMenu() {
        boolean inCompanyMenu = true;
        while (inCompanyMenu) {
            System.out.println("\n┌─ COMPANY MANAGEMENT ──────────────────┐");
            System.out.println("│ 1. Add Company                       │");
            System.out.println("│ 2. View All Companies                │");
            System.out.println("│ 3. Search Company by ID              │");
            System.out.println("│ 4. Back to Main Menu                 │");
            System.out.println("└──────────────────────────────────────┘");
            System.out.print("Enter your choice: ");
            
            int choice = getInput();
            switch (choice) {
                case 1: addCompany(); break;
                case 2: viewAllCompanies(); break;
                case 3: searchCompanyById(); break;
                case 4: inCompanyMenu = false; break;
                default: System.out.println("Invalid choice!");
            }
        }
    }
    
    static void addCompany() {
        System.out.println("\n--- Add New Company ---");
        System.out.print("Enter Company Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter Field: ");
        String field = sc.nextLine().trim();
        System.out.print("Enter Open Positions: ");
        int positions = getInput();
        System.out.print("Enter CTC (LPA): ");
        double ctc = sc.nextDouble();
        sc.nextLine();
        Company company = new Company(name, field, positions, ctc);
        if (companyDAO.addCompany(company)) {
            System.out.println("✓ Company added successfully!");
        } else {
            System.out.println("✗ Failed to add company.");
        }
    }
    
    static void viewAllCompanies() {
        System.out.println("\n--- All Companies ---");
        List<Company> companies = companyDAO.getAllCompanies();
        if (companies.isEmpty()) {
            System.out.println("No companies found.");
        } else {
            for (Company c : companies) {
                System.out.println(c);
            }
        }
    }
    
    static void searchCompanyById() {
        System.out.println("\n--- Search Company by ID ---");
        System.out.print("Enter Company ID: ");
        int id = getInput();
        Company company = companyDAO.getCompanyById(id);
        if (company != null) {
            System.out.println(company);
        } else {
            System.out.println("✗ Company not found.");
        }
    }
    
    static int getInput() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
