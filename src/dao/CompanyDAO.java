package dao;

import model.Company;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO {
    public boolean addCompany(Company company) {
        String sql = "INSERT INTO companies (name, field, positions_open, ctc) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, company.getName());
            stmt.setString(2, company.getField());
            stmt.setInt(3, company.getPositionsOpen());
            stmt.setDouble(4, company.getCtc());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error adding company: " + e.getMessage());
            return false;
        }
    }
    
    public Company getCompanyById(int companyId) {
        String sql = "SELECT * FROM companies WHERE company_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, companyId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Company(rs.getInt("company_id"), rs.getString("name"),
                    rs.getString("field"), rs.getInt("positions_open"), rs.getDouble("ctc"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching company: " + e.getMessage());
        }
        return null;
    }
    
    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<>();
        String sql = "SELECT * FROM companies ORDER BY company_id";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                companies.add(new Company(rs.getInt("company_id"), rs.getString("name"),
                    rs.getString("field"), rs.getInt("positions_open"), rs.getDouble("ctc")));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching companies: " + e.getMessage());
        }
        return companies;
    }
    
    public boolean updateCompany(Company company) {
        String sql = "UPDATE companies SET name=?, field=?, positions_open=?, ctc=? WHERE company_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, company.getName());
            stmt.setString(2, company.getField());
            stmt.setInt(3, company.getPositionsOpen());
            stmt.setDouble(4, company.getCtc());
            stmt.setInt(5, company.getCompanyId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updating company: " + e.getMessage());
            return false;
        }
    }
}
