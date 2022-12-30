package chap9.sammysrental;

import javax.swing.JOptionPane;

public class Rental {
    public final static int COST_PER_HOUR = 40;
    public final static int COST_PER_MINUTE_OVER = 1;
    public final static String[] rentalTypeDesc = {"personal watercraft",
        "pontoon boat", "rowboat", "canoe", "kayak", "beach chair", "umbrella",
        "other"};
    
    private String contractNumber;
    private String contactPhoneNumber = "";
    private int hoursRented, minutesOver, minutes;
    private double price;
    private int rentalType;
    
    public Rental(String contractNumber, int minutesRented, String phoneNumber,
            int rentalType){
        setContractNumber(contractNumber);
        setHoursAndMinutes(minutesRented);
        setPhoneNumber(phoneNumber);
        setRentalType(rentalType);
    }
    
    public Rental() {
        this("A000", 0, "0000000000", rentalTypeDesc.length - 1);
    }
    
    // Mutator methods
    public void setContractNumber(String newContractNumber) {
        // Check if the contract number starts with a letter and has only 
        //  3 numbers after it.
        if (newContractNumber.length() == 4 
            && Character.isAlphabetic(newContractNumber.charAt(0))
            && Character.isDigit(newContractNumber.charAt(1))
            && Character.isDigit(newContractNumber.charAt(2))
            && Character.isDigit(newContractNumber.charAt(3))) {
                contractNumber = newContractNumber;
                // Capitalize the letter, just in case.
                contractNumber = 
                        Character.toUpperCase(newContractNumber.charAt(0)) 
                        + newContractNumber.substring(1);
        }
        else {
            contractNumber = "A000";
        }
    }
    
    public void setHoursAndMinutes(int minutesRented) {
        // Calculate the hours rented
        minutes = minutesRented;
        hoursRented = minutesRented / 60;
        
       // If rental time is less than 1 hour, charge for an hour rental
        if (hoursRented < 1 && minutesRented != 0) {
            hoursRented = 1;
            minutesOver = 0;
        }
        
        // Calculate the minutes over if minutesRented > 1 hour
        else {
            minutesOver = minutesRented % 60;
        }
        if (minutesOver > 40) {
            hoursRented += 1;
            minutesOver = 0;
        }
        
        // Calculate the cost of the rental
        price = (hoursRented * COST_PER_HOUR + minutesOver * 
                COST_PER_MINUTE_OVER);
    }
    
    public void setPhoneNumber(String newContact) {
        contactPhoneNumber = "";
        
        for (int i =0; i < newContact.length(); i++) {
            if (Character.isDigit(newContact.charAt(i))) {
                contactPhoneNumber += newContact.charAt(i);
            }
        }
        
        if (contactPhoneNumber.length() > 10 || contactPhoneNumber.length() 
                < 10) {
            contactPhoneNumber = "0000000000";
        }
    }
    
    public void setRentalType(int evt) {
        if (evt >= 0 && evt <= rentalTypeDesc.length - 1) {
            rentalType = evt;
        }
        else {
            rentalType = rentalTypeDesc.length - 1;
        }
    }
    
    // Accessor methods
    public String getContractNumber() {
        return contractNumber;
    }
    
    public int getHours() {
        return hoursRented;
    }
    
    public int getMinutesOver() {
        return minutesOver;
    }
    
    public int getMinutes() {
        return minutes;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getPhoneNumber() {
        return "(" + contactPhoneNumber.substring(0,3) + ") " 
            + contactPhoneNumber.substring(3,6) + "-" 
            + contactPhoneNumber.substring(6, 10);
    }
    
    public String getRentalType() {
        return rentalTypeDesc[rentalType];
    }
    
    public int getRentalTypeInt() {
        return rentalType;
    }
    
    public static void displayMotto() {
        JOptionPane.showMessageDialog(null, 
            "SsSsSsSsSsSsSsSsSsSsSsSsSsSsSs\n"
            + "Ss Sammy’s makes it fun in the sun! Ss\n"
            + "SsSsSsSsSsSsSsSsSsSsSsSsSsSsSs", "Sammy's Motto", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}
