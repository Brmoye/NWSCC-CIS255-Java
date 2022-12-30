package trycatchlab;

import javax.swing.JOptionPane;

public class TryCatchLab {

    public static void main(String[] args) {
        String strInput;
        int numerator, denominator, result;
        
        strInput = JOptionPane.showInputDialog(null, "Enter a numerator: ");
        numerator = Integer.parseInt(strInput);
        
        strInput = JOptionPane.showInputDialog(null, "Enter a denominator: ");
        denominator = Integer.parseInt(strInput);
        
        try {
            result = numerator / denominator;
            JOptionPane.showMessageDialog(null, "The result of " + numerator 
                + " / " + denominator + " is " + result);
        }
        catch (ArithmeticException err) {
            JOptionPane.showMessageDialog(null, "ERROR: " 
                    + "Cannot divide by zero.\n" + err.getMessage());
        }
        catch (Exception err) {
            JOptionPane.showMessageDialog(null, "ERROR: " 
                    + "An unknown exception has occurred.");
        }
    }
}
