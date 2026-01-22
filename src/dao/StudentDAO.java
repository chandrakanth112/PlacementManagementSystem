package dao;

import model.Student;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public boolean addStudent(Student student) {
        String sql = "INSERT INTO students (name, email, cgpa, branch, phone) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setDouble(3, student.getCgpa());
            stmt.setString(4, student.getBranch());
            stmt.setString(5, student.getPhone());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
            return false;
        }
    }
    
    public Student getStudentById(int studentId) {
        String sql = "SELECT * FROM students WHERE student_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(rs.getInt("student_id"), rs.getString("name"), rs.getString("email"),
                    rs.getDouble("cgpa"), rs.getString("branch"), rs.getString("phone"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching student: " + e.getMessage());
        }
        return null;
    }
    
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students ORDER BY student_id";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                students.add(new Student(rs.getInt("student_id"), rs.getString("name"), rs.getString("email"),
                    rs.getDouble("cgpa"), rs.getString("branch"), rs.getString("phone")));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }
        return students;
    }
    
    public List<Student> searchByMinCGPA(double minCGPA) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE cgpa >= ? ORDER BY cgpa DESC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, minCGPA);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                students.add(new Student(rs.getInt("student_id"), rs.getString("name"), rs.getString("email"),
                    rs.getDouble("cgpa"), rs.getString("branch"), rs.getString("phone")));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return students;
    }
    
    public boolean updateStudent(Student student) {
        String sql = "UPDATE students SET name=?, email=?, cgpa=?, branch=?, phone=? WHERE student_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setDouble(3, student.getCgpa());
            stmt.setString(4, student.getBranch());
            stmt.setString(5, student.getPhone());
            stmt.setInt(6, student.getStudentId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
            return false;
        }
    }
    
    public boolean deleteStudent(int studentId) {
        String sql = "DELETE FROM students WHERE student_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
            return false;
        }
    }
}
