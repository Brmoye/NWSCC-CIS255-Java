/*
 * Author: Brian Moye
 * Date: 2020/09/16
 * Program: Chap3-CarlysEventPriceWithMethods
 * Purpose: Calculate event cost using methods.
 */
package chap3.carlyseventpricewithmethods;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Chap3CarlysEventPriceWithMethods {
    public static void main(String[] args) {
        Event event1 = new Event();         //Create new Event object
        
        event1.setEventNum(getEventNumber());  //Put event number in object
        event1.setGuests(getNumOfGuests());    //Put number of guests in object
        
        Event.displayMotto();
        
        displayEventInfo(event1);
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
        DecimalFormat currency = new DecimalFormat("$###,###,###,###.00");
        DecimalFormat people = new DecimalFormat("###,###,###");
        
        isLargeEvent = (event.getNumOfGuests()>= Event.LARGE_EVENT_CUTOFF);
        
        JOptionPane.showMessageDialog(null, "The cost for Event "
            + event.getEventNum() + " with "
            + people.format(event.getNumOfGuests()) + " guests will be " 
            + currency.format(event.getPrice()) 
            + "\nLarge Event: " + isLargeEvent, "Carly's Event Details", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}
