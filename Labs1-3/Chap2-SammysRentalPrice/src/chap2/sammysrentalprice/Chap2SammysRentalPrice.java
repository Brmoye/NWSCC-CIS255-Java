/*
 * Author: Brian Moye
 * Date: 2020/08/31
 * Program: Chap2-SammysRentalPrice
 * Purpose: Calculate rental cost.
 */
package chap2.sammysrentalprice;

import javax.swing.JOptionPane;
public class Chap2SammysRentalPrice {
    public static void main(String[] args) {
        final int COST_PER_HOUR = 40;
        final int COST_PER_MINUTE_OVER = 1;
        
        String strMinutesRented;
        int minutesRented, hoursRented, minutesOver, totalPrice;
        
        strMinutesRented = JOptionPane.showInputDialog(null, 
            "Enter length of rental in minutes:", "Rental Time", 
            JOptionPane.QUESTION_MESSAGE);
        
        minutesRented = Integer.parseInt(strMinutesRented);
        hoursRented = minutesRented / 60;
        if (hoursRented < 1) {
            hoursRented = 1;
            minutesOver = 0;
        }
        else {
            minutesOver = minutesRented % 60;
        }
        
        totalPrice = (hoursRented * COST_PER_HOUR + minutesOver * 
                COST_PER_MINUTE_OVER);
        
        JOptionPane.showMessageDialog(null, 
            "SsSsSsSsSsSsSsSsSsSsSsSsSsSsSs\n"
            + "Ss Sammy’s makes it fun in the sun! Ss\n"
            + "SsSsSsSsSsSsSsSsSsSsSsSsSsSsSs" + "\n\nHours rented: "
            + hoursRented + "\nMinutes over: " + minutesOver + "\nTotal price: "
            + totalPrice);
    }
}
