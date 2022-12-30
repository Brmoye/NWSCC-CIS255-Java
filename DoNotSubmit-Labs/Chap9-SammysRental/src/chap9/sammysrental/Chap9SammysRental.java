/*
 * Author: Brian Moye
 * Date: 2020/12/05
 * Program: Chap9-SammysRental
 * Purpose: Modifies Sammys Rental so it can be sorted.
 */
package chap9.sammysrental;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Chap9SammysRental {
    
    static int exit = 0;
    
    public static void main(String[] args) {
        Rental[] rentals = new Rental[8];
        
        for (int i = 0; i < rentals.length; i++) {
            rentals[i] = new Rental(getContractNumber(), getMinutes(), 
                    getPhoneNumber(), getRentalType());
        }
        
//      Test Rentals
//        rentals[0] = new Rental("B232", 120, "(555)555-5555", 7);
//        rentals[1] = new Rental("L022", 66, "123555-5555", 4);
//        rentals[2] = new Rental("C131", 124, "(555)5255225", 3);
//        rentals[3] = new Rental("H0312", 300, "1234567890", 1);
//        rentals[4] = new Rental("E073", 88, "12345678901", 0);
//        rentals[5] = new Rental("A683", 360, "0", 6);
//        rentals[6] = new Rental("B200", 98, "1234", 2);
//        rentals[7] = new Rental("Z666", 160, "abcdefghij", 5);
        
        Rental.displayMotto();          // Display Sammy's motto
        
        while(exit != 1) {
            displayRentalInfoArray(rentals);
            pickSort(rentals);
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
    
    public static Rental[] sortRentalByContractNumber(Rental[] rentals) {
        int outerCount = 1;
        int innerCount;
        Rental tempRental;
        
        while(outerCount < rentals.length) {
            tempRental = rentals[outerCount];
            innerCount = outerCount - 1;
            while(innerCount >= 0 && rentals[innerCount].getContractNumber()
                    .compareTo(tempRental.getContractNumber()) > 0) {
                rentals[innerCount + 1] = rentals[innerCount];
                innerCount--;
            }
            rentals[innerCount + 1] = tempRental;
            outerCount++;
        }
        return rentals;
    }
    
    public static Rental[] sortRentalByPrice(Rental[] rentals) {
        int outerCount = 1;
        int innerCount;
        Rental tempRental;
        
        while(outerCount < rentals.length) {
            tempRental = rentals[outerCount];
            innerCount = outerCount - 1;
            while(innerCount >= 0 && rentals[innerCount].getPrice()
                    > tempRental.getPrice()) {
                rentals[innerCount + 1] = rentals[innerCount];
                innerCount--;
            }
            rentals[innerCount + 1] = tempRental;
            outerCount++;
        }
        return rentals;
    }
    
    public static Rental[] sortRentalByRentalType(Rental[] rentals) {
        int outerCount = 1;
        int innerCount;
        Rental tempRental;
        
        while(outerCount < rentals.length) {
            tempRental = rentals[outerCount];
            innerCount = outerCount - 1;
            while(innerCount >= 0 && rentals[innerCount].getRentalTypeInt()
                    > tempRental.getRentalTypeInt()) {
                rentals[innerCount + 1] = rentals[innerCount];
                innerCount--;
            }
            rentals[innerCount + 1] = tempRental;
            outerCount++;
        }
        return rentals;
    }
    
    public static void pickSort(Rental[] rentals) {
        
        int choice = Integer.parseInt(JOptionPane.showInputDialog(null, 
                "Sort by:\n" + "1 - Contract Number\n" + "2 - Price\n" 
                + "3 - Rental Type\n" + "9 - Exit"));
        switch (choice) {
            case 1:
                sortRentalByContractNumber(rentals);
                break;
            case 3:
                sortRentalByRentalType(rentals);
                break;
            case 9:
                exit = 1;
                break;
            default:
                sortRentalByPrice(rentals);
                break;
        }
    }
    
    public static void displayRentalInfoArray(Rental[] rentals) {
        String message = "";
        
        // For each rental in rentals[]
        for (Rental rental : rentals) {
            message += displayRentalInfo(rental) + "\n";
        }
        
        JOptionPane.showMessageDialog(null, message, 
                "Sammy's Rental Details", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static String displayRentalInfo(Rental rental) {
        DecimalFormat currency = new DecimalFormat("$###,##0.00");
        String message = "";
        
        // If there are no minutes over, only display relevant information
        if (rental.getMinutesOver() == 0) {
            message += "The contact phone number given is: " 
            + rental.getPhoneNumber() + "\nContract number: " 
            + rental.getContractNumber() + "\nYou have chosen to rent a(n) " 
            + rental.getRentalType() + " for " + rental.getHours() 
            + " hour(s) at an hourly rate of: " 
            + currency.format(Rental.COST_PER_HOUR) 
            + "\nThe total price is: " + currency.format(rental.getPrice()) 
            + "\n";
        }
        
        else {
            message += "The contact phone number given is: " 
            + rental.getPhoneNumber() + "\nContract number: " 
            + rental.getContractNumber() + "\nYou have chosen to rent a(n) " 
            + rental.getRentalType() + " for " + rental.getHours() 
            + " hour(s) and " + rental.getMinutesOver() + " minutes." 
            + "\nAt an hourly rate of: " + currency.format(Rental.COST_PER_HOUR) 
            + "\nWith an additional cost per minute over of: " 
            + currency.format(Rental.COST_PER_MINUTE_OVER) 
            + "\nThe total price is: " + currency.format(rental.getPrice())
            + "\n";
        }
//        JOptionPane.showMessageDialog(null, message, 
//                "Sammy's Rental", JOptionPane.INFORMATION_MESSAGE);
        return message;
    }
}
