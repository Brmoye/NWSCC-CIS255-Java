package chap3.sammysrentalpricewithmethods;

import javax.swing.JOptionPane;

public class Rental {
    public final static int COST_PER_HOUR = 40;
    public final static int COST_PER_MINUTE_OVER = 1;
    
    private String contractNumber;
    private int hoursRented, minutesOver;
    private double price;
    
    //Mutator methods
    public void setContractNumber(String newContractNumber) {
        contractNumber = newContractNumber;
    }
    
    public void setHoursAndMinutes(int minutesRented) {
        hoursRented = minutesRented / 60;
        
        //If rental time is less than 1 hour, charge for an hour rental
        if (hoursRented < 1) {
            hoursRented = 1;
            minutesOver = 0;
        }
        
        else {
            minutesOver = minutesRented % 60;
        }
        
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
