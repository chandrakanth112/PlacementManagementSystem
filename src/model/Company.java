package model;

public class Company {
    private int companyId;
    private String name;
    private String field;
    private int positionsOpen;
    private double ctc;
    
    public Company(int companyId, String name, String field, int positionsOpen, double ctc) {
        this.companyId = companyId;
        this.name = name;
        this.field = field;
        this.positionsOpen = positionsOpen;
        this.ctc = ctc;
    }
    
    public Company(String name, String field, int positionsOpen, double ctc) {
        this.name = name;
        this.field = field;
        this.positionsOpen = positionsOpen;
        this.ctc = ctc;
    }
    
    public int getCompanyId() { return companyId; }
    public void setCompanyId(int companyId) { this.companyId = companyId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getField() { return field; }
    public void setField(String field) { this.field = field; }
    public int getPositionsOpen() { return positionsOpen; }
    public void setPositionsOpen(int positionsOpen) { this.positionsOpen = positionsOpen; }
    public double getCtc() { return ctc; }
    public void setCtc(double ctc) { this.ctc = ctc; }
    
    @Override
    public String toString() {
        return String.format("ID: %d | Company: %s | Field: %s | Positions: %d | CTC: %.2f LPA",
                companyId, name, field, positionsOpen, ctc);
    }
}
