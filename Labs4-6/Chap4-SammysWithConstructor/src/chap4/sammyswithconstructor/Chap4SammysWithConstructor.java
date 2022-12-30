/*
 * Author: Brian Moye
 * Date: 2020/09/30
 * Program: Chap4-SammysWithConstructor
 * Purpose: Calculate rental cost with constructor
 */
package chap4.sammyswithconstructor;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Chap4SammysWithConstructor {
    public static void main(String[] args) {
        Rental rent1 = new Rental();
        Rental rent2 = new Rental(getContractNumber(), getMinutes());
        
        Rental.displayMotto();          //Display Sammy's motto
        displayRentalInfo(rent1);       //Display rental information
        displayRentalInfo(rent2);       //Display rental information
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
        DecimalFormat currency = new DecimalFormat("$###,##0.00");
        
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
