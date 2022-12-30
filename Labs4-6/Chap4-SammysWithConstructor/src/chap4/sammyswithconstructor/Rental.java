package chap4.sammyswithconstructor;

import javax.swing.JOptionPane;

public class Rental {
    public final static int COST_PER_HOUR = 40;
    public final static int COST_PER_MINUTE_OVER = 1;
    
    private String contractNumber;
    private int hoursRented, minutesOver;
    private double price;
    
    public Rental(String contractNumber, int minutesRented){
        setContractNumber(contractNumber);
        setHoursAndMinutes(minutesRented);
    }
    
    public Rental() {
        this("A000", 0);
    }
    
    //Mutator methods
    public void setContractNumber(String newContractNumber) {
        contractNumber = newContractNumber;
    }
    
    public void setHoursAndMinutes(int minutesRented) {
        //Calculate the hours rented
        hoursRented = minutesRented / 60;
        
       //If rental time is less than 1 hour, charge for an hour rental
        if (hoursRented < 1 && minutesRented != 0) {
            hoursRented = 1;
            minutesOver = 0;
        }
        
        //Calculate the minutes over if minutesRented > 1 hour
        else {
            minutesOver = minutesRented % 60;
        }
        
        //Calculate the cost of the rental
        price = (hoursRented * COST_PER_HOUR + minutesOver * 
                COST_PER_MINUTE_OVER);
    }
    
    //Accessor methods
    public String getContractNumber() {
        return contractNumber;
    }
    
    public int getHours() {
        return hoursRented;
    }
    
    public int getMinutes() {
        return minutesOver;
    }
    
    public double getPrice() {
        return price;
    }
    
    public static void displayMotto() {
        JOptionPane.showMessageDialog(null, 
            "SsSsSsSsSsSsSsSsSsSsSsSsSsSsSs\n"
            + "Ss Sammy’s makes it fun in the sun! Ss\n"
            + "SsSsSsSsSsSsSsSsSsSsSsSsSsSsSs", "Sammy's Motto", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}
