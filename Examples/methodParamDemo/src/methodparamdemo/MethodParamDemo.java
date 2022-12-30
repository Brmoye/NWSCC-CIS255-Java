package methodparamdemo;

import javax.swing.JOptionPane;

public class MethodParamDemo {
    public static void main(String[] args) {
        double price, discount, savings;
        String strInput;
        
        strInput = JOptionPane.showInputDialog(null, 
            "Enter cutoff price for discount:");
        price = Double.parseDouble(strInput);
        strInput = JOptionPane.showInputDialog(null, 
            "Enter discount rate as a percentage:");
        discount = Double.parseDouble(strInput);
        
        savings = computeDiscount(price, discount);
        
        JOptionPane.showMessageDialog(null, 
            "Special this week on any service over $" + price
            + "\nDiscount of " + discount + "%" 
            + "\nThat's a savings of at least $" + savings);
    }
    
    public static double computeDiscount(double newPrice, double newDiscount) {
        double newSavings;
        
        newSavings = newPrice * newDiscount / 100;
        return newSavings;
    }
}
