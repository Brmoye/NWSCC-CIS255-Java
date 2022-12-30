package dowhiledemo;

import javax.swing.JOptionPane;

public class DoWhileDemo {

    public static void main(String[] args) {
        final int CLOTHING_CODE = 1, FURNITURE_CODE = 2;
        final int ELECTRONICS_CODE = 3, OTHER_CODE = 4;
        final int QUIT_CODE = 0;
        final String CLOTHING_PRICER = "Regina", FURNITURE_PRICER = "Walter";
        final String ELECTRONICS_PRICER = "Lydia", OTHER_PRICER = "Marco";
        int donationType;
        String volunteer = "", message;
        
        do {
            donationType = Integer.parseInt(JOptionPane.showInputDialog(null, 
                "What type of donation is this?\n\n" 
                + CLOTHING_CODE + " - Clothing\n" 
                + FURNITURE_CODE + " - Furniture\n" 
                + ELECTRONICS_CODE + " - Electronics\n"
                + OTHER_CODE + " - Other\n"
                + QUIT_CODE + " - Quit", "Donation Type", 
                JOptionPane.INFORMATION_MESSAGE));
        
        
            switch(donationType){
                 case CLOTHING_CODE:
                    volunteer = CLOTHING_PRICER;
                    message = "a clothing donation.";
                    break;
                 case FURNITURE_CODE:
                    volunteer = FURNITURE_PRICER;
                    message = "a furniture donation.";
                    break;
                 case ELECTRONICS_CODE:
                    volunteer = ELECTRONICS_PRICER;
                    message = "an electronics donation.";
                    break;
                 case OTHER_CODE:
                    volunteer = OTHER_PRICER;
                    message = "another donation type.";
                    break;
                 case QUIT_CODE:
                     message = "Thank you for using this program.";
                     break;
                 default:
                     volunteer = "invalid";
                     message = "an invalid donation type.";
            }

            if (donationType == QUIT_CODE){
                JOptionPane.showMessageDialog(null, message, 
                    "Pricing Info", JOptionPane.INFORMATION_MESSAGE);
            }

            else {
                JOptionPane.showMessageDialog(null, "You entered " + donationType
                    + "\nThis is " + message + "\nThe volunteer pricer will be " 
                    + volunteer, "Pricing Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } while(donationType != QUIT_CODE);
    }
}
