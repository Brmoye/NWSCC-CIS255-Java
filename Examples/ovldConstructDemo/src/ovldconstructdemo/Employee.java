
package ovldconstructdemo;

public class Employee {
    private int empNum;
    private String lName, fName;
    private double salary;
    
    public Employee() {
        empNum = 0;
        lName = "Unknown";
        fName = "Unknown";
        salary = 0.00;
    }
    
    public Employee(int newEmpNum) {
        empNum = newEmpNum;
        lName = "Unknown";
        fName = "Unknown";
        salary = 0.00;
    }
    
    public Employee(int newEmpNum, String newLName, String newFName) {
        empNum = newEmpNum;
        lName = newLName;
        fName = newFName;
        salary = 0.00;
    }
    
    public Employee(int newEmpNum, String newLName, String newFName, 
            double newSalary) {
        empNum = newEmpNum;
        lName = newLName;
        fName = newFName;
        salary = newSalary;
    }
    
    public void setEmpNum(int newEmpNum) {
        empNum = newEmpNum;
    }
    
    public void setLName(String newLName) {
        lName = newLName;
    }
    
    public void setFName(String newFName) {
        fName = newFName;
    }
    
    public void setSalary(double newSalary) {
        salary = newSalary;
    }
    
    public int getEmpNum() {
        return empNum;
    }
    
    public String getLName() {
        return lName;
    }
    
    public String getFName() {
        return fName;
    }
    
    public double getSalary() {
        return salary;
    }
}
