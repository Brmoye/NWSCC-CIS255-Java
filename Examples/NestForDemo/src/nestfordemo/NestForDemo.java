package nestfordemo;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class NestForDemo {

    public static void main(String[] args) {

        final double LOW = 0.02, HIGH = 0.05, INCREMENT = 0.01, MAX_YEAR = 4;
        double initBal, bal, interest;
        int year;
        String message = "";
        DecimalFormat currencyFmt = new DecimalFormat("$###,###,##0.00");
        DecimalFormat interestFmt = new DecimalFormat("0.0%");
        
        initBal = Double.parseDouble(JOptionPane.showInputDialog(null, 
                "Enter initial bank balance:"));
        
        for (interest = LOW; interest <= HIGH; interest += INCREMENT) {
            bal = initBal;
            message += "With an initial balance of " + currencyFmt.format(bal) 
                    + " at an interest rate of " 
                    + interestFmt.format(interest) + "\n";
            for ( year = 1; year <= MAX_YEAR; year++ ) {
                bal = bal + bal * interest;
                message += "        After year " + year + " balance is " 
                        + currencyFmt.format(bal) + "\n";
            }
        }
        
        JOptionPane.showMessageDialog(null, message);
    }
}
