package chap3.carlyseventpricewithmethods;

import javax.swing.JOptionPane;

public class Event {
    public final static double PRICE_PER_GUEST = 35.00;
    public final static int LARGE_EVENT_CUTOFF = 50;
    
    private String eventNum;
    private int numOfGuests;
    private double price;
    
    //Mutator methods
    public void setEventNum(String newEventNum) {
        eventNum = newEventNum;
    }
    
    public void setGuests(int newNumOfGuests) {
        this.numOfGuests = newNumOfGuests;
        price = this.numOfGuests * PRICE_PER_GUEST;
    }
    
    //Accessor methods
    public String getEventNum() {
        return eventNum;
    }
    
    public int getNumOfGuests() {
        return numOfGuests;
    }
    
    public double getPrice() {
        return price;
    }
    
    public static void displayMotto() {
        JOptionPane.showMessageDialog(null,
        "******************************************************\n"
        + "* Carly's makes the food that makes it a party. *\n"
        + "******************************************************", 
        "Carly's Motto", JOptionPane.INFORMATION_MESSAGE);
    }
}
