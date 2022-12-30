/*
 * Author: Brian Moye
 * Date: 2020/08/31
 * Program: Chap2-SammysRentalPrice
 * Purpose: Calculate rental cost.
 */
package chap3.sammysrentalpricewithmethods;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Chap3SammysRentalPriceWithMethods {
    public static void main(String[] args) {
        Rental rent1 = new Rental();    //Create Rental object
        
        rent1.setContractNumber(getContractNumber());   //Set values
        rent1.setHoursAndMinutes(getMinutes());         //Set values
        Rental.displayMotto();          //Display Sammy's motto
        displayRentalInfo(rent1);       //Display rental information
    }
    
    public static String getContractNumber() {
        String contractNumber = JOptionPane.showInputDialog(null, 
                "Enter the contract number:", "Contract Entry", 
                JOptionPane.QUESTION_MESSAGE);
        return contractNumber;
    }
    
    public static int getMinutes() {
        String strInput;
        
        strInput = JOptionPane.showInputDialog(null, 
            "Enter length of rental in minutes:", "Rental Time", 
            JOptionPane.QUESTION_MESSAGE);
        
        return Integer.parseInt(strInput);
    }
    
    public static void displayRentalInfo(Rental rent1) {
        DecimalFormat currency = new DecimalFormat("$###,###.00");
        
        //If there are no minutes over, only display relevant information
        if (rent1.getMinutes() == 0) {
            JOptionPane.showMessageDialog(null, 
                "Contract number: " + rent1.getContractNumber() +
                "\nHours rented: " + rent1.getHours() + "\nHourly Rate: " 
                + currency.format(Rental.COST_PER_HOUR) + "\nTotal price: " 
                + currency.format(rent1.getPrice()), "Sammy's Rental", 
                JOptionPane.INFORMATION_MESSAGE);
        }
        
        else {
            JOptionPane.showMessageDialog(null, 
                "Contract number: " + rent1.getContractNumber() +
                "\nHours rented: " + rent1.getHours() + "\nMinutes over: " 
                + rent1.getMinutes() + "\nHourly Rate: " 
                + currency.format(Rental.COST_PER_HOUR) 
                + "\nAdditional cost per minute over: " 
                + currency.format(Rental.COST_PER_MINUTE_OVER) + "\nTotal price: " 
                + currency.format(rent1.getPrice()), "Sammy's Rental Details", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
