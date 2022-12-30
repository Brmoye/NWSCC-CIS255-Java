package inputdialogdemo;

import javax.swing.JOptionPane;

public class InputDialogDemo {

    public static void main(String[] args) {
        final double HOURS_IN_WEEK = 37.5;
        
        String wageString, dependentString;
        double wage, weeklyWage;
        int dependents;
        
        wageString = JOptionPane.showInputDialog(null, 
                "Enter employee's hourly wage", "Wage Input", 
                JOptionPane.INFORMATION_MESSAGE);
        wage = Double.parseDouble(wageString);
        weeklyWage = wage * HOURS_IN_WEEK;
        dependentString = JOptionPane.showInputDialog(null, 
                "How many dependents?", "Dependents Input", 
                JOptionPane.QUESTION_MESSAGE);
        dependents = Integer.parseInt(dependentString);
        
        JOptionPane.showMessageDialog(null, "Weekly salary is $" + weeklyWage
        + "\nDeductions will be made for " + dependents + " dependents.");
    }
}
