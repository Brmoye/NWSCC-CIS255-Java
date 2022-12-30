/*
 * Author: Brian Moye
 * Date: 2020/08/31
 * Program: Chap2-CarlysEventPrice
 * Purpose: Calculate event cost.
 */
package chap2.carlyseventprice;

import javax.swing.JOptionPane;

public class Chap2CarlysEventPrice {
    public static void main(String[] args) {
        final int PRICE_PER_PERSON = 35;
        final int LARGE_EVENT = 50;

        String strNumOfGuests;
        int numOfGuests, totalPrice;
        
        strNumOfGuests = JOptionPane.showInputDialog(null, 
            "Enter the number of guests:", "Guest Entry", 
            JOptionPane.INFORMATION_MESSAGE);
        numOfGuests = Integer.parseInt(strNumOfGuests);
        
        totalPrice = numOfGuests * PRICE_PER_PERSON;

        JOptionPane.showMessageDialog(null,
            "******************************************************\n"
            + "* Carly's makes the food that makes it a party! *\n"
            + "******************************************************"
            + "\nNumber of Guests: " + numOfGuests + "\nPrice per Guest: "
            + PRICE_PER_PERSON + "\nTotal Price: " + totalPrice
            + "\nLarge event? " + (numOfGuests >= LARGE_EVENT));
    }  
}
