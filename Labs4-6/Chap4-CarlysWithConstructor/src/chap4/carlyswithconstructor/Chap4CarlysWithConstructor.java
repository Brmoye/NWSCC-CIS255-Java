/*
 * Author: Brian Moye
 * Date: 2020/09/30
 * Program: Chap4-CarlysWithConstructor
 * Purpose: Calculate event cost using methods and add constructor
 */
package chap4.carlyswithconstructor;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Chap4CarlysWithConstructor {
    public static void main(String[] args) {
        Event event1 = new Event();
        Event event2 = new Event(getEventNumber(), getNumOfGuests());
        
        Event.displayMotto();
        
        displayEventInfo(event1);
        displayEventInfo(event2);
    }
    
    public static int getNumOfGuests() {
        String inputStr;
        
        inputStr = JOptionPane.showInputDialog(null,
            "Enter the number of guests:", "Guest Entry", 
            JOptionPane.QUESTION_MESSAGE);
        
        return(Integer.parseInt(inputStr));
    }
    
    public static String getEventNumber() {
        String inputStr;
        
        inputStr = JOptionPane.showInputDialog(null, "Enter the event number:", 
            "Event Number Entry", JOptionPane.QUESTION_MESSAGE);
        
        return inputStr;
    }
    
    public static void displayEventInfo(Event event) {
        boolean isLargeEvent;
        DecimalFormat currency = new DecimalFormat("$###,###,###,##0.00");
        DecimalFormat people = new DecimalFormat("###,###,##0");
        
        isLargeEvent = (event.getNumOfGuests()>= Event.LARGE_EVENT_CUTOFF);
        
        JOptionPane.showMessageDialog(null, "The cost for Event "
            + event.getEventNum() + " with "
            + people.format(event.getNumOfGuests()) + " guests will be " 
            + currency.format(event.getPrice()) 
            + "\nLarge Event: " + isLargeEvent, "Carly's Event Details", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}
