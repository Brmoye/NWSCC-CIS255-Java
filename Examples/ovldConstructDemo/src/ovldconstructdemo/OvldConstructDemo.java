package ovldconstructdemo;

public class OvldConstructDemo {
    public static void main(String[] args) {
        Employee clerk;     //Declare an object name
        Employee driver;
        Employee floorSweeper = new Employee();
        Employee engineer = new Employee(7890, "Incognito", "Ian", 55000.00);
        
        clerk = getEmployeeData();
        driver = getEmployeeData();
        
        displayEmployeeData(clerk);
        displayEmployeeData(driver);
        displayEmployeeData(floorSweeper);
        displayEmployeeData(engineer);
    }
    
    public static Employee getEmployeeData() {
        Employee tempEmp = new Employee();  //Create new object
        int id;
        double sal;
        String strInput;
        
        
    }
}
