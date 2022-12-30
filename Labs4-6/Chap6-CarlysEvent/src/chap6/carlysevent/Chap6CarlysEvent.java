/*
 * Author: Brian Moye
 * Date: 2020/10/04
 * Program: Chap6-CarlysEvent
 * Purpose: Calculate event cost.
 */
package chap6.carlysevent;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Chap6CarlysEvent {
    public static void main(String[] args) {
        Event event1 = new Event(getEventNumber(), getNumOfGuests());
        Event event2 = new Event(getEventNumber(), getNumOfGuests());
        Event event3 = new Event(getEventNumber(), getNumOfGuests());
        String advertisement = "Please come to my event!\n";
        String message = "";
        
        Event.displayMotto();
        
        displayEventInfo(event1);
        displayEventInfo(event2);
        displayEventInfo(event3);
        getBigger(getBigger(event1, event2), event3);
        Event smallEvent = getSmaller(getSmaller(event1, event2), event3);
        for ( int i = 0; i != smallEvent.getNumOfGuests(); i++ ) {
            message += advertisement;
        }
        JOptionPane.showMessageDialog(null, 
            message, "Annoying Sales Advertisement", JOptionPane.NO_OPTION);
    }
    
    public static int getNumOfGuests() {
        String inputStr;
        int inputInt;
        
        inputStr = JOptionPane.showInputDialog(null,
            "Enter the number of guests:", "Guest Entry", 
            JOptionPane.QUESTION_MESSAGE);
        
        inputInt = Integer.parseInt(inputStr);
        
        if( inputInt < 5 || inputInt > 100 ) {
            JOptionPane.showMessageDialog(null,
                "Number of guests must be between 5 and 100",
                "Guest Entry", 
                JOptionPane.INFORMATION_MESSAGE);
            inputInt = getNumOfGuests();
        }
        
        return inputInt;
    }
    
    public static String getEventNumber() {
        String inputStr;
        
        inputStr = JOptionPane.showInputDialog(null, "Enter the event number:", 
            "Event Number Entry", JOptionPane.QUESTION_MESSAGE);
        
        return inputStr;
    }
    
    public static Event getSmaller(Event event1, Event event2) {
        if (event1.getNumOfGuests() > event2.getNumOfGuests()) {
            return event2;
        }
        else {
            return event1;
        }
    }
    
    public static Event getBigger(Event event1, Event event2) {
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
            return event1;
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
            return event2;
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
