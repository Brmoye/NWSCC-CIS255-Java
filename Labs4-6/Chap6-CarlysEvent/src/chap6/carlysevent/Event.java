package chap6.carlysevent;

import javax.swing.JOptionPane;

public class Event {
    public final static double PRICE_PER_GUEST_LARGE = 32.00;
    public final static double PRICE_PER_GUEST_SMALL = 35.00;
    public final static int LARGE_EVENT_CUTOFF = 50;
    
    private String eventNum;
    private int numOfGuests;
    private double price, pricePerGuest;
    private boolean eventSize;
    
    public Event(String eventNum, int numOfGuests) {
        setEventNum(eventNum);
        setGuests(numOfGuests);
    }
    
    public Event() {
        this("A000", 0);
    }
    
    //Mutator methods
    public void setEventNum(String newEventNum) {
        eventNum = newEventNum;
    }
    
    public void setGuests(int numOfGuests) {
        this.numOfGuests = numOfGuests;
        
        if (isLargeEvent()) {
            pricePerGuest = PRICE_PER_GUEST_LARGE;
        }
        
        else {
            pricePerGuest = PRICE_PER_GUEST_SMALL;
        }
        
        price = numOfGuests * pricePerGuest;
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
    
    public boolean isLargeEvent() {
        eventSize = numOfGuests > LARGE_EVENT_CUTOFF;
        return eventSize;
    }
    
    public double getPricePerGuest() {
        return pricePerGuest;
    }
    
    public static void displayMotto() {
        JOptionPane.showMessageDialog(null,
        "******************************************************\n"
        + "* Carly's makes the food that makes it a party. *\n"
        + "******************************************************", 
        "Carly's Motto", JOptionPane.INFORMATION_MESSAGE);
    }
}
