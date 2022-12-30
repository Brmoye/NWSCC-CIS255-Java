/*
 * Author: Brian Moye
 * Date: 2020/09/30
 * Program: Chap5-CarlysEvent
 * Purpose: Calculate event cost.
 */
package chap5.carlysevent;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Chap5CarlysEvent {
    public static void main(String[] args) {
        Event event1 = new Event(getEventNumber(), getNumOfGuests());
        Event event2 = new Event(getEventNumber(), getNumOfGuests());
        Event event3 = new Event(getEventNumber(), getNumOfGuests());
        
        Event.displayMotto();
        
        displayEventInfo(event1);
        displayEventInfo(event2);
        displayEventInfo(event3);
        getBigger(event1, event2);
        getBigger(event2, event3);
        getBigger(event1, event3);
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
    
    public static void getBigger(Event event1, Event event2) {
        DecimalFormat people = new DecimalFormat("###,###,##0");
        
        if (event1.getNumOfGuests() > event2.getNumOfGuests()) {
            JOptionPane.showMessageDialog(null, "First event number: " 
                + event1.getEventNum() + "\nNumber of guests: " 
                + event1.getNumOfGuests() + "\n\nSecond event number: " 
                + event2.getEventNum() + "\nNumber of guests: " 
                + event2.getNumOfGuests() + "\n\nLarger event: " 
                + event1.getEventNum() + "\nNumber of guests: " 
                + event1.getNumOfGuests(), "Carly's Event Details", 
                JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "First event number: " 
                + event1.getEventNum() + "\nNumber of guests: " 
                + event1.getNumOfGuests() + "\n\nSecond event number: " 
                + event2.getEventNum() + "\nNumber of guests: " 
                + event2.getNumOfGuests() + "\n\nLarger event: " 
                + event2.getEventNum() + "\nNumber of guests: " 
                + event2.getNumOfGuests(), "Carly's Event Details", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static void displayEventInfo(Event event) {
        DecimalFormat currency = new DecimalFormat("$###,###,###,##0.00");
        DecimalFormat people = new DecimalFormat("###,###,##0");
        
        JOptionPane.showMessageDialog(null, "The cost for Event "
            + event.getEventNum() + " with "
            + people.format(event.getNumOfGuests()) + " guests will be " 
            + currency.format(event.getPrice()) + "\nThe cost per guest is: "
            + currency.format(event.getPricePerGuest())
            + "\nLarge Event: " + event.isLargeEvent(), "Carly's Event Details", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}
