/*
 * Author: Brian Moye
 * Date: 2020/12/02
 * Program: Chap8-SammysRental
 * Purpose: Modifies Sammys Rental so that the program defines rental type.
 */
package chap8.sammysrental;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Chap8SammysRental {
    public static void main(String[] args) {
        Rental[] rentals = new Rental[3];
        
        for (int i = 0; i < rentals.length; i++) {
            rentals[i] = new Rental(getContractNumber(), getMinutes(), 
                    getPhoneNumber(), getRentalType());
        }
        
        Rental.displayMotto();          //Display Sammy's motto
        for (Rental rental : rentals) {
            displayRentalInfo(rental); //Display rental information
        }
    }
    
    public static String getContractNumber() {
        String contractNumber = JOptionPane.showInputDialog(null, 
                "Enter the contract number:", "Contract Entry", 
                JOptionPane.QUESTION_MESSAGE);
        return contractNumber;
    }
    
    public static int getMinutes() {
        String strInput;
        int inputInt;
        
        strInput = JOptionPane.showInputDialog(null, 
            "Enter length of rental in minutes:", "Rental Time", 
            JOptionPane.QUESTION_MESSAGE);
        
        inputInt = Integer.parseInt(strInput);
        
        if( inputInt < 60 || inputInt > 7200 ) {
            JOptionPane.showMessageDialog(null,
                "Number of minutes must be between 60 and 7200",
                "Rental Entry", 
                JOptionPane.INFORMATION_MESSAGE);
            inputInt = getMinutes();
        }
        
        return inputInt;
    }
    
    public static String getPhoneNumber() {
        String inputStr;
        
        inputStr = JOptionPane.showInputDialog(null, 
            "Enter a contact phone number:", "Phone Number Entry", 
            JOptionPane.QUESTION_MESSAGE);
        
        return inputStr;
    }
    
    public static int getRentalType() {
        String inputStr;
        
        inputStr = JOptionPane.showInputDialog(null, 
            "Please enter the number of the corresponding rental type:\n" 
            + "1 - Personal Watercraft\n" + "2 - Pontoon Boat\n" 
            + "3 - Rowboat\n" + "4 - Canoe\n" + "5 - Kayak\n" 
            + "6 - Beach Chair\n" + "7 - Umbrella\n" + "8 - Other", 
            "Rental Type Entry", JOptionPane.QUESTION_MESSAGE);
        
        return Integer.parseInt(inputStr) - 1;
    }
    
    public static void displayRentalInfo(Rental rent) {
        DecimalFormat currency = new DecimalFormat("$###,##0.00");
        
        //If there are no minutes over, only display relevant information
        if (rent.getMinutesOver() == 0) {
            JOptionPane.showMessageDialog(null, 
                "The contact phone number given is: " + rent.getPhoneNumber()
                + "\nContract number: " + rent.getContractNumber() 
                + "\nYou have chosen to rent a(n) " + rent.getRentalType() 
                + " for " + rent.getHours() + " hour(s) at an hourly rate of: " 
                + currency.format(Rental.COST_PER_HOUR) 
                + "\nThe total price is: " + currency.format(rent.getPrice()), 
                "Sammy's Rental", JOptionPane.INFORMATION_MESSAGE);
        }
        
        else {
            JOptionPane.showMessageDialog(null, 
                "The contact phone number given is: " + rent.getPhoneNumber()
                + "\nContract number: " + rent.getContractNumber() 
                + "\nYou have chosen to rent a(n) " + rent.getRentalType() 
                + " for " + rent.getHours() + " hour(s) and " 
                + rent.getMinutesOver() + " minutes." 
                + "\nAt an hourly rate of: " 
                + currency.format(Rental.COST_PER_HOUR) 
                + "\nWith an additional cost per minute over of: " 
                + currency.format(Rental.COST_PER_MINUTE_OVER) 
                + "\nThe total price is: " + currency.format(rent.getPrice()), 
                "Sammy's Rental Details", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
