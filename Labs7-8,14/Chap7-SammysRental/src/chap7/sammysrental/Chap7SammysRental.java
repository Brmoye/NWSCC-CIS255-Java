/*
 * Author: Brian Moye
 * Date: 2020/12/01
 * Program: Chap7-SammysRental
 * Purpose: Modifies Sammys Rental so that the program asks for a phone number.
 */
package chap7.sammysrental;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Chap7SammysRental {
    public static void main(String[] args) {
        Rental rent1 = new Rental(getContractNumber(), getMinutes(), 
                getPhoneNumber());
        Rental rent2 = new Rental(getContractNumber(), getMinutes(), 
                getPhoneNumber());
        Rental rent3 = new Rental(getContractNumber(), getMinutes(), 
                getPhoneNumber());
        String advertisement = "Coupon good for 10 percent off next rental\n";
        String message = "";
        
        Rental.displayMotto();          //Display Sammy's motto
        displayRentalInfo(rent1);       //Display rental information
        displayRentalInfo(rent2);       //Display rental information
        displayRentalInfo(rent3);       //Display rental information
        getLonger(getLonger(rent1, rent2), rent3);
        Rental shortRental = getShorter(getShorter(rent1, rent2), rent3);
        
        for ( int i = 0; i != shortRental.getHours(); i++ ) {
            message += advertisement;
        }
        JOptionPane.showMessageDialog(null, 
            message, "Annoying Sales Advertisement", JOptionPane.NO_OPTION);
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
    
    public static Rental getShorter(Rental rent1, Rental rent2) {
        if (rent1.getMinutes() > rent2.getMinutes()) {
            return rent2;
        }
        else {
            return rent1;
        }
    }
    
    public static Rental getLonger(Rental rent1, Rental rent2) {
        if (rent1.getMinutes() > rent2.getMinutes()) {
            JOptionPane.showMessageDialog(null, "First rental contract: "
                + rent1.getContractNumber() + "\nLength of rental: "
                + "\nHours: " + rent1.getHours() + " Minutes: " 
                + rent1.getMinutesOver() + "\n\nSecond rental contract: "
                + rent2.getContractNumber() + "\nLength of rental: "
                + "\nHours: " + rent2.getHours() + " Minutes: " 
                + rent2.getMinutesOver() + "\n\nLonger rental contract: "
                + rent1.getContractNumber(), "Sammy's Rental", 
                JOptionPane.INFORMATION_MESSAGE);
            return rent1;
        }
        else {
            JOptionPane.showMessageDialog(null, "First rental contract: "
                + rent1.getContractNumber() + "\nLength of rental: "
                + "\nHours: " + rent1.getHours() + " Minutes: " 
                + rent1.getMinutesOver() + "\n\nSecond rental contract: "
                + rent2.getContractNumber() + "\nLength of rental: "
                + "\nHours: " + rent2.getHours() + " Minutes: " 
                + rent2.getMinutesOver() + "\n\nLonger rental contract: "
                + rent2.getContractNumber(), "Sammy's Rental", 
                JOptionPane.INFORMATION_MESSAGE);
            return rent2;
        }
    }
    
    public static void displayRentalInfo(Rental rent1) {
        DecimalFormat currency = new DecimalFormat("$###,##0.00");
        
        //If there are no minutes over, only display relevant information
        if (rent1.getMinutesOver() == 0) {
            JOptionPane.showMessageDialog(null, 
                "The contact phone number given is: " + rent1.getPhoneNumber()
                + "\nContract number: " + rent1.getContractNumber() +
                "\nHours rented: " + rent1.getHours() + "\nHourly Rate: " 
                + currency.format(Rental.COST_PER_HOUR) + "\nTotal price: " 
                + currency.format(rent1.getPrice()), "Sammy's Rental", 
                JOptionPane.INFORMATION_MESSAGE);
        }
        
        else {
            JOptionPane.showMessageDialog(null, 
                "The contact phone number given is: " + rent1.getPhoneNumber()
                + "\nContract number: " + rent1.getContractNumber() +
                "\nHours rented: " + rent1.getHours() + "\nMinutes over: " 
                + rent1.getMinutesOver() + "\nHourly Rate: " 
                + currency.format(Rental.COST_PER_HOUR) 
                + "\nAdditional cost per minute over: " 
                + currency.format(Rental.COST_PER_MINUTE_OVER) 
                + "\nTotal price: " + currency.format(rent1.getPrice()), 
                "Sammy's Rental Details", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
