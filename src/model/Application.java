package model;
import java.time.LocalDateTime;

public class Application {
    private int applicationId;
    private int studentId;
    private int companyId;
    private String status;
    private LocalDateTime appliedDate;
    
    public Application(int applicationId, int studentId, int companyId, String status, LocalDateTime appliedDate) {
        this.applicationId = applicationId;
        this.studentId = studentId;
        this.companyId = companyId;
        this.status = status;
        this.appliedDate = appliedDate;
    }
    
    public Application(int studentId, int companyId, String status) {
        this.studentId = studentId;
        this.companyId = companyId;
        this.status = status;
        this.appliedDate = LocalDateTime.now();
    }
    
    public int getApplicationId() { return applicationId; }
    public void setApplicationId(int applicationId) { this.applicationId = applicationId; }
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public int getCompanyId() { return companyId; }
    public void setCompanyId(int companyId) { this.companyId = companyId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getAppliedDate() { return appliedDate; }
    public void setAppliedDate(LocalDateTime appliedDate) { this.appliedDate = appliedDate; }
    
    @Override
    public String toString() {
        return String.format("App ID: %d | Student ID: %d | Company ID: %d | Status: %s | Date: %s",
                applicationId, studentId, companyId, status, appliedDate);
    }
}
