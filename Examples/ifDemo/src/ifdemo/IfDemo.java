package ifdemo;

import javax.swing.JOptionPane;

public class IfDemo {

    public static void main(String[] args) {
        final int CLOTHING_CODE = 1, OTHER_CODE = 2;
        final String CLOTHING_PRICER = "Regina", OTHER_PRICER = "Marco";
        int donationType;
        String volunteer, message;
        
        donationType = Integer.parseInt(JOptionPane.showInputDialog(null, 
            "What type of donation is this?\n\n" + CLOTHING_CODE 
            + " - Clothing\n" + OTHER_CODE + " - Other", "Donation Type", 
            JOptionPane.INFORMATION_MESSAGE));
        
        if (donationType == CLOTHING_CODE) {
            volunteer = CLOTHING_PRICER;
            message = "a clothing donation.";
        }
        else {
            volunteer = OTHER_PRICER;
            message = "a non-clothing donation.";
        }
        
        JOptionPane.showMessageDialog(null, "You entered " + donationType
            + "\nThis is " + message + "\nThe volunteer pricer will be " 
            + volunteer, "Pricing Info", JOptionPane.INFORMATION_MESSAGE);
    }
}
