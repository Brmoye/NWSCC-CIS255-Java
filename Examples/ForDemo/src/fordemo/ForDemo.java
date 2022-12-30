package fordemo;

import javax.swing.JOptionPane;

public class ForDemo {

    public static void main(String[] args) {
        int i, num, factorial = 1;
        
        num = Integer.parseInt(JOptionPane.showInputDialog(null, 
            "This program calculates a factorial (X! = 1 * 2 * 3... * X)"
            + "\nEnter a number: "));
        
        for (i = 1; i <= num; i++) {
            factorial = factorial * i;
        }
        
        JOptionPane.showMessageDialog(null, "The factorial of " + num 
            + "!" + " is " + factorial);
    }
    
}
